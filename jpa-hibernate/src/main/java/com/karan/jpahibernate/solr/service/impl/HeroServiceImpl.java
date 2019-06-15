package com.karan.jpahibernate.solr.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;

import com.karan.jpahibernate.solr.model.Hero;
import com.karan.jpahibernate.solr.repository.HeroSolrRepository;
import com.karan.jpahibernate.solr.service.HeroService;

public class HeroServiceImpl implements HeroService {

	private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");

	private HeroSolrRepository heroSolrRepository;

	@Override
	public Page<Hero> findByName(String searchTerm, Pageable pageable) {
		if (StringUtils.isBlank(searchTerm)) {
			return heroSolrRepository.findAll(pageable);
		}

		return heroSolrRepository.findByNameIn(splitSearchTermAndRemoveIgnoredCharacters(searchTerm), pageable);
	}

	@Override
	public Optional<Hero> findById(String id) {
		return heroSolrRepository.findById(id);
	}

	@Override
	public FacetPage<Hero> autocompleteNameFragment(String fragment, Pageable pageable) {
		if (StringUtils.isBlank(fragment)) {
			return new SolrResultPage<Hero>(Collections.<Hero>emptyList());
		}
		return heroSolrRepository.findByNameStartsWith(splitSearchTermAndRemoveIgnoredCharacters(fragment), pageable);
	}

	private Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
		String[] searchTerms = StringUtils.split(searchTerm, " ");
		List<String> result = new ArrayList<String>(searchTerms.length);
		for (String term : searchTerms) {
			if (StringUtils.isNotEmpty(term)) {
				result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
			}
		}
		return result;
	}
}

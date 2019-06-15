package com.karan.jpahibernate.solr.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;

import com.karan.jpahibernate.solr.model.Hero;

public interface HeroService {

	int DEFAULT_PAGE_SIZE = 3;

	Page<Hero> findByName(String searchTerm, Pageable pageable);

	Optional<Hero> findById(String id);

	FacetPage<Hero> autocompleteNameFragment(String fragment, Pageable pageable);
}

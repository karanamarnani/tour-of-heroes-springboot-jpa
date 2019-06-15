package com.karan.jpahibernate.solr.repository;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.Query.Operator;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.karan.jpahibernate.solr.SearchableHeroDefinition;
import com.karan.jpahibernate.solr.model.Hero;

public interface HeroSolrRepository extends SolrCrudRepository<Hero, String> {

	@Highlight(prefix = "<b>", postfix = "</b>")
	@Query(fields = { SearchableHeroDefinition.ID_FIELD_NAME, SearchableHeroDefinition.NAME_FIELD_NAME,
			SearchableHeroDefinition.CREATED_AT_FIELD_NAME,
			SearchableHeroDefinition.UPDATED_AT_FIELD_NAME }, defaultOperator = Operator.AND)
	HighlightPage<Hero> findByNameIn(Collection<String> names, Pageable page);

	@Facet(fields = { SearchableHeroDefinition.NAME_FIELD_NAME })
	FacetPage<Hero> findByNameStartsWith(Collection<String> nameFragments, Pageable pageable);
}

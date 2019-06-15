package com.karan.jpahibernate.solr.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.karan.jpahibernate.solr.SearchableHeroDefinition;

@SolrDocument(collection = "tour_of_heroes")
public class Hero implements SearchableHeroDefinition {

	@Id
	@Indexed
	private Long id;

	@Indexed(name = NAME_FIELD_NAME)
	private String name;

	@Indexed(name = CREATED_AT_FIELD_NAME)
	private Date createdAt;

	@Indexed(name = UPDATED_AT_FIELD_NAME)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return new StringBuilder("Hero [id: ").append(id).append(", name: ").append(name).toString();
	}
}

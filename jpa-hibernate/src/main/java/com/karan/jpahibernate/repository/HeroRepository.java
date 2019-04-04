package com.karan.jpahibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karan.jpahibernate.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

}

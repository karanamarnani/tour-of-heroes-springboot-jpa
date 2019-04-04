package com.karan.jpahibernate.service;

import java.util.Collection;

import com.karan.jpahibernate.model.Hero;

public interface HeroService {

	public abstract Hero addHero(Hero hero);

	public abstract Hero updateHero(Long id, Hero hero);

	public abstract Hero deleteHero(Long id);

	public abstract Collection<Hero> getHeroes();

	public abstract Hero getHero(Long id);

}

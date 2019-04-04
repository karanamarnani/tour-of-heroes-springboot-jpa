package com.karan.jpahibernate.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.jpahibernate.exceptions.ResourceNotFoundException;
import com.karan.jpahibernate.model.Hero;
import com.karan.jpahibernate.repository.HeroRepository;
import com.karan.jpahibernate.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService {

	@Autowired
	HeroRepository heroRepository;

	@Override
	public Hero addHero(Hero hero) {
		return heroRepository.save(hero);
	}

	@Override
	public Hero updateHero(Long id, Hero hero) {
		Hero heroDetails = heroRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hero", "id", id));
		heroDetails.setName(hero.getName());
		return heroRepository.save(hero);
	}

	@Override
	public Hero deleteHero(Long id) {
		Hero hero = heroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hero", "id", id));
		heroRepository.delete(hero);
		return hero;
	}

	@Override
	public Collection<Hero> getHeroes() {
		Collection<Hero> heroes = heroRepository.findAll();
		if (heroes.isEmpty()) {
			setMockContent();
			heroes = heroRepository.findAll();
		}
		return heroes;
	}

	private void setMockContent() {
		Hero hero = new Hero();
		hero.setName("Maharana Pratap");
		addHero(hero);

		hero = new Hero();
		hero.setName("Shivaji Raje");
		addHero(hero);

		hero = new Hero();
		hero.setName("Lalitaditya");
		addHero(hero);

		hero = new Hero();
		hero.setName("Guru Gobind Singh");
		addHero(hero);

		hero = new Hero();
		hero.setName("Subash Chandra Bose");
		addHero(hero);

		hero = new Hero();
		hero.setName("Chandra Shekhar Azad");
		addHero(hero);

		hero = new Hero();
		hero.setName("Bhagat Singh");
		addHero(hero);

		hero = new Hero();
		hero.setName("Sardar Vallabbhai Patel");
		addHero(hero);

		hero = new Hero();
		hero.setName("Lal Bahadur Shastri");
		addHero(hero);

		hero = new Hero();
		hero.setName("P. V. Narsimha Rao");
		addHero(hero);
	}

	@Override
	public Hero getHero(Long id) {
		return heroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hero", "id", id));
	}

}

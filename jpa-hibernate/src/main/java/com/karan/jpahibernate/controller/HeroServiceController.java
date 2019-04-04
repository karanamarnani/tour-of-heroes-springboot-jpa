package com.karan.jpahibernate.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karan.jpahibernate.model.Hero;
import com.karan.jpahibernate.service.HeroService;

@RestController
@RequestMapping("/api")
public class HeroServiceController {

	private static final Logger logger = LoggerFactory.getLogger(HeroServiceController.class);

	@Value("${spring.application.name:defaultservicename}")
	private String name;

	@Autowired
	HeroService heroService;

	@GetMapping("/")
	public String hello() {
		return new StringBuilder("Welcome to the World of Spring Boot using Maven in application ").append(name)
				.toString();
	}

	/**
	 * get all the heroes
	 * 
	 * @return
	 */
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/heroes")
	public ResponseEntity<Object> getHeroes() {
		logger.info("getting hero list");
		return new ResponseEntity<>(heroService.getHeroes(), HttpStatus.OK);
	}

	/**
	 * get a single Hero object detail
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/heroes/{id}")
	public ResponseEntity<Object> getHeroById(@PathVariable("id") Long id) {
		logger.info("getting hero list");
		return new ResponseEntity<>(heroService.getHero(id), HttpStatus.OK);
	}

	/**
	 * Add a new hero to database
	 * 
	 * @param hero Object of type Hero
	 * @return
	 */
	@PostMapping("/heroes")
	public ResponseEntity<Object> addHero(@Valid @RequestBody Hero hero) {
		logger.info("adding a new hero");
		hero = this.heroService.addHero(hero);
		return new ResponseEntity<>(hero, HttpStatus.OK);
	}

	/**
	 * Update hero details
	 * 
	 * @param id
	 * @param hero
	 * @return
	 */
	@PutMapping("/heroes/{id}")
	public ResponseEntity<Object> updateHero(@PathVariable("id") Long id, @Valid @RequestBody Hero hero) {
		logger.info("updating hero details");
		return new ResponseEntity<>(this.heroService.updateHero(id, hero), HttpStatus.OK);
	}

	/**
	 * Delete a hero
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/heroes/{id}")
	public ResponseEntity<Object> deleteHero(@PathVariable("id") Long id) {
		logger.info("deleting hero details");
		Hero hero = this.heroService.deleteHero(id);
		return new ResponseEntity<>(hero, HttpStatus.OK);
	}
}

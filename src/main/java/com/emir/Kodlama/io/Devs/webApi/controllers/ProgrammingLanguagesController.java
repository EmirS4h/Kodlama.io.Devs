package com.emir.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emir.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.emir.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage language) {
		this.languageService.add(language);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
		this.languageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(@RequestParam int id) {
		return this.languageService.getById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage language) {
		this.languageService.update(language);
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return this.languageService.getAll();
	}
}

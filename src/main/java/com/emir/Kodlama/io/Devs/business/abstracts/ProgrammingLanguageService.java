package com.emir.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.emir.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	void add(ProgrammingLanguage language);

	void delete(int id);

	void update(ProgrammingLanguage language);

	ProgrammingLanguage getById(int id);

	List<ProgrammingLanguage> getAll();

	boolean checkIfExists(ProgrammingLanguage language);
}

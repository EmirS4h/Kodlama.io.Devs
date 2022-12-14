package com.emir.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emir.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.emir.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	private List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		this.programmingLanguages = new ArrayList<ProgrammingLanguage>();

		this.programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		this.programmingLanguages.add(new ProgrammingLanguage(2, "Python"));
		this.programmingLanguages.add(new ProgrammingLanguage(3, "Java"));
		this.programmingLanguages.add(new ProgrammingLanguage(4, "Rust"));
		this.programmingLanguages.add(new ProgrammingLanguage(5, "Javascript"));
	}

	@Override
	public void add(ProgrammingLanguage language) {
		this.programmingLanguages.add(language);
	}

	@Override
	public void delete(int id) {
		this.programmingLanguages.remove(this.getById(id));
	}

	@Override
	public void update(ProgrammingLanguage language) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if(programmingLanguage.getId() == language.getId()) {
				programmingLanguage.setName(language.getName());
			}
		}
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguages;
	}
}

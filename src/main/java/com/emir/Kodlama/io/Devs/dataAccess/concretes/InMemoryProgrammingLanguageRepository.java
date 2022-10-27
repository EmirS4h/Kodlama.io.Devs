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
		int index = 0;
		for (int i = 0; i < programmingLanguages.size(); i++) {
			if (programmingLanguages.get(i).getId() == language.getId()) {
				index = i;
			}
		}
		this.programmingLanguages.add(index, language);
		this.programmingLanguages.remove(index + 1);
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

	@Override
	public boolean checkIfExists(ProgrammingLanguage language) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getName().equals(language.getName())) {
				return true;
			}
		}
		return false;
	}
}

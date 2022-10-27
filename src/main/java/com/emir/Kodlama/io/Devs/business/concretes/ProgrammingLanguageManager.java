package com.emir.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emir.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.emir.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.emir.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository repository;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository repository) {
		this.repository = repository;
	}

	@Override
	public void add(ProgrammingLanguage language) {
		ProgrammingLanguage pl = this.repository.getById(language.getId());

		// Eger programlama dili bulunamadıysa *id* ile
		if (pl == null) {
			// Programlama dili ismi bos veya bosluk olamaz
			if (!language.getName().isBlank() && !this.checkIfExists(language))
				this.repository.add(language);
			else {
				return;
			}
		} else {
			return;
		}
	}

	@Override
	public void delete(int id) {
		this.repository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage language) {
		this.repository.update(language);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.repository.getById(id);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.repository.getAll();
	}

	public boolean checkIfExists(ProgrammingLanguage language) {
		for (ProgrammingLanguage programmingLanguage : this.repository.getAll()) {
			if (programmingLanguage.getName().equals(language.getName())
					|| programmingLanguage.getId() == language.getId()) {
				return true;
			}
		}
		return false;
	}

}

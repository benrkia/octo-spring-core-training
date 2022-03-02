package ma.octo.environment.abstraction.service;

import ma.octo.environment.abstraction.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {

  Optional<Language> getLanguageById(String id);

  Optional<Language> getLanguageByExtension(String extension);

  List<Language> findAllLanguages();
}

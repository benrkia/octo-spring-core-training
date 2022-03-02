package ma.octo.dependency.injection.service;

import ma.octo.dependency.injection.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {

  Optional<Language> getLanguageById(String id);

  Optional<Language> getLanguageByExtension(String id);

  List<Language> findAllLanguages();
}

package ma.octo.environment.abstraction.repository;

import ma.octo.environment.abstraction.entity.Language;

import java.util.Optional;

public interface LanguageRepository extends Repository<Language, String> {
  Optional<Language> findByExtension(String extension);
}

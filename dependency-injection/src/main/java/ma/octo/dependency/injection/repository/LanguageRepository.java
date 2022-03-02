package ma.octo.dependency.injection.repository;

import ma.octo.dependency.injection.entity.Language;

import java.util.Optional;

public interface LanguageRepository extends Repository<Language, String> {
  Optional<Language> findByExtension(String extension);
}

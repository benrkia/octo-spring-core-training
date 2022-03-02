package ma.octo.aop.repository;

import ma.octo.aop.entity.Language;

import java.util.Optional;

public interface LanguageRepository extends Repository<Language, String> {
  Optional<Language> findByExtension(String extension);
}

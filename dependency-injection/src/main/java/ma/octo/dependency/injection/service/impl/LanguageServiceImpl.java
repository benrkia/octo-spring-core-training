package ma.octo.dependency.injection.service.impl;

import ma.octo.dependency.injection.entity.Language;
import ma.octo.dependency.injection.service.LanguageService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LanguageServiceImpl implements LanguageService {
  @Override
  public Optional<Language> getLanguageById(final String id) {
    return Optional.empty();
  }

  @Override
  public Optional<Language> getLanguageByExtension(final String id) {
    return Optional.empty();
  }

  @Override
  public List<Language> findAllLanguages() {
    return List.of();
  }
}

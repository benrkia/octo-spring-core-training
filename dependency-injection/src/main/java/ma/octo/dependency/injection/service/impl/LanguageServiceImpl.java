package ma.octo.dependency.injection.service.impl;

import ma.octo.dependency.injection.entity.Language;
import ma.octo.dependency.injection.repository.LanguageRepository;
import ma.octo.dependency.injection.service.LanguageService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LanguageServiceImpl implements LanguageService {

  private final LanguageRepository languageRepository;

  public LanguageServiceImpl(final LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  @Override
  public Optional<Language> getLanguageById(final String id) {
    return languageRepository.findById(id);
  }

  @Override
  public Optional<Language> getLanguageByExtension(final String extension) {
    return languageRepository.findByExtension(extension);
  }

  @Override
  public List<Language> findAllLanguages() {
    return languageRepository.findAll();
  }
}

package ma.octo.aop.service.impl;

import ma.octo.aop.entity.Language;
import ma.octo.aop.repository.LanguageRepository;
import ma.octo.aop.service.LanguageService;
import ma.octo.aop.util.LRU;
import ma.octo.aop.util.Logger;
import ma.octo.aop.util.impl.LoggerImpl;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LanguageServiceImpl implements LanguageService {

  private final Logger logger;

  private final LanguageRepository languageRepository;

  public LanguageServiceImpl(final LanguageRepository languageRepository, Environment environment) {
    this.languageRepository = languageRepository;
    this.logger = new LoggerImpl(LanguageServiceImpl.class, environment);
  }

  @LRU
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
    logger.debug("Getting a list of languages");
    return languageRepository.findAll();
  }
}

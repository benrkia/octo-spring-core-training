package ma.octo.environment.abstraction.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, E> {
  Optional<T> findById(E id);
  List<T> findAll();
}

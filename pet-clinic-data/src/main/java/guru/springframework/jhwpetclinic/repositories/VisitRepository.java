package guru.springframework.jhwpetclinic.repositories;

import guru.springframework.jhwpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

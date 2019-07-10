package guru.springframework.jhwpetclinic.repositories;

import guru.springframework.jhwpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}

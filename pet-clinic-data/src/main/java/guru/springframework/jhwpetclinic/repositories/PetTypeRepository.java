package guru.springframework.jhwpetclinic.repositories;

import guru.springframework.jhwpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

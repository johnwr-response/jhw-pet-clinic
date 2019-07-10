package guru.springframework.jhwpetclinic.repositories;

import guru.springframework.jhwpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

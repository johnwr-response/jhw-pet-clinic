package guru.springframework.jhwpetclinic.repositories;

import guru.springframework.jhwpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

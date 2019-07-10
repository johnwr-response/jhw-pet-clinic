package guru.springframework.jhwpetclinic.repositories;

import guru.springframework.jhwpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

package guru.springframework.jhwpetclinic.services;

import guru.springframework.jhwpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}

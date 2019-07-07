package guru.springframework.jhwpetclinic.services;

import guru.springframework.jhwpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}

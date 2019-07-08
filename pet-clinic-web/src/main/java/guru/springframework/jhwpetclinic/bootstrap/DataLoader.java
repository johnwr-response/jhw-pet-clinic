package guru.springframework.jhwpetclinic.bootstrap;

import guru.springframework.jhwpetclinic.model.Owner;
import guru.springframework.jhwpetclinic.model.PetType;
import guru.springframework.jhwpetclinic.model.Vet;
import guru.springframework.jhwpetclinic.services.OwnerService;
import guru.springframework.jhwpetclinic.services.PetTypeService;
import guru.springframework.jhwpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = petTypeService.save(createPetType("Dog"));
        PetType cat = petTypeService.save(createPetType("Cat"));
        ownerService.save(createOwner("Michael", "Weston"));
        ownerService.save(createOwner("Fiona", "Glenanne"));
        System.out.println("Loaded Owners...");
        vetService.save(createVet("Sam", "Axe"));
        vetService.save(createVet("Jessie", "Porter"));
        System.out.println("Loaded Vets...");
    }
    private PetType createPetType(String name) {
        PetType pettype = new PetType();
        pettype.setName(name);
        return pettype;
    }
    private Owner createOwner(String firstName, String lastName) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        return owner;
    }
    private Vet createVet(String firstName, String lastName) {
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        return vet;
    }

}

package guru.springframework.jhwpetclinic.bootstrap;

import guru.springframework.jhwpetclinic.model.Owner;
import guru.springframework.jhwpetclinic.model.Vet;
import guru.springframework.jhwpetclinic.services.OwnerService;
import guru.springframework.jhwpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        createOwner("Michael", "Weston");
        createOwner("Fiona", "Glenanne");
        System.out.println("Loaded Owners...");
        createVet("Sam", "Axe");
        createVet("Jessie", "Porter");
        System.out.println("Loaded Vets...");
    }
    private void createOwner(String firstName, String lastName) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        ownerService.save(owner);
    }
    private void createVet(String firstName, String lastName) {
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        vetService.save(vet);
    }

}

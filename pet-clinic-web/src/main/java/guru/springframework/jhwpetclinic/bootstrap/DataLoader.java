package guru.springframework.jhwpetclinic.bootstrap;

import guru.springframework.jhwpetclinic.model.*;
import guru.springframework.jhwpetclinic.services.OwnerService;
import guru.springframework.jhwpetclinic.services.PetTypeService;
import guru.springframework.jhwpetclinic.services.SpecialtyService;
import guru.springframework.jhwpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = petTypeService.save(createPetType("Dog"));
        PetType cat = petTypeService.save(createPetType("Cat"));

        Specialty radiology = specialtyService.save(createSpeciality("Radiology"));
        Specialty surgery = specialtyService.save(createSpeciality("Surgery"));
        Specialty dentistry = specialtyService.save(createSpeciality("Dentistry"));

        Owner mike = createOwner("Michael", "Weston", "123 Brickerel", "Miami", "1231231234");
        Pet rosco = createPet("Rosco",dog,mike, LocalDate.now());
        mike.getPets().add(rosco);
        ownerService.save(mike);

        Owner fiona = createOwner("Fiona", "Glenanne", "","", "");
        Pet justCat = createPet("Just Cat",cat,fiona,LocalDate.now());
        fiona.getPets().add(justCat);
        ownerService.save(fiona);

        System.out.println("Loaded Owners...");
        Vet sam = createVet("Sam", "Axe");
        sam.getSpecialities().add(radiology);
        vetService.save(sam);

        Vet jessie = createVet("Jessie", "Porter");
        jessie.getSpecialities().add(surgery);
        vetService.save(jessie);
        System.out.println("Loaded Vets...");
    }

    private PetType createPetType(String name) {
        PetType pettype = new PetType();
        pettype.setName(name);
        return pettype;
    }
    private Owner createOwner(String firstName, String lastName, String address, String city, String telephone) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);
        return owner;
    }
    private Vet createVet(String firstName, String lastName) {
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        return vet;
    }
    private Pet createPet(String name, PetType pettype, Owner owner, LocalDate birthdate) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setPetType(pettype);
        pet.setOwner(owner);
        pet.setBirthDate(birthdate);
        return pet;
    }
    private Specialty createSpeciality(String description) {
        Specialty specialty = new Specialty();
        specialty.setDescription(description);
        return specialty;
    }

}

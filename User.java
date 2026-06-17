import java.util.ArrayList;

public class User {
    private String name;
    private int userId;
    private ArrayList<Pet> adoptedPets;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.adoptedPets = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public ArrayList<Pet> getAdoptedPets() {
        return this.adoptedPets;
    }

    // Pet adoption (max 3)
    public void adoptPet(Pet pet) {
        if (adoptedPets.size() < 3) {
            adoptedPets.add(pet);
        }
    }

    // Optional: preload pets directly (used in Task 3b prepopulation)
    public void preloadPet(Pet pet) {
        if (adoptedPets.size() < 3) {
            adoptedPets.add(pet);
        }
    }

    // Pet customisation
    public void customizePet(Pet pet, String name, String color, String breed) {
        pet.setName(name);
        pet.setColor(color);
        pet.setBreed(breed);
    }

    // Helper methods for interaction (if needed externally)
    public void feedPet(Pet pet) {
        pet.feed();
    }

    public void playWithPet(Pet pet) {
        pet.play();
    }

    public void putPetToSleep(Pet pet) {
        pet.rest();
    }

    // Pet removal (e.g., when a pet dies or is returned)
    public void removePet(Pet pet) {
        adoptedPets.remove(pet);
    }

    // Display all adopted pets' stats
    public void showAllPetStats() {
        for (Pet pet : adoptedPets) {
            pet.displayStats();
        }
    }

    // Find pet by name (case insensitive)
    public Pet getAdoptedPetByName(String name) {
        for (Pet pet : adoptedPets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null;
    }
}

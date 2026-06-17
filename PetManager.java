import java.util.ArrayList;

/**
 * Manages available pets and all registered users.
 * Acts as the controller for pet adoption, user lookup, and pet listing.
 */
public class PetManager {
    private ArrayList<Pet> availablePets;
    private ArrayList<User> allUsers;

    public PetManager() {
        availablePets = new ArrayList<>();
        allUsers = new ArrayList<>();
    }

    // ------------------------
    // Pet Management Methods
    // ------------------------

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    public ArrayList<Pet> getAvailablePets() {
        return availablePets;
    }

    public void listAvailablePetsPreview() {
        if (availablePets.isEmpty()) {
            System.out.println("No pets available for adoption.");
            return;
        }

        System.out.println("Available Pets:");
        for (int i = 0; i < availablePets.size(); i++) {
            Pet pet = availablePets.get(i);
            System.out.println((i + 1) + ". Species: " + pet.getSpecies()
                    + " | Breed: " + pet.getBreed()
                    + " | Color: " + pet.getColor());
        }
    }

    // ------------------------
    // User Management Methods
    // ------------------------

    public void registerUser(User user) {
        allUsers.add(user);
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public boolean userExists(String name) {
        return allUsers.stream().anyMatch(user -> user.getName().equalsIgnoreCase(name));
    }

    public User getUserByName(String name) {
        for (User user : allUsers) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}

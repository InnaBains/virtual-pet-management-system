import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class for the Virtual Pet Simulation Game.
 * Implements user selection/registration, pet adoption, interaction, and management features.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetManager manager = new PetManager(); // Manages pets and users

        // ---------------------------
        // 1. Preload 20 available pets
        // ---------------------------
        manager.addPet(new Dog("Labrador", "Golden"));
        manager.addPet(new Dog("Poodle", "White"));
        manager.addPet(new Dog("Beagle", "Brown"));
        manager.addPet(new Dog("Husky", "Gray"));
        manager.addPet(new Dog("Bulldog", "Brindle"));

        manager.addPet(new Cat("Siamese", "Cream"));
        manager.addPet(new Cat("Persian", "White"));
        manager.addPet(new Cat("Maine Coon", "Tabby"));
        manager.addPet(new Cat("Sphynx", "Pink"));
        manager.addPet(new Cat("Bengal", "Spotted"));

        manager.addPet(new Rabbit("Lionhead", "White"));
        manager.addPet(new Rabbit("Dutch", "Black & White"));
        manager.addPet(new Rabbit("Mini Rex", "Gray"));
        manager.addPet(new Rabbit("Flemish Giant", "Beige"));
        manager.addPet(new Rabbit("Netherland Dwarf", "Brown"));

        manager.addPet(new Fish("Goldfish", "Gold"));
        manager.addPet(new Fish("Betta", "Blue"));
        manager.addPet(new Fish("Guppy", "Orange"));
        manager.addPet(new Fish("Tetra", "Silver"));
        manager.addPet(new Fish("Molly", "Black"));

       // ----------------------------------------
        // 2. Preload 5 users and assign adopted pets
        // ----------------------------------------
        User emma = new User("Emma", 101);
        manager.registerUser(emma);
        Pet emmaPet1 = new Dog("Labrador", "Golden");
        emma.customizePet(emmaPet1, "Luna", emmaPet1.getColor(), emmaPet1.getBreed());
        emma.adoptPet(emmaPet1); manager.removePet(emmaPet1);

        Pet emmaPet2 = new Cat("Sphynx", "Pink");
        emma.customizePet(emmaPet2, "Max", emmaPet2.getColor(), emmaPet2.getBreed());
        emma.adoptPet(emmaPet2); manager.removePet(emmaPet2);

        User alex = new User("Alex", 102);
        manager.registerUser(alex);
        Pet alexPet1 = new Fish("Goldfish", "Gold");
        alex.customizePet(alexPet1, "Nemo", alexPet1.getColor(), alexPet1.getBreed());
        alex.adoptPet(alexPet1); manager.removePet(alexPet1);

        Pet alexPet2 = new Rabbit("Dutch", "Black & White");
        alex.customizePet(alexPet2, "Snowy", alexPet2.getColor(), alexPet2.getBreed());
        alex.adoptPet(alexPet2); manager.removePet(alexPet2);

        User sara = new User("Sara", 103);
        manager.registerUser(sara);
        Pet saraPet1 = new Dog("Beagle", "Brown");
        sara.customizePet(saraPet1, "Cooper", saraPet1.getColor(), saraPet1.getBreed());
        sara.adoptPet(saraPet1); manager.removePet(saraPet1);

        Pet saraPet2 = new Fish("Molly", "Black");
        sara.customizePet(saraPet2, "Jet", saraPet2.getColor(), saraPet2.getBreed());
        sara.adoptPet(saraPet2); manager.removePet(saraPet2);

        User john = new User("John", 104);
        manager.registerUser(john);
        Pet johnPet1 = new Cat("Persian", "White");
        john.customizePet(johnPet1, "Misty", johnPet1.getColor(), johnPet1.getBreed());
        john.adoptPet(johnPet1); manager.removePet(johnPet1);

        Pet johnPet2 = new Rabbit("Mini Rex", "Gray");
        john.customizePet(johnPet2, "Thumper", johnPet2.getColor(), johnPet2.getBreed());
        john.adoptPet(johnPet2); manager.removePet(johnPet2);

        User mia = new User("Mia", 105);
        manager.registerUser(mia);
        Pet miaPet1 = new Fish("Betta", "Blue");
        mia.customizePet(miaPet1, "Bubbles", miaPet1.getColor(), miaPet1.getBreed());
        mia.adoptPet(miaPet1); manager.removePet(miaPet1);

        Pet miaPet2 = new Dog("Bulldog", "Brindle");
        mia.customizePet(miaPet2, "Rocky", miaPet2.getColor(), miaPet2.getBreed());
        mia.adoptPet(miaPet2); manager.removePet(miaPet2);

               // ------------------------------
        // 3. User login or registration
        // ------------------------------
        
        User currentUser = null;

        System.out.println("Welcome to the Virtual Pet Simulation Game!");
        while (currentUser == null) {
            System.out.println("1. Select an existing user");
            System.out.println("2. Register a new user");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();
        
            if (option.equals("1")) {
                ArrayList<User> allUsers = manager.getAllUsers();
                boolean validUserSelected = false;
        
                while (!validUserSelected) {
                    System.out.println("Existing Users:");
                    for (int i = 0; i < allUsers.size(); i++) {
                        System.out.println((i + 1) + ". " + allUsers.get(i).getName());
                    }
        
                    System.out.print("Choose a user by number: ");
                    String choiceInput = scanner.nextLine();
                    try {
                        int choice = Integer.parseInt(choiceInput) - 1;
                        if (choice >= 0 && choice < allUsers.size()) {
                            currentUser = allUsers.get(choice);
                            System.out.println("Welcome back, " + currentUser.getName() + "!");
                            validUserSelected = true;
                        } else {
                            System.out.println("Invalid selection. Please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
        
            } else if (option.equals("2")) {
                System.out.print("Enter new username: ");
                String newUser = scanner.nextLine();
                if (manager.userExists(newUser)) {
                    System.out.println("That user already exists. Please select from existing users.");
                } else {
                    currentUser = new User(newUser, manager.getAllUsers().size() + 106);
                    manager.registerUser(currentUser);
                    System.out.println("Registration successful. Welcome, " + currentUser.getName() + "!");
                }
        
            } else {
                System.out.println("Invalid input. Please choose 1 or 2.");
            }
        }


                 // ------------------------------
        // 4. Main simulation game loop
        // ------------------------------      

        boolean running = true;

        while (running) {

            // Main menu
            System.out.println("Main Menu:");
            System.out.println("1. Adopt a Pet");
            System.out.println("2. View My Pets");
            System.out.println("3. Interact with a Pet");
            System.out.println("4. Customize or Remove a Pet");
            System.out.println("5. Exit Game");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    // Check if user already has 3 pets
                    if (currentUser.getAdoptedPets().size() >= 3) {
                        System.out.println("You already have 3 pets. You must remove one before adopting another.");
                        break;
                    }

                    ArrayList<Pet> available = manager.getAvailablePets();
                    if (available.isEmpty()) {
                        System.out.println("No pets available for adoption.");
                        break;
                    }

                    boolean adoptionInProgress = true;
                    while (adoptionInProgress) {
                        System.out.println("Available Pets to Adopt:");
                        for (int i = 0; i < available.size(); i++) {
                            Pet pet = available.get(i);
                            System.out.println((i + 1) + ". Species: " + pet.getSpecies()
                                    + " | Breed: " + pet.getBreed()
                                    + " | Color: " + pet.getColor());
                        }

                        System.out.print("Enter number of the pet to adopt or 0 to cancel: ");
                        String adoptionInput = scanner.nextLine();

                        try {
                            int index = Integer.parseInt(adoptionInput) - 1;
                            if (index == -1) {
                                System.out.println("Adoption cancelled. Returning to Main Menu...");
                                adoptionInProgress = false;
                            } else if (index >= 0 && index < available.size()) {
                                Pet chosen = available.get(index);
                                System.out.print("Give your pet a name: ");
                                String petName = scanner.nextLine();

                                boolean nameTaken = currentUser.getAdoptedPets().stream()
                                        .anyMatch(p -> p.getName().equalsIgnoreCase(petName));
                                if (nameTaken) {
                                    System.out.println("You already have a pet with this name. Try another name.");
                                    continue;
                                }

                                currentUser.customizePet(chosen, petName, chosen.getColor(), chosen.getBreed());
                                currentUser.adoptPet(chosen);
                                manager.removePet(chosen);

                                System.out.println(petName + " has been adopted!");
                                adoptionInProgress = false;
                            } else {
                                System.out.println("Invalid selection. Please choose a valid number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }
                }

                
                case "2" -> {
                    if (currentUser.getAdoptedPets().isEmpty()) {
                        System.out.println("You have no pets yet.");
                    } else {
                        currentUser.showAllPetStats();
                    }
                }

                case "3" -> {
                    if (currentUser.getAdoptedPets().isEmpty()) {
                        System.out.println("You have no pets to interact with.");
                        break;
                    }

                    Pet pet = null;

                    if (currentUser.getAdoptedPets().size() == 1) {
                        pet = currentUser.getAdoptedPets().get(0);
                        System.out.println("You're interacting with your only pet: " + pet.getName());
                    } else {
                        currentUser.showAllPetStats();
                        while (pet == null) {
                            System.out.print("Enter pet name to interact with (or type 0 to cancel): ");
                            String name = scanner.nextLine();
                            if (name.equals("0")) {
                                System.out.println("Interaction cancelled.");
                                break;
                            }
                            pet = currentUser.getAdoptedPetByName(name);
                            if (pet == null) {
                                System.out.println("Pet not found. Please try again.");
                            }
                        }
                        if (pet == null) break;
                    }

                    pet.makeSound();
                    boolean interacting = true;

                    while (interacting) {
                        pet.displayStats();
                        System.out.println("🐾 What would you like to do?");
                        System.out.println("1. Feed");
                        System.out.println("2. Play");
                        System.out.println("3. Rest");
                        System.out.println("0. Back");
                        System.out.print("Choice: ");
                        String action = scanner.nextLine();

                        switch (action) {
                            case "1" -> pet.feed();
                            case "2" -> pet.play();
                            case "3" -> pet.rest();
                            case "0" -> {
                                interacting = false;
                                continue;
                            }
                            default -> {
                                System.out.println("Invalid option. Please try again.");
                                continue;
                            }
                        }

                        if (pet.isSick()) {
                            if (pet.getHealth() == 0) {
                                System.out.println("\n💀 " + pet.getName() + " has passed away and has been returned to the adoption pool.\n");
                                currentUser.removePet(pet);
                                manager.addPet(pet);
                                System.out.println("Press Enter to continue...");
                                scanner.nextLine();
                                interacting = false;
                                break;
                            } else {
                                System.out.println("⚠️ " + pet.getName() + " is sick. Please take better care of them!");
                            }
                        }

                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                    }
                }

                case "4" -> {
                    if (currentUser.getAdoptedPets().isEmpty()) {
                        System.out.println("You have no pets to customize or remove.");
                        break;
                    }

                    Pet pet = null;

                    if (currentUser.getAdoptedPets().size() == 1) {
                        pet = currentUser.getAdoptedPets().get(0);
                        System.out.println("You're managing your only pet: " + pet.getName());
                    } else {
                        currentUser.showAllPetStats();
                        while (pet == null) {
                            System.out.print("Enter the pet's name to manage (or type 0 to cancel): ");
                            String name = scanner.nextLine();
                            if (name.equals("0")) {
                                System.out.println("Operation cancelled.");
                                break;
                            }
                            pet = currentUser.getAdoptedPetByName(name);
                            if (pet == null) {
                                System.out.println("Pet not found. Please try again.");
                            }
                        }
                        if (pet == null) break;
                    }

                    boolean managing = true;
                    while (managing) {
                        System.out.println("What would you like to do?");
                        System.out.println("1. Customize Pet");
                        System.out.println("2. Remove Pet");
                        System.out.println("0. Cancel");
                        String choice = scanner.nextLine();

                        switch (choice) {
                            case "1" -> {
                                System.out.print("New Name: ");
                                String newName = scanner.nextLine();
                                System.out.print("New Color: ");
                                String newColor = scanner.nextLine();
                                System.out.print("New Breed: ");
                                String newBreed = scanner.nextLine();

                                currentUser.customizePet(pet, newName, newColor, newBreed);
                                System.out.println("Pet updated successfully!");
                                managing = false;
                            }
                            case "2" -> {
                                currentUser.removePet(pet);
                                manager.addPet(pet);
                                System.out.println(pet.getName() + " has been returned to the adoption pool.");
                                managing = false;
                            }
                            case "0" -> {
                                System.out.println("Cancelled.");
                                managing = false;
                            }
                            default -> System.out.println("Invalid option. Try again.");
                        }
                    }
                }

                case "5" -> {
                    boolean confirmingExit = true;
                    while (confirmingExit) {
                        System.out.print("Are you sure you want to exit the game? (yes/no): ");
                        String confirm = scanner.nextLine().trim().toLowerCase();
                        if (confirm.equals("yes") || confirm.equals("y")) {
                            System.out.println("Thank you for playing!");
                            running = false;
                            confirmingExit = false;
                        } else if (confirm.equals("no") || confirm.equals("n")) {
                            System.out.println("Returning to the main menu.");
                            confirmingExit = false;
                        } else {
                            System.out.println("Invalid input. Please type 'yes' or 'no'.");
                        }
                    }
                }

                default -> System.out.println("Invalid option. Please choose from the menu.");
            } // End of switch
        } // End of while loop

        scanner.close();
    } // End of main method
} // End of class



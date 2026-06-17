public abstract class Pet {
    private String species;
    private String breed;
    private String color;
    private String name;
    private int health;
    private int happiness;
    private int hunger;
    private int energy;
    private int level;
    private int interactionCount;

    public Pet(String species, String breed, String color) {
        this.species = species;
        this.breed = breed;
        this.color = color;
        this.name = "Unnamed";
        this.health = 100;
        this.happiness = 50;
        this.hunger = 50;
        this.energy = 50;
        this.level = 1;
        this.interactionCount = 0;
    }

    public String getSpecies() { return this.species; }
    public String getBreed() { return this.breed; }
    public String getColor() { return this.color; }
    public String getName() { return this.name; }
    public int getLevel() { return this.level; }

    public void setColor(String color) { this.color = color; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = Math.max(0, Math.min(100, health)); }

    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { this.happiness = Math.max(0, Math.min(70, happiness)); }

    public int getHunger() { return hunger; }
    public void setHunger(int hunger) { this.hunger = Math.max(0, Math.min(100, hunger)); }

    public int getEnergy() { return energy; }
    public void setEnergy(int energy) { this.energy = Math.max(0, Math.min(70, energy)); }

    public void feed() {
        if (isDead()) return;

        boolean successful = false;

        if (hunger <= 0) {
            System.out.println(name + " is already full and doesn't want to eat.");
            decreaseHappiness(5);
            decreaseHealth(20);
        } else {
            decreaseHunger(40);
            increaseHealth(10);
            increaseHappiness(10);
            increaseEnergy(10);
            System.out.println(name + " was fed. Health and mood improved!");
            successful = true;
        }

        checkPetCondition();
        if (successful) checkLevelProgress();
    }

    public void play() {
        if (isDead()) return;

        boolean successful = false;

        if (energy < 15 || hunger > 80 || health <= 20) {
            System.out.println(name + " is too tired, hungry, or unwell to play.");
            decreaseHappiness(5);
            decreaseHealth(10);
        } else {
            increaseHappiness(15);
            decreaseEnergy(25);
            increaseHunger(15);
            System.out.println(name + " had a great time playing!");
            successful = true;
        }

        checkPetCondition();
        if (successful) checkLevelProgress();
    }

    public void rest() {
        if (isDead()) return;

        boolean successful = false;

        if (energy >= 70) {
            System.out.println(name + " is already well rested.");
            decreaseHappiness(5);
        } else {
            increaseEnergy(30);
            increaseHealth(15);
            System.out.println(name + " took a nap and feels better.");
            successful = true;
        }

        checkPetCondition();
        if (successful) checkLevelProgress();
    }

    private boolean isDead() {
        if (health <= 0) {
            System.out.println(name + " cannot do anything... They've passed away.");
            return true;
        }
        return false;
    }

    private void checkPetCondition() {
        if (energy < 10) {
            decreaseHealth(20);
            System.out.println(name + " is exhausted! Health dropped severely.");
        }
        if (hunger > 90) {
            decreaseHealth(20);
            System.out.println(name + " is starving! Health decreased badly.");
        }
        if (happiness < 15) {
            decreaseHealth(15);
            System.out.println(name + " is very unhappy. Health is declining.");
        }
    }

    protected void checkLevelProgress() {
        if (health > 80 && happiness > 60 && energy > 30 && hunger < 70) {
            interactionCount++;
            if (interactionCount >= 3) {
                level++;
                interactionCount = 0;
                System.out.println("🎉 " + name + " leveled up! Now Level " + level + "! 🎉");
            }
        } else {
            interactionCount = 0; // Reset progress if pet is not in good condition
        }
    }

    // Utility methods for safe attribute adjustments
    protected void increaseHealth(int value) { setHealth(health + value); }
    protected void decreaseHealth(int value) { setHealth(health - value); }
    protected void increaseHappiness(int value) { setHappiness(happiness + value); }
    protected void decreaseHappiness(int value) { setHappiness(happiness - value); }
    protected void increaseHunger(int value) { setHunger(hunger + value); }
    protected void decreaseHunger(int value) { setHunger(hunger - value); }
    protected void increaseEnergy(int value) { setEnergy(energy + value); }
    protected void decreaseEnergy(int value) { setEnergy(energy - value); }

    public void makeSound() {
        System.out.println(name + " makes a generic pet sound.");
    }

    public void displayStats() {
        System.out.println();
        System.out.println(" PET STATUS ");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species + " | Breed: " + breed + " | Color: " + color + " | Level: " + level);
        System.out.println("Health: " + health + " | Happiness: " + happiness + " | Hunger: " + hunger + " | Energy: " + energy);
        System.out.println("--------------------------------------------------");
    }

    public abstract boolean isSick();
}

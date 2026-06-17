public class Rabbit extends Pet {

    public Rabbit(String breed, String color) {
        super("Rabbit", breed, color);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes a soft hopping sound.");
    }

    @Override
    public void feed() {
        int before = getHunger();
        super.feed();
        if (before > getHunger()) {
            System.out.println(getName() + " munched quietly on a carrot.");
        }
    }

    @Override
    public void play() {
        int before = getEnergy();
        super.play();
        if (before > getEnergy()) {
            System.out.println(getName() + " bounced around playfully!");
        }
    }

    @Override
    public void rest() {
        int before = getEnergy();
        super.rest();
        if (getEnergy() > before) {
            System.out.println(getName() + " nuzzled into hay and rested.");
        }
    }

    @Override
    public boolean isSick() {
        return getHealth() < 20;
    }
}

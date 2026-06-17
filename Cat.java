public class Cat extends Pet {

    public Cat(String breed, String color) {
        super("Cat", breed, color);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " meows softly: Meowww~");
    }

    @Override
    public void feed() {
        int before = getHunger();
        super.feed();
        if (before > getHunger()) {
            System.out.println(getName() + " gracefully nibbled on tuna.");
        }
    }

    @Override
    public void play() {
        int before = getEnergy();
        super.play();
        if (before > getEnergy()) {
            System.out.println(getName() + " pounced on a toy mouse!");
        }
    }

    @Override
    public void rest() {
        int before = getEnergy();
        super.rest();
        if (getEnergy() > before) {
            System.out.println(getName() + " curled up on the windowsill and purred while sleeping.");
        }
    }

    @Override
    public boolean isSick() {
        return getHealth() < 20;
    }
}

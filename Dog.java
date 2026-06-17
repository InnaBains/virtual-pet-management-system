public class Dog extends Pet {

    public Dog(String breed, String color) {
        super("Dog", breed, color);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " barks happily: Woof! 🐶");
    }

    @Override
    public void feed() {
        int before = getHunger();
        super.feed();
        if (before > getHunger()) {
            System.out.println(getName() + " munched on kibble with excitement.");
        }
    }

    @Override
    public void play() {
        int before = getEnergy();
        super.play();
        if (before > getEnergy()) {
            System.out.println(getName() + " chased a ball with joy!");
        }
    }

    @Override
    public void rest() {
        int before = getEnergy();
        super.rest();
        if (getEnergy() > before) {
            System.out.println(getName() + " snuggled into their bed and dozed off.");
        }
    }

    @Override
    public boolean isSick() {
        return getHealth() < 20;
    }
}

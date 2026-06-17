public class Fish extends Pet {

    public Fish(String breed, String color) {
        super("Fish", breed, color);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " blubs quietly.");
    }

    @Override
    public void feed() {
        int before = getHunger();
        super.feed();
        if (before > getHunger()) {
            System.out.println(getName() + " nibbled on flakes happily.");
        }
    }

    @Override
    public void play() {
        int before = getEnergy();
        super.play();
        if (before > getEnergy()) {
            System.out.println(getName() + " swam around in loops joyfully.");
        }
    }

    @Override
    public void rest() {
        int before = getEnergy();
        super.rest();
        if (getEnergy() > before) {
            System.out.println(getName() + " floated calmly near the bottom to rest.");
        }
    }

    @Override
    public boolean isSick() {
        return getHealth() < 20;
    }
}

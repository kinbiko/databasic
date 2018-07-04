package generics;

import inheritance.Cat;
import java.beans.

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        PetOwner<Cat> owner = new PetOwner<>();
        owner.own(cat1);
        owner.own(cat2);

        Farm<Cat> catFarm = new Farm<>();
        catFarm.addAnimal(cat1);
        catFarm.addAnimal(cat2);
        catFarm.addAnimal(cat3);

        catFarm.butcherRandomAnimal();

        owner.makeAnimalsAct();
    }
}
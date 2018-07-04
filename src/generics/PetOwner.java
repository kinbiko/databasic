package generics;

import inheritance.Animal;

import java.util.HashSet;
import java.util.Set;

public class PetOwner<T extends Animal> {

    private Set<T> animals = new HashSet<>();

    void own(T animal) {
        this.animals.add(animal);
    }

    void makeAnimalsAct() {
        for (T animal : this.animals) {
            animal.act();
        }
    }
}

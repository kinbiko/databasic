package generics;

import inheritance.Animal;

import java.util.ArrayList;
import java.util.List;

//inheritance: "A is-a B"
//generics: "A of Bs"

public class Farm<T extends Animal> {

    private List<T> animals = new ArrayList<>();

    void addAnimal(T animal){
        this.animals.add(animal);
    }

    T butcherRandomAnimal(){
        if (animals.isEmpty()){
            return null;
        }

        T randomAnimal = animals.get(0);
        randomAnimal.die();
        return randomAnimal;
    }
}

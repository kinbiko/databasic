package Inheritance;

public class Main {
    public static void main(String[] args) {
        Animal kittie = new Cat();
        Animal dottie = new Dog();
        Animal frodo = new Frog();
        Animal pheve = new Sloth();

        kittie.die();
        pheve.die();

        Animal[] animals = {kittie, dottie, frodo, pheve};
        for (Animal animal : animals) {
            animal.act();
        }

    }
}

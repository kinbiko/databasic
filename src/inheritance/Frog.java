package inheritance;

public class Frog extends Animal implements Speaker {

    @Override
    public void speak() {
        System.out.println("ribbit");
    }

    public void performActions(){
        speak();
    }

}

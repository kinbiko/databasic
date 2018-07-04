package inheritance;

public class Dog extends Animal implements Fetcher, Speaker{
    @Override
    public void speak() {
        System.out.println("bark bark bark");
    }

    @Override
    public String fetch() {
        return "Stick";
    }

    public void performActions(){
        speak();
        System.out.println(fetch());
    }
}

package inheritance;

public class Cat extends Animal implements Fetcher, Speaker{

    @Override
    public void speak() {
        System.out.println("Mieouw");
    }

    @Override
    public String fetch() {
        return "Mouse";
    }

    public void performActions(){
        speak();
        System.out.println(fetch());
    }
}

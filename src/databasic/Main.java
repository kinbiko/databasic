package databasic;

public class Main{


    public static void main(String[] args){
        System.out.println("Welcome to databasic!");
        Cli cli = new Cli();
        if (args[0].equals("stats")){
            cli.stats();
        }
    }
}

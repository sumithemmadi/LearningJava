package io.sumith;

public class Main {
    public static void main(String[] args) {
        if(args.length > 0){
            String argString = args[0];
            System.out.println(argString);
        } else {
            System.out.println("Hello from Main!");
        }
    }
}

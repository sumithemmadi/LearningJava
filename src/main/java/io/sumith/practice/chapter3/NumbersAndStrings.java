package io.sumith.practice.chapter3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NumbersAndStrings {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(args.length > 0){
            String argLine = args[0];

            NumbersAndStrings hwClassInstance = new NumbersAndStrings();
            Method method = NumbersAndStrings.class.getDeclaredMethod(argLine);
            method.invoke(hwClassInstance);

        } else {
            System.out.println("Hello from NumbersAndStrings class");
        }
    }

    void workingOnStrings(){
        StringBuilder sb = new StringBuilder();
        sb.append("Emmadi Sumith Kumar");
        System.out.println(sb.capacity());
    }

    void workingOnAutoBoxingAndUnBoxing() {
        Integer i = 0; // This is auto boxing.
        char ch = 'a';
        Character ch2 = ch; // This is unboxing.

    }

    private void listMethods(){

        Class<?> clazz = NumbersAndStrings.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

package io.sumith.practice.chapter0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Introduction {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(args.length > 0){
            String argLine = args[0];

            Introduction hwClassInstance = new Introduction();
            Method method = Introduction.class.getDeclaredMethod(argLine);
            method.invoke(hwClassInstance);

        } else {
            System.out.println("Hello from Introduction class");
        }
    }

    private void listMethods(){

        Class<?> clazz = Introduction.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

package io.sumith.practice.chapter3;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GettingToKnow {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (args.length > 0) {
            String argLine = args[0];

            GettingToKnow hwClassInstance = new GettingToKnow();
            Method method = GettingToKnow.class.getDeclaredMethod(argLine);
            method.invoke(hwClassInstance);

        } else {
            System.out.println("Hello from GettingToKnow class");
        }
    }

    public void runMountainBikeMethod() {
        MountainBike mb = new MountainBike();
        mb.sayDur();
        mb.changeGear(45);
        mb.speedUp(10);
        mb.changeGear(46);
        mb.printStates();
    }

    /*
     * There are 8  primitive data types in java
     * byte : The byte data type is 8-bit signed two's compliment integer.
     * short : The short data type is a 16-bit signed two's compliment integer.
     * int : The int data type is a 32-bit signed two's compliment integer.
     * long : The long data type is a 64-bit signed two's compliment integer.
     * float : The float data type is a signed-precision 32-bit IEEE 754 floating point.
     * double : The double data type is a double-precision 64-bit IEEE 754 floating point.
     * boolean :  true or false
     * char: The char data type is a single 16-bit Unicode character.
     * */
    public void languageBasicsDataTypes() {
        int someNumber = -1;
        long unsignedNumber = Integer.toUnsignedLong(someNumber);
        System.out.println("unsigned number : " + unsignedNumber);
        System.out.println("signed number : " + (int) unsignedNumber);

        try {
            int largeInt = Integer.MAX_VALUE;
            System.out.println("Largest integer is : " + largeInt);
            largeInt = largeInt + 2;
            System.out.println("Check now : " + largeInt);

            long longValue = Integer.toUnsignedLong(largeInt);
            System.out.println("Long value of string : " + longValue);
            System.out.println("Some operation i want to try " + (int) 9223372036854775807L);

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }


    }

    public void languageBasicsArrays() {
        int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(numbers));

        String[][] multiDimentionalArray = {
                {"sumith"},
                {"emmadi"}
        };

        System.out.println(Arrays.deepToString(multiDimentionalArray));

        String[] countries = {
                "India", "America", "China", "Russia", "Germany", "Israel", "France", "Australia", "Pakistan", "Sri Lanka", "Banladesh"
        };

        System.out.println("No of countries : " + countries.length);
        Arrays.stream(countries)
                .map(country -> Arrays.stream(country.split(""))
                        .map(ch -> {
                            char chr = ch.charAt(0);

                            if (chr >= 'a' && chr <= 'z') {
                                return String.valueOf((char) (chr - 32));
                            }

                            return String.valueOf(chr);
                        }).collect(Collectors.joining())

                ).forEach(System.out::println);

    }

    private int incrementTest(String type) {
        int x = 1;

        return switch (type) {
            case "x++" -> x++;
            case "++x" -> ++x;
            case "x--" -> x--;
            case "--x" -> --x;
            default -> {
                System.out.println("\n Run when default");
                System.out.println("x++ : " +  x++);
                System.out.println("++x : " +  ++x);
                System.out.println("x-- : " +  x--);
                System.out.println("--x : " +  --x);
                yield 0;
            }

        };
    }

    public void callIncrementTest() {
        System.out.println("x++ : " +  incrementTest("x++"));
        System.out.println("++x : " +  incrementTest("++x"));
        System.out.println("x-- : " +  incrementTest("x--"));
        System.out.println("--x : " +  incrementTest("--x"));

        incrementTest("blabla");
    }

    private void listMethods() {

        Class<?> clazz = GettingToKnow.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

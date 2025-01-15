package io.sumith.practice.chapter3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassesAndObjects {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (args.length > 0) {
            String argLine = args[0];

            ClassesAndObjects hwClassInstance = new ClassesAndObjects();
            Method method = ClassesAndObjects.class.getDeclaredMethod(argLine);
            method.invoke(hwClassInstance);

        } else {
            System.out.println("Hello from ClassesAndObjects class");
        }
    }

    void classesAndObjectsClassTest() {
        SimpleClass simpleClass = new SimpleClass(10, 2);
        simpleClass.printStates();

        System.out.println("Speed from variable is " + simpleClass.getSpeed());

        System.out.println("Average of speeds : " + simpleClass.calculateAverage(10, 20, 30, 40, 45));

        SimpleClass simpleClass1 = new SimpleClass("first");
        SimpleClass simpleClass2 = new SimpleClass("secound");

        simpleClass1 = null; // Now this is eligible for garbage collection.

        System.gc();
    }

    void classesAndObjectsTestingNestedClasses() {
        SimpleClass.InnerSimpleClass simpleInnerClass = new SimpleClass("Simple").new InnerSimpleClass();
        simpleInnerClass.sayImInnerClass();
    }

    void classesAndObjectsEnums() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Sumith", Gender.MALE));
        persons.add(new Person("Samantha", Gender.FEMALE));
        persons.add(new Person("Uppal Balu", Gender.OTHER));
        persons.add(new Person("Kartheek", Gender.UNKNOWN));

        Arrays.stream(persons.toArray()).map(person -> (Person) person).forEach(person -> System.out.printf("\nName : %s\nGender : %s\nGender Code : %s\n", person.getName(), person.getGender().name(), person.getGender().getShortId()));
    }


    private void listMethods() {

        Class<?> clazz = ClassesAndObjects.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}

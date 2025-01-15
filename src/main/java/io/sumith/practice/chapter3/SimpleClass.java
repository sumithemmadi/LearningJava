package io.sumith.practice.chapter3;

import java.util.Arrays;

/*
# Java Modifiers

## Access Modifiers

| Modifier      | Class | Package | Subclass | World |
|---------------|-------|---------|----------|-------|
| **public**    | ✔️    | ✔️      | ✔️       | ✔️    |
| **protected** | ✔️    | ✔️      | ✔️       | ❌    |
| **default**   | ✔️    | ✔️      | ❌       | ❌    |
| **private**   | ✔️    | ❌      | ❌       | ❌    |

---

## Non-Access Modifiers

### Class-Level Modifiers
| Modifier    | Purpose                                              |
|-------------|------------------------------------------------------|
| **abstract**| Declares a class that cannot be instantiated.        |
| **final**   | Prevents the class from being extended.              |

### Method-Level Modifiers
| Modifier       | Purpose                                                  |
|----------------|----------------------------------------------------------|
| **abstract**   | Declares a method without a body for subclasses to define.|
| **final**      | Prevents overriding of the method in subclasses.          |
| **static**     | Associates the method with the class rather than an instance. |
| **synchronized** | Ensures thread-safe execution of the method.           |

### Variable-Level Modifiers
| Modifier       | Purpose                                                  |
|----------------|----------------------------------------------------------|
| **final**      | Makes the variable a constant (value cannot change).      |
| **static**     | Associates the variable with the class rather than an instance. |
| **volatile**   | Ensures visibility of variable changes across threads.    |
| **transient**  | Excludes the variable from serialization.                 |
*/
class SimpleClass extends Bicycle implements BicycleImpl {

    private String someVariable;
    private String whyCalling;

    public SimpleClass(String something) {
        whyCalling = something;
    }

    public SimpleClass(int initialSpeed, int initialGear) {
        super.speedUp(initialSpeed);
        super.changeGear(initialGear);
        someVariable = "Is working!";
    }

    public double calculateAverage(int... numbers) {
        return Arrays.stream(numbers).average().orElse(0.0);
    }

    public String getWhyCalling() {
        return whyCalling;
    }

    public void setWhyCalling(String whyCalling) {
        this.whyCalling = whyCalling;
    }

    @Override
    public void printStates() {
        super.printStates();
        System.out.println(someVariable);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(whyCalling + " is being garbage collected");
        super.finalize();
    }

    class InnerSimpleClass {
        void sayImInnerClass() {
            System.out.println("I'm inner class");
        }
    }
}

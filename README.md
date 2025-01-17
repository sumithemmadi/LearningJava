# LearningJava

## Chapter 1

- Nothing important

## Chapter 2 

- Getting to Know 
- Classes And Objects

## Java Modifiers

### Access Modifiers

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


- **Note** : Have a look at anonymous classes and records.



# Java Backend Learning Journey

This repository documents my structured learning journey in **Java Backend Development**.  
It brings together my hands-on practice, examples, and mini-projects covering core backend concepts and modern Java frameworks.

The goal of this repository is to:
- Track my backend learning progress in a single place
- Practice concepts with real code
- Showcase my growth from fundamentals to advanced topics

## 📂 Repository Structure
```
java-backend-journey/       # Central repository showcasing my overall backend development journey and learning activities
├── core_java/              # Contains core Java practice code to strengthen fundamental concepts
├── design_patterns/        # Contains implementations of essential design patterns learned in Java
└── task_management_system  # Spring Boot–based application where backend concepts are applied to build a task management system
```

# 📚 Covered Topics - [Core Java](/core_java/)

## Java Quickstart
In Java, every application begins with a **class**,  and class name must match the filename.  
📄 File: `Main.java`  
```java
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
```
⚙️ Compile and Run
```bash
# Compile the program
javac Main.java
# Run the program
java Main
```
### 1️⃣ Java Syntax
- Class names should start with an **uppercase letter**
- Java is **case-sensitive**
  - `MyClass` ≠ `myclass`
- Single-line comments: `//`
- Multi-line comments: `/* ... */`

### 2️⃣ Data Types Overview
1. Primitive Types
    - `byte`, `short`, `int`, `long`
    - `float`, `double`
    - `boolean`
    - `char`
2. Non-Primitive Types
    - `String` **•** `Arrays` **•** `Classes` & `Objects`
3. Type Casting in Java

    - **Widening Casting (automatic)** - converting a smaller type to a larger type size
    `byte` -> `short` -> `char` -> `int` -> `long` -> `float` -> `double`

    - **Narrowing Casting (manual)** - converting a larger type to a smaller type size
    `double` -> `float` -> `long` -> `int` -> `char` -> `short` -> `byte`  
### 3️⃣ Variables
1. Declaring Variables
    ```bash
    type variableName = value;
    ```
2. Example
    ```Java
    // Student data
    int studentID = 15;
    float studentFee = 75.25f;
    char studentGrade = 'B';
    String studentName = "John Doe";
    final int BIRTHYEAR = 1980;
    ```
3. Array
    ```Java
    //Method 1:
    String[] cars = new String[5];

    //Method 2:
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

    System.out.println(cars[0]); //access the elements of an array
    cars[0] = "Opel"; //change an array element
    System.out.println(cars.length); //To find out how many elements an array has, use the length property.
    ```
### 4️⃣ Java User Input/Output
- The `Scanner` class is used to get user input, and it is found in the `java.util` package.
- To use the `Scanner` class, create an object of the class and use any of the available methods found in the Scanner class documentation.
    ```java
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter username");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + userName);  // Output user input
    ```
- Input Types:  
In the example above, we used the nextLine() method, which is used to read Strings. To read other types, look at the table below:
    ```bash
    nextBoolean()	# Reads a boolean value from the user
    nextByte()	# Reads a byte value from the user
    nextDouble()	# Reads a double value from the user
    nextFloat()	# Reads a float value from the user
    nextInt()	    # Reads a int value from the user
    nextLine()	# Reads a String value from the user
    nextLong()	# Reads a long value from the user
    nextShort()	# Reads a short value from the user
    ```
- You can use the `println()`, `print()` method to output values or print text in Java.  
    - System.out.println("Hello World!");
    - System.out.print("Hello World! ");


### 5️⃣ Conditional Branching
Conditions and if statements let you control the flow of your program - deciding which code runs, and which code is skipped.
1. **if-else**
    ```Java
    int temperature = 30;

    if (temperature < 0) {
      System.out.println("It's freezing!");
    } else if (temperature < 20) {
      System.out.println("It's cool.");
    } else {
      System.out.println("It's warm.");
    } 
    ```
2. **switch**
Instead of writing many if..else statements, you can use the switch statement.
    ```Java
    int day = 4;
    switch (day) {
      case 6:
        System.out.println("Today is Saturday");
        break;
      case 7:
        System.out.println("Today is Sunday");
        break;
      default:
        System.out.println("Looking forward to the Weekend");
    }
    ```
### 6️⃣ Looping
1. while Loop
    ```Java
    while (condition) {
      // code block to be executed
    }
    ```
2. do-while Loop
    ```Java
    do {
      // code block to be executed
    }
    while (condition);
    ```
3. for Loop
    ```Java 
    for (statement 1; statement 2; statement 3) {
      // code block to be executed
    }
    ```
4. for-each Loop
    ```Java
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

    for (String car : cars) {
      System.out.println(car);
      }
    ```

### 7️⃣ Java Methods
```Java
public class Main {
  static void myMethod(String fname) {
    System.out.println(fname + " Refsnes");
  }

  public static void main(String[] args) {
    myMethod("Liam");
    myMethod("Jenny");
    myMethod("Anja");
  }
}
// Liam Refsnes
// Jenny Refsnes
// Anja Refsnes
```
### 8️⃣ Java Exceptions
1. Syntax
    ```Java
    try {
    //  Block of code to try
    }
    catch(Exception e) {
    //  Block of code to handle errors
    }
    finally {
      // The finally statement lets you execute code, after try...catch
    }
    ```
2. The `throw` keyword
    - The `throw` statement allows you to create a custom error.
    - The `throw` statement is used together with an **exception type**. There are many exception types available in Java: `ArithmeticException`, `FileNotFoundException`, `ArrayIndexOutOfBoundsException`, `SecurityException` etc.
    ```Java
    public void checkAge(int age) {
        if (age < 18) {
             throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        }
        else {
            System.out.println("Access granted - You are old enough!");
        }
    }
    ```
3. Multi-Catch
    ```Java
    try {
        int result = 10 / 0;
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[10]);
    } 
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
        System.out.println("Math error or array error occurred.");
    }
    ```
4. try-with-resources
    ```Java
    public class Main {
        public static void main(String[] args) {
            // resource is opened inside try()
            try (FileOutputStream output = new FileOutputStream("filename.txt")) {
                output.write("Hello".getBytes());
                // no need to call close() here
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("Error writing file.");
            }
        }
    }
    ```
    **Why use try-with-resources?**
    - Safer - resources are always closed, even if an exception occurs.
    - Cleaner - no need to write close() calls.
    - Shorter code - less boilerplate, easier to read.
## Java Collections & Data Structure
The Java Collections Framework provides a set of **interfaces** (like `List`, `Set`, and `Map`) and a set of **classes** (`ArrayList`, `HashSet`, `HashMap`, etc.) that implement those interfaces.  
All of these are part of the `java.util` package.

| Class | Interface | Description |
| :--- | :--- | :--- |
| `ArrayList` | **List** | Resizable array that maintains order and allows duplicates |
| `LinkedList` | **List** | List with fast insert and remove operations |
| `HashSet` | **Set** | Unordered collection of unique elements |
| `TreeSet` | **Set** | Sorted set of unique elements (natural order) |
| `LinkedHashSet` | **Set** | Maintains the order in which elements were inserted |
| `HashMap` | **Map** | Stores key/value pairs with no specific order |
| `TreeMap` | **Map** | Sorted map based on the natural order of keys |
| `LinkedHashMap` | **Map** | Maintains the order in which keys were inserted |

**When & What to Use in Java Collections**:
- Use `List` classes when you care about order, you may have duplicates, and want to access elements by index.
- Use `Set` classes when you need to store unique values only.
- Use `Map` classes when you need to store pairs of keys and values, like a name and its phone number.  

### 1️⃣ Java List
The `List` interface is part of the Java Collections Framework and represents an ordered collection of elements.
- You can access elements by their **index**, **add duplicates**, and maintain the insertion **order**.
- Since `List` is an interface, you **cannot** create a List object directly.
- Instead, you use a class that implements the List interface, such as:
    - `ArrayList` - like a resizable array with fast random access
    - `LinkedList` - like a train of cars you can easily attach or remove

```Java
 List<String> cars = new ArrayList<String>();
 List<String> cars = new LinkedList<String>();
```    
| Method   | Description                                           |
|----------|-------------------------------------------------------|
| add()    | Adds an element to the end of the list               |
| get()    | Returns the element at the specified position        |
| set()    | Replaces the element at the specified position       |
| remove() | Removes the element at the specified position        |
| size()   | Returns the number of elements in the list           |

**Sort a List**: 
```java
 Collections.sort(cars);  // Ascending order
 Collections.sort(cars, Collections.reverseOrder()); // Descending order
```
### 2️⃣ Java Set
The `Set` interface is part of the Java Collections Framework and is used to store a collection of **unique** elements.

Unlike a `List`, a `Set` does **not allow duplicates**, and it does **not preserve the order** of elements (unless you're using `TreeSet` or `LinkedHashSet`).

**Common classes that implement `Set`:**
- `HashSet` - fast and unordered
- `TreeSet` - sorted set
- `LinkedHashSet` - ordered by insertion

```Java
Set<String> cars = new HashSet<String>();
TreeSet<String> cars = new TreeSet<>();
Set<String> cars = new LinkedHashSet<>();
// Loop Through a XSet
for (String i : cars) {
  System.out.println(i);
}
```

| Method      | Description                                      |
|------------|--------------------------------------------------|
| add()      | Adds an element if it's not already in the set  |
| remove()   | Removes the element from the set                |
| contains() | Checks if the set contains the element          |
| size()     | Returns the number of elements                  |
| clear()    | Removes all elements                            |

### 3️⃣ Java Map
The Map interface is a part of the Java Collections Framework and is used to **store key-value pairs**. **Each key must be unique, but values can be duplicated.**

**Common classes that implement Map:**
- `HashMap` - fast and unordered
- `TreeMap` - sorted by key
- `LinkedHashMap` - ordered by insertion

```Java
Map<String, String> capitalCities = new HashMap<>();
Map<String, String> capitalCities = new TreeMap<>();
Map<String, String> capitalCities = new LinkedHashMap<>();

// Print keys
for (String i : capitalCities.keySet()) {
  System.out.println(i);
}
// Print values
for (String i : capitalCities.values()) {
  System.out.println(i);
}
```

| Method         | Description                              |
|---------------|------------------------------------------|
| put()         | Adds or updates a key-value pair         |
| get()         | Returns the value for a given key        |
| remove()      | Removes the key and its value            |
| containsKey() | Checks if the map contains the key       |
| keySet()      | Returns a set of all keys                |

### 4️⃣ Iterators 
- An `iterator` is a way to loop through elements in a data structure.
- It is called an **iterator** because **iterating** is the technical term for looping.
    ```Java
        // Create an ArrayList of Strings
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");

        // Get an iterator for the ArrayList
        Iterator<String> it = cars.iterator();

        // Iterate through the list using the iterator
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    ```
### 5️⃣ Algorithms
Algorithms are used to solve problems by sorting, searching, and manipulating data structures.

In Java, many useful algorithms are already built into the Collections class (found in the `java.util` package), so you don't have to write them from scratch.

```Java
// Searching & Sorting
Collections.sort(names); // must be sorted first
int index = Collections.binarySearch(names, "Angie");
System.out.println("Angie is at index: " + index);
// Reverse order sorting
Collections.sort(list, Collections.reverseOrder())
```
**The Collections class contains many more algorithms, such as:**
- `Collections.max()` - find the largest element
- `Collections.min()` - find the smallest element
- `Collections.shuffle()` - randomly shuffle elements
- `Collections.frequency()` - count how many times an element appears
- `Collections.swap()` - swap two elements in a list  

## OOP in Java
Everything in Java is associated with classes and objects, along with its attributes and methods. For example: in real life, a car is an object. The car has **attributes**, such as weight and color, and **methods**, such as drive and brake.

**Class Vs Object**   
- Class -> Blueprint  
- Object -> Instance of a class

**Accessing Attributes**: You can access attributes by creating an object of the class, and by using the dot syntax (`.`).
```Java
// Create a Main class
public class Main {
  int x;  // Create a class attribute

  // Create a class constructor for the Main class
  public Main() {
    x = 5;  // Set the initial value for the class attribute x
  }
  // Constructor with parameter
  public Main(int x) {
    this.x = x;
  }

  public static void main(String[] args) {
    Main myObj = new Main(); // Create an object of class Main (This will call the constructor)
    System.out.println(myObj.x); // Print the value of x
  }
}
// Outputs 5
```
### 1️⃣ Java Modifiers
Modifiers define **access level** and **behavior** of classes, methods, and variables.  
**Types of Modifiers:**  
- Access Modifiers - controls the access level
- Non-Access Modifiers - do not control access level, but provides other functionality  

1. Access Modifiers  
For **classes:**
    - `public` : The class is accessible by any other class
    -  `default`: The class is only accessible by classes in the same package.

    For **attributes, methods and constructors:**
    - `public`:	The code is accessible for all classes	
    - `private`: The code is only accessible within the declared class	
    - `default`: The code is only accessible in the same package. This is used when you don't specify a modifier.
    - `protected`: The code is accessible in the same package and subclasses. 

2. Non-Access Modifiers  
Non-access modifiers do not control visibility (like public or private), but instead **add other features** to classes, methods, and attributes.
The most commonly used non-access modifiers are `final`, `static`, and `abstract`.  
    - `final`: If you don't want the ability to override existing attribute values, declare attributes as final.
    - `static`: A `static` method belongs to the class, not to any specific object. This means you can call it without creating an object of the class.
    - `abstract`: An abstract method belongs to an abstract class, and it does not have a body. The body is provided by the subclass.
    - `synchronized`: Methods can only be accessed by one thread at a time

### 2️⃣ Java Encapsulation
The meaning of **Encapsulation**, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:
- declare class variables/attributes as `private`
- provide public **get** and **set** methods to access and update the value of a `private` variable
```java
public class Person {
  private String name; // private = restricted access
  // Getter
  public String getName() {
    return name;
  }
  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}
```
### 3️⃣ Java Inheritance
To inherit from a class, use the `extends` keyword.
```Java
class Vehicle {
}
class Car extends Vehicle {
}
```
Java **does not support multiple inheritance with classes** (to avoid the diamond problem), but it does support multiple inheritance through interfaces.  

### 4️⃣ Java Abstraction
Data **abstraction** is the process of hiding certain details and showing only essential information to the user.
Abstraction can be achieved with either abstract classes or interfaces
The `abstract` keyword is a non-access modifier, used for classes and methods:

- **Abstract class:** is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
- **Abstract method:** can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).  

**An abstract class can have both abstract and regular methods:**
```Java
abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}
```

Another way to achieve **abstraction** in Java, is with **interfaces**.  
An `interface` is a completely "**abstract class**" that is used to group related methods with empty bodies:
```Java
// interface
interface Animal {
  public void animalSound(); // interface method (does not have a body)
  public void run(); // interface method (does not have a body)
}
```
To access the `interface` methods, the interface must be "**implemented**" (kinda like inherited) by another class with the `implements` keyword (instead of `extends`). The body of the interface method is provided by the "**implement**" class:
```Java
// Interface
interface Animal {
  public void animalSound(); // interface method (does not have a body)
  public void sleep(); // interface method (does not have a body)
}

// Pig "implements" the Animal interface
class Pig implements Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
  public void sleep() {
    // The body of sleep() is provided here
    System.out.println("Zzz");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig();  // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
  }
}
```
**Note on Interfaces:**  
- Interface methods do not have a body - the body is provided by the "**implement**" class
- On implementation of an interface, **you must override all of its methods**.
- Interface methods are by default `abstract` and `public`
- Interface attributes are by default `public`, `static` and `final`.
- An interface cannot contain a constructor (as it cannot be used to create objects)

### 5️⃣ Java Anonymous Class
An anonymous class is a class without a name. It is created and used at the same time.  
You often use anonymous classes to **override methods** of an existing class or interface, without writing a separate class file.

```Java
// Normal class
class Animal {
  public void makeSound() {
    System.out.println("Animal sound");
  }
}

public class Main {
  public static void main(String[] args) {
    // Anonymous class that overrides makeSound()
    Animal myAnimal = new Animal() {
      public void makeSound() {
        System.out.println("Woof woof");
      }
    }; // semicolon is required to end the line of code that creates the object

    myAnimal.makeSound();
  }
}
```

### 6️⃣ Java Enums
An `enum` is a special "class" that represents a group of **constants** (unchangeable variables, like final variables).
```Java
// enum class
enum Level {
  LOW,
  MEDIUM,
  HIGH
}
```
**Loop Through an Enum**  
```Java
for (Level myVar : Level.values()) {
  System.out.println(myVar);
}
```

**Enum Constructor**  
```java
enum Level {
  // Enum constants (each has its own description)
  LOW("Low level"),
  MEDIUM("Medium level"),
  HIGH("High level");

  // Field (variable) to store the description text
  private String description;

  // Constructor (runs once for each constant above)
  private Level(String description) {
    this.description = description;
  }

  // Getter method to read the description
  public String getDescription() {
    return description;
  }
}

public class Main {
  public static void main(String[] args) {
    Level myVar = Level.MEDIUM; // Pick one enum constant
    System.out.println(myVar.getDescription()); // Prints "Medium level"
  }
}
```

**Loop Through Enum with Constructor**  
```Java
for (Level myVar : Level.values()) {
  System.out.println(myVar + ": " + myVar.getDescription());
}
```

## Advanced Java
### 1️⃣ Java Wrapper Classes  
Wrapper classes provide a way to use primitive data types (`int`, `boolean`, etc..) as objects.  
The table below shows the primitive type and the equivalent wrapper class:

| Primitive Data Type | Wrapper Class |
|---------------------|--------------|
| byte                | Byte         |
| short               | Short        |
| int                 | Integer      |
| long                | Long         |
| float               | Float        |
| double              | Double       |
| boolean             | Boolean      |
| char                | Character    |

When working with Collection objects, such as `ArrayList`, where primitive types cannot be used (the list can only store objects):
```java
ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid
ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid
```
Since you're now working with objects, you can use certain methods to get information about the specific object.
```java
public class Main {
  public static void main(String[] args) {
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt.intValue());
    System.out.println(myDouble.doubleValue());
    System.out.println(myChar.charValue());
  }
}
```
### 2️⃣ Java Generics
Generics allow you to write classes, interfaces, and methods that work with different data types, without having to specify the exact type in advance.
1. Generic Class
    ```java
    class Box<T> {
        T value; // T is a placeholder for any data type
        void set(T value) {
            this.value = value;
        }
        T get() {
            return value;
        }
    }
    public class Main {
        public static void main(String[] args) {
            // Create a Box to hold a String
            Box<String> stringBox = new Box<>();
            stringBox.set("Hello");
            System.out.println("Value: " + stringBox.get());
            // Create a Box to hold an Integer
            Box<Integer> intBox = new Box<>();
            intBox.set(50);
            System.out.println("Value: " + intBox.get());
        }
    }
    ```
2. Generic Method Example
    ```java
    public class Main {
        // Generic method: works with any type T
        public static <T> void printArray(T[] array) {
            for (T item : array) {
            System.out.println(item);
            }
        }

        public static void main(String[] args) {
            // Array of Strings
            String[] names = {"Jenny", "Liam"};

            // Array of Integers
            Integer[] numbers = {1, 2, 3};

            // Call the generic method with both arrays
            printArray(names);
            printArray(numbers);
        }
    }
    ```
Java `Collections` like `ArrayList` and `HashMap` use generics internally:

### 3️⃣ Java Annotations
**Annotations are special notes** you add to your Java code. They start with the `@` symbol.  
They don't change how your program runs, but they give extra information to the compiler or tools.  
**Java includes several built-in annotations. Here are some of the most commonly used:**  
1. `@Override`: Indicates that a method overrides a method in a superclass.
2. `@Deprecated`: Marks a method or class as outdated or discouraged from use.
3. `@SuppressWarnings`: Tells the compiler to ignore certain warnings.

```Java
class Animal {
  void makeSound() {
    System.out.println("Animal sound");
  }
}

class Dog extends Animal {
  @Override // Compiler check that a method really overrides a method from a superclass.
  void makesound() { // Typo here!
    System.out.println("Woof!");
  }

  @Deprecated // Warns developers not to use a method because it may be removed or replaced in the future
  static void oldMethod() {
    System.out.println("This method is outdated.");
  }
}

public class Main {
  @SuppressWarnings("unchecked") //  Tells the compiler to ignore specific warnings, like "unchecked" or "deprecation"
  public static void main(String[] args) {
    Animal myDog = new Dog();
    myDog.makeSound();
  }
}
```
### 4️⃣ Java Threads
Threads allows a program to operate more efficiently by doing multiple things at the same time. Threads can be used to perform complicated tasks in the background without interrupting the main program.
```Java
public class Threads extends Thread {
    public static void main(String[] args) {
        Threads thread = new Threads();
        thread.start();
        for(int i = 0; i < 50; i++) {
            System.out.println("Outside: " + i);
        }
    }
    public void run() {
        for(int i = 0; i < 50; i++) {
            System.out.println("Inside: " + i);
        }
    }
}
```

### 5️⃣ Java Regular Expressions
Java does not have a built-in Regular Expression class, but we can import the `java.util.regex` package to work with regular expressions. The package includes the following classes:
- `Pattern` Class - Defines a pattern (to be used in a search)
- `Matcher` Class - Used to search for the pattern
- `PatternSyntaxException` Class - Indicates syntax error in a regular expression pattern

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("Visit W3Schools!");
    boolean matchFound = matcher.find();
    if(matchFound) {
      System.out.println("Match found");
    } else {
      System.out.println("Match not found");
    }
  }
}
// Outputs Match found
```
| Method        | Cursor Behavior            | Notes                        |
| ------------- | -------------------------- | ---------------------------- |
| `matches()`   | Moves to end of string     | Full match only              |
| `find()`      | Moves to end of last match | Can be called repeatedly     |
| `lookingAt()` | Moves to end of match      | Starts at current cursor     |
| `reset()`     | Cursor → 0                 | Useful for repeated searches |





**Flags**  
Flags in the `compile()` method change how the search is performed. Here are a few of them:
- `Pattern.CASE_INSENSITIVE` - The case of letters will be ignored when performing a search.
- `Pattern.LITERAL` - Special characters in the pattern will not have any special meaning and will be treated as ordinary characters when performing a search.
- `Pattern.UNICODE_CASE` - Use it together with the CASE_INSENSITIVE flag to also ignore the case of letters outside of the English alphabet

# 📚 Covered Topics - [Spring Boot](task_management_system/)
**Spring boot** is an extension of the Spring-Framework that simplifies the creation of stand-alone, production-grade Spring-based applications. It provides a fast and efficient way to develop Spring applications with minimal configuration.   
## Introduction To Spring Boot  
To work with Spring Boot, it is important to understand the following core principles:
### 1️⃣ Dependency Injection (DI) - [DependencyInjection.java](/design_pattern/DependencyInjection.java)
Dependency Injection (DI) is a design pattern used in object-oriented programming where an object receives its required dependencies from an external source rather than creating them itself. It helps manage how objects are constructed and how they obtain the resources they need. By separating dependency creation from usage, DI improves code flexibility. This results in systems that are easier to modify, test, and maintain.
- Reduces tight coupling between classes
- Improves code reusability and flexibility
- Makes unit testing easier by allowing mock dependencies
- Enhances maintainability and scalability of the system
### 2️⃣ Inversion of Control (IoC) Container - [IocContainer.java](/design_pattern/IocContainer.java)
Inversion of Control Principle (it’s a principle, not a design pattern) is basically about inverting the control flow of a program.  
what does **“Inversion of Control”** even mean?  
`Normally your code controls object creation and flow, With IoC the framework controls object creation and flow`  
👉 The control is inverted
From you → to the container  
That’s it. That’s IoC.

The Spring framework provides an Inversion of Control (IoC) container that manages the creation and lifecycle of objects (beans) and their dependencies.  
**Spring provides two main types of IoC containers:**
1. **BeanFactory:** This is the most basic type of IoC container in Spring. It provides the essential features needed to manage objects (called Beans) in your application. BeanFactory is lightweight and perfect for simple applications where you only need basic dependency injection.

2. **Application Context:** This is a more advanced type of IoC container that extends the capabilities of BeanFactory. In addition to the basic features, ApplicationContext offers more robust options like event propagation, declarative mechanisms to create a Bean, and a more extensive lifecycle management. It's typically the go-to choice for most Spring applications because of its powerful features.

<details><summary>Example of IOC in Spring</summary>

1. Engine.java 
    ```Java
    public class Engine {

        public Engine() {
            System.out.println("Engine bean created");
        }

        public void start() {
            System.out.println("Engine started");
        }
    }
    ```
2. Car.java
    ```Java
    public class Car {

        private Engine engine;

        public Car(Engine engine) {
            System.out.println("Car bean created");
            this.engine = engine;
        }

        public void drive() {
            engine.start();
            System.out.println("Car is driving");
        }
    }
    ```
3. AppConfig.java
    ```Java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    public class AppConfig {

        @Bean
        public Engine engine() {
            return new Engine();
        }

        @Bean
        public Car car() {
            return new Car(engine());
        }
    }
    ```
4. ApplicationContext Example(Eager Initialization)
    ```Java
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class ApplicationContextExample {

        public static void main(String[] args) {

            System.out.println("Before context initialization");

            ApplicationContext context =
                    new AnnotationConfigApplicationContext(AppConfig.class);

            System.out.println("After context initialization");

            Car car = context.getBean(Car.class);
            car.drive();
        }
    }
    ```
4. BeanFactory Example(Lazy Initialization)
    ```Java
    import org.springframework.beans.factory.support.DefaultListableBeanFactory;
    import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

    public class BeanFactoryExample {

        public static void main(String[] args) {

            System.out.println("Before BeanFactory setup");

            DefaultListableBeanFactory factory =
                    new DefaultListableBeanFactory();

            AnnotatedBeanDefinitionReader reader =
                    new AnnotatedBeanDefinitionReader(factory);

            reader.register(AppConfig.class);

            System.out.println("After BeanFactory setup");

            Car car = factory.getBean(Car.class);
            car.drive();
        }
    }
    ```
</details>

### 3️⃣ Beans in Spring Boot - [Spring Beans](https://www.linkedin.com/pulse/understanding-beans-spring-boot-nejah-yengui-c6zlf/)
Spring Beans are Java objects managed by the Spring Container, allowing for dependency injection and efficient application configuration.  

**Key Characteristics of Beans:**
- Signleton by Default
- Configurable
- Managed by the Container

**There are three primary ways to define beans in Spring:**
- XML-Based Configuration
- Annotation-Based Configuration
- Java-based Configuration

**Spring provides multiple ways to define Beans, each with its own purpose and use case:** 

1. `@Component` (Most Common)  
This is the most basic way to define a Bean in Spring. It's typically used for generic components.  
➡ Where to use?  
    - Utility classes
    - General services
    - Simple business logic components

    ```bash
    @Component
    public class MyService {
        public String getServiceName() {
            return "This is MyService";
        }
    } 
    ```

2. `@Service` (Specialized Component for Business Logic)  
A specialized version of @Component, used specifically for service classes.  
    ➡ Where to use?  
    - Business logic implementation
    - Service layer handling complex operations
    ```bash
    @Service
    public class UserService {
        public String getUser() {
            return "Fetching user details...";
        }
    } 
    ```


3. `@Repository` (DAO Layer for Data Access)  
This is a specialized `@Component` used in the data access layer. It also provides exception translation.  
➡ Where to use?  
    - Database interaction
    - DAO (Data Access Object) layer  
    ```bash
    @Repository
    public class UserRepository {
        public List<String> findAllUsers() {
            return List.of("John", "Jane", "Doe");
        }
    } 
    ```

4. `@Controller` (For Handling HTTP Requests)  
Used in Spring MVC to handle incoming web requests.  
➡ Where to use?
    - Exposing APIs
    - Handling HTTP requests  
    ```bash
    @RestController
    @RequestMapping("/api")
    public class UserController {
        @GetMapping("/users")
        public List<String> getUsers() {
            return List.of("Alice", "Bob");
        }
    } 
    ```

5. `@Bean` (Manual Bean Definition)
Used inside a `@Configuration` class to define a Bean manually.  
➡ Where to use?
    - When you need more control over Bean creation
    - Third-party library Beans  
    ```bash
    @Configuration
    public class AppConfig {
        @Bean
        public MyService myService() {
            return new MyService();
        }
    } 
    ```


### 4️⃣ Spring Context  
The Spring Context is the core component of the Spring Framework, representing the Spring IoC (Inversion of Control) container. It is responsible for managing the lifecycle of beans, including their creation, configuration, and destruction. The Spring Context acts as a container that holds the beans and provides them to the application whenever required.

**Types of ApplicationContext**  
Spring provides several implementations of the `ApplicationContext`, each suitable for different use cases:

- `ClassPathXmlApplicationContext:` Loads the context definition from an XML file located in the classpath.
- `FileSystemXmlApplicationContext:` Loads the context definition from an XML file in the file system.
- `AnnotationConfigApplicationContext:` Loads the context definition from Java-based configuration classes using annotations.
- `WebApplicationContext:` A specialized version of `ApplicationContext` used in web applications.

### 5️⃣ Commonly used Spring boot annotations
1. Core Spring Boot Annotations
    - `@SpringBootApplication` – Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` to bootstrap the application.
    - `@Configuration` – Marks a class as a source of bean definitions.
    - `@Bean` – Declares a method that returns a Spring-managed bean.
    - `@ComponentScan` – Scans the specified package for Spring components.
    - `@EnableAutoConfiguration` – Automatically configures Spring based on dependencies.
2. Stereotype Annotations
    - `@Component` – Marks a class as a Spring-managed component.
    - `@Service` – Indicates that a class contains business logic.
    - `@Repository` – Marks a class as a data access component and enables exception translation.
    - `@Controller` – Marks a class as a web controller.
    - `@RestController` – Combines `@Controller` and `@ResponseBody` for REST APIs.

3. Dependency Injection
    - `@Autowired` – Injects a dependency automatically by type.
    - `@Qualifier` – Specifies which bean to inject when multiple candidates exist.
    - `@Primary` – Marks a bean as the default choice when multiple beans are available.
    - `@Value` – Injects values from properties files.

4. Web Layer Annotations
    - `@RequestMapping` – Maps HTTP requests to handler methods.
    - `@GetMapping` – Handles HTTP GET requests.
    - `@PostMapping` – Handles HTTP POST requests.
    - `@PutMapping` – Handles HTTP PUT requests.
    - `@DeleteMapping` – Handles HTTP DELETE requests.
    - `@PathVariable` – Binds URL path variables to method parameters.
    - `@RequestParam` – Binds query parameters to method parameters.
    - `@RequestBody` – Binds HTTP request body to a Java object.
    - `@ResponseBody` – Returns data directly as HTTP response body.
5. JPA & Database Annotations
    - `@Entity` – Marks a class as a JPA entity.
    - `@Table` – Specifies the database table name.
    - `@Id` – Marks the primary key of an entity.
    - `@GeneratedValue` – Specifies how the primary key is generated.
    - `@Column` – Maps a field to a database column.
    - `@OneToOne` – Defines a one-to-one relationship.
    - `@OneToMany` – Defines a one-to-many relationship.
    - `@ManyToOne` – Defines a many-to-one relationship.
    - `@ManyToMany` – Defines a many-to-many relationship.
    - `@JoinColumn` – Specifies the foreign key column.

6. Validation Annotations
    - `@Valid` – Triggers validation on request body objects.
    - `@NotNull` – Ensures a field is not null.
    - `@NotBlank` – Ensures a string is not empty or whitespace.
    - `@Size` – Validates the size of a string or collection.
    - `@Email` – Validates email format.
    - `@Min` – Sets minimum numeric value.
    - `@Max` – Sets maximum numeric value.

7. Security Annotations
    - `@EnableWebSecurity` – Enables Spring Security configuration.
    - `@PreAuthorize` – Authorizes method access before execution.
    - `@PostAuthorize` – Authorizes method access after execution.
    - `@Secured` – Restricts access based on roles.

8. Transaction & Utility
    - `@Transactional` – Manages database transactions automatically.
    - `@Slf4j` – Creates a logger instance (Lombok).
    - `@Data` – Generates getters, setters, equals, hashCode, and toString (Lombok).
    - `@Builder` – Implements the builder pattern (Lombok).
    - `@AllArgsConstructor` – Generates constructor with all fields.
    - `@NoArgsConstructor` – Generates no-argument constructor.

## Spring MVC Architecture
The Spring MVC architecture is designed to streamline the development of web applications by providing a clear separation of concerns. It follows the MVC design pattern, where:
- `Model` represents the application data and business logic.
- `View` is responsible for rendering the user interface.
- `Controller` handles user requests and coordinates between the Model and the View.

In Spring MVC, the architecture revolves around a central component called the `DispatcherServlet`, which acts as the front controller. It delegates requests to appropriate controllers, based on the configured `HandlerMapping`, and returns a `ModelAndView` object to be rendered by a `ViewResolver`.

**`DispatcherServlet` performs the following steps:**
- **Receives the Request:** DispatcherServlet intercepts the incoming request.
- **Finds the Handler:** It uses HandlerMapping to determine the appropriate handler (controller) for the request.
- **Executes the Handler:** Once the handler is determined, DispatcherServlet calls the corresponding controller method.
- **Returns the Model and View:** The controller returns a ModelAndView object, which contains the model data and the view name.
- **Renders the View:** DispatcherServlet uses ViewResolver to render the view based on the ModelAndView object.
```java
@Controller  // Marks this class as a Spring MVC controller
public class HomeController {  // Defines the controller class

    @RequestMapping("/home")  // Maps the URL "/home" to this method
    public ModelAndView home() {  // Controller method that handles the request

        ModelAndView mav = new ModelAndView();  // Creates a ModelAndView object

        mav.setViewName("home");  // Sets the logical view name to "home"

        mav.addObject("message", "Welcome to Spring MVC!");  // Adds model data to send to the view

        return mav;  // Returns the ModelAndView to DispatcherServlet
    }
}
```

### 1️⃣ Introduction to REST
REST(Representational State Transfer) is a stateless architecture, where each request from the client to the server must contain all the information needed to understand and process the request.  
RESTful APIs follow the following key principles:
- **Statelessness:** Each request is independent, and the server doesn't retain client state.
- **Uniform Interface:** APIs use standard HTTP methods like GET, POST, PUT, and DELETE.
- **Client-Server Separation:** The client and server are independent and can evolve separately.
### 2️⃣ Data Binding
Data binding is the process of transferring data between a user interface and the server-side application. In the context of web applications, this means mapping form data from an HTML form to a Java object on the server. Spring Boot simplifies this process through the use of `@ModelAttribute`.

### 3️⃣ Understanding Exception Handling in Spring Boot
Exception handling in Spring Boot allows you to manage errors that occur during application execution. By default, Spring Boot provides basic error handling, but you can customize it according to your requirements.

The `@ExceptionHandler` annotation allows you to handle exceptions at the controller level, while `@ControllerAdvice` enables global exception handling across the entire application.

1. Create a controller
    ```Java
    @RestController
    public class MyController {

        @GetMapping("/divide/{a}divideBy{b}")
        public int divide(@PathVariable int a, @PathVariable int b) {
            return a / b; // May throw ArithmeticException when b = 0
        }
        
        @GetMapping("/custom")
        public String custom() {
            throw new CustomException("This is a custom exception");
        }
    }
    ```

2. Create Custom Exception Class  
This allow you to define application-specific error scenarios with more meaningful or context-specific messages.

    ```Java
    class CustomException extends RuntimeException {

        public CustomException(String message) {
            super(message);
        }
    }
    ```
3. Handling Multiple Exceptions Globally Using the `@ExceptionHandler` Annotation  

    ```Java
    @ControllerAdvice
    class GlobalExceptionHandler {

        @ExceptionHandler(ArithmeticException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public String handleMultipleExceptions(ArithmeticException ex) {
            return "An error occurred: " + ex.getMessage();
        }

        @ExceptionHandler(CustomException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public String handleCustomException(CustomException ex) {
            return "An error occurred: " + ex.getMessage();
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public String handleInternalServerError(Exception ex) {
            return "An internal server error occurred: " + ex.getMessage();
        }
    }
    ```

### 4️⃣ What are Interceptors?
Interceptors are a powerful feature in Spring Boot that allow you to perform operations before and after the execution of a request. They are particularly useful for tasks such as logging, authentication, or modifying the request and response.  

**Key Uses of Interceptors:**  
- **Logging:** Log request details and response statuses.
- **Authentication and Authorization:** Check user credentials and permissions.
- **Performance Monitoring:** Measure request processing times.
- **Modification of Requests/Responses:** Add headers or modify request parameters.

**How Interceptors Works:**  
Interceptors are similar to filters but provide more specific control over request handling. They are part of the Spring MVC framework and are implemented using the `HandlerInterceptor` interface.

Here's a step-by-step guide to creating a custom interceptor in Spring Boot.

1. **Define the Custom Interceptor**  
Create a class that implements the `HandlerInterceptor` interface. This interface has three key methods that you can override:
    - `preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)`: Called before the request is processed by a controller.
    - `postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)`: Called after the request has been processed but before the view is rendered.
    - `afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)`: Called after the request has been completed, including view rendering.

    <details><summary> Example of a custom interceptor that logs request and response details </summary>

    ```java
    @Component
    public class CustomInterceptor implements HandlerInterceptor {

        private static final Logger logger = Logger.getLogger(CustomInterceptor.class.getName());

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            logger.info("Pre Handle method is Calling");
            logger.info("Request URL: " + request.getRequestURL());
            logger.info("Request Method: " + request.getMethod());
            return true; // Continue with the request
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            logger.info("Post Handle method is Calling");
            logger.info("Response Status: " + response.getStatus());
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            logger.info("After Completion method is Calling");
            if (ex != null) {
                logger.severe("Exception: " + ex.getMessage());
            }
        }
    }
    ```
    </details>

2. **Register the interceptor**  
To make your interceptor functional, you need to register it with Spring Boot. This is done by creating a configuration class that implements `WebMvcConfigurer` and overrides the `addInterceptors` method.

    <details><summary>Here's an example of how to register the interceptor</summary>

    ```java
    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        @Autowired
        private CustomInterceptor customInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(customInterceptor);
        }
    }
    ```
    </details>

3. **Test the Interceptor**  
Start your Spring Boot application and make a few requests to test your interceptor. You should see logs in the console indicating that the interceptor's methods are being called at different stages of request processing.

    <details><summary>Interceptro logs</summary>

    ```bash
    : Pre Handle method is Calling
    : Request URL: http://localhost:8081/hello
    : Request Method: GET
    : Post Handle method is Calling
    : Response Status: 200
    : After Completion method is Calling
    ```
    </details>

## Spring Data JPA 
Spring Data JPA is a powerful abstraction in Spring that simplifies working with databases using the Java Persistence API (JPA). It provides a way to handle database operations efficiently without requiring developers to write boilerplate code. 

Spring Data JPA internally uses JPA, the Java standard for Object-Relational Mapping (ORM). With ORM, Java objects are automatically mapped to database tables, making it easier to interact with the database in an object-oriented way.

### 1️⃣ JPA Entities  
An entity in JPA represents a table in your database. Each instance of the entity corresponds to a row in the table. Here’s an example of a simple `Book` entity:

```Java

@Entity // Marks the class as a JPA entity.
public class Book {
    @Id // Specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  Auto-generates the ID for each new entity.
    private Long id;

    private String title;
    private String author;
    private double price;
}
```
### 2️⃣ Repositories
Repositories are interfaces that handle database operations, such as saving, updating, or retrieving data. You can create a repository by extending `JpaRepository` or `CrudRepository`. For instance:

```Java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
```
This interface now provides built-in CRUD methods (save, findById, delete, etc.) without needing to write SQL queries.

### 3️⃣ Query Methods
Spring Data JPA allows you to define query methods directly in your repository by following a specific naming convention. For example:
```java
List<Book> findByTitle(String title);
List<Book> findByAuthor(String author);
```
Spring will automatically generate the required SQL queries based on the method names!

### 4️⃣ Custom Query Methods
Spring Data JPA automatically translates these method names into SQL queries. You can also use the `@Query` annotation to write custom JPQL (Java Persistence Query Language) queries:
```Java
@Query("SELECT b FROM Book b WHERE b.price > :price")
List<Book> findBooksCostlierThan(@Param("price") double price);
```
### 5️⃣ Entity Mapping  
Entity mapping is the process of mapping a Java object (an entity) to a corresponding database table using annotations. Each field in the entity class is mapped to a column in the database, and relationships between entities are mapped to reflect foreign keys, join tables, etc.

JPA provides a set of annotations that simplify this mapping process, eliminating the need to write SQL queries manually.

**Common JPA Annotation Explained**  
1. `@Entity`: 
Once the class is annotated with `@Entity`, JPA automatically maps it to a table in the database. If no table name is specified, the class name will be used by default.

2. `@Id`: The @Id annotation marks a field as the primary key for the entity. Every entity must have an @Id field.
3. `@Column`: The @Column annotation is used to specify the mapping between a field and a database column. It allows customization of column properties such as name, length, nullability, etc.
4. `@Table`: 
The @Table annotation is used to specify the table name for the entity. If the table name differs from the entity class name, you can use this annotation.

**Defining Relationships Between Entities**
1. `@OneToOne`: 
A OneToOne relationship maps one entity to another entity. This is used when an entity has a single related entity.
2. `@OneToMany: 
A OneToMany` relationship indicates that one entity can be associated with multiple related entities. For example, one Author can write many Books.

3. `@ManyToOne`: 
A ManyToOne relationship is the inverse of @OneToMany. In this case, many Books can belong to a single Author.

4. `@ManyToMany`: 
A ManyToMany relationship represents a relationship where multiple entities can be associated with multiple other entities. For example, multiple `Books` can have multiple `Categories`.

<details><summary> Example Code for Entity Mapping and Relationships</summary>
Let’s take a practical example with three entities: Author, Book, and Category.

```java

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(
      name = "book_category",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
}

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Book> books;
}

```

- The `Author` entity is linked to the `Book` entity with a `@OneToMany` relationship.
- The `Book` entity has a `@ManyToOne` relationship with `Author` and a `@ManyToMany` relationship with `Category`.
- The `Category` entity has a `@ManyToMany` relationship with `Book`.

This setup allows each author to write multiple books, each book to belong to multiple categories, and each category to have multiple books.
</details>

### 6️⃣ JPA Cascading Operations
One of the key features of the JPA is Cascading Operations, which allow the propagation of state changes from one entity to the related entities of the JPA application.

**Different types of cascade options in JPA:**
- `PERSIST`: When the parent is persisted (saved), the related entities are also persisted.
- `MERGE`: When the parent is updated, the related entities are updated.
- `REMOVE`: When the parent is deleted, the related entities are deleted.
- `REFRESH`: If the parent is refreshed from the database, the related entities are refreshed.
- `DETACH`: When the parent is detached from the persistence context, the related entities are also detached.
- `ALL`: All of the above cascade operations are applied.

<details><summary>Expand to view the example</summary>

```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}
```
In this example:  
- The `Author` entity has a list of `Book` entities.
- The `cascade = CascadeType.ALL` tells JPA to automatically apply certain operations (like saving or deleting) to the `Book` entities when performed on the `Author`.
</details>

### 7️⃣ Fetching Strategies 
Fetching strategies in JPA determine how and when related entities (associations) are loaded from the database when querying an entity. These strategies are essential for managing performance, particularly when dealing with large datasets and complex relationships.

**JPA provides two main fetching strategies:** 
- Eager Fetching: Loads related entities immediately along with the parent entity.
- Lazy Fetching: Loads related entities on-demand, when they are accessed for the first time.

**Choosing the Right Fetching Strategy**
- Use **Eager Fetching** when you always need the associated entities along with the parent entity. For example, in a **OneToOne** relationship where you frequently access both sides together.
- Use **Lazy Fetching** when associated entities are not always required and should only be fetched when accessed. This helps in optimizing performance, especially in large collections like **OneToMany**.
However, beware of the **N+1 Select Problem** in lazy fetching. This occurs when lazy-loaded entities trigger multiple queries, significantly increasing the number of database calls.

<details><summary>Examples of Fetching Strategies</summary>

**Example 1:** Lazy Fetching in OneToMany   
```Java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> employees;

    // Getter and Setter methods
}
```
Here, `Department` has a `OneToMany` relationship with `Employee`. Employees will only be fetched from the database when you access the `employees` field in a department object.

**Example 2:** Eager Fetching in ManyToOne
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    // Getter and Setter methods
}
```
In this case, when you load an `Employee` entity, its associated `Department` is fetched eagerly.
</details>

### 8️⃣ Paging and Sorting
**Pagination** is the process of breaking down a large dataset into smaller, manageable pages. Instead of loading all the data in one go, we retrieve one page at a time. This is especially useful for handling large datasets in a memory-efficient way.

**Sorting** allows data to be ordered in ascending or descending order based on one or more fields.

Spring Data JPA provides the following interfaces for pagination and sorting:
- **Pageable:** This interface is used to create pagination information, such as the page number and the number of records per page.
- **Sort:** This interface helps to define the sorting logic, such as sorting by a field in ascending or descending order.

Both of these interfaces can be passed as parameters to repository methods.

**Example:** Paginating Through Books  
```Java
@Autowired
private BookRepository bookRepository;

public void getPaginatedBooks(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Book> bookPage = bookRepository.findAll(pageable);

    List<Book> books = bookPage.getContent();  // Get the list of books on the current page
    int totalPages = bookPage.getTotalPages();  // Get total number of pages
    long totalElements = bookPage.getTotalElements();  // Get total number of elements

    System.out.println("Total Pages: " + totalPages);
    System.out.println("Total Elements: " + totalElements);
    books.forEach(System.out::println);  // Print the books on the current page
}
```
In this example:  
- **PageRequest.of(page, size)** creates a **Pageable** object for the specified page number and page size.
- The **Page<Book>** object contains the books for that page, along with additional information like total pages and total elements.

**Example:** Sorting `Books` by Title
```Java
@Autowired
private BookRepository bookRepository;

public void getSortedBooks() {
    List<Book> books = bookRepository.findAll(Sort.by("title").ascending());
    books.forEach(System.out::println);  // Print the sorted books
}
```
This will sort the books in ascending order by their **title** field. You can also sort in descending order by using **.descending().**

**Combining Pagination and Sorting**
```Java
public void getPaginatedAndSortedBooks(int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
    Page<Book> bookPage = bookRepository.findAll(pageable);

    List<Book> books = bookPage.getContent();
    books.forEach(System.out::println);
}

```

### 9️⃣ Database Locking
Locking mechanisms in databases are used to prevent dirty reads, non-repeatable reads, and phantom reads by managing access to data when multiple transactions occur. Locking ensures data consistency and integrity, especially in concurrent environments.

**Types of Locking in JPA**  
1. **Optimistic Locking:**
    - **Definition:** Optimistic locking assumes that multiple transactions can complete without affecting each other, and it only checks for conflicts at the time of committing.
    - **Usage:** Best suited for scenarios where data conflicts are rare.
    - **How It Works:** Entities are checked for modifications using a version field (usually a column like `@Version`). If the version doesn't match during a commit, it indicates a conflict, and an exception is thrown.
    Annotations: `@Version`
2. **Pessimistic Locking:**
    - **Definition:** Pessimistic locking assumes that conflicts will occur, and it locks the data from the moment a transaction starts until it completes.
    **Usage:** Best for cases where there's a high likelihood of conflicts.
    **How It Works:** A row is locked in the database until the transaction completes, ensuring that no other transactions can modify the data.
    **Annotations:** `LockModeType.PESSIMISTIC_READ`, `LockModeType.PESSIMISTIC_WRITE`

**When to Use Optimistic vs. Pessimistic Locking**
1. Optimistic Locking
    - Use when the likelihood of concurrent data conflicts is low.
    - Best for systems with high read-to-write ratios.
    - Example: A ticket booking system where many users are querying availability but only a few are confirming purchases at the same time.
2. Pessimistic Locking
    - Use when the likelihood of conflicts is high.
    - Best for systems where data consistency is critical.
    - Example: A financial system where multiple transactions on the same account need to be processed in a strictly serialized manner.

### 🔟 Transactions in Spring
In any real-world application, especially when interacting with databases, managing data integrity is crucial. Transactions allow us to ensure that a group of operations are executed in an "all-or-nothing" fashion. This means that if one operation fails, all changes made by other operations in the transaction should be rolled back, leaving the system in a consistent state.  

**Key Points**  
Use `@Transactional` at the **service** layer where business logic and database operations are managed.
By default, `@Transactional` rolls back on RuntimeExceptions or unchecked exceptions.
Transactions ensure data consistency and integrity, making them crucial in systems that handle financial operations, order processing, and more.

## Spring Security
Spring Security is a robust framework that enhances Java EE applications by adding essential security features. It acts as a collection of filters that manage authentication, authorization, and protection. This library ensures that applications are secure, user identities are verified, access is properly controlled, and vulnerabilities are mitigated effectively.

`Authentications:` To verify the identity of users.  
`Authorizations:` To control the access to resources based on permissions.  
`Protections:` To protect applications from frequent and well-known security threats.  

To enable Spring Security support, we need to add the `spring-boot-starter-security` dependency in our Spring MVC application.

### 1️⃣ Internal Working of Spring Security
In a Spring Boot application, `SecurityFilterAutoConfiguration` automatically registers the `DelegatingFilterProxy` filter with the name springSecurityFilterChain. Once the request reaches to DelegatingFilterProxy, Spring delegates the processing to `FilterChainProxy` bean that utilizes the `SecurityFilterChain` to execute the list of all filters to be invoked for the current request.

- `SecurityFilterAutoConfiguration`: Automatically registers the `DelegatingFilterProxy` filter under the name springSecurityFilterChain.  
- `DelegatingFilterProxy`: This filter intercepts incoming HTTP requests and delegates their processing to the `FilterChainProxy`.
- `FilterChainProxy`: The `FilterChainProxy` bean manages a list of security filters defined in the `SecurityFilterChain`. It determines which filters should be applied to the current request.
- `SecurityFilterChain`: This component contains the filters that will be executed in sequence for the request, handling various security aspects like authentication, authorization, etc.

**Imagine if This Situation:**  
Your Spring Boot application is like a mall. The mall has various sections, like stores, a food court, and a VIP lounge. Some areas are open to everyone, while others (like the VIP lounge) require special access.

- In this mall analogy, Spring Security’s `DelegatingFilterProxy` is the main security gate.
- This gate ensures that every visitor is routed through the appropriate security checkpoints (filters) managed by the `FilterChainProxy`.
- Each checkpoint in the `SecurityFilterChain` ensures that only authorized and authenticated visitors access restricted areas.  
- If you clear all the necessary checkpoints, you can freely explore the mall, including the restricted VIP areas.

### 2️⃣ Core Spring Security Components
Core Spring Security components are used throughout a Spring Boot application to manage authentication, authorization, and overall security. Here’s where and how these components are typically used:

1. UserDetails Interface:  
    - The **UserDetails** interface represents a user in the Spring Security framework. It provides methods to get user information such as username, password, and authorities.
    - **Purpose:** To encapsulate user information, including authentication and authorization details.
    - **Implementation:** You can use it to extend your User Entity.
 
2. UserDetailsService Interface:  
    - The **UserDetailsService** interface is a core component in Spring Security that is used to retrieve user-related data. It has a single method: *loadUserByUsername()*.
    - **Purpose:** To fetch user details from a datasource (e.g., database) based on the username.
    - **Implementation:** You typically implement this interface to load user details, such as username, password, and roles, from your own user repository.
 
3. InMemoryUserDetailsManager Interface:
    - The **InMemoryUserDetailsManager** is a Spring Security provided implementation of **UserDetailsService** that stores user information in memory.
    - **Purpose:**To store user details in memory, typically for testing or small applications. You define users directly in the configuration.
 
4. PasswordEncoder Interface: 
    - The **PasswordEncoder** interface is used for encoding and validating passwords. It has methods for encoding raw passwords and matching encoded passwords.
    - **Purpose:** To securely hash passwords before storing them and to verify hashed passwords during authentication.
    - Common Implementations: 
        - BCryptPasswordEncoder 
        - Pbkdf2PasswordEncoder 
        - SCryptPasswordEncoder

### 3️⃣ Understanding JWT
JWT stands for JSON Web Token. A JSON Web Token is a digitally signed token used to securely transmit information between parties in a compact format. It’s like a digital passport that allows users to access different parts of a web application without having to repeatedly log in. The token itself contains all the necessary information, and its signature ensures that the data has not been tampered with. This makes JWT a powerful tool for enabling stateless authentication, where the server doesn’t need to remember who you are, but can still trust the information you provide each time you interact with it.

1. **JWT Creation**  
Think of JWT as a digitally signed message. It consists of three parts: a header, payload(which contains the data), and a signature (which ensures that the message hasn’t been tampered with)
    - **Sample Token:** `eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9`.`eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ`.`SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c`
    - **JWT Header:**  Contains metadata about the token, such as the signing algorithm (`HS256`) and token type (`JWT`).
    - **JWT Payload:** Contains the claims (e.g., user information, expiration time).
    - **Secret Key:** Used to sign the token, ensuring its integrity.
    - **Signature Generation:**
        - The encoded header and payload are concatenated with a period (`.`) in between.
        - This concatenated string is hashed using the HMAC-SHA256 algorithm, along with the secret key.
        - The result is base64url encoded to produce the encoded signature.
    
    - **Final Token:** The token is the concatenation of the encoded header, payload, and signature, separated by periods (.).

## Production Ready Features
### 1️⃣ Logging
Logging is the process of recording events, errors, and informational messages from an application. It helps developers and system administrators track the application's behavior and troubleshoot issues.

Many programming languages have libraries and frameworks (like Log4j, SLF4J, or Python’s logging module) that simplify the logging process and offer advanced features like formatting and log rotation.

**Elements of Logging Framework:**  
Every logging framework comes with three elements.
1. **Logger** — capture the messages
2. **Formatter** — formats the messages captured by the logger
3. **Handler** — Dispatches the messages by printing them on the console , or storing them in a file , sending an email, etc.  

**Log Levels**  
The messages logged can be of various security levels . Spring Boot supports five log levels which are
1. FATAL – fatal error crashing the system
2. ERROR — runtime errors
3. WARN — warning
3. INFO — events occurring at the run time
4. DEBUG — Information about the flow of the system
5. TRACE — more detailed information about the flow of the system  
Each level serves a specific purpose, helping developers prioritize and filter log messages based on their severity or importance.
<details>
<summary>Example: Logging using SLF4J</summary>

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeClient {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeClient.class);

    public EmployeeDto createNewEmployee(EmployeeDto input) {

        logger.trace("TRACE log");
        logger.debug("DEBUG log");
        logger.info("Creating new employee");
        logger.warn("Sample warning log");
        logger.error("Sample error log");

        try {
            // business logic
        } catch (Exception e) {
            logger.error("Error while creating employee", e);
        }

        return null;
    }
}
```
</details>

</br>

**Log Formatters**  
Customize console log output in `application.properties`.
```bash
#properties:
logging.pattern.console=%d [%level] %c{2.} [%t] %m%n
```
| Pattern  | Meaning     |
| -------- | ----------- |
| `%d`     | Date & time |
| `%level` | Log level   |
| `%c`     | Class name  |
| `%t`     | Thread name |
| `%m`     | Log message |
| `%n`     | New line    |

**Log File Configuration**  
```bash
# Save logs into a file.
logging.file.name=error.log # Spring Boot will automatically create the log file.
# File Log Pattern
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss.SSS} [%level] %c{2.} [%t] %m%n
```

## Random Terminology
### Stateful vs. Stateless Architecture
**Stateful** architecture maintains client session data on servers, while **stateless** architecture treats each request independently.

## 🧩 Featured Projects  
### 1. Task Management System - [Console Application](/core_java/task_management_system%20console_app/)
- A console-based Java application for Simple Task Management System
- Focuses on OOP concepts, core Java APIs, and real-world problem-solving

### 2. Task Management System - [Spring Boot Application](/task_management_system/) 
- Spring Boot application with CRUD operations, authentication, authorization, and JWT-based security for multi-user access.
- It supports multi-user access using JWT-based security and follows clean, scalable backend design practices.

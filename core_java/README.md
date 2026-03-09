# 📘 Learn Core Java
As a **Computer Science graduate** with strong fundamentals in **C/C++ and Object-Oriented Programming (OOP)**, I am learning **Core Java** to transition into backend development with **Spring Boot**.

## My Learning Strategy
- I do not memorize Java syntax mechanically
- I scan Java concepts quickly
- I practice and document only Java-specific or hard-to-retain topics
- I focus on:
  - Differences between **Java vs C/C++**
  - Concepts required for **Spring Boot & enterprise development**
  - Core APIs used in **real-world backend systems**

This repository acts as a personal **revision notebook**

## 🛠️ Environment Setup

You need the following:

- **JDK (Java Development Kit)**
- **IDE (any one)**
  - IntelliJ IDEA  
  - Eclipse  
  - VS Code
- **Environment Variables**
  - `JAVA_HOME`
  - Add JDK `bin` directory to `PATH`
## 📂 Repository Structure
```
├───advanced_java
│   └───regex_practice
├───basics
├───collections_and_dsa
├───file_handling
├───object_oriented_programming
└───task_management_system console_app  # A console-based Java application for Simple Task Management System.
```

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
### Java Operator Precedence
Here are some common operators, from highest to lowest priority:
- `()` - Parentheses
- `*`, `/`, `%` - Multiplication, Division, Modulus
- `+`, `-` - Addition, Subtraction
- `>`, `<`, `>=`, `<=` - Comparison
- `==`, `!=` - Equality
- `&&` - Logical AND
- `||` - Logical OR
- `=` - Assignment
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
    nextLine()	# Reads a full line of text (String) from the user until the Enter key is pressed
    next()       # Reads a single word (String) from the user and stops reading when it encounters whitespace (space, tab, or newline)
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

# Java Regular Expressions
- A regular expression is a sequence of characters that forms a search pattern. When you search for data in a text, you can use this search pattern to describe what you are searching for.
- A regular expression can be a single character, or a more complicated pattern.
- Regular expressions can be used to perform all types of text search and text replace operations.

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

## Important Key Notes on Regular Expressions

### 1. Anchors
  | Symbol | Meaning |
  |--------|---------|
  | `^`    | Start of string/line |
  | `$`    | End of string/line |
  | `\b`   | Word boundary |
  | `\B`   | Not a word boundary |

### 2. Character Classes
| Symbol       | Meaning |
|--------------|---------|
| `[abc]`      | Character set (any of a, b, c) |
| `[^abc]`     | Negated set (not a, b, c) |
| `[a-z]`      | Range (any lowercase letter) |
| `.`          | Any character except newline |
| `\w`         | Word character `[a-zA-Z0-9_]` |
| `\W`         | Not a word character |
| `\d`         | Digit `[0-9]` |
| `\D`         | Not a digit |
| `\s`         | Whitespace |
| `\S`         | Not whitespace |

### 3. Flags
| Flag | Meaning |
|------|---------|
| `i`  | Ignore case |
| `g`  | Global (match all) |
| `m`  | Multiline mode |

### 4. Groups & References
| Symbol | Meaning |
|--------|---------|
| `()`   | Group |
| `\1`   | Reference to first group |
| `(?:)` | Non-capturing group |

### 5. Lookarounds
| Symbol    | Meaning |
|-----------|---------|
| `(?=...)` | Positive lookahead |
| `(?!...)` | Negative lookahead |
| `(?<=...)`| Positive lookbehind |
| `(?<!...)`| Negative lookbehind |

### 6. Quantifiers & Alternation
| Symbol       | Meaning |
|--------------|---------|
| `+`          | One or more |
| `*`          | Zero or more |
| `?`          | Zero or one (optional) |
| `{n}`        | Exactly n times |
| `{n,m}`      | Between n and m times |
| `\|`          | Alternation (OR) |

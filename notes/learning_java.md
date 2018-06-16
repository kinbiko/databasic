# Learning Java
*First sessions have been partly documented and are available at: http://learning-java.surge.sh/*

#### Declaration and assignment:
```java
int num1;           // Declaration of a variable num1
num1 = 50;          // Assignment
int num2 = 100;     // Declaration of variable num3 and its initialization
```

```java
//The following snippet of code prints all elements of an int array numList:
int[] numList = {10, 20, 30, 40};
for(int num : numList) {
    System.out.println(num);
}
```

## OOP Design
Classes are the basic units of programming in the object-oriented paradigm, and are used as templates to create objects.
A class in Java may consist of five components:
- Fields
- Methods
- Constructors
- Static initializers
- Instance initializers

#### The main() method serves as the entry point for a Java application:
```java
public static void main(String[] args) {
        // Method body goes here
}
```

Fields and methods are also known as members of the class. Classes and interfaces can also be members of a class.

*It is a convention (not a rule or a requirement) in java to start a class name with an uppercase letter and capitalize the subsequent words, for example, Human, Table, ColorMonitor, etc. the name of fields and methods should start with a lowercase letter and the subsequent words should be capitalized, for example, name, firstName, maxDebitAmount, etc.*

#### The general syntax for declaring a class in Java is:
```java
<<modifiers>> class <<class name>> {
    // Body of the class goes here
}
```

### `modifiers`
| Access Level for Class Member | Accessibility                             |
|-------------------------------|-------------------------------------------|
| private                       | Only within the same class                |
| package-level                 | In the same package                       |
| protected                     | Same package or descendant in any package |
| public                        | Everywhere                                |

Fields of a class represent properties (also called attributes) of objects of that class. Suppose every object of human class has two properties: a name and a gender. The human class should include declarations of two fields: one to represent name and one to represent gender.

*The fields are declared inside the body of the class. The general syntax to declare a field in a class is:*
```java
<<modifiers>> class <<class name>> {
    // A field declaration
    <<modifiers>> <<data type>> <<field name>> = <<initial value>>;
}
```

```java
// Human.java
class Human {
    String name;
    String gender;
}
```

The Human class declares two fields: name and gender. Both fields are of the String type. Every instance (or object) of the Human class will have a copy of these two fields.

*Java lets you declare two types of fields for a class:*
- Class fields
- Instance fields

```java
class Human {
        String name;        // An instance variable
        String gender;      // An instance variable
        static long count;  // A class variable because of the static modifier
}
```

A class variable is also known as a static variable. An instance variable is also known as a non-static variable.

*Create an instance of a class:*
```java
new <<Call to Class Constructor>>;
```

The new operator is followed by a call to the constructor of the class whose instance is being created. The new operator creates an instance of a class by allocating the memory on heap.

*The following statement creates an instance of the Human class:*
```java
new Human();
```

When you do not add a constructor to a class, the Java compiler adds one for you. The constructor that is added by the Java compiler is called a default constructor. The default constructor accepts no arguments. The name of the constructor of a class is the same as the class name.

*The general syntax for a method declaration is of the form:*
```java
<<modifiers>> <<return type>> <<method name>> (<<parameters list>>) <<throws clause>> {
        // Body of the method goes here
}
```

#### `this` keyword is a reference to the current instance of a class. It can be used only in the context of an instance.
```java
public class ThisTest1 {
        int varA = 555;
        int varB = varA;      // Assign value of varA to varB
        int varC = this.varA; // Assign value of varA to varC
}
```

#### A constructor is a named block of code that is used to initialize an object of a class immediately after the object is created.
- The structure of a constructor looks similar to a method.
- A constructor does not have a return type.
*The general syntax for a constructor declaration is:*
```java
<<Modifiers>> <<Constructor Name>>(<<parameters list>>) throws <<Exceptions list>> {
        // Body of constructor goes here
}
```

*Example:*
```java
public class Dog {
    // Constructor #1
    public Dog() {
        System.out.println("A dog is created.");
    }
    // Constructor #2
    public Dog(String name) {
        System.out.println("A dog named " + name + " is created.");
    }
}
// These obejects use different constructors
Dog dog1 = new Dog();
Dog dog2 = new Dog("Cupid");
```

#### Getters and Setters
- Accessors and Mutators/modifiers
```java
class Clock {
        String time;
        void setTime (String t) {   //setter
           time = t;
        }
        String getTime() {          //getter
           return time;
        }
}

class ClockTest{
   public static void main (String [] args) {
   Clock c = new Clock;
   c.setTime("12345")
   String today = c.getTime();
   System.out.println("time: " + today);
 }
}
```

## IntelliJ Shortcuts

| Shortcut         | Meaning                                        |
|------------------|------------------------------------------------|
| alt + Return     | Error/syntax improvement                       |
| alt + Space      | Definition                                     |
| cmd + alt + L    | Improve formatting                             |
| ctrl + shift + T | Create test                                    |
| ctrl + alt + R   | Run class/test                                 |
|                  |                                                |
| cmd + alt + C    | Extract constant (on variable)                 |
| cmd + alt + V    | Extract variable (that is used mulitple times) |
| cmd + alt + N    | Inline variable                                |
| cmd + alt + M    | Extract method                                 |
|                  |                                                |
| shift + F6       | Rename                                         |
| cmd + K          | Git commit                                     |

# Description of how I learned about unit testing
### TDD cycle           ==> fail, pass, refactor
*Refactoring = amplify clarity of intent while minimizing duplication.*

After creating a class, use (ctrl + shift + T) to create a test class. So far I have been using JUnit4 for testing.
*An initial test will look like this:*
```java
public class <<TestName>> {
    @Test
    // Test goes here
}
```

### The JUnit Assert class provides the following methods:
| Method            | Function                                                              |
|-------------------|-----------------------------------------------------------------------|
| assertEquals      | Asserts that two objects (or primitives) are equal.                   |
| assertArrayEquals | Asserts that two arrays have the same items.                          |
| assertTrue        | Asserts that a statement is true.                                     |
| assertFalse       | Asserts that a statement is false.                                    |
| assertNull        | Asserts that an object reference is null.                             |
| assertNotNull     | Asserts that an object reference is not null.                         |
| assertSame        | Asserts that two object references point to the same instance.        |
| assertNotSame     | Asserts that two object references do not point to the same instance. |
| assertThat        | Asserts that an object matches the given conditions.                  |


A good convention is to name a test class with in the form `givenX_doY`:
```java
@Test
    void givenNullObject_NoResults() {
        Assertions.assertEquals(<<expected>>, <<input>>);
    }
```

At the start of the test, create a `target` variable:
```java
<<Object type in class to test>> target = new <<Object type in class to test>>();
```
*For example:*
```java
@Test
public void canWriteAndGetJsonPath() {
    JsonPath target = new JsonPath();
    target.setJsonPath("number.value");
    String result = target.getJsonPath();
    Assertions.assertEquals("number.value", result);
}
```

### Exception handling
- An execption is an object
- An exception in Java is an object that encapsulates the details of an error.
- the use of `try/catch` blocks is useful to catch issues

```java
try {
    // Code for the try block goes here
}
catch (ExceptionClassName parameterName) {
    // Exception handling code goes here
}
```


---
Markdown -> HTML:   https://dillinger.io/
Tables:             https://www.tablesgenerator.com/markdown_tables

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
Look around you...
The real-world objeccts in the area around you (such as computer, clock, mirror, air-conditioner, shelves, door, etc.) have two major charateristics:
- state (qualities, how it looks) ==> in OOP: stores its state in fields
- behaviour (things it can do)    ==> in OOP: expose behaviour in methods

Classes are the basic units of programming in the object-oriented paradigm, and are used as templates to create objects.
A class in Java may consist of two components:
- Fields
- Methods (and Constructors)

#### The main() method serves as the entry point for a Java application:
```java
public static void main(String[] args) {
        // Method body goes here
}
```

Fields and methods are also known as members of the class. Classes and interfaces can also be member variables of a class.

*It is a convention (not a rule or a requirement) in java to start a class name with an uppercase letter and capitalize the subsequent words (`CamelCase`), for example, Human, Table, SumOfTriangles, etc. the name of fields and methods should start with a lowercase letter and the subsequent words should be capitalized (`pascalCase`), for example, name, firstName, maxDebitAmount, etc.*


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

*It's important to note that these are cascading permissions. E.g. package-private (not package-level btw) is also accessible from within the same class. Similarly, protected is also visible by classes in the same package, etc.*

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
        static long count;  // A static field because of the static modifier
}
```

A class variable is also known as a static field. An instance/member variable is also known as a non-static variable - or field.

*Create an instance of a class:*
```java
new <<Call to Class Constructor>>;
```

The new operator is followed by a call to the constructor of the class whose instance is being created. The new operator creates an instance of a class by allocating the memory on heap.
*I don't really need to worry about memory allocation at the moment because Java handles this with the garbage collector.*

*The following statement creates an instance of the Human class:*
```java
new Human();
```

When you do not add a constructor to a class, the Java compiler adds one for you. The constructor that is added by the Java compiler is called a `default constructor`. The default constructor accepts no arguments. The name of the constructor of a class is the same as the class name.

*The general syntax for a method declaration is of the form:*
```java
<<modifiers>> <<return type>> <<method name>> (<<parameters list>>) <<throws clause>> {
        // Body of the method goes here
}
```

TIP: Write the methods you wish you had - just pretend they exist. Write the method's name - then hotkey (opt + Return) to generate.

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
<<Modifiers>> <<Constructor Name>>(<<parameters list>>){
        // Body of constructor goes here
}
```

*Pro tip: Don't ever throw exceptions in your constructor. It's a sign that the constructor is doing more than just setting up it's initial state. (e.g. making database connections).*


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
| cmd + B          | Go to Declaration (more info)                  |
|                  |                                                |
| cmd + alt + C    | Extract constant (on variable)                 |
| cmd + alt + V    | Extract variable (that is used mulitple times) |
| cmd + alt + N    | Inline variable                                |
| cmd + alt + M    | Extract method                                 |
|                  |                                                |
| shift + F6       | Rename                                         |
| cmd + K          | Git commit                                     |
| cmd + N          | Generate... (can automate getters/setters...)  |

# Description of how I learned about unit testing
### TDD cycle           ==> fail, pass, refactor

*Refactoring = amplify clarity of intent while minimizing duplication.*

After creating a class, use (ctrl + shift + T) to create a test class. So far I have been using JUnit4 for testing.
*An initial test will look like this:*
```java
public void class <<TestName>> {
    @Test
    // Test goes here
}
```

*Important: tests must be public void*

### The JUnit Assert class provides the following methods:
| Method            | Function                                                              |
|-------------------|-----------------------------------------------------------------------|
| assertEquals      | Asserts that two objects (or primitives) are equal.                   |
| assertTrue        | Asserts that a statement is true.                                     |
| assertFalse       | Asserts that a statement is false.                                    |
| assertNull        | Asserts that an object reference is null.                             |
| assertNotNull     | Asserts that an object reference is not null.                         |
|  *uncommon assertions below*                                                              |
| assertSame        | Asserts that two object references point to the same instance.        |
| assertNotSame     | Asserts that two object references do not point to the same instance. |
| assertThat        | Asserts that an object matches the given conditions.                  |
| assertArrayEquals | Asserts that two arrays have the same items.                          |


A good convention is to name a test class with in the form `givenX_doY`:
```java
@Test
    void givenNullObject_NoResults() {
        Assertions.assertEquals(<<expected>>, <<input>>);
    }
```
---
NOTE: TCWP not understanding RG's comment: `s/input/actual`
---
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

*Make sure your tests are properly writen before you utilise them!
Trying to get the code to pass a bad test (unaware this might be the cause of EVERY SINGLE PROBLEM!) will drive you crazy!
In the following example, I'm trying to find the unique element in a array of type double. Notice that the answer should be `3.0`, but that the test asserts that it should be `1.0`!*
```java
 @Test
    public void FindUniqueElementTest() {
        assertEquals(1.0, FindUniqueElement.finder(new double[]{0.0, 0.0, 3.0, 0.0}), 0.0000000000001 );
    }
```

### Exception handling
- An execption is an object
- An exception in Java is an object that encapsulates the details of an error.
- the use of `try/catch` blocks is useful to catch issues:
I'm going to
`TRY` this risky thing
and I'm going to
`CATCH` myself if I fall


```java
try {
    // Code for the try block goes here
    // do risky thing
}
catch (ExceptionClassName parameterName) {
    // Exception handling code goes here
    // try to recover
}
```
An excecption is an object that extends the 'Exception' class.

---
`Quiz`: Look into the difference between RuntimeException and Exception to understand why we wrap some of our exceptions in runtime exceptions

`Error` and `Exception` both extend `Throwable`. Errors cannot be handled, however there is an opportunity to handle Excecptions.
`Error` along with `RuntimeException` & their subclasses are `unchecked exceptions`. All other `Exception` classes are `checked exceptions`.
`Checked exceptions`: They extend the java.lang.Exception class. A program can recover from these, and you are expected to check for these exceptions by using the `try-catch-finally` or `throw` it back to the `caller`.
`Unchecked exceptions`: They extend the java.lang.RuntimeException.
RuntimeException: a more specific Exception (this could help during debugging), and usually the result of invalid user input.
The main reason one would use exception wrapping is to prevent the code further up the call stack from having to know about every possible exception in the system.
RuntimeException, is reserved for exceptions that indicate incorrect use of an API.
Unchecked exceptions should be reserved for system errors which cannot/should not be recovered.


`Quiz`: find a more elegant solution for verifying that exceptions are being thrown in JUnit tests, using an @Annotation.

The following techniques exist for testing exceptions:
– "Old school" try-catch idiom
– @Test annotation with expected element
– JUnit ExpectedException rule
– Lambda expressions (Java 8+)

In JUnit, rules (@Rule) can be used as an alternative or an addition to fixture setup and
cleanup methods: @Before, @After, @BeforeClass, and @AfterClass. ExpectedException rule is meant for verification that code throws a specific exception. The rule must be declared as public field annotated with @Rule annotation:

public class SimpleExpectedExceptionTest {
     @Rule
     public ExpectedException thrown= ExpectedException.none();

     @Test
     public void throwsNothing() {
         // no exception expected, none thrown: passes.
     }

     @Test(expected = NullPointerException.class)
     public void throwsExceptionWithSpecificType() {
         thrown.expect(NullPointerException.class);
         throw new NullPointerException();
     }
 }
---

package Inheritance;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.speak();
        dog.speak();

    }
}

# 4 Pillars of OOP
- Abstraction, polymorphism, inheritance & encapsulation.
Inheritance: "A is-a B"


# Extending classes: Abstract classes and Interfaces
## *`Abstract classes:`*
- keyword <<abstract>> is added to the class
- Superclasses that are meant to be extended by other classes (other classes can inherit from that class)
- you can't instantiate them (the construction must be done through the subclasses)
- as soon as there is one abstract method - the class must become abstract.
- the abstract methods have no braces, no implementation, and just ends in a semicolon.
- a partially completed class
- you must have a subclass that implements it.
- Subclasses must conform to the contracts set up by the abstract class
- the abstract methods in the abstract class must be used when being implemented as child classes (compile time safety)
- when you know the methods, but you might not know how they are to be implemented
- cannot be marked as final
- in UML, abstract classes and abstract methods are in *italic*
- recommended not to use abstract classes where possible.


## `Interfaces:`
- keyword <<interface>> is used instead of class
- must be public or package access scope
- you cannot create an instance of an interface
- therefor, no constructor
- A contract that all the methods in an interface will be implemented
- A hierarchy of interfaces can be created
- a class can implement as many interfaces as needed
- interfaces can implement any number of interfaces.
- Interface naming convention: start with Can-, end with -able
- recommended not to make interfaces with constants. (put the final constants in a final class)
- All fields in an interface are implicitly public, static, and final - their use is redundant.
- The general (incomplete) syntax for declaring an interface is:
<modifiers> interface <interface-name> {
        Constant-Declaration
        Method-Declaration
        Nested-Type-Declaration
}

# Generics

With `generics`, you tell the compiler what types of objects are permitted in each collection. The compiler inserts casts for you automatically and tells you at compile time if you try to insert an object of the wrong type. This results in programs that are both safer and clearer, but these benefits come with complications.

A class or interface whose declaration has one or more *type parameters* is a *generic* class or interface.

A List interface can have a single type parameter, E, representing the element type of the list. The name of the interface is now List<E> (read “list of E”), but people often call it *List* for short. Generic classes and interfaces are collectively known as `generic types`.

Each generic type defines a set of *parameterized types*, which consist of the class or interface name followed by an angle-bracketed list of *actual type parameters* corresponding to the generic type’s formal type parameters. For example, List<String> (read “list of string”) is a parameterized type representing a list whose elements are of type String.

It is an unwritten convention that type parameter names are one character, and to use T to indicate that the parameter is a type, E to indicate that the parameter is an element, K to indicate that the parameter is a key, N to indicate the parameter is a number, and V to indicate that the parameter is a value.

`Unbounded wildcard types`: If you want to use a generic type but you don’t know or care what the actual type parameter is, you can use a question mark instead. For example, the unbounded wildcard type for the generic type Set<E> is Set<?> (read “set of some type”). It is the most general parameterized Set type, capable of holding any set.

## Generics: Terms and Examples

| Term                    | Example                          |
|-------------------------|----------------------------------|
| Parameterized type      | List<String>                     |
| Actual type parameter   | String                           |
| Generic type            | List<E>                          |
| Formal type parameter   | E                                |
| Unbounded wildcard type | List<?>                          |
| Raw type                | List                             |
| Bounded type parameter  | <E extends Number>               |
| Recursive type bound    | <T extends Comparable<T>>        |
| Bounded wildcard type   | List<? extends Number>           |
| Generic method          | static <E> List<E> asList(E[] a) |
| Type token              | String.class                     |


# Collections

Java provides Collection Framework which defines several classes and interfaces to represent a group of objects as a single unit.

The Collection interface (java.util.Collection) and Map interface (java.util.Map) are two main root interfaces of Java collection classes.

`Hierarchy of Collection Framework` (core interfaces only)

```
             Collection                Map
         /     /    \      \            |
        /      /      \     \           |
     Set    List    Queue  Dequeue   SortedMap
     /
    /
 SortedSet
```
---

```
Collection : Root interface with basic methods like add(), remove(),
             contains(), isEmpty(), addAll(), ... etc.

Set : Doesn't allow duplicates. Example implementations of Set
      interface are HashSet (Hashing based) and TreeSet (balanced
      BST based). Note that TreeSet implements SortedSet.

List : Can contain duplicates and elements are ordered. Example
       implementations are LinkedList (linked list based) and
       ArrayList (dynamic array based)

Queue : Typically order elements in FIFO order except exceptions
        like PriorityQueue.

Deque : Elements can be inserted and removed at both ends. Allows
        both LIFO and FIFO.

Map : Contains Key value pairs. Doesn't allow duplicates.  Example
      implementation are HashMap and TreeMap.
      TreeMap implements SortedMap.

The difference between Set and Map interface is, in Set we have only
keys, but in Map, we have key value pairs.
```


# Casting

class A {}
class B extends A{
    public void methodThatExistsOnlyOnB() {
    }
}
class Whatev {
    public static void main(String[] args) {
        A obj = new B();
        //....
        if (obj instanceof B) {
            ((B) obj).methodThatExistsOnlyOnB();
        }
    }
}


---

Markdown -> HTML:   https://dillinger.io/
Tables:             https://www.tablesgenerator.com/markdown_tables

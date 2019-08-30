---?color=#1C1C1C
## Kotlin in an evening

---?color=#1C1C1C
@snap[west span-45]
#### Who am I
@ul[split-screen-list text-08](false)
- 34 years
- Married, 2 kids
- Software Developer
- Programming since 1993 
- Coding is fun
@ulend
@snapend

@snap[east span-40]
![split-screen-img span-40](assets/img/danny.png)
@snapend

---?color=#1C1C1C
## What will we Do
@ul[split-screen-list text-08](false)
- Kotlin in Action in rapid tempo 
- H1-4
- Coffee break
- H5-7
- H8-11 out of scope, it needs to stay fun ;) 
- Coding!
@ulend

---?color=#1C1C1C
@snap[north span-100]
#### H1
@snapend

- Wat is Kotlin
    - Server side, android, anywhere java runs
    - staticly typed (known at compile time)
    - Functional and Object-oriented
- Waarom Kotlin?
    - Free
    - Pragmatic / concise / safe / interoperable
---
@snap[north span-100]
#### H2 - Functions
@snapend
```kotlin
fun someMethod() {}

fun someReturningMethod():String = "Hi there"

fun someReturningMethod():String = {
return "Hi there"
}
```
---
@snap[north span-100]
#### H2 - Variables
@snapend
```kotlin
val someVal = "Hi"
someVal = "this isn't possible" 

var somVar = "Hi"
someVar = "this is possible"

val notReallyNeeded:String = "redundant"
```
---
@snap[north span-100]
#### H2 - String formatting
@snapend
```kotlin
"""
   This 
   is pretty 
   cool 
"""

"Random value $myVal" // Values in formatting

"Random number ${Random().nextInt()}" // Methods in formatting
                                      // Note the brackets {}          
```
---
@snap[north span-100]
#### H2 - Classes / Properties (1)
@snapend
```kotlin
// public and final by default

class MyClass {
    // functions
}          

class MyClass(val someVal: String){
    // Only getters (val is immutable)
}

class MyClass(var someVal: String){
    // getters / setters (var is mutable)
}
```
---
@snap[north span-100]
#### H2 - Classes / Properties (2)
@snapend
```kotlin
data class MyDataClass {
    // The compiler automatically derives the following members
    
    // equals()/hashCode() pair;
    // toString() of the form "MyDataClass(someParam=someVal)";
}              
```
---
@snap[north span-100]
#### H2 - Classes / Properties (3)
@snapend
```kotlin
class MyClass {
    var someParameter: String = ""
        set(value) {
            println("The someParameter for $id has changed to $value")
            field = value
        }
        get() = someParameter        
}              
```
---
@snap[north span-100]
#### H2 - Enums / When
@snapend
```kotlin
enum class Colors {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    ORANGE
}

fun colorSwitch(c: Colors): String = when (c) {
    Colors.RED, Colors.YELLOW, Colors.ORANGE -> "Warm"
    Colors.GREEN -> "Neutral"
    Colors.BLUE -> "Cold"
}                     
```
---
@snap[north span-100]
#### H2 - In / Is
@snapend
```kotlin
fun whenIn(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a character"
    else -> "I have no Idea"
}

fun whenIs(a: Any) = when (a) {
    is String -> "it's a String"
    !is String -> "it's not a String"
}                    
```
---
@snap[north span-100]
#### H2 - As ('Unsafe' / 'Safe' casts)
@snapend
```kotlin
// The unsafe way
// note that; Null cannot be cast to String as this type is not nullable
val x: String = y as String

// The safe way, returns null when fails
val x: String? = y as? String

fun whenIs(a: Any) = when (a) {
    is String -> "it's a String"
    !is String -> "it's not a String"
}                    
```
---
@snap[north span-100]
#### H2 - While / For
@snapend
```kotlin
fun doWhile() {
    var a = 100
    while (a > 0) {
        print(a)
        a--
    }
}

fun whileFunction() {
    var a = 100
    do {
        print(a)
        a--
    } while (a > 0)
}      
```
---
@snap[north span-100]
#### H2 - While / For (2)
@snapend
```kotlin
fun forLoop() {
    for (i in 0..100) {
        print(i)
    }
}

fun forLoop(a: Int) {
    for (i in 0 until a) {
        print(i)
    }
}            
```
---
@snap[north span-100]
#### H2 - While / For (3)
@snapend
```kotlin
fun forUntilWithStep() {
    for (i in 0 until 100 step 2) {
        print(i)
    }
}

fun forDownToWithStep() {
    for (i in 100 downTo 0 step 2) {
        print(i)
    }
}        
```
---
@snap[north span-100]
#### H2 - Iterating over Maps
@snapend
```kotlin
fun forEachMaps(m: Map<String, String>) {
    for((key, value) in m){
        println("The key $key and value $value")
    }
}       
```
---
@snap[north span-100]
#### H3 - Named arguments
@snapend
```kotlin
fun overriding(id: String, name: String, location: String = "unknown") {
    // do Something
}

overriding("id", "name")

overriding("id", "name", "location")

overriding(name = "name", id = "id")

// Unable to mix named an positioned arguments, so a name is mandatory
overriding(name = "name", id = "id", location = "location")   
```
---
@snap[north span-100]
#### H3 - Getting rid of util classes
##### Extension functions / properties
@snapend
```kotlin
fun String.methodDoesNotExistOnString(): Char = this.get(0)

val String.parameterNotExistOnString: String
    get() = "My property"

fun foo() {
    println("The method: ${"Kotlin".methodDoesNotExistOnString()}")
    println("The property: ${"".parameterNotExistOnString}")
}

// The method: K
// The property: My property
```
---
@snap[north span-100]
#### H3 - Collections
##### SetOf, ListOf, Pairs, MapOf
@snapend
```kotlin
setOf(Colors.RED, Colors.YELLOW)

listOf(Colors.RED, Colors.YELLOW)

Pair("a", "b")

mapOf(Pair("a", "b"), Pair("c", "d"))
```
---
@snap[north span-100]
#### H3 - Local functions (functions in functions)
@snapend
```kotlin
fun outer() {
    fun inner() {
        
    }
    
    fun innerAsWell(){
        
    }
    
    inner()
    innerAsWell()
}
```
---
@snap[north span-100]
#### H4 - Interfaces
@snapend
```kotlin
interface MyInterface {
    fun foo()
    fun bar() = println("baz") // Default implementation
}

interface MyOtherInterface {
    fun foo()
    fun bar() = println("bazzz") 
}

// Gives an error, 'because it inherits many implementations'
class HasError: MyInterface, MyOtherInterface

class NoError: MyInterface, MyOtherInterface {
    override fun bar() = "No Error Impl"
}
```
---
@snap[north span-100]
#### H4 - Open, final and abstract
##### Final by default
@snapend
```kotlin
// To prevent the 'fragile base class' everything is final

open class MyClass: MyInterface {
    fun notOverridable() = "Sorry"
    
    open fun overridable() = "Yes you can"
    
    final override fun foo() {
        // some implementation
    }
}

class MyChild: MyClass() {
    override fun foo() {} // This will give an error

    override fun overridable() = "This is still possible"
}
```
---
@snap[north span-100]
#### H4 - Visibility
@snapend
```kotlin
// public by default

public class Public // redundant 

internal class Internal // Only usable in module

protected class Protected // Only usable by subclasses

private class Private // Private...
```
---
@snap[north span-100]
#### H4 - Inner and Outer
@snapend
```kotlin
class Outer {
    class Inner {
        fun getOuter(): Outer = this@outer
    }
}
```
---
@snap[north span-100]
#### H4 - Sealed (1)
@snapend
```kotlin
interface Expr {
    class Sum : Expr
    class Multiply : Expr
}

fun switchIt(e: Expr) = when(e){
    is Num -> "num"
    is Sum -> "sum"
    else -> "don't know"
}
```
---
@snap[north span-100]
#### H4 - Sealed (2)
@snapend
```kotlin
sealed class Expr {
    class Sum : Expr()
    class Multiply : Expr()
}

fun switchIt(e: Expr) = when(e){
    is Expr.Multiply -> "num"
    is Expr.Sum -> "sum"
    else -> "don't know" // Redundant / not needed anymore
}

fun switchIt(e: Expr) = when(e){
    is Expr.Multiply -> "num"
    is Expr.Sum -> "sum"
}
```
---
@snap[north span-100]
#### HX - Coffee
@snapend
```kotlin

// Finally ! ~5 minutes

```
---
@snap[north span-100]
#### H5 - Lamdas
@snapend
```kotlin
data class Person(val name:String, val age:Int)

val people = listOf(Person("Danny", 34), Person("Desiree", 34))

people.maxBy({ it.age })
people.maxBy { it.age } // Preferred way for write
people.maxBy { p -> p.age } 
people.maxBy(Person::age) // By Method reference
 
val byAge = Person::age
people.maxBy(byAge)

val byAge = { p:Person -> p.age }
people.maxBy(byAge)
```
---
@snap[north span-100]
#### H5 - Collections
@snapend
```kotlin
// many many functions
// all, any, count
// find, min, max
// average, groupBy, flatMap
// map, filter
```
---
@snap[north span-100]
#### H5 - Lazy vs Eager
@snapend
```kotlin
val people = listOf(Person("Danny", 34), Person("Desiree", 34))

// sequences (asSequence()), can be compared to streams to java
// Need a terminator operator to start (toList, toSet, etc)
// Should be used to enhance performance (big collections)
val sequence = people.asSequence().filter { it.age > 30 } .toList()

// Default actions on collections are eager, always returning a collection
val eager = people.filter { it.age > 30 }
```
---
@snap[north span-100]
#### H6 - The Nullable 
@snapend
```kotlin
// A reply to the 'billion dollar mistake' (to prevent NullPointers)
// Everything is nonNullable by default
val s: String = null // This will not compile

// In order to be able to use nulls, use a question mark
val s: String? = null
```
---
@snap[north span-100]
#### H6 - Safety first (1)
@snapend
```kotlin
val s: String? = null

// This will null-pointer
val c = s.get(0)

// This will not
val c = s?.get(0)
```
---
@snap[north span-100]
#### H6 - Safety first (2)
@snapend
```kotlin
var c: Char? = null
if(s == null){
    c = '?'   
} else {
    c = s.get(0)
}

// Introducing Elvis
var c = s?.get(0) ?: '?'
```
---
@snap[north span-100]
#### H6 - Safety first (3)
@snapend
```kotlin
val s: Any? = ""

// Not the String? if s is not castable, null is returned
val c: String? = s as? String 

// Will throw a NullPointerException when null, otherwise return value
val s: String? = null
val c: String? = s!!
```
---
@snap[north span-100]
#### H6 - Safety first (4)
@snapend
```kotlin
val s: String? = null
val c: String? = "Kotlin"

// Does nothing
s?.let { print("s has been called"); it.get(0) }

// Prints 'c has been called'
c?.let { print("c has been called"); it.get(0) }
```
---
@snap[north span-100]
#### H6 - lateinit
@snapend
```kotlin
public class Test {

  lateinit var mock: Mock // This will not compile otherwise

  @SetUp fun setup() {
     mock = Mock()
  }

  @Test fun test() {
     mock.foo()
  }
}
```
--- 
@snap[north span-100]
#### H6 - Primitives
@snapend[north span-100]
```kotlin
// Byte, Short, Int, Long
// Float, Double, Char, Boolean

// Number conversions can be done as follows
val i: Int = 1_000
val l: Long =  i.toLong()
val f: Float =  i.toFloat()
```
---
@snap[north span-100]
#### H6 - Any, Unit and Nothing
@snapend
```kotlin
// Any; The root of the Kotlin class hierarchy. Every Kotlin class has Any as a superclass.
// Can be compared to the Object class in Java

// The type with only one value: the Unit object. This type corresponds to the void type in Java.

// Nothing has no instances. You can use Nothing to represent "a value that never exists": 
// for example, if a function has the return type of Nothing, it means that it never returns 
// (always throws an exception).
```
---
@snap[north span-100]
#### H6 - Nothing (Java)
@snapend
```kotlin
void reportError() {
    throw new RuntimeException();
}

int i = 0;
void exampleOne() {
    reportError(); // throws RuntimeException
    i = 1; // This is unreachable code. But there is no warning.
}
```
---
@snap[north span-100]
#### H6 - Nothing (Kotlin)
@snapend
```kotlin
fun reportError(): Nothing {
    throw RuntimeException()
}

var i = 0;
fun exampleOne() {
    reportError(); // throws RuntimeException
    i = 1; // We will get an 'Unreachable code' warning here. 
}
```
---
@snap[north span-100]
#### H7 - Operator overloading
@snapend
```kotlin
// * (times())
operator fun times(p: Person):Pair<Person, Person> = Pair(this, p)

// / (div())
operator fun div(p: Pair<Person, Person>):Person = p.first

// + (plus())
operator fun plus(age: Int):Person = Person(this.name, this.age + age)

// - (minus())
operator fun minus(age: Int):Person = Person(this.name, this.age - age)

// % (rem())

// etc
```
---
@snap[north span-100]
#### H7 - Compound overloading
@snapend
```kotlin
// *= (timesAssgin())

// /= (divAssign())

// += (plusAssign())

// -= (minusAssign())

// % (remAssign())

// etc
```
---
@snap[north span-100]
#### H7 - Unary overloading
@snapend
```kotlin
// ! (not())

// +p (unaryPlus())

// -p (unaryMinus())

// ++p / p++ (inc())

// --p / p-- (dec())

// etc
```
---
@snap[north span-100]
#### H7 - Extra overloading
@snapend
```kotlin
// p[0] (get())

// p[0] = someValue (set())

// and much much more, for a full list see 
// https://kotlinlang.org/docs/reference/operator-overloading.html

```
---
@snap[north span-100]
#### That's all folks 
@snapend
```kotlin
// More info can be found on https://kotlinlang.org/

// https://kotlinlang.org/docs/reference/keyword-reference.html
```
---
@snap[north span-100]
#### What's next
@snapend
```kotlin
// After all this, it's finally time to do some coding.
// You can;
// - Check out the links below to get started
// - Migrate some code from your project 

// https://play.kotlinlang.org
// https://play.kotlinlang.org/hands-on/overview
// https://play.kotlinlang.org/byExample/overview
// https://play.kotlinlang.org/koans/overview
```

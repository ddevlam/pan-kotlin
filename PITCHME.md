## Kotlin in an evening

---?color=linear-gradient(100deg, white 50%, #e41b40 50%)

@snap[west text-black span-45]
#### Wie ben ik

@ul[split-screen-list text-08](false)
- 34 jaar
- Getrouwd, 2 kids
- Software Developer
- Programmeer sinds 1993 
- Coding is fun
@ulend
@snapend

@snap[east span-40]
![split-screen-img span-40](assets/img/danny.png)
@snapend

---

## Wat gaan we doen
@ul[split-screen-list text-08](false)
- Boek in een vogelvlucht doornemen H1-4
- FF Koffie
- Boek in een vogelvlucht doornemen H5-7
- H8-11 out of scope, het moet wel leuk blijven ;) 
- Aantal voorbeelden 
- Coden!
@ulend
@snapend

---
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

H4
- Interfaces
-- With default
-- Override functions
- Open, final and abstract
-- final by default
- Visibility
-- Public by default
-- Internal (module only)
- Inner classes
- Sealed classes
-- Vergelijkbaar met enums ... handig voor switch casses zodat je geen default wil
- Constructors
- Delegation
-- By
- Companion
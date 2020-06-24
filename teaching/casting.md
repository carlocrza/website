---
layout: default
title:  "Casting: compiler and runtime errors"
tags: java, cs61b
highlighter: rouge
redirect_from: /casting
---

Both compiler errors *and* runtime errors can occur in regards to casting.

`(A) var`

1. The compiler will allow you to cast var to `A` as long as `A` is a superclass or subclass of the static type of `var`. Even though we don't get compile errors in this case, we still could get a runtime error.

2. If `A` is not a super/sub class of the static type of `var`, then the compiler knows something is wrong and we get a compiler error.

So, for example:
```java
Fish fishy = new Fish();
Dog d = new Dog();

((Salmon) fishy).swim();  // cast allowed, but gives
                          // runtime error (ClassCastException)
((Dog) fishy).bark();  // compiler error (incompatible types)
```

### More examples:
```java
public class CastingDemo {
  static class Fish { 
    public void swim() {}
  }
  static class Salmon extends Fish {
    public void sally() {}
  }
  static class Cod extends Fish {
    public void coddy() {}
  }
  public static void main(String[] args) {
    Fish fishy = new Fish();
    Salmon sal = new Salmon();
    Fish bob = new Salmon();
    fishy.swim();
    sal.swim();
    bob.swim();


    // CASTING: *temporarily* change the static type of a variable. 
    // Long story short: you can only cast to:
    // the dynamic type  OR  a superclass of the dynamic type.
```
```java
((Fish) sal).swim();
```
`sal` has dynamic type Salmon. Since Fish is a supercass of Salmon, this line is fine. You can cast to a superclass of the dynamic type but normally no reason too.

```java
((Fish) sal).sally();
```
COMPILE ERROR: this errors b/c the cast gives ((Fish) sal) static type of Fish, which doesn't have the sally method

```java
((Salmon) sal).sally();
```
no error but does nothing b/c the static type of sal is already Salmon

```java
bob.sally();
```              
COMPILE ERROR: this errors b/c the static type of bob (Fish) does not have the sally method

```java
((Salmon) bob).sally();
```
bob has dynamic type Salmon. Here the cast changes its static type to Salmon so we can run the sally method now
    
```java
((Salmon) fishy).sally();
```
RUNTIME ERROR: static type of fishy is Fish. Salmon is a subclass of Fish so the compiler allows the cast w/o error. But, when we try to run the program we get a ClassCastException b/c fishy's dynamic type is Fish! (not Salmon). We can only cast to the dynamic type or a superclass of the dynamic type.

```java
((Cod) sal).swim();
```
COMPILE ERROR: incompatible types. sal has static type Salmon. Since Cod is not a super/sub class of Salmon, the compiler knows this is wrong
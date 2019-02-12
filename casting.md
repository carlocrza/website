---
layout: default
title:  "Casting: compiler and runtime errors"
tags: java
---

Both compiler errors *and* runtime errors can occur in regards to casting.

`(A) var`

The compiler will allow you to cast var to `A` as long as `A` is a superclass or subclass of the static type of `var`. Even though we don't get compile errors in this case, we still could get a runtime error.

If `A` is not a super/sub class of the static type of `var`, then the compiler knows something is wrong and we get a compiler error.

So, for example:
```Java
Fish fishy = new Fish();

Dog d = new Dog();

((Salmon) fishy).swim();  // cast allowed, but gives
                          // runtime error (ClassCastException)

((Dog) fishy).bark();  // compiler error (incompatible types)
```


I have attached a java file with a few more examples/explanations using Fish, Salmon, and Cod. (Feel free to try running different things and seeing what errors you do/don't get.)

I hope this is helpful. I also recommend reading these notes on static vs dynamic method selection.

---
layout: default
title: Discussion 1
tags: java, cs61b
redirect_from: /disc1
---
### Compilation
Java is a compiled language. This means that we must compile the java **source code** into **byte code** that the computer *(Java Virtual Machine)* can read.

![](http://www.buildingjavaprograms.com/labs/1/compile-run-output.png)

This is in contrast to some interpreted languages like python in which you run the program directly from the source file.[^1]

### What are the benefits of compilation?
* Speed: compilation converts source code to machine-readable code which runs faster
* "Write Once, Run Everywhere": Bytecode runs on the Java Virtual Machine so any computer with a JVM can run the files that you compiled on your machine

### Declare + Initialize
All variables in Java must be declared and initialized before use.
1. Declaration: states variable's **type** and **name**. A variable can only be declared **once**.
2. Initialize: assign value to a variable

Note that we can reassign a variable if we would like, but we can't declare it more than once!

```
int i = 0;
i = 7;
int i = 5; // error: variable already defined
```

> Can we 'delete' variables? How could we reduce the amount of memory an object takes when we no longer need it?

### Git Demo
![](https://qph.fs.quoracdn.net/main-qimg-d151c0543baa145e6252c1ec95199963)
Come to discussion!

To better understand git and the difference between `add`, `commit`, `push`, `pull`, `merge` then read this [61b using git guide](https://sp18.datastructur.es/materials/guides/using-git.html).

[^1]: <small> Don't worry about this but technically when you run a python file, it first compiles it and then runs it for you. Still, python is called interpreted because you run programs directly from the source file.</small>

---
layout: default
title:  "Python 2: Names, Functions, and Frames"
tags: python, cs61a
redirect_from: /python2
---
> Download [this notebook](materials/python2.ipynb) and run it interactively to play with the code yourself! [See instructions here](python)

Today, you'll learn:

1. Names: values and functions
2. Visualizing Function calls
3. Data Types
4. Booleans

Let's Go!  
<img width="300" src="http://neooc.com/wp-content/uploads/2016/10/Python_natalensis_Smith_1840.jpg">


# 1. Review

### Reminder: two options for running a cell.

1. Button
    * click on the cell
    * click the play button ▶ on the left


2. Keyboard
    - click on the cell
    - press down "SHIFT" key and then simulataneously tap the "ENTER/RETURN" key. Let go.

<br>   
<font color="blue">In general, as you go through the notebook, run <b>all</b> the code cells even if I don't explicitly tell you to do so</font>

Also, just a reminder. If the last line of a cell is a value, the notebook will display that value for you! Or you can use `print`.


```python
max(5, 6)
-99
```


```python
print(max(5,6))
-99
```


```python
-99
max(5, 6)
```


```python
variable = 8.9
```

Nothing was displayed if you run the cell above! That's because the last line just made a variable. To get something to display then the last line **has to be** a value.

## Sidenote: Tabs
<mark>When you write a function, everything in the body of the function has to be tabbed!</mark>
- the tabs tell python what's part of the function and what isn't

Run the following cell. See how you get an error because of the bad tab in the second function? Note that it says the error is at line 11 which is actually wrong. So when you get an error message, the line number it gives you isn't always the **source** of the error.

Fix `another_func` so it doesn't error.


```python
def func(x, y, hello):
    print("You are inside a function!")
    # more stuff
    # blah blah
    return x + y * hello

def another_func(x, y, hello):
  print("Oops!")
    # more stuff
    # blah blah
    return x**y + hello

number = 67
hello_there = 45
ok = 2
```

# Names

Let's review names.

You've learned about two types of names:
1. Variable names
    * example: `x = 5`. `x` is a variable name
2. Function names
    * `abs(-5)`. `abs` is a function name


```python
def func(x, y, cat):
    print("You are inside a function!")
    # blah blah
    return x + y * cat

number = 6.7
hello_there = "heyyy"
ok = True
```

The above code creates 4 names:
1. `func`
2. `number`
3. `hello_there`
4. `ok`

You can visualize with a diagram!

![img](https://lh3.googleusercontent.com/tCmR-z_vxzgThBgFmSbQrtwLdCPyE0aF3rVBWx3ChK0PKfUp2pauupiJdipVgf6eQ9qzVOKAXkkKu6f48oT-DpeyRF-k06bv0jywBQ67aLMVn3lHnbL_LgGJ13-sD6XxJNkKpxRe8dw=w766-h284-no)


As you can see, **function names** are drawn with an arrow pointing to the function header.


```python
print(func)
print(number)
print(hello_there)
print(ok)
```

Notice that printing `func` looks a little funk-y ;)

`<function func at 0xMumboJumpo>`. It basically means, python knows the name `func` refers to a function.

What if we do this??


```python
func = 56
print(func)
```

Now, `func` no longer refers to a function, but to the number 56. 

**Oops!** We NO LONGER have access to the the function that `func` once pointed to!

So try to use different names for all your stuff.

## Calling Functions

What do you think this function does?


```python
def body_mass_index(height, weight):                           
    return weight / (height ** 2)
```

The function header requests two arguments:

![img](https://lh3.googleusercontent.com/u6dNcaxuKBEhgOXgkwCX1_bM_FRDMmcGlWe1yrSJgte4lWaxqTPlvQC5dyMx8Gaq83ADk0Ch-QIVNWtLkoKw5TwGZA2Rtbojce-K1rCVO1sXNxG5AhEOcpFRs9xLdq3ywiEDndGX3lcVzEnpwRtKe6sU1Acvqk4neFB7WeTx_cPSBwIf5V9MT1dRlUB3MWR6Ey8PgsocZLgfaUWQJeg4DnyBVU1IV9YreuTJNl5wlIN07APC8lM2x5Y3Rgk8PuQGlVxEG3TJU1rRZ7bZnLi4E-1KMYezK71FX5dQ_HJcQv_Uv-oQZgNoETqn_s5KzPSdU16TA0oJHEp7owfnFexz3qnUHoUqtkIjNNSLXPTAKUMAxpXm58D-Vbw2ZQS06UYGKhQnlotNu3Qz4zjZzZs3cvA9j258v5WJ5QiwJJ176lkzh2MLQxuw6OhOEJW-NF9cVBFtBBx1yerrpiMZkXfpulETaXBjZAirkU6R5sVWUCzAiWNiiJsOCA3wM_3n8kkzPTrHrHyvaprUdSIRiziuOEOgv2QyaVSvaKqVQSR9RbyFJudBVQH288ufatpDkl1fGxwM5nxaLbt16CZKNSspLWFpg6FYfgCNGn4sBp9lx1LjR7m-dC_O_DkxfUtBjWMwjA4dKky3OUbpOg4LiAeO2SFERmIUxjdmOQ=w630-h154-no)

<font size=7px>So...</font> When calling the function I need to pass in two values! The values I pass in will then be assigned to `height` and `weight`.


```python
# Run me!
body_mass_index(2, 70)
```

Again, I'll repeat: The values you pass in will then be assigned to the variables in the function header. 


![img](https://lh3.googleusercontent.com/lG9GFXrTeMuTrm9Ni8PBnyulvlQy8D6VwHTNG2uViHhhivSa77Dwki6xnY7YZIy4AqDtr065JrP-snSs2aH9_5YIUWtW7SWkStOTN4epFwZUJftYnl-anJSOzmxy6GLIcbzBwmDvhuSAM0D_RvVOY5-EqF_boPcpaGAUdDmGwWA3a6wrP_R8wMeblot2OvASG7yEKOfX1IkHc9lrjvEKvLsi9FDCOhtU4xMjZA0L19PnhP29ELcW_8VF8vHyUKMycGGmHgw8oQcxCd6UzMIs0pD860bxnvmDz6tKzFlr7E3WXJ0T-KAUurfexRV_27IqjUGgx-HPm0NiMgJLdGi6t-xyPfRnlh_sDy_CdD_xWgKo5GVGwslPm3Q1xUc8YYY-GayPDJMruphoGCK1r0Y2RaJz4HIYkKZUkJct5lfIabtiJvwhtFilzCMUPph9CRXWddUtzeZcJuU8Oa2TYpinDuFaxwMc_G1QHXHH0q_KjQu2of-ZfO3jhl19Be7WF8ZWv8xyufzar0RTzYxq7SV1jHerwRqx1HIVPH5Nzafdo3Q5aGWV0daTuy5R2RDvfYy2ubcSlq63zhzaDt1dGOnf8PIAizagkpBtNGQ8hHRHVBQyK1pnM-SeM95hAJBByfiptW3wRijwZ6hZQMDYyd3rsKxiM6YdFG3EmA=w646-h228-no)

Once we call the function `body_mass_index`, imagine that you suddenly jump up and into the function! Now, `height` is 2 and `weight` is 70. We can do the calculations and then return our calculation.<br><br>

<font size=6px>.. wait... what is 'return'?</font>

**Return** literally returns _everything to the right of the return statement_ back to where you called the function! You can imagine erasing your function call and replacing it with the return value:

![img](https://lh3.googleusercontent.com/ZwDR_7dqvVyYPfFzgK0nSceoumDVHZdPd6hIG3VDJtX99mEykq7wnL9rk0ChVCEG6rLoltga9-g2hlTqRizLCqkZUbQe_0frYM95nxNVUqrGXyOIYut1guyvYh3CNdWtbBpXR0JwAzekWEFJ32XZpBB5wq9EVe4gQTU9-aqOrnoCUfll3ietTmfX4_5IMks_Imb9njXubd9EQAdYfzA6DiQ3-ZnyyrUSRy-t-2jXznv1e2VD3bh69i4IHk3umPcQXWNlvPqd65_j0B1sr8T1Vrkr7yMXZ2YhZW56X4NdFVFQP1Dt0C1Tw117CBd4gLaaztJxxXiSRMZ2z-dtB5oSQBXkl-TTSpCL2QQYpRx3Ir7DUuQx-7tHIaAMp8HDJeQGtX0NGEUCfFFjdpFYbtW8ryai8OH6FUU6j91m-GikFlLCC_FGL2ddfBl3gB_jIwb9BZl7L5MUWPl_esE9InMBfQX3CS4a28rRGPt6vCcP8P2txyyPS0-fJp8LqgrgOXbEXNuFj_XPQBt1VsGcGF2-xZbxl058_6DJNvnjxuTkGQmBAOmINjiqBNyUXcURJl76d5uiNFCGGciBS-K2RlVtwvbH_r2Kg1XvsKqkaz1JAoZYEcFsxe3Ul_XkwaVa-rDBTButX9LYgzh3HWv-NMANmgJMSNuY0yR1Eg=w616-h168-no)

We can do stuff with that return value! For example, print it out, or assign a name to it.


```python
fake_bmi = body_mass_index(2, 100) + 5
```

Just a reminder, to print out `my_bmi` we have to call `print` or put it on the last line of a cell!


```python
# last line is below me ;)
fake_bmi
```


```python
# Call the function again yourself!!

```

## Frames

Okay... so when we were **inside** the `body_mass_index` function we were dealing with two names:
1. height
2. weight

However, since those names were made in the function header (in the argument list), we can only access them **inside** the `body_mass_index` function.

Will the following cell then error? Run it!


```python
def body_mass_index(height, weight):                           
    return weight / (height ** 2)

print(body_mass_index(1, 10))

print(body_mass_index(1, 34))

print(weight * 2)
```

The error message says `name 'weight' is not defined`. That's because outside of the `body_mass_index` function it's true - we haven't defined `weight`.<br><br>

<font size=5px>We could do this ... </font>


```python
weight = 60

def body_mass_index(height, weight):                           
    return weight / (height ** 2)

print(body_mass_index(1, 10))

print(body_mass_index(1, 34))

print(weight * 2)
```

What's happening here is that there are two versions of `weight`. There's the "global" weight which equals 60. 

But when we enter `body_mass_index` we redefine `weight` as 10 - just for that function call!

For the second function call, `weight=34`

But once we are outside of the function, we go back to using the 'global' version of weight which is 60.

<font size=7px>Whew!!</font> If this last point was a little weird, don't worry too much about it. Normally you can just use different variable names.

## Java Visualizer

<mark>However, it is useful to keep track of our names and which names we have access to. Clearly, when you're inside the `body_mass_index` function I have access to different names than when I'm outside.</mark>

Every time we call a function, we create a new 'frame'. Each frame gives us specific access to names. When we `return` from a function, we exit the frame.

You can diagram this manually, or use a handy [python visualizer tool](http://www.pythontutor.com/visualize.html#mode=display)

Click the link, copy the code below into the box and click "visualize execution".

![img](https://lh3.googleusercontent.com/wsxrpU6GrJWM6jx8cX1fniPuMoEb8IChhDYK5hLssuPrgP15i8rDjiPCTx7OUMD_ICneAXZk8ZkgTyddGVq6SrlF2zXsovJMw3n60SnlBCCIOG_vCpWMQp00WLIQdUHjxI9iSBztdmNlFDKV6hgMlNzUFlaHwD70-gUGB-hObje-mJE7OKx1x8U5mDRIhxjUwLC54yop5J9uHCf-5QGYfQxN00bPGRtgFveZJ543dixrLmkSIFmTW1U9G_nwL66H_Eal8KyWu-3RI1eAHEQ9UVtooIRWUZXwhzkuclIa-53Q6AIhdXn1vba8HDo68sGdpgXICiu3JeFcwgHZA4gUTDlex-lFz1dCilRdVrNrkI5ayvIPmqeRMkUC8K1LtY_BIQPIYceiPcACld9NPpOGr-xaDpOu0jAJGAoUpzOiOy0IDvCQtFqNypduHL9ZxsOigSUlMoF1wPnw-MHfha9clvaHKeUxJkP49dFLmyFa4EZlWbdzS0PLSJCHMt9mAfYhmJLwD03E7r3GQqPbTDF5RGUloLM7v1ZKghhbkF_D1mZdO5avOPtItf37M3dBATOvGIWqiQGsAr4OlHzdrS4YI3ERWg-Dd3Gpiqfbgn6HrFBq62MBoQjH-0TIlaN-a_iY34Wa0KoEI6KJ86LHz6biHkd7_BCg0A-wjw=w894-h356-no)

Run the visualizer and run the program slowly, line by line by clicking 'forward'. Look at the frames and see what is happening. 

### Another example

Let's look at the familiar code below. Earlier we said we have 4 names.

_But what about `x`, `y`, and `cat`?_

Once we call `func`, we are **inside** the `func` function and we also have access to `x`, `y`, and `cat`. Being inside the function is called being inside the `func` frame!! If we aren't inside any function then we are part of the "global frame".

Copy and paste the following code into [Python Visualizer](http://www.pythontutor.com/visualize.html#mode=display)


```python
def func(x, y, cat):
    print("You are inside a function!")
    # blah blah
    return x + y * cat

number = 6.7
hello_there = 5
ok = 2
func(number, hello_there, ok)
```

## Data Types

We've hinted this, but just to mention formally. Names can refer to DIFFERENT TYPES OF DATA.

1. Numbers
2. Functions
3. Strings
4. Booleans

Read on to learn about a fourth type!!

## Booleans

Booleans are simple, they're **True** or **False**

Note that they are a different from the word "True" or "False"

![img](https://lh3.googleusercontent.com/IpNO6Q8EAJ-E54oaFSR3wCcmuDIo0-3P1UjGU30U7j3-PV7pI4dAhqwETRMso6p0nb59n-p0EP1VQKJsUKfovADcJ1-8bz_w05glxh0UMlVxUMQIkITNBGsmn-_z3N8WwDhDAksDm0mxvbJvVQ8tndJSJ3G5eKNENm5gO10qwVoytnPc-IyrcQ3ooUoFsnmw0mdkHjKMof3qdvVyKuxV8GEF1EC3GhI4jfNJdxrf0yTy0CsU_VhYkHuti5geDk0hNflYDRLbsIygJ24ZycsX_mUlDob4Lh6afkYfdG_rp2jXllpf0qBdiiXyJZedMxvCD1Evx26EUvcXjbuOSedxtJ2djqVSi2ObMMW98Myw6oaA2n5x1YDKGHKT8RHv79F6dN6rLtiscUox0LYlyXmkO6PLk6jhY3GLlJw43k28V4vAByDco9HJSIqtEdhDdUmvnBpzqUdYTq51uXD9waAmfWs0LIYjNk4QSJ_omSkjX-xtYFCKVTDPn36I0Cyc5_tdMU7DHk-u80W4JoPGWF32L1zmwCYAaFpK0XLI7Tq5Z8PtNUzMkkZmKVZblmurwB_JtkUEXOioIai1aPalzbFKs42jgATCVDy0JPvETfeKF6iKpkl7g3qvuGAgCzxtgG7g7HlmbdTYKmKkkwxMGhm8Lhxk3KHNj9jKhA=w894-h214-no)

Why have booleans? They are useful in if statements.


```python
a = True

if (a):
    print("hello Sylvia")
```


```python
x = 3

statement = x > 5

print(statement)

if (statement):
    print("x is greater than 5")
```

We can use `and` , `or` to make more complicated truth statements.

*  `and` : both statements have to be True for the whole thing to be True.

*  `or` : either statement can be True for the whole thing to be True.


```python
and_statement = x > 5 and x < 5 
and_statement
```

### While Loops

We can use booleans to execute while loops as well. `while` loops repeat a section of code until the condition is false.

    while (condition):
        continue running
        coutinue running


```python
x = 1

while (x < 5):
    print("Hi for the " + str(x) + " time!")
    x = x + 1
```

Note!! If we did not include the `x = x + 1` line then we would be in an infinite loop! Make sure your condition will be False at some point.

### Strings : `in`

You can check if a part of a string is in another string, using the `in` keyword.


```python
"h" in "hello"
```


```python
"hello" in "h"
```


```python
"cap" in "escape"
```

# Exercises

Note: <code style="color:darkred">"""zippity doo"""</code> are another way of making comments. Often they are used in functions to specify examples of what the function should do!

### Fix the Bug
The following snippet of code doesn't work! Figure out what is wrong and fix the bug.


```python
def both_positive(x, y):
    """Returns True if both x and y are positive.

    >>> both_positive(-1, 1)
    False
    >>> both_positive(1, 1)
    True
    """
    return x and y > 0 # Replace this line!
```

### Alfonso's Jacket

Alfonso will only wear a jacket outside if it is below 60 degrees or it is raining.
Write a function that takes in the current temperature and a boolean value telling
if it is raining and **returns** True if Alfonso will wear a jacket and False otherwise.
First, try solving this problem using an if statement.


```python
def wears_jacket_with_if(temp, raining):
    """
    >>> wears_jacket(90, False)
    False
    >>> wears_jacket(40, False)
    True
    >>> wears_jacket(100, True)
    True
    """
    # write your code here and below
```

Try to write the same function using one line!


```python
def wears_jacket_with_if(temp, raining):
    # one line here
```

### Whiling away

Write a function that returns True if n is a prime number and False otherwise. 

**Hint:** use the % operator: x % y returns the remainder of x when divided by y.


```python
def is_prime(n):
    """
    >>> is_prime(10)
    False
    >>> is_prime(7)
    True
    """
```

### Diagramadrama

Try to draw the diagram for the following code.

Remember, we make a new frame when we call a function. Check your solution using the visualizer.


```python
x = 3
def square(x):
    return x ** 2
square(2)
```

### Tricky names

Before running the following code, try to think about what the final output will be (what will `hmm(wow)` return?)


```python
def double(x):
    return x * 2

hmmm = double
wow = double(3)
hmmm(wow)
```

### Returning a function

Before running the following code, try to think about what the outputs will be.

See if you understand what's going on here. I write a function that returns a function :O


```python
def special_add():
    def function_i_will_return(x):
        return x + 17
    return function_i_will_return

f = special_add()

f(3)
```

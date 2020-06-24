---
layout: default
title:  "Introductory Python Tutorial 😮🐍"
tags: cs61a, python
redirect_from: /python
---
Today, you'll learn how to:

1. navigate Jupyter notebooks (like this one);
2. write and evaluate some basic *expressions* in Python, the computer language that many people use!
3. call *functions* to use code other people have written; and
4. break down Python code into smaller parts to understand it.

# 1. Jupyter notebooks
This webpage looks like a Jupyter notebook. A notebook is a place to write programs and view their results. You could write programs in a text file if you want, but it's nice to do it in a notebook like this because you can share it with others! To run this notebook, first **[download it here](materials/python.ipynb).**

You can then upload it to Google Drive and run it there using [Colaboratory](https://colab.research.google.com/). 

Or, install python and then follow these steps to run locally:

Install jupyter:
```
pip3 install jupyter
```
Launch your notebook (opens in browser):
```
jupyter notebook [name_of_file.ipynb]
```

Let's go! 

## 1.1. Text cells
In a notebook, each rectangle containing text or code is called a *cell*.

Text cells (like this one) can be edited by double-clicking on them. Double click this cell!! This cell is a text cell, not code. If you want to make a new cell, click "+Code" or "+Text" at the top of the page for the cell type. 

After you edit a text cell, click the "run cell" button on the left ▶ to re-run any changes.

## To run a cell: 
## - click on the cell
## - hold down 'SHIFT' and then tap 'ENTER/RETURN' once.

## 1.2. Code cells
I will use these text cells to give instructions. YOU will basically only work with code cells.

Try running the **code cell below** (remember shift + enter! or click the ▶ play button on the left).


```python
print("Hello, World!")
```

CODE IS EXECUTED IN ORDER!
- first line is printed first, then second, etc.


```python
print("First this line is printed,")
print("and then this one.")
```

**Question 1.2.1.** Change the cell above so that it prints out:

    I'm dreaming of a
    white christmas,
    just like the ones I used to know


## 1.3. Writing Jupyter notebooks
You can use Jupyter notebooks for your own projects or documents.  When you make your own notebook, you'll need to create your own cells for text and code.

To add a cell, click the '+ CODE' button in the menu bar.  It'll start out as a text cell.  You can change it to a code cell by double-clicking inside it.

**Question 1.3.1.** Add a code cell below this one.  Write some code in it like:
   
    2 + 2

Run your cell to verify that it works.

## 1.4. Errors
Python is a language, and like natural human languages, it has rules.

We have made an error in the next cell.  Run it and see what happens.


```python
print("This line is missing something."
```

OOPS! we are missing a parenthesis.

```python
# use the hashtag to make a comment!
```

# 2. Numbers


```python
3.2500
```

Notice that we didn't have to `print` to see the number displayed. When you run a notebook cell, if the last line has a value, then Jupyter helpfully prints out that value for you. However, it won't print out prior lines automatically.


```python
print(2)
3
4
```

Above, you should see that 4 is the value of the last expression, 2 is printed, but 3 is lost forever because it was neither printed nor last.

You don't want to print everything all the time anyway.  But if you feel sorry for 3, change the cell above to print it.

## 2.1. Arithmetic
The line in the next cell subtracts.  Its value is what you'd expect.  Run it.


```python
3.25 - 1.5
```

Remember order of operations applies in code!


```python
1+6*5-6*3**2*2**3/4*7
```


```python
1+(6*5-(6*3))**2*((2**3)/4*7)
```

# 3. Names
If we want to save a value for later, we assign it a name!


```python
ten = 3 * 2 + 4
```

When you run that cell, Python computes the value of `3 * 2 + 4`, which is the number 10.  Then it gives that value the name `ten`.

After you run that cell, the value 10 is bound to the name `ten`. Run the two cells below:


```python
print(ten)
print(ten * 5)
```

**Question 3.1.** Try defining a variable called `special_number` that's equal to your favorite number!


```python
# delete this comment and put your answer here!

```

If we use a variable name that we haven't made yet, we get an error! Run the following cell.


```python
cruz + 5
```


```python

```

Extra tip: Do "to the power of" in python using two stars:

$$x^{y} = x ** y$$

Run the following cell:


```python
5**2
```

Here's a real-life example of a really useful variable to make:


```python
pi = 355/113
pi
```

Compute the area of this circle, using the variable called  `pi`. 

EXTRA: instead of using `14`, define a variable called `radius = 14` first. Then use the variables `pi` AND `radius` to compute the area.

<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAO0AAADHCAMAAADCpCTtAAAABlBMVEX///8AAABVwtN+AAADAUlEQVR4nO2d23LaQBAF0f//dAKUgIRLCWnOZZjTVfEDlex2azcStmX5dAohhBBCCCGEEEIIIYQQbFieUStBeJv2a81bcn4j+auI3sV75JsG79fuF3xQuFNvxeJ0WeAyzQa9pYrmveV6zr0INddc0DpYLi9Qyq8XK+SVCz/6TsvLULHJ5Yh45NI2mcNuZirIc7kC4lz29NJc/uS6XMlpQ3WuUh1mybzCPTViSt3c2mvBqEsBe3b1uxrq/OpYqoE+lujgEEuz8Iid9Wk1ycMllmLiE0twcYrF24yq9YoF+7jFYo1G1frFIp1G1TrGwqw8Y1Feo2pdY2fd7gEx841FuI2qdY6tt0utD8V23rHVfqNq3WNrDVPrRaGhf2ylY2rdKHPsEFtnmVo/UqsbBk6NZ2odSa1qFDwlnl1ia0xT60lqFWNwSC1/CBrHXVPrSmrZI/BILXsEHra1kB8+dK3FPCbMuRbAca+CthejjlrbWf9vd8y/QaR77X3Db9kM3Wtv8y8T1vYXa//u0nWjPl1MlvXjbUtf/u7rZ7oeNzk8wpZJ3i/dsn64H45r64t/0KP20xnoFrr89wKklpH7MMXLnfzPS+9rm3wV7tMUT9fb7rUfZxhV+/D24v7C+ueLcSpcvEitZhAC+W61ahQ8qVWNgqfIs0dulWVq/UitdiAgdY6pdaPQ0T+30jC1XpQauufW+s2qNc+ttkutD+V2zrn1brNqjXM9b+FAATFzzcV4zao1zYVZOebinGbVGuYijWbV2uWCfbxy0Tazaq1yxTc3ceHclMiYZAMcj1m1Jrk0C4dcooM+l2qgziXPr81lzz6rVpormFuXK5lZlSuad9TvSD0pDrP07DjrUkCeXv2mhiogjyWeNhx+3/xp2qfVFBGbWMImM9nFK1gbr9YT9OibLewVkJRl65lZt3vUr4Ptwl4p1TNvPVOm2KD1TMmjj5q0Xjjo2in1wv7FabWsd/ZoN0298tUzwjAPFCOz5YltNU91s+HtU+qKHl/nCOIxfSE88Ac8wwKwUjtj+QAAAABJRU5ErkJggg==">


```python
# Put your answer below this comment!

```

Variable Names in python can have:
- letters
- numbers
- underscore _

Names CANNOT have:
- no spaces allowed
- names can't start with a number


```python
a = 840
b = 2 * a
c = 12
d = c * Bob
d
```

Hint: make names meaningful.

instead of random variable names, give it useful names like this: (for the computer, it's the same thing!)


```python
bimonthly_salary = 840
monthly_salary = 2 * bimonthly_salary
number_of_months_in_a_year = 12
yearly_salary = number_of_months_in_a_year * monthly_salary
yearly_salary
```

## Calling functions!

What do you thing the `abs` function does?


```python
abs(5)
```


```python
abs(-5)
```

Note that calling any function has the same format: name, paranthesis, values, end paranthesis

**function_name ( put in your values here )**

    print("hello")
    abs(5)

You can put in expressions as the value!


```python
abs(1.21 - 1.688)
```

Some functions take in multiple values! If it does, you have to seperate them by **commas**


```python
max(17, 16)
```


```python
min(590, -590)
```

## Writing your own function!


```python
def func(x, y, hello):
    return x + y * hello
```

Now we can call this function later. Note that the name `func` now refers to the function above. It takes in three values. We call these values that a function takes in **arguments.** So, when we call `func` we have to input 3 arguments!


```python
func(5, 6, 7)
```

What actually happens??? The values `5, 6, 7` are **passed to the function `func`** and the **values are assigned to the argument names.** 

Now, in the function the argument names have become variables:
- `x = 5`
- `y = 6`
- `hello = 7`

Every time we call the function `func` the `x, y, hello` values are reassigned. 

For example, if we do `func(99, 4, -9)` then:
- `x = 99`
- `y = 4`
- `hello = -9`

Try calling the function again!


```python
# call the function here
```


```python
# Extra: try function for finding roots of a quadratic equation
```


```python

```

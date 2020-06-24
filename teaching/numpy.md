---
layout: default
title: "Python Libraries: Numpy Tutorial"
tags: python, numpy
redirect_from: /numpy
---
## How to Use Numpy for Datascience
> <img width="100" src="http://rickizzo.com/images/posts/2017-12-19/numpy.jpeg"/><br>
> Numpy reference: [https://docs.scipy.org/doc/numpy-1.13.0/reference/](https://docs.scipy.org/doc/numpy-1.13.0/reference/)

Numpy is a powerful python library that allows for efficient operations on arrays.

Install jupyter:
```
pip3 install jupyter
```
Launch your notebook (opens in browser):
```
jupyter notebook [name_of_file.ipynb]
```
Alternatively, you can run Jupyter Notebooks in Google Drive using [Colaboratory](https://colab.research.google.com/).

## Import

`numpy` is a library made by other people! We need to `import` libraries in order to use them.

```python
import numpy as np
```

## Numpy Arrays

Numpy's main use is ```np.array```

Numpy arrays take less space than built-in lists and come with a **wide variety of useful functions.**

```python
# make an array
a = np.array([2,3,4])
a
```

<pre id="out">
array([2, 3, 4])
</pre>


```python
# make a 2-dimensional array (matrix)
matrix = np.array([ [1,2,3],
                    [4,5,6],
                    [7,8,9] ])
matrix
```
<pre id="out">
array([[1, 2, 3],
      [4, 5, 6],
      [7, 8, 9]])
</pre>

## Linear Algebra


```python
# you can multiply matrices with np.dot
np.dot(matrix, a)
```

<pre id="out">
array([20, 47, 74])
</pre>

## Arithmetic
These operations are convenient and extremeley fast. Much faster than accomplishing the same thing with a for loop.

**You can add/subtract/multiply/divide with numpy arrays!** You *cannot* do this with built-in python lists.


```python
a + 5
```




<pre id="out">
array([7, 8, 9])
</pre>



```python
a * -1
```



<pre id="out">
array([-2, -3, -4])
</pre>



```python
b = np.array([3, 2, 1])
a + b
```




<pre id="out">
array([5, 5, 5])
</pre>

## Length Errors

If you try to perform operations on two arrays of different lengths, <span style="color:red">an error will occur.</span> Try running the following cell!


```python
# Run me!
b + np.array([1, 2, 3, 4])
```

<pre id="out">
---------------------------------------------------------------------------

ValueError                                Traceback (most recent call last)

<\ipython-input-10-01af955792b6> in <\module>()
      1 # Run me!
----> 2 b + np.array([1, 2, 3, 4])


ValueError: operands could not be broadcast together with shapes (3,) (4,) 
</pre>

You will also get an error when trying to access the value at an index that does not exist in the array.

## Essential Array Functions

Why do we use Numpy? **Numpy provides a multitude of useful functions for arrays.** We'll teach you a few (many more exist!)

<font color="blue">Exercise:</font> Search online how to find the mean of a numpy array.


Use ```len( array )``` to find length of array.


```python
len(b)
```




<pre id="out">
3
</pre>



```python
len(np.array([1, 2, 3, 4]))
```




<pre id="out">
4
</pre>


Conditionals apply to every element of a numpy array as well. This will come in handy later!


```python
a = np.array([1, 2, 3, 1, 1])
a == 1
```




<pre id="out">
array([ True, False, False,  True,  True], dtype=bool)
</pre>


```python
x = np.array([1, 5, -7, 18, 1, -2, 4])
```


```python
# Find the mean of array x
x_mean = np.mean(x)
```

Here, we'll give you a list of some useful numpy functions. Remember, you can easily find info about these by searching google / numpy documentation!


```python
np.sum(x)
```




<pre id="out">
20
</pre>



```python
np.min(x)
```




<pre id="out">
-7
</pre>



```python
np.max(x)
```




<pre id="out">
18
</pre>



```python
np.median(x)
```




<pre id="out">
1.0
</pre>



```python
np.cumsum(x)
```




<pre id="out">
array([ 1,  6, -1, 17, 18, 16, 20])
</pre>



```python
np.abs(x)
```




<pre id="out">
array([ 1,  5,  7, 18,  1,  2,  4])
</pre>


What do you think ```np.cumsum``` does? Note, numpy has a similar function ```np.cumprod```. Try it!

What do you think ```np.diff``` does?


```python
np.diff(x)
```




<pre id="out">
array([  4, -12,  25, -17,  -3,   6])
</pre>


Two super useful functions in numpy are `np.arange` and `np.linspace`. They allow you to craft arrays with equidistant values:
* np.arange asks for [`start`], `stop`, and [`step`]
* np.linspace asks for `start`, `stop`, and `num`


```python
np.arange(0, 100, 10)
```




<pre id="out">
array([ 0, 10, 20, 30, 40, 50, 60, 70, 80, 90])
</pre>



```python
np.linspace(0, 100, 15)
```




<pre id="out">
array([   0.        ,    7.14285714,   14.28571429,   21.42857143,
         28.57142857,   35.71428571,   42.85714286,   50.        ,
         57.14285714,   64.28571429,   71.42857143,   78.57142857,
         85.71428571,   92.85714286,  100.        ])
</pre>


## Python Lists vs Numpy Arrays

Using ```np.arrays``` in python is a little bit different than with built-in lists.


```python
a = np.array([2, 3, 4])
b = [2, 3, 4]
print(a)
print(b)
```

<pre id="out">
[2 3 4]
[2, 3, 4]
</pre>

#### Adding values to np.array is different


```python
b.append("hello")
b
```




<pre id="out">
[2, 3, 4, 'hello']
</pre>



```python
a = np.append(a, 'hello')
a
```




<pre id="out">
array(['2', '3', '4', 'hello'], 
      dtype='< U21')
</pre>


#### For loops work the same way


```python
c = np.array([1, 2, 3, 4, 5])
cumulative_product = 1

for element in c:
    cumulative_product *= element
    
cumulative_product
```




<pre id="out">
120
</pre>


### <font color="blue">Numpy Exercises</font>

Use [`np.arange`](https://docs.scipy.org/doc/numpy/reference/generated/numpy.arange.html) to create an array called `arr1` that contains every odd number from 1 to 100, inclusive.


```python
arr1 = np.arange(1, 100, 2)
arr1
```




<pre id="out">
array([ 1,  3,  5,  7,  9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33,
       35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 63, 65, 67,
       69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 93, 95, 97, 99])
</pre>


Use `arr1` to create an array `arr2` of every number divisible by 4 from 1 to 200, inclusive.


```python
arr2 = (arr1 + 1) * 2 
arr2
```




<pre id="out">
array([  4,   8,  12,  16,  20,  24,  28,  32,  36,  40,  44,  48,  52,
        56,  60,  64,  68,  72,  76,  80,  84,  88,  92,  96, 100, 104,
       108, 112, 116, 120, 124, 128, 132, 136, 140, 144, 148, 152, 156,
       160, 164, 168, 172, 176, 180, 184, 188, 192, 196, 200])
</pre>


Create the same array, but using [`np.linspace`](https://docs.scipy.org/doc/numpy/reference/generated/numpy.linspace.html) instead. Call this array `arr3`.


```python
arr3 = np.linspace(4, 200, 50)
arr3
```




<pre id="out">
array([   4.,    8.,   12.,   16.,   20.,   24.,   28.,   32.,   36.,
         40.,   44.,   48.,   52.,   56.,   60.,   64.,   68.,   72.,
         76.,   80.,   84.,   88.,   92.,   96.,  100.,  104.,  108.,
        112.,  116.,  120.,  124.,  128.,  132.,  136.,  140.,  144.,
        148.,  152.,  156.,  160.,  164.,  168.,  172.,  176.,  180.,
        184.,  188.,  192.,  196.,  200.])
</pre>


Print the following summary statistics for `arr3`: 

* minimum
* 1st quartile (Hint: See [`np.percentile()`](https://docs.scipy.org/doc/numpy-dev/reference/generated/numpy.percentile.html))
* median
* mean
* standard deviation
* 3rd quartile
* max



```python
print('Minimum: '            + str(np.min(arr3)))
print('1st quartile: '       + str(np.percentile(arr3, 25)))
print('Median: '             + str(np.median(arr3)))
print('Mean: '               + str(np.mean(arr3)))
print('Standard Deviation: ' + str(np.std(arr3)))
print('3rd Quartile: '       + str(np.percentile(arr3, 75)))
print('Max: '                + str(np.max(arr3)))
```

<pre id="out">
Minimum: 4.0
1st quartile: 53.0
Median: 102.0
Mean: 102.0
Standard Deviation: 57.7234787586
3rd Quartile: 151.0
Max: 200.0
</pre>

## Conclusions
While it may not have been obvious from the token examples in this tutorial, when we are dealing with huge, multi-dimensional arrays numpy is vastly superior than python lists in terms of speed.

Applying arithmetic operations or functions on numpy arrays is also much faster than manually going through a python for loop to accomplish the same task.
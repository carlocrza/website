---
layout: default
title: "Python Libraries: Pandas Tutorial"
date: 
tags: 
---
## How to Use Pandas for Datascience
> <img width="60" src="http://worldartsme.com/images/chinese-panda-clipart-1.jpg"/><br>
> Pandas reference: [http://pandas.pydata.org/pandas-docs/stable/](http://pandas.pydata.org/pandas-docs/stable/)

Pandas is a useful python library for data manipulation and analysis.

To best learn the material, I recommend using Jupyter Notebook to play with the code and exercises yourself! Jupyter Notebooks allow you to write text and run python code in the same document. [Download the notebook](materials/python_libraries.ipynb).

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

`pandas` is a library made by other people! We need to import it. We'll also be using numpy (see [previous tutorial](/numpy))

```python
import numpy as np
import pandas as pd
```


A table is called a ['dataframe'](http://pandas.pydata.org/pandas-docs/stable/dsintro.html#dataframe) in Pandas. Consider the table `fruit_info`:



<table border="1" class="dataframe">
  <thead><tr><td>**color**</td><td>**fruit**</td></tr></thead>
<tr><td>red</td><td>apple</td></tr>
<tr><td>orange</td><td>orange</td></tr>
<tr><td>yellow</td><td>banana</td></tr>
<tr><td>pink</td><td>raspberry</td></tr>
</table>

## Pandas Series

Let's break this table down. DataFrames consist of columns called **```Series```**. Series act like numpy arrays.

_How to make a Series:_

1.   create a numpy ```array```
2.   call ```pd.Series(array, name="...")``` &nbsp;&nbsp; <font color="gray"># name can be anything</font>

<font color="blue">Exercise:</font> Make a Series that contains the colors from `fruit_info` and has `name='color'`



```python
array = np.array(['red', 'orange', 'yellow', 'pink'])
color_column = pd.Series(array, name="color")
color_column
```




    0       red
    1    orange
    2    yellow
    3      pink
    Name: color, dtype: object



<font color="blue">Exercise:</font> Make another Series for the fruit column:


```python
array = np.array(['apple', 'orange', 'banana', 'raspberry'])
fruit_column = pd.Series(array, name="fruit")
fruit_column
```




    0        apple
    1       orange
    2       banana
    3    raspberry
    Name: fruit, dtype: object



Combine your Series into a table!

`pd.concat([ series1, series2, series3, ... ], 1)`

Don't forget the ```1``` or you'll just make a giant Series.


```python
fruit_info = pd.concat([color_column, fruit_column], 1)
fruit_info
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
    </tr>
  </tbody>
</table>
</div>



What if we were given the DataFrame and we want to extract the columns?


```python
fruit_info['fruit'] # we get the fruit_column Series back!
```




    0        apple
    1       orange
    2       banana
    3    raspberry
    Name: fruit, dtype: object



### Dictionaries

Also, we can manually create tables by using a [python dictionary](https://www.python-course.eu/dictionaries.php). A dictionary has the following format:

```
d = { "name of column"   :  [  list of values  ],
      "name of column 2" :  [  list of values  ],
                        ...
                        ...
    }```
    


```python
d = { 'fruit' : ['apple', 'orange', 'banana', 'raspberry'],
      'color' : ['red', 'orange', 'yellow', 'pink']
    }
```


```python
fruit_info_again = pd.DataFrame(d)
fruit_info_again
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
    </tr>
  </tbody>
</table>
</div>



### Add Columns

Add a column to `table` labeled "new column" like so:

`table['new column'] = array`


```python
fruit_info['inventory'] = np.array([23, 18, 50, 20])
fruit_info
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
    </tr>
  </tbody>
</table>
</div>



<font color="blue">Exercise:</font> Add a column called ```rating``` that assigns your rating from 1 to 5 for each fruit :) 


```python
fruit_info['rating'] = np.array([3, 4, 5, 5])

fruit_info  # should now include a rating column
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>5</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



### Drop

<font color="blue">Exercise:</font> Now, use the `.drop()` method to [drop](https://pandas.pydata.org/pandas-docs/stable/generated/pandas.DataFrame.drop.html) the `color` column.


```python
fruit_info_without_color = fruit_info.drop('color', 1) # must include axis=1

fruit_info_without_color
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>banana</td>
      <td>50</td>
      <td>5</td>
    </tr>
    <tr>
      <th>3</th>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



## California Baby Names

Time to use a real dataset!

You can read a `.csv` file into pandas using `pd.read_csv( url )`.

Create a variable called `baby_names` that loads this data: `https://raw.githubusercontent.com/carlocrza/Data_Science_Society/master/ca_baby_names.csv`




```python
baby_names = pd.read_csv("https://raw.githubusercontent.com/carlocrza/Data_Science_Society/master/baby_names.csv")
```

Let's display the table. We can just type `baby_names` and run the cell but baby_names is HUGE! So, let's display just the first five rows with:

`DataFrame.head( # of rows )`


```python
baby_names.head(5)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>State</th>
      <th>Sex</th>
      <th>Year</th>
      <th>Name</th>
      <th>Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>CA</td>
      <td>F</td>
      <td>1910</td>
      <td>Mary</td>
      <td>295</td>
    </tr>
    <tr>
      <th>1</th>
      <td>CA</td>
      <td>F</td>
      <td>1910</td>
      <td>Helen</td>
      <td>239</td>
    </tr>
    <tr>
      <th>2</th>
      <td>CA</td>
      <td>F</td>
      <td>1910</td>
      <td>Dorothy</td>
      <td>220</td>
    </tr>
    <tr>
      <th>3</th>
      <td>CA</td>
      <td>F</td>
      <td>1910</td>
      <td>Margaret</td>
      <td>163</td>
    </tr>
    <tr>
      <th>4</th>
      <td>CA</td>
      <td>F</td>
      <td>1910</td>
      <td>Frances</td>
      <td>134</td>
    </tr>
  </tbody>
</table>
</div>



## Row, Column Selection

Follow the structure:

`table.loc[rows, columns]`

`table.loc[2:8, [ 'Name', 'Count']]`

The above code will select columns "Name" and "Count" from rows 2 **through** 8.


```python
# Returns the name of our columns
baby_names.columns
```




    Index(['State', 'Sex', 'Year', 'Name', 'Count'], dtype='object')




```python
baby_names.loc[2:8, ['Name', "Count"]]
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Name</th>
      <th>Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2</th>
      <td>Dorothy</td>
      <td>220</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Margaret</td>
      <td>163</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Frances</td>
      <td>134</td>
    </tr>
    <tr>
      <th>5</th>
      <td>Ruth</td>
      <td>128</td>
    </tr>
    <tr>
      <th>6</th>
      <td>Evelyn</td>
      <td>126</td>
    </tr>
    <tr>
      <th>7</th>
      <td>Alice</td>
      <td>118</td>
    </tr>
    <tr>
      <th>8</th>
      <td>Virginia</td>
      <td>101</td>
    </tr>
  </tbody>
</table>
</div>



<font color="blue">Exercise:</font> Return a table that includes rows 1000-1005 and only includes the column "Name".


```python
baby_names.loc[1000:1005, ['Name']]
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1000</th>
      <td>Sara</td>
    </tr>
    <tr>
      <th>1001</th>
      <td>Teresa</td>
    </tr>
    <tr>
      <th>1002</th>
      <td>Cecilia</td>
    </tr>
    <tr>
      <th>1003</th>
      <td>Eda</td>
    </tr>
    <tr>
      <th>1004</th>
      <td>Etta</td>
    </tr>
    <tr>
      <th>1005</th>
      <td>Faye</td>
    </tr>
  </tbody>
</table>
</div>




```python
# Want to select EVERY row?
# Don't put anything before and after the colon :
baby_names.loc[:, ['Sex', 'Name']].head(4)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Sex</th>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>F</td>
      <td>Mary</td>
    </tr>
    <tr>
      <th>1</th>
      <td>F</td>
      <td>Helen</td>
    </tr>
    <tr>
      <th>2</th>
      <td>F</td>
      <td>Dorothy</td>
    </tr>
    <tr>
      <th>3</th>
      <td>F</td>
      <td>Margaret</td>
    </tr>
  </tbody>
</table>
</div>



### Selecting an entire Column

Remember we can extract the column in the form of a **Series** using:

`table_name['Name of column']`


```python
name_column = baby_names['Name']
name_column.head(5) # we can also use .head with Series!
```




    0        Mary
    1       Helen
    2     Dorothy
    3    Margaret
    4     Frances
    Name: Name, dtype: object



### Selecting rows with a Boolean Array

Lastly, we can select rows based off of True / False data. Let's go back to the simpler `fruit_info` table.


```python
fruit_info
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>5</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>




```python
# select row only if corresponding value in *selection* is True
selection = np.array([True, False, True, False])
fruit_info[selection]
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



## Filtering Data

So far we have selected data based off of row numbers and column headers. Let's work on filtering data more precisely.

`table[condition]`


```python
condition = baby_names['Name'] == 'Carlo'
baby_names[condition].head(5)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>State</th>
      <th>Sex</th>
      <th>Year</th>
      <th>Name</th>
      <th>Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>219486</th>
      <td>CA</td>
      <td>M</td>
      <td>1917</td>
      <td>Carlo</td>
      <td>10</td>
    </tr>
    <tr>
      <th>219941</th>
      <td>CA</td>
      <td>M</td>
      <td>1918</td>
      <td>Carlo</td>
      <td>8</td>
    </tr>
    <tr>
      <th>220848</th>
      <td>CA</td>
      <td>M</td>
      <td>1920</td>
      <td>Carlo</td>
      <td>10</td>
    </tr>
    <tr>
      <th>221935</th>
      <td>CA</td>
      <td>M</td>
      <td>1922</td>
      <td>Carlo</td>
      <td>9</td>
    </tr>
    <tr>
      <th>222457</th>
      <td>CA</td>
      <td>M</td>
      <td>1923</td>
      <td>Carlo</td>
      <td>10</td>
    </tr>
  </tbody>
</table>
</div>



The above code only selects rows that have Name equal to 'Carlo'. Change it to your name!

### Apply multiple conditions!

 `table[ (condition 1)  &  (condition 2) ]`
 

 
<font color="blue">Class Exercise:</font> select the names in Year 2000 that have larger than 3000 counts.


```python
result = baby_names[(baby_names['Count'] > 3000) & (baby_names['Year'] == 2000)]
result.head(3)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>State</th>
      <th>Sex</th>
      <th>Year</th>
      <th>Name</th>
      <th>Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>320198</th>
      <td>CA</td>
      <td>M</td>
      <td>2000</td>
      <td>Daniel</td>
      <td>4339</td>
    </tr>
    <tr>
      <th>320199</th>
      <td>CA</td>
      <td>M</td>
      <td>2000</td>
      <td>Anthony</td>
      <td>3837</td>
    </tr>
    <tr>
      <th>320200</th>
      <td>CA</td>
      <td>M</td>
      <td>2000</td>
      <td>Jose</td>
      <td>3803</td>
    </tr>
  </tbody>
</table>
</div>



### Thorough explanation:

Remember that calling `baby_names['Name']` returns a **Series** of all of the names.

Checking if values in the series are equal to `Carlo` results in an array of {True, False} values. 

Then, we select rows based off of this boolean array. Thus, we could also do:


```python
names = baby_names['Name']
equalto_Carlo = (names == 'Carlo')  # equalto_Carlo is now an array of True/False variables!
baby_names[equalto_Carlo].head(5)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>State</th>
      <th>Sex</th>
      <th>Year</th>
      <th>Name</th>
      <th>Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>219486</th>
      <td>CA</td>
      <td>M</td>
      <td>1917</td>
      <td>Carlo</td>
      <td>10</td>
    </tr>
    <tr>
      <th>219941</th>
      <td>CA</td>
      <td>M</td>
      <td>1918</td>
      <td>Carlo</td>
      <td>8</td>
    </tr>
    <tr>
      <th>220848</th>
      <td>CA</td>
      <td>M</td>
      <td>1920</td>
      <td>Carlo</td>
      <td>10</td>
    </tr>
    <tr>
      <th>221935</th>
      <td>CA</td>
      <td>M</td>
      <td>1922</td>
      <td>Carlo</td>
      <td>9</td>
    </tr>
    <tr>
      <th>222457</th>
      <td>CA</td>
      <td>M</td>
      <td>1923</td>
      <td>Carlo</td>
      <td>10</td>
    </tr>
  </tbody>
</table>
</div>



## Using Numpy with Pandas

How many rows does our `baby_names` table have?


```python
len(baby_names)
```




    367931



That's a lot of rows! We can't just look at the table and understand it.

Luckily, **Numpy** functions treat pandas **Series** as np.arrays.

<font color="blue">Exercise:</font> What is oldest and most recent year that we have data from in `baby_names`?
HINT: np.min, np.max


```python
recent_year = np.max(baby_names['Year'])
oldest_year = np.min(baby_names['Year'])
(recent_year, oldest_year)
```




    (2016, 1910)



<font color="blue">Exercise:</font> How many baby names were born in CA in 2015?

Hint: the 'Count' column refers the the number of occurrences of a baby name. How could we find the total number of baby names? Now narrow that to only 2015.


```python
baby_names_2015 = baby_names[baby_names['Year'] == 2015]
baby_names_2015_counts = baby_names_2015['Count']
number_baby_names_2015 = np.sum(baby_names_2015_counts)
number_baby_names_2015
```




    429730




```python
np.sum(baby_names[baby_names['Year'] == 2015]['Count'])
```




    429730



### np.unique


```python
# return an array with an element for each unique value in the Series/np.array
np.unique(baby_names['Sex'])
```




    array(['F', 'M'], dtype=object)




```python
# demo
states = np.unique(baby_names['State']) # okay now we know this dataset only involves California babies.
```


```python
names = np.unique(baby_names['Name'])
len(names)
```




    19234



## Copy vs View

Depending on how you format your code, pandas might be returning a copy of the dataframe (i.e. a whole new dataframe, but just with the same values), or a view of the dataframe (i.e. the same dataframe itself).


```python
carlos_fruits = fruit_info.copy()
carlos_fruits
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>5</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



Let's say Carlo is happy with those ratings. But Jun Seo loves bananas! Let's make a "new" dataframe and change the ratings accordingly:


```python
junseos_fruits = carlos_fruits
junseos_fruits['rating'] = [3, 4, 9999, 5]
junseos_fruits
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>9999</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



And taking a look back at Carlo's fruits:


```python
carlos_fruits
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>9999</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



Wait, Carlo's banana rating shouldn't be that high! What happened is that junseos_fruits returned a *view* on Carlo's dataframe. Then did our shenanigans affect the original fruit_info dataframe too?


```python
fruit_info
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>5</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



No, because when we called `carlos_fruits = fruit_info.copy()`, we asked pandas to forcibly create a brand new dataframe with identical values instead.

### SettingWithCopyWarning

This is arguably one of the most frustrating warnings you will see while using pandas. 
TL;DR: Use .loc instead of square brackets to index into data.

Let's say Jun Seo strongly dislikes apples.


```python
junseos_fruits[junseos_fruits['fruit'] == 'apple']
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
  </tbody>
</table>
</div>




```python
junseos_fruits[junseos_fruits['fruit'] == 'apple']['rating'] = -100
junseos_fruits
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>9999</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>




```python
junseos_fruits['rating']
```




    0       3
    1       4
    2    9999
    3       5
    Name: rating, dtype: int64




```python
junseos_fruits['rating'][0] = -100
junseos_fruits
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>-100</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>9999</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>




```python
junseos_fruits.loc[1, 'rating'] = 1738
junseos_fruits
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>color</th>
      <th>fruit</th>
      <th>inventory</th>
      <th>rating</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>apple</td>
      <td>23</td>
      <td>-100</td>
    </tr>
    <tr>
      <th>1</th>
      <td>orange</td>
      <td>orange</td>
      <td>18</td>
      <td>1738</td>
    </tr>
    <tr>
      <th>2</th>
      <td>yellow</td>
      <td>banana</td>
      <td>50</td>
      <td>9999</td>
    </tr>
    <tr>
      <th>3</th>
      <td>pink</td>
      <td>raspberry</td>
      <td>20</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



## [optional] Group By

We won't have time to go through this thoroughly in lab. However, we encourage you to look into this material if you want to go further. Feel free to ask us any questions!

In the previous section we calculated the number of baby names registered in 2015.


```python
np.sum(baby_names[baby_names['Year'] == 2015]['Count'])
```




    429730



There are 107 years though. If we wanted to know how many babies were born in California for each year we need to do something more efficient.

`groupby` to the rescue!

Groupby allows us to split our table into groups, each group having one similarity.

For example if we group by "Year" we would create 107 groups because there are 107 unique years.


<center>`baby_names.groupby('Year')`</center>


Now we have 107 groups but what do we do with them? We can apply the function `sum` to each group. This will sum the other numerical column, 'Counts' which reduces each group to a single row: Year and sum.

Excellent tutorial: http://bconnelly.net/2013/10/summarizing-data-in-python-with-pandas/


```python
# this will apply sum to the "Count" column of each year group
yearly_data = baby_names.groupby('Year').sum()
yearly_data.head(5)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Count</th>
    </tr>
    <tr>
      <th>Year</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1910</th>
      <td>9164</td>
    </tr>
    <tr>
      <th>1911</th>
      <td>9984</td>
    </tr>
    <tr>
      <th>1912</th>
      <td>17944</td>
    </tr>
    <tr>
      <th>1913</th>
      <td>22094</td>
    </tr>
    <tr>
      <th>1914</th>
      <td>26925</td>
    </tr>
  </tbody>
</table>
</div>



Further reading: http://bconnelly.net/2013/10/summarizing-data-in-python-with-pandas/

# <font id="2.5" color="blue">Plot with Pandas</font>


```python
%matplotlib inline
```

[Pandas.plot documentation](https://pandas.pydata.org/pandas-docs/stable/generated/pandas.DataFrame.plot.html)

Pandas comes with a built-in `plot` method that can be very useful! `pandas.plot` actually uses `matplotlib` behind the scenes!

`yearly_data` contains the number of registered babies per year.


```python
yearly_data.head()
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Count</th>
    </tr>
    <tr>
      <th>Year</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1910</th>
      <td>9164</td>
    </tr>
    <tr>
      <th>1911</th>
      <td>9984</td>
    </tr>
    <tr>
      <th>1912</th>
      <td>17944</td>
    </tr>
    <tr>
      <th>1913</th>
      <td>22094</td>
    </tr>
    <tr>
      <th>1914</th>
      <td>26925</td>
    </tr>
  </tbody>
</table>
</div>



## Line Graphs


```python
yearly_data.plot(kind="line")  #kind='line' is optional
```




    <matplotlib.axes._subplots.AxesSubplot at 0x11a052198>




![png](numpy_files/numpy_150_1.png)


### Study: Name History


```python
# don't worry about this function unless you want to learn about groupby
def your_name_history(name):
    return baby_names[baby_names['Name'] == name].groupby('Year').sum()
```


```python
table = your_name_history('John')

table.plot()
```




    <matplotlib.axes._subplots.AxesSubplot at 0x114a44470>




![png](numpy_files/numpy_153_1.png)


## Bar Graphs

We can modify our data before we graph it to analyze different things.


```python
yearly_data.plot(kind="bar")
plt.axis('off')
```




    (-0.5, 106.5, 0.0, 580000.05000000005)




![png](numpy_files/numpy_155_1.png)


<font color="blue">Class Exercise:</font> How could we graph only the 15 years after World War II (i.e. 1945-1960)?

Hint: create a table with only the desired years first


```python
modified = yearly_data.loc[1945:1960]

modified.plot(kind="bar", figsize=(15,8))
```




    <matplotlib.axes._subplots.AxesSubplot at 0x11b7f5fd0>




![png](numpy_files/numpy_157_1.png)
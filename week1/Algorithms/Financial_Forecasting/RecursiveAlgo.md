# Recursion and how it can simplify certain problems

Recursion is a programming technique where a function calls itself to solve a problem. Each recursive call breaks the problem into smaller subproblems until a base case is reached the simplest possible version of the problem that can be solved directly.

## A recursive function  typically has two components

- A base case : The condition that stops recursion. Without it, recursion would run forever and cause a stack overflow.

- Recursive Case – The part of the function where it calls itself with a smaller or simpler input.


In this example, we use a recursive approach to find predict the price for a specific year based on an initial value. The recursive function is called as

```predictor(n) = predictor(n-1)*(1+growth_rate)  ```
  
where, ```predictor(n)``` is the function call for the nth year and so is the ```growth_rate```.

```predictor(n)``` calls ```predictor(n-1)``` which is a recursive call for the prediction for ```n-1 th``` year.

this goes on until we reach ```predictor(-1)``` (in case of 0 indexing) which returns the initial value we started with resulting in all the recursive calls in the stack to return until we get the value for ```predictor(n)```. 


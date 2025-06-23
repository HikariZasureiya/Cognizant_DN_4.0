# Time Complexity of the code
In this example, we use a recursive approach to find predict the price for a specific year based on an initial value. The recursive function is called as

```predictor(n) = predictor(n-1)*(1+growth_rate)  ```

here at every step, the function call expands to find the prediction of previous year in a linear fashion. 

for example , ```predictor(5)``` will call ```predictor(4)``` which will call ```predictor(3)``` ... until we reach base case. this is why , the time complexity is ``O(n)``.


# Improvement of Recursive method

The recursive approach of a problem can be improved using ```memoization``` which is a process of storing subproblems so that further computations are not required at that step.

## For example
In this problem, if we were said to find the amount of the ```3rd``` year and ```5th``` year for a same initial value, we'd be doing computation of  ```2nd``` year and ```3rd``` year twice if we don't save their amount.

in order to store it , we use multi-dimentional arrays or hash maps to store intermediate results which can be fetched instead of recomputing the whole subproblem.

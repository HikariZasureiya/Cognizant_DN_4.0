# 📊 Big O Notation and Search Scenarios Explained

## Understanding Big O Notation and Why It Matters

Big O notation is a way to measure how an algorithm performs as the input size increases. It doesn’t focus on how long something takes in seconds, but on how the number of operations grows relative to the input.

For example, if a developer writes a loop that runs once for every item in a list, the time complexity is `O(n)` , meaning it grows linearly with the number of items.

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```
This loop runs n times, so the time complexity is ```O(n)```. But if there’s a nested loop inside it, like:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + "," + j);
    }
}
```
Then it becomes ```O(n^2)``` since it does ```n * n``` operations.

Big O helps the developer choose which algorithm works better, especially when performance becomes an issue with large inputs.

# Best, Average, and Worst-Case Scenarios for Search Operations

When analyzing an algorithm, especially for searching, it’s important to look at how it performs in different scenarios , not just the perfect case.

In the best case, the item being searched is found right at the beginning. Take this example:

```java
int[] arr = {5, 8, 2, 9, 1};
int key = 5;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == key) {
        System.out.println("Found at index: " + i);
        break;
    }
}
```
Here, the key is found on the first check. That’s the best case, and it runs in O(1) time.

In the average case, the item might be somewhere in the middle. So the loop runs a few times before finding it. Even if it doesn’t run all the way through, we still consider the time complexity to be O(n) because it's proportional to input size on average.

In the worst case, the item is either at the very end or not present at all. The loop goes through every single element.

```java

int key = 100; // doesn't exist in array

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == key) {
        System.out.println("Found at index: " + i);
        break;
    }
}
```

This will run n times and still not find the key, which is why we say the worst-case time complexity is O(n) for linear search.

For other search algorithms like binary search, best case is still O(1), average and worst are O(log n) , but that’s only when the array is sorted.


# Comparing Linear and Binary Search Algorithms
When building a search function for an e-commerce platform, it’s important to choose the right algorithm for performance and scalability. Two common approaches are linear search and binary search.

## Linear search
Linear search goes through each item one by one until it finds the target (or doesn't). The time complexity is O(n). Which means the time increases linearly as more products are added.


```java
String[] products = {"Laptop", "Camera", "Phone", "Tablet"};
String target = "Phone";

for (int i = 0; i < products.length; i++) {
    if (products[i].equals(target)) {
        System.out.println("Found at index: " + i);
        break;
    }
}
```

This works even if the data is unsorted, but performance drops as the number of products grows.

## Binary Search
Binary search is much faster, but it requires the product list to be sorted. It repeatedly divides the search space in half, cutting down the number of comparisons drastically. The time complexity is O(log n).


Binary search is much faster than linear search, especially with large data sets.

# Which Algorithm is More Suitable for the Platform?

In an e-commerce platform, where product listings can grow into thousands or more, binary search is more suitable — but only if the product data is sorted.

If the product list is sorted by name, price, or category, binary search can drastically reduce the time taken to find an item. Since most platforms use databases or in-memory sorted structures for product listings, binary search (or even better, database indexing) is a smart choice.

However, if the data is unsorted (like results from a user-generated collection or a temporary cart), linear search is more flexible and doesn't require pre-sorting.

So, the choice depends on the scenario:

For quick, one-off searches in unsorted data → linear search works.

For main product catalog search → binary search is better and scales well.

In most real-world platforms, developers would go a step further and use optimized search algorithms and data structures like tries, trees, or database indexes. But at the base level, binary search already gives a good balance of speed and simplicity.


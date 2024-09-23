### Exercise Comparing Class Objects

In this exercise, you will learn how to tell the compiler how to order elements. This is necessary for maintaining a sorted list, which is used in Binary Search.

You will compare Square objects using `==`, `.equals`, `compareTo()`, and `compare()`.

1. Modify the Square class by adding a Color color member variable. Use WHITE for the default constructor. Add color as a parameter to the other constructor.

1. Implement the .equals method for Square. The method signature is below. Note that the parameter is of type **Object**. Two squares are equal if both the width and height are the same for both.

```
@Override
public boolean equals(Object other)
```

1. It is important that the compareTo method of a class has the same basis of comparison as equals. Therefore, modify the compareTo method so that the basis of comparison is the width, with height as the tie-breaker.

1. In Main, complete the first set of comparisons, comparing s1 to s3 and then to s4. Pay attention to the different results. Answer the question on the worksheet.

1. In Main, complete the print statements and comparisons for s1 and s2 using your compareTo method. Answer the questions on the worksheet.

1. Change the compareTo method so it is ordering from maximum to minimum. Complete the print statements and comparisons in Main. Answer the question on the worksheet.

Now change it back so it matches the equals.

### Implement the Comparator

1. In Main, define an ordering class for each of area, area reverse, and color.

1. Create an instance of each.

1. Use those instances to compare as indicated in main.

1. Create an instance of comparison based on height (within main). Then use it to compare squares.

 



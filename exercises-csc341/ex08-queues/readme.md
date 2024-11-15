## Exercise 8 Queues and Stacks

This will be needed for the final programming assignment based on graphs.

<hr>

In this assignment, you will implement the ADT Queue and the ADT Stack. Both will be implementing the QueueInterface.

The Queue should be implemented using a **Circular Array**, which uses indices to mark the "head" and "tail" of the queue that is stored in the array. You should also use a **dummy space** in this implementation, meaning an extra space that is a buffer between the end of the array and the head (it is always 1 space "before" the head). The count is not maintained.

> If the indices used for the head and tail of the Queue are equal, then the Queue is empty. If the tail index + 1 would be equal to the head index of the Queue, then the Queue is full.

The Stack implementation is your choice. For the implementation, both push and pop operate at the same "end" of the data structure. 


> The word "queue" is used both as a general concept and as a specific ADT. The ADTs Stack and Queue are technically both queues in that they only operate on the ends of the structure, not in the middle. There is also a Priority Queue and a Deque (not to be confused with the operation dequeue, which is synonymous with remove). Typically, when someone just says "queue," they mean an FIFO Queue, but if there is any ambiguity be sure to ask.

<hr>

### Implementation of interface QueueInterface
- `public void push(T value)` : add a value to the end of the Queue.
- `public T pop()` : remove the first element of the Queue.
- `public T peek()` : return the first element of the Queue, but do not remove it.
- `public boolean isEmpty()` : true if Queue is empty.


### Implementation of class Queue

The methods for `public class Queue<T> implements QueueInterface<T>` are specified by the QueueInterface. Additionally:
- `public String toString()` : override Object toString, which might be useful for debugging.

Your class Queue should have the following private member variables. You may include more than these.
- `private int head` : index of the first element in the Queue
- `private int tail` : index of the location to place the next added value

>Note: you might find it useful to have a helper function that returns the "next" index.

<hr>

### Implementation of class Stack

The methods for `public class Stack<T> implements QueueInterface<T>` are specified by the QueueInterface. Additionally,


<hr>

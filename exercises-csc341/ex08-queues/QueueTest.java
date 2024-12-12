import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testPushAndPop() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertEquals(2, queue.peek());
    }

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>(3);
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        queue.pop();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueFull() {
        Queue<Integer> queue = new Queue<>(2);
        queue.push(1);
        queue.push(2);
        assertThrows(IllegalStateException.class, () -> queue.push(3));
    }

    @Test
    public void testQueueEmpty() {
        Queue<Integer> queue = new Queue<>(2);
        assertThrows(IllegalStateException.class, queue::pop);
        assertThrows(IllegalStateException.class, queue::peek);
    }
}
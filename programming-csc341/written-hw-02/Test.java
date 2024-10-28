public class Test {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList.getMiddle());
        linkedList.add(6);
        System.out.println(linkedList.getMiddle());
        linkedList.remove(6);
        System.out.println(linkedList.getMiddle());

    }

}
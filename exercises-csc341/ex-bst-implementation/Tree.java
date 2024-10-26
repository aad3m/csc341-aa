public class Tree {

    public static Node root;

    public static Node locate(int val, Node node) {
        if (node == null) {
            return null;
        } else if (node.value == val) {
            return node;
        } else if (val < node.value) {
            return locate(val, node.left);
        } else {
            return locate(val, node.right);
        }
    }

     public static Node locate(int val) {
        return locate(val, root);
    }


    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(40);
        root.right = new Node(60);
        root.left.left = new Node(30);
        root.left.right = new Node(45);
        root.right.left = new Node(55);
        root.left.left.right = new Node(42);

        System.out.println("Locate 42: " + locate(42));
        System.out.println("Locate 55: " + locate(55));
        System.out.println("Locate 33: " + locate(33));
        System.out.println("Locate 63: " + locate(63));
    }
}
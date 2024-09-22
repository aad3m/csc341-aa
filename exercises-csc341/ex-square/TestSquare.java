public class TestSquare {

    public static void main(String[] argos) {
        Square s1 = new Square();
        Square s2 = new Square(10,5);
        Square s3 = new Square(5,10);
        Square s4 = new Square(8,5);

        System.out.println("s1 s2 expect <0: " + s1.compareTo(s2));
        System.out.println("s2 s3 expect ==0: " + s2.compareTo(s3));
        System.out.println("s3 s4 expect >0: " + s3.compareTo(s4));

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println(s4.toString());
    }
}

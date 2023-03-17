public class Main {
    public static void main(String[] args){

        algoArray a = new algoArray(6);
        a.input();
        a.shellSort();
        System.out.println("=============================");

        System.out.println(a);
        System.out.println("-----------------------------");

        algoArray b = new algoArray(6);
        b.Frd(1, 30);
        System.out.println(b);
        b.shellSort();
        System.out.println(b);
        System.out.println("=============================");


        algoArray c = new algoArray(9);
        c.setElement(0, 2);
        c.setElement(1, 8);
        c.setElement(2, 7);
        c.setElement(3, 3);
        c.setElement(4, 9);
        c.setElement(5, 10);
        c.setElement(6, 3);
        c.setElement(7, 5);
        c.setElement(8,-1);
        c.mergeSort();
        System.out.println("mergeSort Array: " + c.toString());
        System.out.println("-----------------------------");
        c.shellSort();
        System.out.println("shellSort Array: " + c.toString());
        System.out.println("-----------------------------");
        c.quickSort();
        System.out.println("quickSort Array: " + c.toString());
        System.out.println("-----------------------------");



    }
}

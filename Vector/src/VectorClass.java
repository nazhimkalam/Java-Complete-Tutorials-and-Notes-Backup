import java.util.Vector;

public class VectorClass {
    public static void main(String[] args) {
        // Vector is a type of list and it's similar to an array List
        // ArrayList is much better than Vectors
        // Always use arrayList not Vectors in your projects because, arrayList are faster, optimizes the usage of memory than compared to Vectors
        Vector v = new Vector();
        Vector<Integer> v1 = new Vector<Integer>();

        v.add(5);                   // adding integer
        v.add(5.2);                 // adding double
        v.add(true);                // adding boolean
        v.add("NAzhim");            // adding string
        v.add(new VectorClass());   // adding object

        v1.add(55);
        v1.add(10);

        for (Object obj : v) {
            System.out.println(obj);
        }

        for (int i : v1){
            System.out.println(i);
        }

    }
}

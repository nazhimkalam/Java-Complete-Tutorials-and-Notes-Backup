public class Overloading {                    // In this we access methods of same name but different parameters
    public static void main(String[] args) {
        Methods obj = new Methods();
        obj.show();
        obj.show(5);
        obj.show(2.5);
        obj.show(true);
    }
}

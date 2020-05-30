public class Abstract {
    public static void main(String[] args) {
        // example 01
//        Ramesh obj = new Suresh();  //we create an object of Suresh
//        obj.call();
//        obj.move();
//        obj.dance();
//        obj.cook();

        // example 02
        display(new Samsung());  //we can just name any phone class it will use the method in the Phone class to give the output
    }
    public static void display(Phone object){
        object.showConfiguration();
    }
}



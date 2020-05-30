public class B extends A{  // Initially the super key is by default there for show() but
    @Override              // when we create a new method called show it shows the overriding to class A show() with the super key word.
    public void show() {
        super.show();      //when super is used it will refer to the parent class method
        super.show();      //calls the show method in the class A again
        System.out.println("This is the show method from class B");
        super.show();
    }
}

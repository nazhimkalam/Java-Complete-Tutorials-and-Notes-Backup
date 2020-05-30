public class A {
    int count = 0;
    public A(){
        count = 7;
    }
    public void display(){
        System.out.println(count);
        // Like this you will be able to see the constructor changing the value of the count to 7
    }
}

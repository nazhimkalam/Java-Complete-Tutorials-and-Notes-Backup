public class Encapsulation { // this is the use of setter and getters
    public static void main(String[] args) {
        Customer customer = new Customer();      //making an object of customer
        customer.setName("Nazhim");
        customer.setAge(18);
        customer.setGender("Male");
        customer.setHeight(5.7);
        customer.setSingle(false);
        customer.displayDetails();
    }
}

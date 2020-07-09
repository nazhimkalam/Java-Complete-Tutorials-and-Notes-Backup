import java.util.HashMap;
import java.util.Set;

public class HMap {
    public static void main(String[] args) {

        // Creating a Hash map
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Put elements to the map
        hashMap.put(2019281,"Nazhim");
        hashMap.put(2019282,"Shaahid");
        hashMap.put(2019283,"Shonny");
        hashMap.put(2019284,"Saavy");
        // Get a set of the entries
        Set set = hashMap.entrySet();

        // Displaying the contents in the HashMap
        Object[] HashMapArray = set.toArray();
        for (int i = 0; i < HashMapArray.length; i++) {
            String[] split = HashMapArray[i].toString().split("=");
            System.out.println("This is the key: " + split[0] + " for the value: " + split[1]);
        }
    }
}

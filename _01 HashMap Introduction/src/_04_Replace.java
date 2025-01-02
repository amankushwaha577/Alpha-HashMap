import java.util.HashMap;
import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

public class _04_Replace {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);
        System.out.println("map -> "+ map);
        System.out.println("--------------------------------");

        // 4.A. replace(K key, V value):
        //      Replaces the value for the specified key if it exists.
        // Returns :
        // a. if key matches + if the optional parameter oldValue is not present :
        //    than returns The previous value associated with the specified key.
        // b. if key does't match returns null.
        map.replace("Apple", 33);
        System.out.println("Old Banana -> "+ map.replace("Banana", 88888)); // if key matches returns old value
        System.out.println("Old Kiwi -> "+ map.replace("kiwi", 88888));     // if key does't match returns null
        System.out.println("map -> "+ map);
        System.out.println("--------------------------------");


        map.clear();
        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);
        System.out.println("map -> "+ map);
        System.out.println("--------------------------------");



        // 4.B. replace(K key, V oldValue, V newValue):
        //      Replaces the value for the key only if it is currently mapped to oldValue.
        // Returns :
        // a. if key matches + if the optional parameter oldValue is also matches :
        //    than returns true else false
        // b. if key does't match returns false.
        System.out.println("Old Banana -> "+ map.replace("Apple", 300,800));
        // key matched + value matched       => Replaced + return true
        System.out.println("Old Orange -> "+ map.replace("Orange", 11, 800));
        // key matched + value did't matched => No Replacement + return false
        System.out.println("Old Kiwi -> "+ map.replace("Kiwi", 11, 800));
        // key does't match => returns false
        System.out.println("map -> "+ map);
    }
}
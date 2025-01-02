
import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

public class _05_Remove {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);
        System.out.println("map -> " + map);
        System.out.println("--------------------------------");


        // Removing an element
        // 3.A. remove(Object key) :
        //    Removes the mapping for the specified key if present.
        // returns :
        // -------------------------------------------------------
        //    a. If key matches : return value
        //    b. if key does't match : return null
        System.out.println(map.remove("Orange"));  // If key matches : return value
        System.out.println(map.remove("Kiwi"));    // if key does't match : return null
        System.out.println("map -> " + map);
        System.out.println("--------------------------------");



        // 3.B. remove(Object key, Object value) :
        //      Removes the mapping for the specified key + value if present.
        // returns :
        // -------------------------------------------------------
        //    a. If key matches + value matches: return true
        //    b. If key matches + value does't matches: return false
        //    b. if key does't match : return false
        System.out.println(map.remove("Apple", 300));  // If key matches + value matches: return true
        System.out.println(map.remove("Banana", 500)); // If key matches + value does't matches: return false
        System.out.println(map.remove("kiwi", 700));   // if key does't match : return false
        System.out.println("map -> " + map);
        System.out.println("--------------------------------");



    }
}
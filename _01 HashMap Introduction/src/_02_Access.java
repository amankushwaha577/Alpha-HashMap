import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

public class _02_Access {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);
        System.out.println("map -> "+ map);
        System.out.println("--------------------------------");

        // Accessing elements :
        // -----------------------------------------------

        // 2.A.(i) get(Object key) :
        // -----------------------
        // Returns the value associated with the specified key, or null if the key is not found.
        // returns value/null
        // Note :  if either the specified key is mapped to a null value
        System.out.println("Apple Price: " + map.get("Apple"));
        System.out.println("Apple2 Price: " + map.get("Apple2"));
        System.out.println("--------------------------------");


        // 2.A.(ii) getOrDefault(Object key, V defaultValue)
        // Returns the value associated with the key or a default value if the key is not found.
        // returns value/yourDefaultValue
        System.out.println("Apple Price: " + map.getOrDefault("Apple", 123)); // defaultvalue should have same datatype as 'value'
        System.out.println("Apple2 Price: " + map.getOrDefault("Apple2", 123));
        System.out.println("--------------------------------");



        // Accessing elements (Iteration Operations) :
        // --------------------------------

        // Iterate Keys
        // --------------------------------
        // 2.B.(i) keySet() :
        //         Returns a Set view of all the keys in the map.
        System.out.println("Print HashMap (Iteration) -");
        System.out.println("map.keySet() : Set View : " + map.keySet());
        // or Set<String> keys = map.keySet();
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println("--------------------------------");

        // Iterate Values
        // --------------------------------
        // 2.B.(ii) values() :
        //          Returns a Collection view of all the values in the map.
        System.out.println("Print HashMap (Iteration) -");
        System.out.println("map.values() : Collection View : " + map.values());
        // or Collection<Integer> values = map.values();
        for (int value : map.values()) {
            System.out.println( value);
        }
        System.out.println("--------------------------------");

        // Iterate Key-value pairs
        // --------------------------------
        // 2.B.(iii) entrySet() :
        //           Returns a Set view of all the key-value pairs (Map.Entry<K, V> objects) in the map.
        System.out.println("Print HashMap (Iteration) -");
        System.out.println("map.entrySet() : Set View : " + map.entrySet());
        // or Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry );
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // A. getKey(): Retrieves the key from the current entry.
        // B. getValue(): Retrieves the value associated with the current key in the entry.


    }
}

/**
 * 🌟 **HashMap Methods and Their Time Complexities**
 *
 * 1️⃣ **Basic Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | get(Object key)              | 🔍 Retrieves the value associated with a key  | O(1) (average)    |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 2️⃣ **Advanced Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | getOrDefault(Object key, V default) | 🔍 Returns value for a key or a default value | O(1)          |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 3️⃣ **Views and Iteration**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | keySet()                     | 🔑 Returns a Set of all keys                  | O(1)              |
 * | values()                     | 🛠️ Returns a Collection of all values         | O(1)              |
 * | entrySet()                   | 📦 Returns a Set of all key-value pairs       | O(1)              |
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | Iterating through keySet()   | 🔁 Iterates over all keys in the map          | O(n)              |
 * | Iterating through values()   | 🔁 Iterates over all values in the map        | O(n)              |
 * | Iterating through entrySet() | 🔁 Iterates over all key-value pairs          | O(n)              |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 📌 **Notes**:
 * - O(1) operations are average cases; hash collisions may degrade performance to O(n).
 * - O(n) operations depend on the number of entries in the HashMap.
 */

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

        // 2.A. get(Object key) :
        // -----------------------
        // Returns the value associated with the specified key, or null if the key is not found.
        // returns value/null
        // Note :  if either the specified key is mapped to a null value
        System.out.println("Apple Price: " + map.get("Apple"));
        System.out.println("Apple2 Price: " + map.get("Apple2"));
        System.out.println("--------------------------------");


        // 2.B. getOrDefault(Object key, V defaultValue)
        // Returns the value associated with the key or a default value if the key is not found.
        // returns value/yourDefaultValue
        System.out.println("Apple Price: " + map.getOrDefault("Apple", 123)); // defaultvalue should have same datatype as 'value'
        System.out.println("Apple2 Price: " + map.getOrDefault("Apple2", 123));
        System.out.println("--------------------------------");


        System.out.println("--------------------------------");
        System.out.println("Print HashMap -");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }





        // Iteration Operations :
        // --------------------------------
        // Iterate Keys
        // --------------------------------
        // 6.1. keySet() :
        // Returns a Set view of all the keys in the map.
        System.out.println("--------------------------------");
        System.out.println("Print HashMap (Iteration) -");
        System.out.println("map.keySet() : " + map.keySet());
        // or Set<String> keys = map.keySet();
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // Iterate Values
        // --------------------------------
        // 6.2. values() :
        // Returns a Collection view of all the values in the map.
        System.out.println("map.values() : " + map.values());
        // or Collection<Integer> values = map.values();
        for (int value : map.values()) {
            System.out.println( value);
        }

        // Iterate Key-value pairs
        // --------------------------------
        // 6.3. entrySet() :
        // Returns a Set view of all the key-value pairs (Map.Entry<K, V> objects) in the map.
        System.out.println("Print HashMap (Iteration) -");
        System.out.println("map.entrySet() : " + map.entrySet());
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
 * | put(K key, V value)          | 📝 Inserts or updates a key-value pair        | O(1) (average)    |
 * | get(Object key)              | 🔍 Retrieves the value associated with a key  | O(1) (average)    |
 * | remove(Object key)           | ❌ Removes the key-value pair for a key       | O(1) (average)    |
 * | size()                       | 📏 Returns the number of key-value pairs      | O(1)              |
 * | isEmpty()                    | 🤔 Checks if the map is empty                 | O(1)              |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 2️⃣ **Key and Value Checks**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | containsKey(Object key)      | 🔑 Checks if the map contains a specific key   | O(1) (average)    |
 * | containsValue(Object value)  | 🔍 Checks if the map contains a specific value | O(n)              |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 3️⃣ **Bulk Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | putAll(Map<? extends K, ? extends V>) | 🔄 Copies all key-value pairs from another map | O(n)       |
 * | clear()                      | 🗑️ Removes all key-value pairs from the map    | O(1)              |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 4️⃣ **Views and Iteration**
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
 * 5️⃣ **Advanced Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | getOrDefault(Object key, V default) | 🔍 Returns value for a key or a default value | O(1)          |
 * | replace(K key, V oldVal, V newVal)  | ♻️ Replaces a value if it matches the old one | O(1)          |
 * | replace(K key, V value)             | ♻️ Replaces the value for a key              | O(1)          |
 * | merge(K key, V val, BiFunction)     | 🔗 Merges a key's value or applies a function | O(1)          |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 6️⃣ **Utility Methods**
 * ┌──────────────────────────────┬───────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                               | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────┼───────────────────┤
 * | equals(Object o)             | ⚖️ Compares the map with another object        | O(n)              |
 * | hashCode()                   | 🧮 Returns the hash code for the map           | O(n)              |
 * └──────────────────────────────┴───────────────────────────────────────────────┴───────────────────┘
 *
 * 📌 **Notes**:
 * - O(1) operations are average cases; hash collisions may degrade performance to O(n).
 * - O(n) operations depend on the number of entries in the HashMap.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements
        // 1. put(K key, V value) :
        // Inserts a key-value pair into the map or updates the value if the key already exists.
        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);
        System.out.println("map -> "+ map);

        // Accessing elements
        // 2. get(Object key) :
        // Returns the value associated with the specified key, or null if the key is not found.
        // returns value/null
        System.out.println("Apple Price: " + map.get("Apple"));
        System.out.println("Apple2 Price: " + map.get("Apple2"));


        // Iterating over the map
        System.out.println("--------------------------------");
        System.out.println("Print HashMap -");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // Removing an element
        // 3. remove(Object key) :
        // Removes the mapping for the specified key if present.
        System.out.println("--------------------------------");
        map.remove("Orange");
        System.out.println("Print HashMap (After Removing Orange Key) -");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }


        // Update Existing Key value
        // 4. put(K key, V value) :
        // Inserts a key-value pair into the map or updates the value if the key already exists.
        System.out.println("--------------------------------");
        map.put("Apple", 400);  // Update value of "Apple"
        System.out.println("Print HashMap (After Updating Apple value) -");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }


        // Search Operations :
        // -----------------------------------------
        // Search Key
        // --------------------------------
        // 5.1. containsKey(Object key) :
        // Checks if the map contains the specified key.
        // returns true/false
        System.out.println("--------------------------------");
        System.out.println("Print HashMap (Search Operations) -");
        System.out.println("Contains Banana? " + map.containsKey("Banana"));
        System.out.println("Contains Kiwi? " + map.containsKey("Kiwi"));

        // Search value
        // --------------------------------
        // 5.2. containsValue(Object value)
        // Checks if the map contains one or more keys that map to the specified value.
        // returns true/false
        System.out.println("Contains 400? " + map.containsValue(400));
        System.out.println("Contains 80000? " + map.containsValue(8000));

        // Search emptiness
        // --------------------------------
        // 5.3. isEmpty()
        // Checks if the map is empty.
        // returns true/false
        System.out.println("is map empty ? " + map.isEmpty());



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



        // 7. size() :
        // Returns the number of key-value pairs in the map.
        System.out.println("--------------------------------");
        System.out.println("Size Of map map.size() :- "+ map.size());


        // 8. clear() :
        // Removes all key-value pairs from the map.
        System.out.println("--------------------------------");
        map.clear();
        System.out.println("Size Of map After clear():- "+ map.size());
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

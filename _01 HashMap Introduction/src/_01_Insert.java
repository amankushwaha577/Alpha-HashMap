import java.util.HashMap;
import java.util.Map;

public class _01_Insert {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();

        // Adding elements :
        // -------------------------------------------------------------
        // Note: Every item is inserted in random positions in the HashMap.


        // 1.A. put(K key, V value) :
        //      Inserts a key-value pair into the map or updates the value if the key already exists.
        // -----------------------------------------------------------------------------------------
        // put() Return Value -
        // ---------------------
        // a. if key is already associated with any value, returns the previously associated value
        // b. if key is not associated with any value, returns null
        // Note : If key is previously associated with a null value, then also the method returns null
        map1.put("Apple", 300);
        map1.put("Banana", 35);
        System.out.println(map1.put("Orange", 70));  // return null  : as Orange key does't exist
        System.out.println(map1.put("Orange", 90));  // return 70    : as Orange key exists with value 70
        System.out.println("map1 -> "+ map1);
        System.out.println("--------------------------------");


        // 1.B. putAll(Map<? extends K, ? extends V> m) :
        //      map.putAll(anotherMap);
        //      Copies all key-value pairs from another map into this map.
        // ------------------------------------------------------------------------------------------
        // The putAll() method does not return any values.
        // ----------------------------------------------
        // Q. When Does Overriding Happen?
        // A. If a key in the source map matches a key in the current map, the value for that key in the current map will be updated to the value from the source map.
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Apple", 30000);
        map2.put("Kiwi", 77);
        map2.put("Strawberry", 900);
        System.out.println("map2 -> "+ map2);
        System.out.println("--------------------------------");

        map1.putAll(map2);
        // Apple key already existing in map1 so override it from map2.
        // other keys are not existing in map1 so add them as it is.
        System.out.println("Print HashMap map1 after merging with map2 -");
        System.out.println("map1 -> "+ map1);



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

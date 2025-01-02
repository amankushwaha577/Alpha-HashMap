
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _03_Search {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);
        System.out.println("map -> "+ map);
        System.out.println("--------------------------------");


        // Search Operations :
        // -----------------------------------------
        // Search Key
        // --------------------------------
        // 3.1. containsKey(Object key) :
        // Checks if the map contains the specified key.
        // returns true/false
        System.out.println("Print HashMap (Search Operations) -");
        System.out.println("Contains Banana? " + map.containsKey("Banana"));
        System.out.println("Contains Kiwi? " + map.containsKey("Kiwi"));
        System.out.println("--------------------------------");

        // Search value
        // --------------------------------
        // 3.2. containsValue(Object value)
        // Checks if the map contains one or more keys that map to the specified value.
        // returns true/false
        System.out.println("Contains 300? " + map.containsValue(300));
        System.out.println("Contains 80000? " + map.containsValue(8000));
        System.out.println("--------------------------------");

        // Search emptiness
        // --------------------------------
        // 3.3. isEmpty()
        // Checks if the map is empty.
        // returns true/false
        System.out.println("is map empty ? " + map.isEmpty());
        System.out.println("--------------------------------");



        // size() :
        // Returns the number of key-value pairs in the map.
        System.out.println("Size Of map map.size() :- "+ map.size());
        System.out.println("--------------------------------");

        // 8. clear() :
        // Removes all key-value pairs from the map.
        map.clear();
        System.out.println("Size Of map After clear():- "+ map.size());
        System.out.println("is map empty after clear() ? " + map.isEmpty());


    }
}

/**
 * 🌟 **HashMap Search Operations: Categorized and Explained**
 *
 * 1️⃣ **Search Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                                                       | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | containsKey(Object key)      | 🔑 Checks if the map contains a specific key.                         | O(1) (average)    |
 * |                              | Returns true if the key exists, false otherwise.                      |                   |
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | containsValue(Object value)  | 🔍 Checks if the map contains one or more keys for the specified value.| O(n)              |
 * |                              | Returns true if the value exists, false otherwise.                    |                   |
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | isEmpty()                    | 🤔 Checks if the map is empty.                                         | O(1)              |
 * |                              | Returns true if the map has no entries, false otherwise.              |                   |
 * └──────────────────────────────┴───────────────────────────────────────────────────────────────────────┴───────────────────┘
 *
 * 2️⃣ **Utility Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                                                       | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | size()                       | 📏 Returns the number of key-value pairs in the map.                   | O(1)              |
 * |                              | Does not modify the map.                                              |                   |
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | clear()                      | 🗑️ Removes all key-value pairs from the map.                           | O(1)              |
 * |                              | Makes the map empty.                                                  |                   |
 * └──────────────────────────────┴───────────────────────────────────────────────────────────────────────┴───────────────────┘
 *
 * 📌 **Notes**:
 * - Time complexities are based on average cases assuming a well-distributed hash function.
 * - The `containsValue` method is linear in complexity because it scans through all entries in the map.
 */

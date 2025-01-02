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
        System.out.println("--------------------------------");



        // 1.C. putIfAbsent(K key, V value)
        //      Inserts the key-value pair only if the key is not already present.
        // ------------------------------------------------------------------------------------------
        // putIfAbsent() Return Value -
        // ----------------------------
        // a. if the specified key is already present => returns the value associated with the key
        // b. if the specified key is't already present => returns null
        map1.putIfAbsent("Apple", 99999); // Apple key already present so ignore this operation.
        System.out.println(map1.putIfAbsent("Apple", 99999)); // Apple key already present so return value associated with it.
        System.out.println("map1 -> "+ map1);

        System.out.println(map1.putIfAbsent("Date", 44)); // Date key is not present so insert it. and return null
        System.out.println("map1 -> "+ map1);


    }
}

/**
 * 🌟 **HashMap Methods: Categorized Insert Operations**
 *
 * 1️⃣ **Basic Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                                                       | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | put(K key, V value)          | Inserts or updates a key-value pair.                                  | O(1) (average)    |
 * |                              | Returns the previous value if key existed, or null if the key was new.|                   |
 * └──────────────────────────────┴───────────────────────────────────────────────────────────────────────┴───────────────────┘
 *
 * 2️⃣ **Bulk Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                                                       | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | putAll(Map<? extends K, ? extends V> m) | Copies all key-value pairs from another map into this map. | O(n)              |
 * |                              | Overwrites values for matching keys, adds new keys.                   |                   |
 * └──────────────────────────────┴───────────────────────────────────────────────────────────────────────┴───────────────────┘
 *
 * 3️⃣ **Advanced Operations**
 * ┌──────────────────────────────┬───────────────────────────────────────────────────────────────────────┬───────────────────┐
 * | **Method**                   | **Description**                                                       | **Time Complexity**|
 * ├──────────────────────────────┼───────────────────────────────────────────────────────────────────────┼───────────────────┤
 * | putIfAbsent(K key, V value)  | Inserts the key-value pair only if the key is not already present.    | O(1) (average)    |
 * |                              | Returns the existing value if key exists, or null if insertion occurs.|                   |
 * └──────────────────────────────┴───────────────────────────────────────────────────────────────────────┴───────────────────┘
 *
 * 📌 **Notes**:
 * - O(1) operations assume a well-distributed hash function and minimal collisions.
 * - O(n) applies to the number of entries in the source map for `putAll`.
 */

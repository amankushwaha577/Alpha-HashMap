import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements
        // 1. put(K key, V value) :
        // Inserts a key-value pair into the map or updates the value if the key already exists.
        map.put("Apple", 300);
        map.put("Banana", 35);
        map.put("Orange", 70);

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
        // 5. containsKey(Object key) :
        // Checks if the map contains the specified key.
        // returns true/false
        System.out.println("--------------------------------");
        System.out.println("Print HashMap (Search Operations) -");
        System.out.println("Contains Banana? " + map.containsKey("Banana"));
        System.out.println("Contains Kiwi? " + map.containsKey("Kiwi"));

        // Search value
        // --------------------------------
        // 6. containsValue(Object value)
        // Checks if the map contains one or more keys that map to the specified value.
        // returns true/false
        System.out.println("Contains 400? " + map.containsValue(400));
        System.out.println("Contains 80000? " + map.containsValue(8000));




    }
}

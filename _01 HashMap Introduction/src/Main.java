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
        System.out.println("--------------------------------");
        System.out.println("Contains Banana? " + map.containsKey("Banana"));
        System.out.println("Contains Kiwi? " + map.containsKey("Kiwi"));



    }
}

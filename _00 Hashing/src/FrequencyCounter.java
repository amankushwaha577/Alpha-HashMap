import java.util.*;

public class FrequencyCounter {

    public static void main(String[] args) {
        // Dummy input for the number of elements and elements array
        int n = 5; // 5 elements
        int[] arr = {1, 2, 3, 1, 2};

        // Initialize a hash array to store the frequency of numbers from 0 to 9
        int[] hash = new int[10]; // Since the range is 0 to 9, size is 10
        // hash =[0,0,0,0,0,0,0,0,0]

        // Precompute the frequency of each element in the array
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && arr[i] <= 9) {
                // Ensure the number is within the hash array range
                // because it can't mesaure <0 like -2,-1  & >9 like 10,11,12

                hash[arr[i]] += 1;
                // arr[i] gives the value of the current element in the array.
                // hash[arr[i]] accesses the index in the hash array corresponding to the value of arr[i]
                // The += 1 operation increases the count at that index by 1.
            }
        }

        // Dummy input for queries and results
        int[] queries = {1, 2, 3, 4};

        // Answer each query by printing the frequency of the given number
        for (int number : queries) {
            if (number >= 0 && number <= 9) {
                System.out.println("Frequency of " + number + ": " + hash[number]);
            } else {
                System.out.println("Number out of range!");
            }
        }
    }
}

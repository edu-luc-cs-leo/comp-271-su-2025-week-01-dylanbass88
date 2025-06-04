import java.util.Arrays; // for printing array

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /*
     * Line 83 uses arr.length as the index because the temporary array
     * was made one element larger than arr (arr.length + 1).
     * This means the index arr.length is the first available empty spot
     * at the end of the new array. We use it to add the new value to the end.
     * If we tried arr.length on the old array, it would be out of bounds,
     * but for the new temporary array, it's a valid and correct index.
     */

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return Integer with the smallest value in array arr,
     *         or null if the array is empty
     */
    public static Integer getSmallest() {
        if (arr.length == 0) {
            return null;
        }

        int smallest_index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                smallest_index = i;
            }
        }

        int result = arr[smallest_index];
        int[] temporary = new int[arr.length - 1];

        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }

        arr = temporary;
        return result;
    }

    /**
     * Adds a new element to the end of the principal array arr after it resizes up
     * to accomodate the new element.
     * 
     * @param value int to add to the array
     */
    public static void add(int value) {
        int[] temporary = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temporary[i] = arr[i];
        }
        temporary[arr.length] = value;
        arr = temporary;
    }

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %s", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
    }
}

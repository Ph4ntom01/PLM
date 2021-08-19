package plm.array.sort;

public class PLMArrays {

    private PLMArrays() {}

    /**
     * The bubble sort algorithm repeatedly steps through the array, compares adjacent elements and
     * swaps them if they are in the wrong order.</br>
     * The pass through the array is repeated until the array is sorted.
     * 
     * @param array The array to be sorted.
     */
    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            boolean permuted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmpValue = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmpValue;
                    permuted = true;
                } else if (i == (array.length - 2) && !permuted) {
                    sorted = true;
                }
            }
        }
    }

    /**
     * The selection sort algorithm sorts an array by repeatedly finding the minimum element from
     * unsorted part and putting it at the beginning.
     * 
     * @param array The array to be sorted.
     */
    public static void selectionSort(int[] array) {
        int i = 0;
        int tmpValue, minPosition = 0;
        while (i < array.length) {
            minPosition = checkMinPosition(array, i);
            tmpValue = array[i];
            array[i] = array[minPosition];
            array[minPosition] = tmpValue;
            i++;
        }
    }

    /**
     * The min-max sort algorithm sorts an array by repeatedly finding the minimum and maximum elements
     * from unsorted part and putting them respectively at the beginning and the end.
     * 
     * @param array The array to be sorted.
     */
    public static void minMaxSort(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int tmpValue, minPosition, maxPosition = 0;
        while (i < j) {
            minPosition = checkMinPosition(array, i);
            tmpValue = array[i];
            array[i] = array[minPosition];
            array[minPosition] = tmpValue;

            maxPosition = checkMaxPosition(array, i, j);
            tmpValue = array[j];
            array[j] = array[maxPosition];
            array[maxPosition] = tmpValue;

            i++;
            j--;
        }
    }

    /**
     * This function is used into the selection and min-max sort algorithms to find the minimum.</br>
     * The minimum has to be find because the head position is constantly increasing.
     * 
     * @param array The array to be sorted.
     * @param head  The beginning of the unsorted part.
     * 
     * @return The position of the minimum.
     */
    private static int checkMinPosition(int[] array, int head) {
        int min = array[head];
        int position = head;
        for (int i = head + 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                position = i;
            }
        }
        return position;
    }

    /**
     * This function is used into the selection and min-max sort algorithms to find the maximum.</br>
     * The maximum has to be find because the head and the tail's positions are respectively increasing
     * and decreasing.
     * 
     * @param array The array to be sorted.
     * @param head  The beginning of the unsorted part.
     * @param tail  The end of the unsorted part.
     * 
     * @return The position of the minimum.
     */
    private static int checkMaxPosition(int[] array, int head, int tail) {
        int max = array[tail];
        int position = head;
        for (int i = tail - 1; i >= head; i--) {
            if (max < array[i]) {
                max = array[i];
                position = i;
            }
        }
        return position;
    }

}
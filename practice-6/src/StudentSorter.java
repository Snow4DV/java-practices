import java.util.Comparator;

public class StudentSorter {
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int sortedLength = 1; sortedLength < array.length; sortedLength++) {
            int index = sortedLength;
            while(index != 0 && array[index].compareTo(array[index - 1]) < 0) {
                T temp = array[index];
                array[index] = array[index-1];
                array[index-1] = temp;
                index --;
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(Comparator<T> comparator, T[] array, int firstI , int lastI) {


        if(firstI < lastI) {
            int pivot = (firstI + lastI)/2;

            int left = firstI, right = lastI;

            do {
                while (comparator.compare(array[left], array[pivot]) > 0) {
                    left++;
                }

                while (comparator.compare(array[right], array[pivot]) < 0) {
                    right--;
                }

                if (left <= right) {
                    if (left < right) {
                        T temp = array[left];
                        array[left] = array[right];
                        array[right] = temp;
                    }
                    left++;
                    right--;
                }
            }
            while(left <= right);
            int divIndex = (firstI + lastI)/2;
            quickSort(comparator, array, firstI, divIndex);
            quickSort(comparator, array, divIndex+1, lastI);
        }
    }
}

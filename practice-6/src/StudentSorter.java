public class StudentSorter {
    public static void insertionSort(Student[] array) {
        for (int sortedLength = 1; sortedLength < array.length; sortedLength++) {
            int index = sortedLength;
            while(index != 0 && array[index].compareTo(array[index - 1]) < 0) {
                Student temp = array[index];
                array[index] = array[index-1];
                array[index-1] = temp;
                index --;
            }
        }
    }

    public static Student[] quickSort(Student[] array) {
        if()
    }
}

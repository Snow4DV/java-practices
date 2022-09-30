import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] iDNumber = new Student[]{
                new Student("Vanya", 0, 2),
                new Student("Kolya", 2, 3),
                new Student("Petya", 1, 1),
                new Student("Tolya", 3, 4)
        };
        System.out.println(Arrays.toString(iDNumber));
        StudentSorter.insertionSort(iDNumber);
        System.out.println(Arrays.toString(iDNumber));
    }




}
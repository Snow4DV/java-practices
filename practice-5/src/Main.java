import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        //int counter = ex16(0, Integer.MIN_VALUE);
        //System.out.println(counter);
        //int max = ex17();
        //System.out.println(max);
        System.out.println(ex1(5));
    }


    public static int ex16(int counter, int max) {
        int num = s.nextInt();
        if(num == 0) return counter;
        else if(num > max) { // New max found
            return ex16(1, num);
        } else { // Using old max
            return ex16((num == max ? counter + 1 : counter), max);
        }
    }

    public static int ex17() { // returns max number
        int num = s.nextInt();
        if(num == 0) return Integer.MIN_VALUE;
        return Math.max(num, ex17());
    }


    public static StringBuilder ex1(int n) {
        if(n == 0) return new StringBuilder();
        StringBuilder result = new StringBuilder();
        result.append(ex1(n-1));
        for (int i = 0; i < n; i++) {
            result.append(' ').append(n);
        }
        return result;
    }
}
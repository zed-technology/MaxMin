import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 0; i <= arr.length - k; i++) {
            int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
            min = arr[i];
            max = arr[i+k-1];
//            for (int j = i; j < i + k; j++) {
//                if (arr[j] < min) {
//                    min = arr[j];
//                };
//                if (arr[j] > max) {
//                    max = arr[j];
//                }
//            }
            if (Math.abs(max - min) < unfairness) {
                unfairness = Math.abs(max - min);
            }
        }
        return unfairness;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

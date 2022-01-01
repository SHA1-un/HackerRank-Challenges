import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int countArray[] = {0,0,0}; // keeps count of number of positive values, negative values & Zeros
    int length = arr.size();

    for (Integer integer : arr) {
       if (integer > 0) {
        countArray[0]++;
       } else if (integer < 0) {
        countArray[1]++;
       } else {
           countArray[2]++;
       }
    }

    for (int i = 0; i < countArray.length; i++) {
        double ratio = (double)(countArray[i])/(double)(length);
        System.out.format("%.6f\n", ratio);
    }
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

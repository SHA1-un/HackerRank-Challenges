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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        String convertedTime = "";
        String[] splitTime = s.split(":");
        String timeOfDay = splitTime[2].substring(2, 4);
        
        if (timeOfDay.equals("AM")) {
            if (splitTime[0].equals("12")) {
                splitTime[0] = "00";
            }
            convertedTime = String.format("%s:%s:%s", splitTime[0], splitTime[1], splitTime[2].substring(0, 2));               
        } else {
            String convertedHour = splitTime[0];
            if (!splitTime[0].equals("12")) {
            convertedHour = "" + (Integer.parseInt(splitTime[0]) + 12) ;
            }
            convertedTime = String.format("%s:%s:%s", convertedHour, splitTime[1], splitTime[2].substring(0, 2));
        } 
        
        return convertedTime;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

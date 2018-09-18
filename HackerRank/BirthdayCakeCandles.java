/**************************************************
*
* https://www.hackerrank.com/challenges/birthday-cake-candles/problem
*
* https://www.hackerrank.com/rest/contests/master/challenges/birthday-cake-candles/hackers/inspiregates/download_solution
*
***************************************************/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int max=0;
        int maxCount=0;
        int len = ar.length;
        if(len >=1 && len <= Math.pow(10, 5)){
            for(int i=0; i < len ; i++){
                if(ar[i] >= 1 && ar[i] <= Math.pow(10, 7)){
                    if(ar[i]>max){
                        max=ar[i];
                        maxCount=1;
                    }else if(ar[i]==max){
                        maxCount++;
                    }
                }
            }
        }
        return maxCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


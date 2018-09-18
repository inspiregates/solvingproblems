/***************************************************************
*
* https://www.hackerrank.com/challenges/mini-max-sum/problem
*
* https://www.hackerrank.com/rest/contests/master/challenges/mini-max-sum/hackers/inspiregates/download_solution
*
****************************************************************/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        
        long min = 0;
        long max = 0;
        
        double upper = Math.pow(10,9);
        
        for(int i=0; i<5; i++){
            if( arr[i] > 0 && arr[i] <= upper){
                long sum=0;
                    for(int j=0; j<5; j++){
                        if( j==i) continue;
                        sum = sum + arr[j];        
                    }
                    
                    if(min==0)
                        min = sum;
                
                    if(sum < min){
                        min = sum;
                    }
                
                    if(sum > max){
                        max = sum;
                    }
                }
        }
        System.out.print(min+" "+max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

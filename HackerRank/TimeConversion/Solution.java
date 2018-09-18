/**************************************************************
*
* https://www.hackerrank.com/challenges/time-conversion/problem
*
***************************************************************/


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        //Strings to hold hh,mm,ss and AM/PM
        String hour = "";
        String min = "";
        String sec = "";
        String meridian = "";
        //Integers to hold hh,mm and ss. Required for validation of boundaries
        int hourInt,minInt,secInt;
        hourInt = minInt = secInt = 0;
        //Tokenize with :
        String[] tokenized = s.split(":");
        //Extract AM/PM based on which further manipulations will be done
        meridian = tokenized[tokenized.length-1].substring(tokenized.length-1);

        //Alternative is to extract the third token separately and then use its own length to extract the meridian as follows:
        /*****
         * meridian = tokenized[tokenized.length-1];
         * meridian = meridian.substring(meridian.length-2);
         ******/

        hour = tokenized[0];
        if(null!=hour){
            hourInt = Integer.parseInt(hour);
        }

        min = tokenized[1];
        if(null!=min){
            minInt = Integer.parseInt(min);
        }

        sec = tokenized[tokenized.length-1].substring(0,2);
        if(null!=sec){
            secInt = Integer.parseInt(sec);
        }

        //Validate every boundary here
        if(hourInt >=1 && hourInt <=12 && minInt >=0 && minInt <= 59 && secInt >=0 && secInt <=59 && null!=meridian){
            //No change in mm,ss
            //No change in hh unless it is 12
            if("AM".equals(meridian)){
                if(hourInt==12){
                    hour = "00";
                }
            }
            //Increase hour by 12 if PM
            else if("PM".equals(meridian)){
                //Change only if hour!=12
                if(hourInt != 12){
                    hourInt = hourInt + 12;
                    hour = String.valueOf(hourInt);
                }
            }
            return hour + ":" + min + ":" + sec;
        } else {
            return ("Invalid input - "+s);
        }
        
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}


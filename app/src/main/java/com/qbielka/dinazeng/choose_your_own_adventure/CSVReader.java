package com.qbielka.dinazeng.choose_your_own_adventure;

import java.util.ArrayList;

public class CSVReader {

    public static ArrayList<String> breakCSVLineIntoColumns(String CSVLine){
        ArrayList<String> arr = new ArrayList<>();

        for(int index = 0; index < CSVLine.length(); index++){
            // Escape Characters will be handled
            if(CSVLine.charAt(index) == '\\'){
                index++;
            }
            //Handling for a Quote Mark, note that this is not an escaped quote mark
            else if(CSVLine.charAt(index) == '\"'){
                // first iterate to the next character
                index++;
                // then check for the next unescaped Quote mark
                for (;index < CSVLine.length(); index++){
                    // Ensure no escaped Quote marks break out of the enclosed quotes
                    if(CSVLine.charAt(index) == '\\'){
                        index++;
                        continue;
                    }
                    //A Second Quote mark has been found
                    if(CSVLine.charAt(index) == '\"'){
                        break;
                    }
                }
            }
            // Handling a comma
            else if(CSVLine.charAt(index) == ','){
                // Cell starts with the first character and ends the character before the comma
                String cell = CSVLine.substring(0,index);
                CSVLine = CSVLine.substring(index + 1);
                // the negative 1 will roll over into 0 for the next iteration of the loop
                index = -1;
                arr.add(cell);
            }

        }
        // Handling hitting the end of input
        arr.add(CSVLine);

        // Return Statement
        return arr;
    }

}

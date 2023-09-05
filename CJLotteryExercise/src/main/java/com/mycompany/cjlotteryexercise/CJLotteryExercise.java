/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cjlotteryexercise;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author bloopykj
 */
public class CJLotteryExercise {
    
    public static void rangeCheck(int user_input) throws outofRange_Exception
    {
        // This method can throw an outofRange_Exception
        // If the user_input is below 0 or over 99, this method will throw an outofRange_Exception
        
        int maxNum = 99;
        int minNum = 0;

        if (user_input < minNum || user_input > maxNum)
        {
            throw new outofRange_Exception();
        }
    }

    public static int inputConversion(String user_input)
    {
        // Use a while loop to keep asking the user for input until the numbers are valid
        // Catch exceptions either if the number cannot be parsed, or if the number is out of range(Below 0 and over 99)
        
        int intnum;
        
        while(true)
        {
            
            try
            {
                /*
                    There are two criteria:
                        1. The user_input variable can be parsed
                        2. If it can be parsed, is it within range?
                */
                
                // Use try to parse input 1-3 into num 1-3
                // Also run range check
                // Break from loop if both these critrias are met
                
                intnum = Integer.parseInt(user_input);
                rangeCheck(intnum);
                break;
            }
            catch(NumberFormatException e)
            {
                // If the string cannot be parsed, then this code will run
                // Asks the user for input again and store it inside the user_input variable
                user_input = JOptionPane.showInputDialog(null, "This is not a valid integer. Enter a valid integer");
                    
                
            }
            catch(outofRange_Exception r)
            {
                // If the string can be parsed but the number is out of range, then this code will run
                // Asks the user for input again and stores it insude the user_input variable
                user_input = JOptionPane.showInputDialog(null, "This is out of range. Enter a valid integer between 0 and 99");
            }
        }
        return intnum;
    }
 
    
    public static int Lottery(int a, int b , int c)
    {
        // This function will randomize three numbers
        // It will loop until it generates the users numbers and display how many times it had to loop
        // It keeps a counting variable starting at 0 and will increment with each loop
        // Loop will iterate as long as there is not match between the randomized numbers and the numbers the user inputted. Use a boolean for this!!!
        // The arguments for this method, a, b, and c are the user inputted numbers
        
        int count = 0;
        int ranNum1, ranNum2, ranNum3;
        boolean no_match = true;
        Random random = new Random();
        
        while(no_match)
        {
            
            ranNum1 = random.nextInt(99);
            ranNum2 = random.nextInt(99);
            ranNum3 = random.nextInt(99);
        
            if (ranNum1 == a && ranNum2 == b && ranNum3 == c)
            {
                JOptionPane.showMessageDialog(null, "It took " + count + " tries to generate these three numbers: " + a + ", "+ b + ", " + c);
                no_match = false;
                
            } else {
            
                count++;
                    
            }

        }
        
       return count;
    }
    

    
    public static void main(String[] args){
     
        int intnum1, intnum2, intnum3;
        
        String input1 = JOptionPane.showInputDialog(null, "What do you think the 1st lottery number will be? ");
        intnum1 = inputConversion(input1);
        
        String input2 = JOptionPane.showInputDialog(null, "What do you think the 2nd lottery number will be? ");
        intnum2 = inputConversion(input2);
        
        String input3 = JOptionPane.showInputDialog(null, "What do you think the 3rd lottery number will be? ");
        intnum3 = inputConversion(input3);
        
        Lottery(intnum1, intnum2, intnum3);

    }
}

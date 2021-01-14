import java.util.Random;
import java.util.Scanner;

public class DiceRollSimulator
{

   public static void main (String[] args)
   {
      
      //This variable will be used for the dice rolls later
      Random generator = new Random();
      
      //This variable will be used to accept user input and set the number of rolls
      Scanner in = new Scanner(System.in);
      
      //This will store the number of rolls and be used in a for loop later
      int rollCount = 0;
      
      //This array will be used to tally the number of times each value is hit by the dice rolls
      //Possible dice rolls number 2-12, hence eleven  and later in the main method we will see that each Array index corresponds 
      //to a dice roll equal to its value + 2 ([0] = 2, [1] = 3, etc.)
      int[] rollArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      
      
      
      
      System.out.println("Welcome to the dice rolling simulator!");
      System.out.println("How many dice rolls would you like to simulate?");
      
      //This sets the number of times the dice will be rolled -- set by the user 
      rollCount = in.nextInt();
      
      System.out.println("Each asterisk (*) represents 1% of the total number of rolls");
      
      //This loop will run for as many iterations as the user specifies
      for (int i = 0; i < rollCount; i++)
      {
         
         //Two dice are rolled, each yielding a random value ranging 1-6
         int die1 = generator.nextInt(6) + 1;
         int die2 = generator.nextInt(6) + 1;
         
         //Here is where the tally takes place
         //The values of the two dice are added together, and then have two subtracted from the sum
         //The result is an incremented rollArray index corresponding to the value (as outlined in the Array initialization above)
         rollArray[ (die1 + die2) - 2 ]++;
         
      }
      
      //This for loop made the output statement a lot simpler to code
      //It prints one line for each value, 2-12, and crawls through each Array index value as it does so
      for (int i = 0; i < rollArray.length; i++)
      {
         
         //Begin with 'i+2' in order to print the proper sum-value of dice from above
         //Then it passes the necessary variables to the converter method (below) and prints the formatted results
         //This conditional is just so the lines are printed uniformly when the number labels switch from 1 to 2 digits
         if(i < 8)
         {
            System.out.println(" " + (i + 2) + ": " + converter(rollCount, rollArray[i]));         
         }
         else
         {
            System.out.println((i + 2) + ": " + converter(rollCount, rollArray[i]));
         }
      }
      
      
   }
   
   //This converter method takes the tallied numbers from the array in the main method and converts them into the percent-bar format required
   //Note that the ints passed into this method are initialized as doubles to make the division and for-loop function properly
   public static String converter(double rollNum, double diceValueTally)
   {
      
      String percentRolls = "";
      
      //First we find the percent-of-total for the Array index being passed through
      //We take the tally and divide it by the number of rolls (rollCount in the main method) to find the proportion
      double percent = (diceValueTally / rollNum) * 100;
      
      //Then we put it through this for loop to add on the correct amount of asterisks, each representing 1%
      //i starts at zero and is incremented by .01 (or 1%) with each loop, adding an asterisk each time until i reaches the value of the percent variable
      for(double i = 0; i < percent; i += 1 )
      {
         percentRolls = percentRolls + "*";
      }
      
      //The String is returned, and voila! We've turned our tally into a graphically-represented proportion
      return percentRolls;
   }

}
///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           French Fry cost
// Course:          cs 200
//
// Author:          Sandeep
// Email:           kapugamage@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
//NONE
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.IllegalFormatException;


/**
 * FrenchFries collects two double from the user and uses them to either
 * compute and print out number of meals that can be bought, or to print
 * out an error message when the number of meals cannot be computed
 *
 * <p>Bugs: (a list of bugs and other problems)
 * @author Debarshi Deka
 * @author (your name)
 */
public class FrenchFries {

    /**
     * computes the number of french fry meals that can be ordered with the
     * available balance of balance dollars where each meal cost costPerOrder
     * dollars.
     *
     * @param balance      Available balance of the user
     * @param costPerOrder dollar cost of a single order of French fry meal.
     * @return numMeals number of meals that can be bought if both numOrders
     * and costPerOrder are valid
     */
    public static int computeNum(double balance, double costPerOrder) {
        //
        //  TODO 1&2&3 Check if the inputs are valid and if not, throw the appropriate exception
        //
        //  TODO 4   Otherwise return the number of meals.
        if (balance == 0) {
            throw new IllegalArgumentException("You cannot order fries.");
        } else if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        } else if (costPerOrder <= 0) {
            throw new IllegalArgumentException("Fries must cost money.");
        }
        int numMeals = (int) (balance / costPerOrder);
        return numMeals;
    }

    /**
     * Collects input from the user and either computes and
     * prints out the cost of a meal, or to print out an error
     * message when the price of a valid meal cannot be computed.
     *
     * @param args unused
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // gets the available balance from user.
        System.out.println("What is your available balance?");
        while(!input.hasNextDouble() && input.hasNextLine())
        {
            input.nextLine();
        }
        double balance = input.nextDouble();

        // gets the cost of french fries from the user.
        System.out.println("How much does an order of fries cost?");
        while(!input.hasNextDouble() && input.hasNextLine())
        {
            input.nextLine();
        }
        double costPerOrder = input.nextDouble();

        // computes the number or prints an error message
        try
        {
            int numMeals = computeNum(balance, costPerOrder);
            System.out.println("You can order " + numMeals +
                    " French Fries with the given balance of $"
                    +String.format("%.2f", balance)+".");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
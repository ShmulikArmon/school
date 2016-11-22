import java.util.Scanner;

/**
 * This class will run a program that receives 3 integers that represent a date, then another integer between 1 and 10 that will indicate how many days have past from that date,
 * and will output the future date outcome.
 */
public class Dates {

    //constant values
    private static final int MIN_NUM_OF_DAYS = 1;
    private static final int MAX_NUM_OF_DAYS = 10;
    private static final int LEAP_YEAR_DIVIDER = 4;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    //begin program
    public static void main(String[] args){
        //we ask for the 3 integers from the users and take them in with a java Scanner class instance
        System.out.println("Please enter 3 integers to represent a valid date:");
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        //if the year or month is invalid we can stop the program here and avoid doing any further work.
        if( month < JANUARY || month > DECEMBER || year < 1){
            System.out.println("The original date " + day + "/" + month + "/" + year + " is invalid.");
        }
        else {
            //we initiate daysInMonth to 31 since most months have 31 days. Then with logic we see if the month is special and change daysInMonth accordingly.
            int daysInMonth = 31;
            if(month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER){
                daysInMonth = 30;
            }
            if(month == FEBRUARY){
                //if the moth is february we need to perform a special calculation to see if the year is a leap year. In leap years there is an extra day in february (leap day! yay! :) )
                if(year % LEAP_YEAR_DIVIDER == 0){
                    daysInMonth = 29;
                }
                else {
                    daysInMonth = 28;
                }
            }
            //after calculating daysInMonth, we check to see the day the user has input is correct. If it is not we stop and print out the issue.
            if(day < 1 || day > daysInMonth){
                System.out.println("The original date " + day + "/" + month + "/" + year + " is invalid.");
            }
            else {
                //if all the data the user has input is legal we proceed to take in the fourth integer - the number of days that have past.
                System.out.println("Please enter an integer to represent the number of days:");
                int num = scan.nextInt();
                //we check again if the user has input a legal integer, if not we print and stop.
                if(num < MIN_NUM_OF_DAYS || num > MAX_NUM_OF_DAYS){
                    System.out.println("The number of days must be between " + MIN_NUM_OF_DAYS + " and " + MAX_NUM_OF_DAYS + ".");
                }
                else {
                    //we print out the original date, calculate the future date considering how many days, months and years have past, and finally print out the outcome date.
                    System.out.println("The original data is " + day + "/" + month + "/" + year + ".");
                    day += num;
                    if(day > daysInMonth){
                        if(month == DECEMBER){
                            month = JANUARY;
                            year++;
                        }
                        else {
                            month++;
                        }
                        day -= daysInMonth;
                    }
                    System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
                }
            }
        }
    } // end of program
} // end of class

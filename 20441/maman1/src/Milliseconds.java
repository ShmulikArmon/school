import java.util.Scanner;

/**
 * This class will run a program that reads an integer that represents milliseconds from the user, and represent it in a days:hours:minutes:seconds
 */
public class Milliseconds {

    //constant values
    private static final long SECONDS_TO_MS = 1000;
    private static final long MINUTES_TO_MS = SECONDS_TO_MS * 60;
    private static final long HOURS_TO_MS = MINUTES_TO_MS * 60;
    private static final long DAYS_TO_MS = HOURS_TO_MS * 24;

    //begin program
    public static void main(String[] args){
        //we ask the user for an integer that represents milliseconds, then take it in with an instance of java Scanner class
        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads an integer which represents Milliseconds and converts it to days, hours, minutes and seconds. ");
        System.out.println("Please enter the number of Milliseconds");
        long ms = scan.nextLong();
        //we calculate the seconds, minutes, hours and days using modulo remainder.
        long days = ms / DAYS_TO_MS;
        long remainder = ms % DAYS_TO_MS;
        long hours = remainder / HOURS_TO_MS;
        remainder = ms % HOURS_TO_MS;
        long minutes = remainder / MINUTES_TO_MS;
        remainder = ms % MINUTES_TO_MS;
        long seconds = remainder / SECONDS_TO_MS;
        //we output the data we have calculated to the user
        System.out.println(days + " days " + hours + ":" + minutes + ":" + seconds + " hours");
    } // end of program
}

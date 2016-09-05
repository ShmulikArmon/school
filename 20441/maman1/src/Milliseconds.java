import java.util.Scanner;

public class Milliseconds {

    private static final long SECONDS_TO_MS = 1000;
    private static final long MINUTES_TO_MS = SECONDS_TO_MS * 60;
    private static final long HOURS_TO_MS = MINUTES_TO_MS * 60;
    private static final long DAYS_TO_MS = HOURS_TO_MS * 24;


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads an integer which represents Milliseconds and converts it to days, hours, minutes and seconds. ");
        System.out.println("Please enter the number of Milliseconds");
        long ms = scan.nextLong();

        long days = ms / DAYS_TO_MS;
        long remainder = ms % DAYS_TO_MS;
        long hours = remainder / HOURS_TO_MS;
        remainder = ms % HOURS_TO_MS;
        long minutes = remainder / MINUTES_TO_MS;
        remainder = ms % MINUTES_TO_MS;
        long seconds = remainder / SECONDS_TO_MS;

        System.out.println("Days - " + days);
        System.out.println("Hours - " + hours);
        System.out.println("Minutes - " + minutes);
        System.out.println("Seconds - " + seconds);
    }

}

import java.util.Scanner;

public class Dates {

    public static void main(String[] args){


        System.out.println("Please enter 3 integers to represent a valid date:");

        Scanner scan = new Scanner(System.in);

        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();

        int daysInMonth = 31;

        if(month == 4 || month == 6 || month == 9 || month == 11){
            daysInMonth = 30;
        }

        if(month == 2){
            if(year % 4 == 0){
                daysInMonth = 29;
            }
            else {
                daysInMonth = 28;
            }
        }

        System.out.println("Please enter an integer to represent the number of days:");

        int daysPast = scan.nextInt();

        if(day < 1 || day > daysInMonth || month < 1 || month > 12 || year < 1){
            System.out.println("The original data " + day + "/" + month + "/" + year + " is invalid.");
        }
        else {
            System.out.println("The original data is " + day + "/" + month + "/" + year + ".");

            day += daysPast;

            
        }
    }

}

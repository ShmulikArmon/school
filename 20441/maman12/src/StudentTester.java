
/**
 * 
 * @author Shula
 * @version (a version number or a date)
 */
public class StudentTester
{
    public static void main(String[] args)
    {
        System.out.println("Test Israel tour Constructor ");
        System.out.println("****************************");
        IsraelTour tour1 = new IsraelTour();
        System.out.println("Constructor  OK\n");
        System.out.println("Test getNoOfTrips");
        System.out.println("*****************");
        System.out.println(tour1.getNoOfTrips()+" OK\n");
        Trip trip1 = new Trip("Moshe", 2, 1, 2009, 10,1,2009, 5, 23);
        System.out.println("Test addTrip");
        System.out.println("************");
        System.out.println(tour1.addTrip(trip1)+" OK\n");
        Trip trip2 = new Trip ("Shosh", 13, 2, 2005, 29,4,2005, 6, 26); 
        tour1.addTrip(trip2);
        System.out.println("Test removeTrip");
        System.out.println("***************");
        System.out.println(tour1.removeTrip(trip2)+" OK\n");
        System.out.println("Test howManyTravellers");
        System.out.println("**********************");
        Trip trip3 = new Trip ("Shosh", 13, 2, 2005, 29,5,2005, 3, 21); 
        tour1.addTrip(trip3);
        System.out.println(tour1.howManyTravellers()+" OK\n");
        System.out.println("Test howManyTripsDeparture");
        System.out.println("**************************");
        IsraelTour tour2 = new IsraelTour(); 
        tour2.addTrip(trip1);
        tour2.addTrip(trip2);
        tour2.addTrip(trip3);
        Date originalDepartureDate = new Date(13,2,2005);
        System.out.println(tour2.howManyTripsDeparture(originalDepartureDate)+" OK\n");
        System.out.println("Test howManyCars");
        System.out.println("****************");
        System.out.println(tour2.howManyCars(originalDepartureDate)+" OK\n");
        System.out.println("Test longestTrip");
        System.out.println("****************");
        System.out.println(tour2.longestTrip()+" OK\n");
        System.out.println("Test mostPopularGuide");
        System.out.println("****************");
        System.out.println(tour2.mostPopularGuide()+" OK\n");
        System.out.println("Test earliestTrip");
        System.out.println("****************");
        System.out.println(tour2.earliestTrip()+" OK\n");
        System.out.println("Test mostExpensiveTrip");
        System.out.println("****************");
        System.out.println(tour2.mostExpensiveTrip()+" OK\n");
    }
}

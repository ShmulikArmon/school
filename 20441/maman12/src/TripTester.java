public class TripTester
{
    public static void main(String[] args) {
        System.out.println("\n********** Test Trip - Started **********");
        System.out.println("\n1. Testing Constructors and toString:");
        String s1=new String("Yossi Cohen");
        Trip trip1=new Trip(s1,1,5,2016,3,5,2016,2,40);
        System.out.println("trip1:"+trip1);
        Date d1=new Date(2,2,2016);
        Date d2=new Date(10,2,2016);
        Trip trip2=new Trip(s1,d1,d2,3,30);
        System.out.println("trip2:"+trip2);
        Trip trip3=new Trip(trip1);
        System.out.println("trip3:"+trip3);
        System.out.println("\n2. Testing accessors and mutators:");
        System.out.println("Name of guide is: " + trip1.getGuideName());
        System.out.println("No of countries to visit is: " + trip1.getNoOfCountries());
        System.out.println("No of travellers : " + trip1.getNoOfTravelers());
        System.out.println("Trip 1 departure date is: " + trip1.getDepartureDate());
        System.out.println("Trip 1 returning date is: " + trip1.getReturningDate());
        String s2=new String("Arik Levy");
        trip1.setGuideName(s2);
        trip1.setNoOfCountries(6);
        trip1.setNoOfTravellers(18);
        d1=new Date(6,11,2016);
        d2=new Date(13,11,2016);
        trip1.setReturningDate(d2);
        trip1.setDepartureDate(d1);
        System.out.println("Trip1:"+trip1);
        System.out.println("\n3. Testing equals method:");
        if(trip1.equals(trip2))
             System.out.println("Trips trip1 and trip2 are equal");
        else
              System.out.println("Trips trip1 and trip2 are not equal");
        System.out.println("\n4. Testing sameDepartureDate method:");
        if(trip1.sameDepartureDate(trip2))
             System.out.println("Trips trip1 and trip2 have the same departure date");
        else
              System.out.println ("Trips trip1 and trip2 do not have the same departure date");
        System.out.println("\n5. Testing sameReturningDate method:");
        if(trip1.sameReturningDate(trip2))
             System.out.println("Trips trip1 and trip2 have the same returning date");
         else
              System.out.println ("Trips trip1 and trip2 do not have the same returning  date");
        System.out.println("\n6. Testing overlap method:");
        if(trip1.overlap(trip2))
             System.out.println("Trips trip1 and trip2 overlap");
        else
              System.out.println ("Trips trip1 and trip2 do not overlap");
        System.out.println("\n7. Testing tripDuration method:");
        System.out.println("Trip1 duration is : " + trip1.tripDuration());

        System.out.println("\n8. Testing isLoaded method:");
        if(trip1.isLoaded())
             System.out.println("Trip1 is loaded");
        else
              System.out.println ("Trip1 isn't loaded");
        System.out.println("\n9. Testing howManyCars method:");
        System.out.println("Number of cars needed to take all travellers in trip1 is: " + trip1.howManyCars());
        System.out.println("\n10. Testing howManyWeekends method:");
//        System.out.println("Number of weekends during  trip1 are: " + trip1.howManyWeekends());
        System.out.println("\n11. Testing calculatePrice method:");
        System.out.println("The price of  trip1 is: " + trip1.calculatePrice());
        System.out.println("\n12. Testing firstWeekend method:");
//        if(trip1.firstWeekend()==null)
//           System.out.println("There is no weekend on the trip");
//        else
//           System.out.println("The first weekend of  trip1 is on : " + trip1.firstWeekend());
        System.out.println("\n********** Test Trip - Finished **********\n");

    }
}


public class Trip {

    private static final String DEFAULT_GUIDE_NAME = "NoName";
    private static final int DEFAULT_NUM_OF_COUNTRIES = 1;
    private static final int DEFAULT_NUM_OF_TRAVELERS = 10;
    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 2000;
    private static final int PRICE_PER_DAY = 250;
    private static final int PRICE_PER_COUNTRY = 100;
    private static final int PRICE_ADDITION_FOR_SAT = 100;

    private String _name;
    private int _noOfCountries;
    private Date _depDate;
    private Date _retDate;
    private int _noOfTravellers;

    /**
     * creates a new Trip object
     * @param name of the guide of the trip
     * @param noOfCountries the day of the departure date(1-31)
     * @param depDay the month of the departure date(1-12)
     * @param depMonth the year of the departure date (4 digits)
     * @param depYear the day of the return date(1-31)
     * @param retDay the month of the return date(1-12)
     * @param retMonth the year of the return date(4 digits)
     * @param retYear the number of countries to be visited in the trip(1-10)
     * @param noOfTravellers the number of travellers(1-50)
     */
    public Trip(String name, int depDay, int depMonth, int depYear,
                int retDay, int retMonth, int retYear, int noOfCountries, int noOfTravellers)
    {
        _name = name != null ? name : DEFAULT_GUIDE_NAME;
        _noOfCountries = isValidNoOfCountries(noOfCountries) ? noOfCountries : DEFAULT_NUM_OF_COUNTRIES;
        _noOfTravellers = isValidNoOfTravellers(noOfTravellers) ? noOfTravellers : DEFAULT_NUM_OF_TRAVELERS;
        _depDate = new Date(depDay,depMonth,depYear);
        _retDate = new Date(retDay,retMonth, retYear);
        if(_retDate.before(_depDate)){
            _depDate = new Date(DEFAULT_DAY,DEFAULT_MONTH,DEFAULT_YEAR);
            _retDate = new Date(DEFAULT_DAY,DEFAULT_MONTH,DEFAULT_YEAR);
        }
    }

    public Trip(String name, Date depDate, Date retDate, int noOfCountries, int noOfTravellers)
    {
        _name = name != null ? name : DEFAULT_GUIDE_NAME;
        _depDate = new Date(depDate);
        _retDate = new Date(retDate);
        _noOfCountries = isValidNoOfCountries(noOfCountries) ? noOfCountries : DEFAULT_NUM_OF_COUNTRIES;
        _noOfTravellers = isValidNoOfTravellers(noOfTravellers) ? noOfTravellers : DEFAULT_NUM_OF_TRAVELERS;
    }

    /**
     * creates a new Trip object
     * @param otherTrip trip to be copied
     */
    public Trip(Trip otherTrip)
    {
        _name = otherTrip.getGuideName();
        _noOfCountries = otherTrip.getNoOfCountries();
        _noOfTravellers = otherTrip.getNoOfTravelers();
        _depDate = new Date(otherTrip.getDepartureDate());
        _retDate = new Date(otherTrip.getReturningDate());
    }

    /**
     * sets the guide name
     * @return the value to be set
     */
    public String getGuideName()
    {
        return _name;
    }

    /**
     * gets the number of countries to be visit in the trip
     * @return the number of countries
     */
    public int getNoOfCountries()
    {
        return _noOfCountries;
    }

    /**
     * gets the trip departure date
     * @return the departure date
     */
    public Date getDepartureDate()
    {
        return _depDate;
    }

    /**
     * gets the trip return date
     * @return the return date
     */
    public Date getReturningDate()
    {
        return _retDate;
    }

    /**
     * gets the number of travellers in the trip
     * @return the number of travellers
     */
    public int getNoOfTravelers()
    {
        return _noOfTravellers;
    }

    /**
     * gets the guide name
     * @param guideName the guide name
     */
    public void setGuideName(String guideName)
    {
        if(guideName != null){
            _name = guideName;
        }
    }

    /**
     * sets the trip departure day the date will change only if the new departure date is before the return date or equal to it.
     * @param noOfCountries the value to be set.

     */
    public void setNoOfCountries(int noOfCountries)
    {
        if(isValidNoOfCountries(noOfCountries)){
            _noOfCountries = noOfCountries;
        }
    }

    /**
     * sets the trip departure day the date will change only if the new departure date is before the return date or equal to it.
     * @param departureDate the value to be set.
     */
    public void setDepartureDate(Date departureDate)
    {
        if(!departureDate.after(_retDate)){
            _depDate = departureDate;
        }
    }

    /**
     * sets the trip return date the date will change only if the new return date is after the departure date or equal to it.
     * @param returningDate the value to be set.
     */
    public void setReturningDate(Date returningDate)
    {
        if(!returningDate.before(_depDate)){
            _retDate = returningDate;
        }
    }

    /**
     * sets the number of travellers (only if valid)
     * @param noOfTravellers the value to be set
     */
    public void setNoOfTravellers(int noOfTravellers)
    {
        if(isValidNoOfTravellers(noOfTravellers)){
            _noOfTravellers = noOfTravellers;
        }
    }

    /**
     * check if 2 trips are the same
     * @param trip the trip to compare this trip to
     * @return true if the trips are the same
     */
    public boolean equals(Trip trip)
    {
        return _noOfCountries == trip.getNoOfCountries() && _noOfTravellers == trip.getNoOfTravelers()
                && _depDate.equals(trip.getDepartureDate()) && _retDate.equals(trip.getReturningDate())
                && _name.equals(trip.getGuideName());
    }

    /**
     * check if two trips have the same departure date
     * @param trip the trip to compare to
     * @return true if the two trips have the same departure date otherwise false
     */
    public boolean sameDepartureDate(Trip trip)
    {
        return _depDate.equals(trip.getDepartureDate());
    }

    /**
     * check if two trips have the same return date
     * @param trip the trip to compare this trip to
     * @return true if the two trips have the same return date otherwise false
     */
    public boolean sameReturningDate(Trip trip)
    {
        return _retDate.equals(trip.getReturningDate());
    }

    /**
     * check if two trips overlap with their dates
     * @param trip the trip to check if overlaps with this trip
     * @return true if the two trip have overlapping dates otherwise false
     */
    public boolean overlap(Trip trip)
    {
        return trip.getDepartureDate().after(_depDate) && trip.getDepartureDate().before(_retDate)
                || trip.getReturningDate().after((_depDate)) && trip.getReturningDate().before(_retDate)
                || _depDate.after(trip.getDepartureDate()) && _depDate.before(trip.getReturningDate())
                || _retDate.after(trip.getDepartureDate()) && _retDate.before(trip.getReturningDate());
    }

    /**
     * calculates the number of days of the trip
     * @return the number of days of the trip
     */
    public int tripDuration()
    {
        return _retDate.difference(_depDate);
    }

    /**
     * check if trip is loaded
     * @return true if the number of countries to visit is greater than the trip duration - else return false
     */
    public boolean isLoaded()
    {
        return tripDuration() > _noOfCountries;
    }

    /**
     * calculates the minimum number of buses needed for the trip
     * @return the number of buses needed for the trip
     */
    public int howManyCars()
    {
        int noOfCars = _noOfTravellers / 10;
        if(_noOfTravellers % 10 != 0){
            noOfCars += 1;
        }
        return noOfCars;
    }

    /**
     * calculates how many weekends occur during the trip
     * @return the number of weekends occurring during the trip
     */
    public int howManyWeekends()
    {
        //get the departure day in int representation as required in date. If it is not saturday
        //simply add to the duration of trip in days and divide by 7 (integers dividing will result in the
        //correct number). if it is saturday we add 1 more to the end result.
        int depDay = _depDate.dayInWeek();
        int result = (depDay + tripDuration()) / 7;
        if(depDay == 0){
            result++;
        }
        return result;
    }

    /**
     * calculates the date of first weekend of the trip
     * @return the date of the first weekend of the trip or null if there is no weekend on the trip
     */
    public Date firstWeekend()
    {
        if(howManyWeekends() > 0){
            int a = 7 - _depDate.dayInWeek();
            return new Date(_depDate.getDay()+a,_depDate.getMonth(),_depDate.getYear());
        } else {
            return null;
        }
    }

    /**
     * calculates total price of the trip according to days of the trip and number of countries visited
     * @return the total price of the trip
     */
    public int calculatePrice()
    {
        int price = _noOfTravellers * tripDuration() * PRICE_PER_DAY + _noOfCountries * PRICE_PER_COUNTRY +
                howManyWeekends() * PRICE_ADDITION_FOR_SAT;
        if(_depDate.getMonth() == 7 || _depDate.getMonth() == 8){
            price *= 1.2;
        }
        return price;
    }

    /**
     * return a string representation of this trip.
     * @return representation of the trip in the following format: Trip:guide name|departure date-return date|number of countries|number of travellers for example: Trip:Yossi Chen|2/3/1998|10/3/1998|5|25
     */
    @Override
    public String toString() {
        return "TRIP: " + _name + " | " + _depDate + " - " + _retDate + " | " + _noOfCountries + " | " + _noOfTravellers;
    }

    private boolean isValidNoOfCountries(int noOfCountries)
    {
        return noOfCountries > 0 && noOfCountries <= 10;
    }

    private boolean isValidNoOfTravellers(int noOfTravellers)
    {
        return noOfTravellers > 0 && noOfTravellers <= 50;
    }
}

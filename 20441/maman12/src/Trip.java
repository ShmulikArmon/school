
public class Trip {

    //nothing was permitted to add publicly, therefore we could not declare some of these constants statically and
    //publicly in Date, saving us from declaring them here as well.

    //constants
    private final String DEFAULT_GUIDE_NAME = "NoName";
    private final int DEFAULT_NUM_OF_COUNTRIES = 1;
    private final int DEFAULT_NUM_OF_TRAVELERS = 10;
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;
    private final int PRICE_PER_DAY = 250;
    private final int PRICE_PER_COUNTRY = 100;
    private final int PRICE_ADDITION_FOR_SAT = 100;
    private final int LEAP_YEAR_DIVIDER = 4;
    private final int JANUARY = 1;
    private final int FEBRUARY = 2;
    private final int APRIL = 4;
    private final int JUNE = 6;
    private final int JULY = 7;
    private final int AUGUST = 8;
    private final int SEPTEMBER = 9;
    private final int NOVEMBER = 11;
    private final int DECEMBER = 12;
    private final int DAYS_IN_WEEK = 7;

    //private variables
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
        //as required, if the departure date and return date are incorrect (return date is before departure date), we
        //create default instances of the date instead.
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
        _noOfTravellers = otherTrip.getNoOfTravellers();
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
    public int getNoOfTravellers()
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
        return _noOfCountries == trip.getNoOfCountries() && _noOfTravellers == trip.getNoOfTravellers()
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
        //if other trips dep date is in the middle of this trip
        return trip.getDepartureDate().after(_depDate) && trip.getDepartureDate().before(_retDate)
                //if the other trips return date is in the middle of this trip
                || trip.getReturningDate().after((_depDate)) && trip.getReturningDate().before(_retDate)
                //if this trips dep date is in the middle of the other one
                || _depDate.after(trip.getDepartureDate()) && _depDate.before(trip.getReturningDate())
                //if this trips return date is in the middle of the other one
                || _retDate.after(trip.getDepartureDate()) && _retDate.before(trip.getReturningDate())
                //if return or departure dates occur on same day
                || _retDate.equals(trip.getDepartureDate())
                || _retDate.equals(trip.getReturningDate())
                || _depDate.equals(trip.getReturningDate())
                || _depDate.equals(trip.getDepartureDate());
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
        //we divide the number of travellers by ten for an integer, and then if there is a remainder add another car
        //for them.
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
        //first we check if there is even a weekend to speak of, if not we return null as required.
        if(howManyWeekends() > 0){
            //we calculate the days in the departure month, since we will need to add days to the date we want
            //to confirm our date will be valid. (e.g. init a date for 34th of august)
            int daysInMonth = calcDaysInMonth(_depDate.getMonth(),_depDate.getYear());
            //calculate the day in month in which the first weekend is on
            int firstWeekedendDay = _depDate.getDay() + (DAYS_IN_WEEK - _depDate.dayInWeek());
            //see if this day is valid for this month
            if(firstWeekedendDay > daysInMonth){
                //if it isnt (which means its higher than the number of days in it) then we
                //recalculate the month and year if necessary.
                firstWeekedendDay = firstWeekedendDay -  daysInMonth;
                if(_depDate.getMonth() == DECEMBER){
                    return new Date(firstWeekedendDay,JANUARY,_depDate.getYear()+1);
                }
                else {
                    return new Date(firstWeekedendDay,_depDate.getMonth()+1,_depDate.getYear());
                }
            }
            else {
                //if the day of the date is valid we create and return a Date instance with it
                return new Date(firstWeekedendDay,_depDate.getMonth(),_depDate.getYear());
            }
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
        //we add the number of days times the price per day, then add the number of countries times the price per country,
        //and finally the number of weekends times the addition for them
        int price = tripDuration() * PRICE_PER_DAY + _noOfCountries * PRICE_PER_COUNTRY +
                howManyWeekends() * PRICE_ADDITION_FOR_SAT;
        //if the trip begins in the peak months there is an addition of 20%
        if(_depDate.getMonth() == JULY || _depDate.getMonth() == AUGUST){
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

    //we had to add the function calcDaysInMonth again since we cannot add public methods of our own and therefore cannot use this
    //directly from the Date instance in the firstWeekend method.

    /**
     * returns the number of days in a certain month.
     * @param month the month for which we want to calculate the days (months have different number of days)
     * @param year the month for which we want to calculate the days (leap years affect the number of days)
     * @return the number of days in a certain month.
     */
    private int calcDaysInMonth(int month, int year)
    {
        //if the month is one of these four, we know the number of days is 30.
        if(month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER){
            return 30;
        }
        else {
            //if the month is February, we need to check if its leap year and return days accordingly.
            if(month == FEBRUARY){
                if(year % LEAP_YEAR_DIVIDER == 0){
                    return 29;
                }
                else {
                    return 28;
                }
            }
            else {
                //if it is none of the above options, we know the number of days is 31.
                return 31;
            }
        }
    }
}

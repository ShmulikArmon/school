
public class Trip {

    private static final String DEFAULT_GUIDE_NAME = "NoName";
    private static final int DEFAULT_NUM_OF_COUNTRIES = 1;
    private static final int DEFAULT_NUM_OF_TRAVELERS = 10;
    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 2000;
    private static final int PRICE_PER_DAY = 250;
    private static final int PRICE_PER_COUNTRY = 100;

    private String _guideName;
    private int _noOfCountries;
    private Date _departureDate;
    private Date _returningDate;
    private int _noOfTravellers;


    public Trip(String guideName, int noOfCountries, int departureDay, int departureMonth, int departureYear,
                int returningDay, int returningMonth, int returningYear, int noOfTravellers)
    {
        _guideName = guideName != null ? guideName : DEFAULT_GUIDE_NAME;
        _noOfCountries = isValidNoOfCountries(noOfCountries) ? noOfCountries : DEFAULT_NUM_OF_COUNTRIES;
        _noOfTravellers = isValidNoOfTravellers(noOfTravellers) ? noOfTravellers : DEFAULT_NUM_OF_TRAVELERS;
        _departureDate = new Date(departureDay,departureMonth,departureYear);
        _returningDate = new Date(returningDay,returningMonth, returningYear);
        if(_returningDate.before(_departureDate)){
            _departureDate = new Date(DEFAULT_DAY,DEFAULT_MONTH,DEFAULT_YEAR);
            _returningDate = new Date(DEFAULT_DAY,DEFAULT_MONTH,DEFAULT_YEAR);
        }
    }

    public Trip(Trip trip)
    {
        _guideName = trip.getGuideName();
        _noOfCountries = trip.getNoOfCountries();
        _noOfTravellers = trip.getNoOfTravelers();
        _departureDate = new Date(trip.getDepartureDate());
        _returningDate = new Date(trip.getReturningDate());
    }

    public String getGuideName()
    {
        return _guideName;
    }

    public int getNoOfCountries()
    {
        return _noOfCountries;
    }

    public Date getDepartureDate()
    {
        return _departureDate;
    }

    public Date getReturningDate()
    {
        return _returningDate;
    }

    public int getNoOfTravelers()
    {
        return _noOfTravellers;
    }

    public void setGuideName(String guideName)
    {
        if(guideName != null){
            _guideName = guideName;
        }
    }

    public void setNoOfCountries(int noOfCountries)
    {
        if(isValidNoOfCountries(noOfCountries)){
            _noOfCountries = noOfCountries;
        }
    }

    public void setDepartureDate(Date departureDate)
    {
        if(!departureDate.after(_returningDate)){
            _departureDate = departureDate;
        }
    }

    public void setReturningDate(Date returningDate)
    {
        if(!returningDate.before(_departureDate)){
            _returningDate = returningDate;
        }
    }

    public void setNoOfTravellers(int noOfTravellers)
    {
        if(isValidNoOfTravellers(noOfTravellers)){
            _noOfTravellers = noOfTravellers;
        }
    }

    public boolean equals(Trip trip)
    {
        return _noOfCountries == trip.getNoOfCountries() && _noOfTravellers == trip.getNoOfTravelers()
                && _departureDate.equals(trip.getDepartureDate()) && _returningDate.equals(trip.getReturningDate())
                && _guideName.equals(trip.getGuideName());
    }

    public boolean sameDepartureDate(Date date)
    {
        return _departureDate.equals(date);
    }

    public boolean sameReturningDate(Date date)
    {
        return _returningDate.equals(date);
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

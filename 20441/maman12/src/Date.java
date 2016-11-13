/**
 * This class represents a date - a day, month and year.
 */
public class Date {

    //constant values
    private static final int LEAP_YEAR_DIVIDER = 4;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    private static final int DEFAULT_YEAR = 2000;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_DAY = 1;
    private static final int MIN_NUM_OF_DAYS = 1;
    private static final int MIN_YEAR = 1000;
    private static final int MAX_YEAR = 9999;

    //private variables
    private int _day;
    private int _month;
    private int _year;

    /**
     * takes in a day, month and year. If the date input is not valid, the default values are set.
     * @param day the day of the date. default value is 1
     * @param month the moth of the date. default value is 1
     * @param year the year of the date. default value is 2000
     */
    public Date(int day, int month, int year)
    {
        if(isValidDate(day,month,year)){
            _day = day;
            _month = month;
            _year = year;
        }
        else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    }

    /**
     *  copies an existing instance of Date.
     * @param date the date that should be copied
     */
    public Date(Date date)
    {
        _day = date.getDay();
        _month = date.getMonth();
        _year = date.getYear();
    }

    /**
     * returns the day of the date.
     * @return the day of the date.
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * returns the month of the date.
     * @return the month of the date.
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * returns the year of the date.
     * @return the year of the date.
     */
    public int getYear()
    {
        return _year;
    }

    /**
     * sets the day of the date. if day is not valid, former value is kept.
     * @param day the day of the date. between 1 and the number of days in that month.
     */
    public void setDay(int day)
    {
        if(isValidDate(day,_month,_year)){
            _day = day;
        }
    }

    /**
     * sets the month of the date. if month is not valid, former value is kept.
     * @param month the month of the date. between 1 and 12.
     */
    public void setMonth(int month)
    {
        if(isValidDate(_day,month,_year)){
            _month = month;
        }
    }

    /**
     * sets the year of the date. if year is not valid, former value is kept.
     * @param year the year of the date. between 1000 and 9999.
     */
    public void setYear(int year)
    {
        if(isValidDate(_day,_month,year)){
            _year = year;
        }
    }

    /**
     * returns true if this instance of Date to the give instance.
     * @param date the instance of Date to compare to.
     * @return true if this instance of Date to the give instance.
     */
    public boolean equals(Date date)
    {
        return date.getYear() == _year && date.getMonth() == _month && date.getDay() == date._day;
    }

    /**
     * returns true the given date is before this instance.
     * @param date
     * @return
     */
    public boolean before(Date date)
    {
        return date.getYear() < _year || date.getMonth() < _month || date.getDay() < _day;
    }

    public boolean after(Date date)
    {
        return !before(date) && !equals(date);
    }

    public int difference(Date date){
        int diff = calculateDate(_day,_month,_year) - calculateDate(date.getDay(),date.getMonth(),date.getYear());
        if(diff < 0){
            diff *= -1;
        }
        return diff;
    }

    @Override
    public String toString() {
        return _day + " / " + _month + " / " + _year;
    }

    private boolean isValidDate(int day, int month, int year)
    {
        return year >= MIN_YEAR && year <= MAX_YEAR && month >= JANUARY && month <= DECEMBER && day >= MIN_NUM_OF_DAYS && day <= calcDaysInMonth(month,year);
    }

    private int calcDaysInMonth(int month, int year)
    {
        int daysInMonth = 31;
        if(month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER){
            daysInMonth = 30;
        }
        if(month == FEBRUARY){
            if(year % LEAP_YEAR_DIVIDER == 0){
                daysInMonth = 29;
            }
            else {
                daysInMonth = 28;
            }
        }
        return daysInMonth;
    }

    private int calculateDate(int day, int month, int year)
    {
        if(month < MARCH){
            year--;
            month = month+12;
        }
        return 365*year+year/4-year/100+year/400+((month+1)*306)/10+(day-62);

    }
}

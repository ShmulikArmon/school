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
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day the day in the month(1-31)
     * @param month the month in the year(1-12)
     * @param year the year ( 4 digits)
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
     *  copy constructor
     * @param date the date that should be copied
     */
    public Date(Date date)
    {
        _day = date.getDay();
        _month = date.getMonth();
        _year = date.getYear();
    }

    /**
     * gets the Day
     * @return the day
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * gets the month
     * @return the month
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * gets the year
     * @return the year
     */
    public int getYear()
    {
        return _year;
    }

    /**
     * sets the day (only if date remains valid)
     * @param day the day value to be set
     */
    public void setDay(int day)
    {
        if(isValidDate(day,_month,_year)){
            _day = day;
        }
    }

    /**
     * set the month (only if date remains valid)
     * @param month the month value to be set
     */
    public void setMonth(int month)
    {
        if(isValidDate(_day,month,_year)){
            _month = month;
        }
    }

    /**
     * sets the year (only if date remains valid)
     * @param year the year value to be set
     */
    public void setYear(int year)
    {
        if(isValidDate(_day,_month,year)){
            _year = year;
        }
    }

    /**
     * check if 2 dates are the same
     * @param date the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date date)
    {
        return date.getYear() == _year && date.getMonth() == _month && date.getDay() == date._day;
    }

    /**
     * check if this date is before other date
     * @param date the date to compare to.
     * @return true if this date is before other date
     */
    public boolean before(Date date)
    {
        return date.getYear() < _year || date.getMonth() < _month || date.getDay() < _day;
    }

    /**
     * check if this date is after other date
     * @param date the date to compare to.
     * @return if this date is after other date
     */
    public boolean after(Date date)
    {
        return !before(date) && !equals(date);
    }

    /**
     * calculates the difference in days between two dates
     * @param date the date to calculate the difference between
     * @return the number of days between the dates
     */
    public int difference(Date date){
        int diff = calculateDate(_day,_month,_year) - calculateDate(date.getDay(),date.getMonth(),date.getYear());
        if(diff < 0){
            diff *= -1;
        }
        return diff;
    }

    public int dayInWeek()
    {
        int m;
        if(_month < 3){
            m=_month+12;
        }
        else {
            m=_month;
        }
        int y = _year%100;
        int c = _year/100;
        return (_day + (26*(m+1))/10 + y + y/4 + c/4 - 2*c) % 7;

    }

    /**
     * returns a String that represents this date
     * @return String that represents this date in the following format: day/month/year for example: 2/3/1998
     */
    @Override
    public String toString() {
        return _day + " / " + _month + " / " + _year;
    }

    /**
     * returns true if the date given in day, month and year are valid. This is according to the definitions
     * given in the assignment.
     * @param day the day of the date to check.
     * @param month the day of the date to check.
     * @param year the day of the date to check.
     * @return true if the date given in day, month and year are valid.
     */
    private boolean isValidDate(int day, int month, int year)
    {
        return year >= MIN_YEAR && year <= MAX_YEAR && month >= JANUARY && month <= DECEMBER && day >= MIN_NUM_OF_DAYS && day <= calcDaysInMonth(month,year);
    }

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

    private int calculateDate(int day, int month, int year)
    {
        if(month < MARCH){
            year--;
            month = month+12;
        }
        return 365*year+year/4-year/100+year/400+((month+1)*306)/10+(day-62);

    }
}

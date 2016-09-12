public class Date {

    private final int DEFAULT_YEAR = 2000;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_DAY = 1;

    private int _day;
    private int _month;
    private int _year;

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

    public Date(Date date)
    {
        _day = date.getDay();
        _month = date.getMonth();
        _year = date.getYear();
    }

    public int getDay()
    {
        return _day;
    }

    public int getMonth()
    {
        return _month;
    }

    public int getYear()
    {
        return _year;
    }

    public void setDay(int day)
    {
        if(isValidDate(day,_month,_year)){
            _day = day;
        }
    }

    public void setMonth(int month)
    {
        if(isValidDate(_day,month,_year)){
            _month = month;
        }
    }

    public void setYear(int year)
    {
        if(isValidDate(_day,_month,year)){
            _year = year;
        }
    }

    public boolean equals(Date date)
    {
        return date.getYear() == _year && date.getMonth() == _month && date.getDay() == date._day;
    }

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
        return year > 0 && month > 1 && month < 12 && day > 1 && day < calcDaysInMonth(month,year);
    }

    private int calcDaysInMonth(int month, int year)
    {
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
        return daysInMonth;
    }

    private int calculateDate(int day, int month, int year)
    {
        if(month < 3){
            year--;
            month = month+12;
        }
        return 365*year+year/4-year/100+year/400+((month+1)*306)/10+(day-62);

    }
}

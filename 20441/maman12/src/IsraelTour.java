/**
 * Created by shmulprivate on 27/11/2016.
 *
 *
 */
public class IsraelTour {

    private final int MAX_TRIPS = 100;

    private Trip[] _data;
    private int _noOfTrips;

    public IsraelTour(){
        _data = new Trip[MAX_TRIPS];
        _noOfTrips = 0;
    }

    public int getNoOfTrips()
    {
        return _noOfTrips;
    }

    public boolean addTrip(Trip trip) {
        if(_noOfTrips >= 100){
            return false;
        } else {
            _data[_noOfTrips++] = trip;
            return true;
        }
    }

    public boolean removeTrip(Trip trip){

        boolean itemRemoved = false;
        for(int i = 0; i < _data.length; i++){
            if(itemRemoved){
                if(i == _data.length-1){
                    _data[i] = null;
                }
                else {
                    _data[i] = _data[i+1];
                }
            }
            else {
                if (_data[i].equals(trip)){
                    itemRemoved = true;
                    _data[i] = _data[i+1];
                }
            }
        }
        return itemRemoved;
    }

    public int howManyTravellers()
    {
        int total = 0;
        for(int i = 0; i <= _noOfTrips; i++){
            total += _data[i].getNoOfTravelers();
        }
        return total;
    }

    public int howManyTripsDeparture(Date date)
    {
        int total = 0;
        for(int i = 0; i <= _noOfTrips; i++){
            if(_data[i].getDepartureDate().equals(date)) {
                total ++;
            }
        }
        return total;
    }

    public int howManyCars(Date date)
    {
        int total = 0;
        for(int i = 0; i <= _noOfTrips; i++){
            if(_data[i].getDepartureDate().equals(date)) {
                total += _data[i].howManyCars();
            }
        }
        return total;
    }

    public Trip longestTrip()
    {
        Trip result = _data[0];
        for(int i = 1; i <= _noOfTrips; i++){
            if (_data[i].tripDuration() > _data[i-1].tripDuration()){
                result = _data[i];
            }
        }
        return result;
    }

    public String mostPopularGuide()
    {
        String[] guideNames = new String[_noOfTrips];
        int[] guideCounts = new int[_noOfTrips];
        for(int i = 0; i < _noOfTrips;i++){
            String currentName = _data[i].getGuideName();
            for(int j = 0; j < guideNames.length; j++){
                if(_data[i].getGuideName().equals(currentName)){

                }
            }
        }
        return null;
    }

    public Trip earliestTrip()
    {
        int index = 0;
        Date date = _data[0].getDepartureDate();
        for(int i = 1; i < _noOfTrips; i++){
            if(_data[i].getDepartureDate().before(date)){
                date = _data[i].getDepartureDate();
                index = i;
            }
        }
        return _data[index];
    }

    public Trip mostExpensiveTrip()
    {
        int index = 0;
        int price = _data[0].calculatePrice();
        for(int i = 1; i < _noOfTrips; i++){
            int currentPrice = _data[i].calculatePrice();
            if(currentPrice < price){
                price = currentPrice;
                index = i;
            }
        }
        return _data[index];
    }
}

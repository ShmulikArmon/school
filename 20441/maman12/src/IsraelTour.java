/**
 * Represent a touristic agency that manages trips in Israel.
 */
public class IsraelTour {

    private final int MAX_TRIPS = 100;

    private Trip[] _data;
    private int _noOfTrips;

    /**
     * Create an instance of IsraelTour
     */
    public IsraelTour(){
        _data = new Trip[MAX_TRIPS];
        _noOfTrips = 0;
    }

    /**
     * Returns the number of trips
     * @return the number of trips
     */
    public int getNoOfTrips()
    {
        return _noOfTrips;
    }

    /**
     * Add a trip to the tour
     * @param trip the trip to add
     * @return true if the trip was added (if the tour hasn't reached the maximum number of trips), false if it wasn't
     */
    public boolean addTrip(Trip trip) {
        if(_noOfTrips >= 100){
            return false;
        } else {
            _noOfTrips++;
            _data[_noOfTrips-1] = trip;
            return true;
        }
    }

    /**
     * Removes the trip that is given from the trip array
     * @param trip the trip to remove
     * @return true if the trip was found and removed, false if the trip was not found.
     */
    public boolean removeTrip(Trip trip){

        boolean itemRemoved = false;
        if(_noOfTrips > 0){
            for(int i = 0; i < _data.length; i++){
                //if we have reached a null value we should break the loop since we know there could not be anymore non-null values.
                if(_data[i] == null){
                    break;
                }
                //when item is removed we realign the array
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
                        _noOfTrips--;
                        _data[i] = _data[i+1];
                    }
                }
            }
        }
        return itemRemoved;
    }

    /**
     * Returns the total number of travellers for all the trips in this instance
     * @return the total number of travellers for all the trips in this instance
     */
    public int howManyTravellers()
    {
        int total = 0;
        if(_noOfTrips > 0){
            for(int i = 0; i < _noOfTrips; i++){
                total += _data[i].getNoOfTravellers();
            }
        }
        return total;
    }

    /**
     * Returns the number of trips that depart in the date given
     * @param date the departure date to count for
     * @return the number of trips that depart in the date given
     */
    public int howManyTripsDeparture(Date date)
    {
        int total = 0;
        if(_noOfTrips > 0){
            for(int i = 0; i < _noOfTrips; i++){
                if(_data[i].getDepartureDate().equals(date)) {
                    total ++;
                }
            }
        }
        return total;
    }

    /**
     * Returns the number of cars are needed for trips that depart on the given date
     * @param date the departure date
     * @return the number of cars are needed for trips that depart on the given date
     */
    public int howManyCars(Date date)
    {
        int total = 0;
        if(_noOfTrips > 0){
            for(int i = 0; i < _noOfTrips; i++){
                if(_data[i].getDepartureDate().equals(date)) {
                    total += _data[i].howManyCars();
                }
            }
        }
        return total;
    }

    /**
     * Returns the longest trip
     * @return the longest trip
     */
    public Trip longestTrip()
    {
        if(_noOfTrips > 0){
            Trip result = _data[0];
            for(int i = 1; i < _noOfTrips; i++){
                if (_data[i].tripDuration() > _data[i-1].tripDuration()){
                    result = _data[i];
                }
            }
            return new Trip(result);
        }
        return null;
    }

    /**
     * Returns the name of the guide who appears most in all the trips
     * @return the name of the guide who appears most in all the trips
     */
    public String mostPopularGuide()
    {
        //to save some work, we can save the already checked agent and cross check to stop the loop in case the name was
        //already counted.
        String[] agentsCounted = new String[MAX_TRIPS];
        int agentCounterIndex = 0;
        //if there are no trips then there is no point to search
        if(_noOfTrips > 0){
            //with nested loops, we go over each trip in the array and then go over the entire array again to count
            //if the count is higher than the highest saved count (starts at 0), then it will now be the highest count
            //and the agent name is saved. The last agent name saved is the highest counted one and therefore the most
            //popular one.
            int highestCount = 0;
            String popularName = null;
            for(int i = 0; i < _noOfTrips;i++){
                int tempCount = 0;
                String currentName = _data[i].getGuideName();
                if(agentsCounted.length > 0 && agentCounted(agentsCounted,currentName)){
                    continue;
                }
                agentsCounted[agentCounterIndex++] = currentName;
                for(int j  = 0; j < _noOfTrips; j++){
                    if(j != i && currentName.equals(_data[j].getGuideName())){
                        tempCount++;
                    }
                }
                if(tempCount > highestCount){
                    popularName = currentName;
                    highestCount = tempCount;
                }
            }
            return popularName;
        }
        return "";
    }

    /**
     * check if a name of an agent appears in an array of names
     * @param agentList the array of agent names
     * @param agentName the name to look for
     * @return true if name exists, false it does not
     */
    private boolean agentCounted(String[] agentList, String agentName)
    {
        for(int i = 0; i < agentList.length; i++){
            if(agentList[i] != null && agentList[i].equals(agentName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the trip with the earliest departure date
     * @return the trip with the earliest departure date
     */
    public Trip earliestTrip()
    {
        if(_noOfTrips > 0){
            int index = 0;
            Date date = _data[0].getDepartureDate();
            for(int i = 1; i < _noOfTrips; i++){
                if(_data[i].getDepartureDate().before(date)){
                    date = _data[i].getDepartureDate();
                    index = i;
                }
            }
            return new Trip(_data[index]);
        }
        return null;
    }

    /**
     * Returns the most expensive trip
     * @return the most expensive trip
     */
    public Trip mostExpensiveTrip()
    {
        if(_noOfTrips > 0){
            int index = 0;
            int price = _data[0].calculatePrice();
            for(int i = 1; i < _noOfTrips; i++){
                int currentPrice = _data[i].calculatePrice();
                if(currentPrice < price){
                    price = currentPrice;
                    index = i;
                }
            }
            return new Trip(_data[index]);
        }
        return null;
    }
}

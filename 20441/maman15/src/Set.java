/**
 * Represents a set of uneven, positive integers.
 */
public class Set {

    private IntNode _head;
    private int _numOfElements;

    /**
     * Returns true if a number is positive and uneven
     * @param num the number to check
     * @return true if a number is positive and uneven
     */
    private boolean isUnevenAndPositive(int num)
    {
        return num > 0 && num % 2 != 0;
    }

    /**
     * Returns true if set is empty (Complexity time - O(1), space - O(1))
     * @return true if set is empty
     */
    public boolean isEmpty()
    {
        return _head == null;
    }

    /**
     * Return the number of elements in the set (Complexity time - O(1), space - O(1))
     * @return the number of elements in the set
     */
    public int numOfElements()
    {
        return _numOfElements;
    }

    /**
     * Returns true if this set equals the given set (Complexity time - O(N), space - O(1))
     * @param other the set that should be compared to
     * @return true if this set equals the given set
     */
    public boolean equals(Set other){
        //check if we even need to continue, or we can already return false at this point
        if(other == null || _numOfElements != other.numOfElements()){
            return false;
        }
        //go through both lists, each time advancing to next element in both (we have already confirmed they have the
        //same number of elements). If at any point the values are different between them, return false. If we got to
        //the end of both lists, return true.
        IntNode curr = _head;
        IntNode otherCurr = other._head;
        while(curr != null){
            if(curr.getValue() != otherCurr.getValue()){
                return false;
            }
            else {
                curr = curr.getNext();
                otherCurr = otherCurr.getNext();
            }
        }
        return true;
    }

    /**
     * returns true if the given integer is a member in the set (Complexity time - O(N), space - O(1))
     * @param num the integer to check against the set
     * @return true if the given integer is a member in the set
     */
    public boolean isMember(int num)
    {
        //check if number is uneven and positive, if its not, there is no point to continue
        if(isUnevenAndPositive(num)){
            //go through the list, if the number is higher than the current node, there is no point to continue since
            //the list is created ordered. if we get to the end of the list, we also return false. If at any point we
            //get the value that equals num we return true.
            IntNode curr = _head;
            while (curr != null){
                if(curr.getValue() > num){
                    return false;
                }
                else if(curr.getValue() == num){
                    return true;
                }
                curr = curr.getNext();
            }
        }
        return false;
    }

    /**
     * returns true if the given set is a subset of the set (Complexity time - O(N), space - O(1))
     * @param other the given set to test against
     * @return true if the given set is a subset of the set
     */
    public boolean subSet(Set other)
    {
        IntNode curr = _head;
        IntNode otherCurr = other._head;
        while (curr != null){
            if(otherCurr.getValue() == curr.getValue()){
                otherCurr = otherCurr.getNext();
            }
            if(otherCurr == null){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    /**
     * adds an element to the set. It will only be added if its a positive, uneven integer. (Complexity time - O(N), space - O(1))
     * @param x the number to add to the set
     */
    public void addToSet(int x)
    {
        //check if number is uneven and positive, if its not, there is no point to continue
        if(isUnevenAndPositive(x)){
            //each time we add a number to the set, we go through the list, we look for the correct place in the list,
            //so when it is added it will be ordered. each time we add an element, we count one element
            if(_head == null){
                //if head is null we need to create it first
                _head = new IntNode(x,null);
                _numOfElements++;
            }
            else {
                IntNode curr = _head;
                while(curr.getNext() != null){
                    if(x == curr.getValue()){
                        //if we got to the same number in the set, we can stop looking and return (the element is already
                        //there so we dont need to add it or the element count)
                        return;
                    }
                    if(x > curr.getValue() && curr.getNext().getValue() > x){
                        IntNode nextNode = curr.getNext();
                        curr.setNext(new IntNode(x,nextNode));
                        _numOfElements++;
                        return;
                    }
                    curr = curr.getNext();
                }
                curr.setNext(new IntNode(x,null));
            }
        }
    }

    /**
     * removes an element from the set (Complexity time - O(N), space - O(1))
     * @param x the number to remove from the set
     */
    public void removeFromSet(int x)
    {
        //check if number is uneven and positive, if its not, there is no point to continue
        if(isUnevenAndPositive(x)){
            //we go through the list, if we hit a node thats value equals x we remove it, and patch the list so it
            //remains ordered. Also decrease the number of elements.
            IntNode curr = _head;
            if(_head.getValue() == x){
                _head = curr.getNext();
                _numOfElements--;
                return;
            }
            while(curr.getNext() != null){
                if(curr.getValue() > x){
                    return;
                }
                if(curr.getNext().getValue() == x){
                    curr.setNext(curr.getNext().getNext());
                    _numOfElements--;
                    return;
                }
                curr = curr.getNext();
            }
        }
    }

    /**
     * Returns a set which is a intersection of this set and the given set. (Complexity time - O(N), space - O(N))
     * @param other the set to intersect with the current set
     * @return a set which is a intersection of this set and the given set.
     */
    public Set intersection(Set other)
    {
        //we create a new set, go through both this set and the other set. if the values are equal, its added to the new set
        //we then crawl through the lists according to the compared values to cover all values. when we get to the end of
        //one of them we can stop, since intersection requires elements ot be in both sets.
        Set set = new Set();
        IntNode curr = _head;
        IntNode otherCurr = other._head;
        IntNode setCurr = null;
        while(curr != null && otherCurr != null){
            if(curr.getValue() == otherCurr.getValue()){
                if(setCurr == null){
                    set._head = new IntNode(curr.getValue(),null);
                    setCurr = set._head;
                }
                else {
                    setCurr.setNext(new IntNode(curr.getValue(),null));
                    setCurr = setCurr.getNext();
                }
                set._numOfElements++;
            }
            if(curr.getValue() < otherCurr.getValue()){
                curr = curr.getNext();
            }
            else {
                otherCurr = otherCurr.getNext();
            }
        }
        return set;
    }

    /**
     * Returns a union of this set with the given set (Complexity time - O(N), space - O(N))
     * @param other the set to create a union with
     * @return a union of this set with the given set
     */
    public Set union(Set other)
    {
        //we create a new set to hold the union of both this and the other set. We go through them both, crawling to cover
        //each value, making sure we dont add the same value twice, and that we add all values from both sets.
        Set set  = new Set();
        IntNode curr = _head;
        IntNode otherCurr = other._head;
        IntNode setCurr = null;
        while(curr != null && otherCurr != null){
            int val;
            if(curr.getValue() < otherCurr.getValue()){
                val = curr.getValue();
                curr = curr.getNext();
            }
            else {
                val = otherCurr.getValue();
                otherCurr = otherCurr.getNext();

            }
            if(setCurr == null){
                set._head = new IntNode(val,null);
                setCurr = set._head;
                set._numOfElements = 1;
            }
            else {
                if(setCurr.getValue() != val){
                    setCurr.setNext(new IntNode(val,null));
                    setCurr = setCurr.getNext();
                    set._numOfElements++;
                }
            }
        }
        //if we finished going through both sets, and there are elements left, we need to add them also to the union
        if(curr != null){
            while(curr != null){
                if(setCurr.getValue() != curr.getValue()){
                    setCurr.setNext(new IntNode(curr.getValue(),null));
                    setCurr = setCurr.getNext();
                    set._numOfElements++;
                }
                curr = curr.getNext();
            }
        }
        else if (otherCurr != null){
            while (otherCurr != null){
                if(setCurr.getValue() != otherCurr.getValue()){
                    setCurr.setNext(new IntNode(otherCurr.getValue(), null));
                    setCurr = setCurr.getNext();
                    set._numOfElements++;
                }
                otherCurr = otherCurr.getNext();
            }
        }
        return set;
    }

    /**
     * Returns a set which is the difference of A from B (A - B) (Complexity time - O(N), space - O(N))
     * @param other the set to created the difference against
     * @return a set which is the difference of A from B (A - B)
     */
    public Set difference(Set other)
    {
        //we create a new set to hold the difference. Here we need to only add the elements which are in A but not in B.
        Set set = new Set();
        IntNode curr = _head;
        IntNode otherCurr = other._head;
        IntNode setCurr = null;
        while(curr != null && otherCurr != null){
            //if the current value is smaller than the other value, we can safely add it to the difference since the
            //lists are always ordered.
            if(curr.getValue() < otherCurr.getValue()){
                if(setCurr == null){
                    set._head = new IntNode(curr.getValue(),null);
                    setCurr = set._head;
                }
                else {
                    setCurr.setNext(new IntNode(curr.getValue(),null));
                    setCurr = setCurr.getNext();
                }
                set._numOfElements++;
                curr = curr.getNext();
            }
            //if the values in curr and otherCurr are equal we can advance in both lists
            else if (curr.getValue() == otherCurr.getValue()){
                curr = curr.getNext();
                otherCurr = otherCurr.getNext();
            }
            else {
                otherCurr = otherCurr.getNext();
            }
        }
        //if we got to the end of the crawl and curr is not null, we need to add the remaining values. (we now for sure
        //they are not in other..)
        if(curr != null){
            while(curr != null){
                if(setCurr == null){
                    set._head = new IntNode(curr.getValue(),null);
                    setCurr = set._head;
                }
                else {
                    setCurr.setNext(new IntNode(curr.getValue(),null));
                    setCurr = setCurr.getNext();
                }
                set._numOfElements++;
                curr = curr.getNext();
            }
        }
        return set;
    }

    /**
     * returns the string format of the set (Complexity time - O(N), space - O(1))
     * @return the string format of the set
     */
    @Override
    public String toString() {
        if(_head == null){
            return "{}";
        }
        return "{"+toString(_head);
    }

    //a recursive private method to create the required string for a set
    private String toString(IntNode node)
    {
        if(node.getNext() == null){
            return node.getValue() + "}";
        }
        return node.getValue() + "," + toString(node.getNext());

    }
}

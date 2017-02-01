/**
 * Created by Shmuliks on 29-Jan-17.
 *
 *
 */
public class Set {

    private IntNode _head;
    private IntNode _tail;

    public Set()
    {

    }

    public boolean isEmpty()
    {
        return _head == null;
    }

    public int numOfElements()
    {
        if(isEmpty()){
            return 0;
        }
        return numOfElement(_head);
    }

    private int numOfElement(IntNode node)
    {
        if(node == null){
            return 0;
        }
        return 1 + numOfElement(_head.getNext());
    }

    public boolean equals(Set other){
        IntNode curr = _head;
        IntNode otherCurr = other._head;
        while(curr.getNext() != null){
            if(otherCurr == null || curr.getValue() != otherCurr.getValue()){
                return false;
            }
            else {
                curr = curr.getNext();
                otherCurr = otherCurr.getNext();
            }
        }
        return true;
    }



}

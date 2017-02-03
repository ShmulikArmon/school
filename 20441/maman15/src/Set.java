
public class Set {

    private IntNode _head;
    private IntNode _tail; //?

    private int _numOfElements; //??

    public Set()
    {

    }

    private boolean isUnevenAndPositive(int num)
    {
        return num > 0 && num % 2 != 0;
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
        while(curr != null){
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

    public boolean isMemeber(int num)
    {
        if(isUnevenAndPositive(num)){
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

    public void addToSet(int x)
    {
        if(isUnevenAndPositive(x)){
            if(_head == null){
                _head = new IntNode(x,null);
            }
            else {
                IntNode curr = _head;
                while(curr.getNext() != null){
                    if(x == curr.getValue()){
                        return;
                    }
                    if(x > curr.getValue() && curr.getNext().getValue() > x){
                        IntNode nextNode = curr.getNext();
                        curr.setNext(new IntNode(x,nextNode));
                        return;
                    }
                    curr = curr.getNext();
                }
                curr.setNext(new IntNode(x,null));
            }
        }
    }

    public void removeFromSet(int x)
    {
        if(isUnevenAndPositive(x)){
            IntNode curr = _head;
            if(_head.getValue() == x){
                _head = curr.getNext();
                return;
            }
            while(curr.getNext() != null){
                if(curr.getValue() > x){
                    return;
                }
                if(curr.getNext().getValue() == x){
                    curr.setNext(curr.getNext().getNext());
                    return;
                }
            }
        }
    }

    public Set intersection(Set other)
    {
        Set set = new Set();
        IntNode curr = _head;
        while(curr != null){
            if(other.isMemeber(curr.getValue())){
                set.addToSet(curr.getValue());
            }
            curr = curr.getNext();
        } 
        return set;
    }

    public Set union(Set other)
    {
        Set set  = new Set();
        return set;
    }

    public Set difference(Set other)
    {
        Set set = new Set();
        IntNode curr = _head;
        while(curr != null){
            if(other.isMemeber(curr.getValue())){
                set.removeFromSet(curr.getValue());
            }
            curr = curr.getNext();
        }
        return set;
    }

    @Override
    public String toString() {
        if(_head == null){
            return "{}";
        }
        return "{"+toString(_head);
    }

    private String toString(IntNode node)
    {
        if(node.getNext() == null){
            return node.getValue() + "}";
        }
        return node.getValue() + "," + toString(node.getNext());

    }

    public static void main(String[] args)
    {
        Set A = new Set();
        A.addToSet(1);
        A.addToSet(3);
        A.addToSet(7);
        A.addToSet(5);
        System.out.println("A = " + A);
        A.removeFromSet(3);
        System.out.println("A = " + A);
        A.addToSet(9);
        System.out.println("A = " + A);
        Set B = new Set();
        B.addToSet(7);
        B.addToSet(9);
        B.addToSet(23);
        System.out.println("B = " + B);
        System.out.println("A intersection B = " + A.intersection(B));



    }

}

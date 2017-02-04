
public class Set {

    private IntNode _head;
    private int _numOfElements;

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
        return _numOfElements;
    }

    public boolean equals(Set other){
        if(other == null || _numOfElements != other.numOfElements()){
            return false;
        }
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

    public boolean isMember(int num)
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
                _numOfElements++;
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
                        _numOfElements++;
                        return;
                    }
                    curr = curr.getNext();
                }
                curr.setNext(new IntNode(x,null));
                _numOfElements++;
            }
        }
    }

    public void removeFromSet(int x)
    {
        if(isUnevenAndPositive(x)){
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

    public Set intersection(Set other)
    {
        Set set = new Set();
        IntNode curr = _head;
        while(curr != null){
            if(other.isMember(curr.getValue())){
                set.addToSet(curr.getValue());
            }
            curr = curr.getNext();
        } 
        return set;
    }

    public Set union(Set other)
    {
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
        if(curr != null){
            while(curr != null){
                setCurr.setNext(new IntNode(curr.getValue(),null));
                setCurr = setCurr.getNext();
                curr = curr.getNext();
                set._numOfElements++;
            }
        }
        else if (otherCurr != null){
            while (otherCurr != null){
                setCurr.setNext(new IntNode(otherCurr.getValue(), null));
                setCurr = setCurr.getNext();
                otherCurr = otherCurr.getNext();
                set._numOfElements++;
            }
        }
        return set;
    }

    public Set difference(Set other)
    {
        Set set = new Set();
        IntNode curr = _head;
        while(curr != null){
            if(!other.isMember(curr.getValue())){
                set.addToSet(curr.getValue());
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
        System.out.println("A.numOfElements() = " + A.numOfElements());
        A.removeFromSet(3);
        System.out.println("A = " + A);
        System.out.println("A.numOfElements() = " + A.numOfElements());
        A.addToSet(9);
        System.out.println("A = " + A);
        System.out.println("A.numOfElements() = " + A.numOfElements());
        Set B = new Set();
        B.addToSet(7);
        B.addToSet(9);
        B.addToSet(23);
        System.out.println("B = " + B);
        System.out.println("B.numOfElements() = " + B.numOfElements());
        System.out.println("B.eqauls(A) = " + B.equals(A));
        System.out.println("A intersection B = " + A.intersection(B));
        System.out.println("A difference B = " + A.difference(B));
        System.out.println("A union B = " + A.union(B));
        Set C = new Set();
        C.addToSet(1);
        C.addToSet(5);
        C.addToSet(7);
        C.addToSet(9);
        System.out.println("C = " + C);
        System.out.println("C.numOfElements() = " + C.numOfElements());
        System.out.println("C.eqauls(A) = " + C.equals(A));
        C.removeFromSet(9);
        System.out.println("C = " + C);
        System.out.println("C.numOfElements() = " + C.numOfElements());
        System.out.println("C.eqauls(A) = " + C.equals(A));
        System.out.println("end.");
        return;
    }

}

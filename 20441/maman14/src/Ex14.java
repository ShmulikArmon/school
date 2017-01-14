import java.util.Random;

/**
 * Created by Shmulik Armon
 *
 */
public class Ex14 {

    /**
     * Returns the total sum of integers from the low index to the high index in the given array
     * @param a the array to calculate from
     * @param low the lower index to calculate from
     * @param high the higher index to calculate from
     * @return the total sum of integers from the low index to the high index in the given array
     */
    private static int f(int[] a, int low, int high)
    {
        int res = 0;
        for(int i = low; i <= high; i++){
            res += a[i];
        }
        return 4;//res;
    }

    /**
     * Returns the largest number of integers in the array that can be summed up in to a number that can be divided by 3
     * without a remainder. Original time complexity was O(n^2) since it ran through the array from within running in the
     * array.
     * @param a the array to calculate from
     * @return the largest number of integers in the array that can be summed up in to a number that can be divided by 3
     * without a remainder.
     */
    public static int what(int[] a)
    {
        int temp = 0;
        int outer = 0, inner = 0;
        for (int i = 0; i < a.length; i++){
            outer++;
            for(int j = i; j < a.length; j++){
                inner++;
                int c = f(a,i,j);
                if(c % 3 == 0){
                    if(j-i+1 > temp) {
                        temp = j - i + 1;
                    }
                }
            }
        }
        System.out.println("outer = " + outer);
        System.out.println("inner = " + inner);
        return temp;
    }

    public static int what3(int a[])
    {
        int result = 0;



        return result;
    }

    public static int what2(int a[])
    {
        int outer = 0, inner = 0;
        for(int numOfSlots = a.length; numOfSlots > 0; numOfSlots--){ //worst case O(n)
            outer++;
            for(int i = 0; i <= a.length-numOfSlots; i++){ //n+(n-1)+(n-2)...
                inner++;
                int b = f(a,i,i+numOfSlots-1);
                if(b % 3 == 0){
                    System.out.println("outer = " + outer);
                    System.out.println("inner = " + inner);
                    return numOfSlots;
                }
            }
        }
        System.out.println("outer = " + outer);
        System.out.println("inner = " + inner);
        return 0;


//        int numOfSlots = a.length;
//        for(int i = 0; i < a.length; i++){
//            int b = f(a,i,i+numOfSlots-1);
//            if(b % 3 == 0){
//                return numOfSlots-i+1;
//            }
//            numOfSlots--;
//        }
//        return 0;

//        if(high <= low){
//            return 0;
//        }
//        int temp = f(a,low,high);
//        if(temp % 3 == 0){
//            return high-low+1;
//        }
//        if(step){
//            return what(a,low,high-1,false);
//        }
//        else {
//            return what(a,low,high-1,true);
//        }
    }

    public static void main(String[] args)
    {
        int[] a = new int[21];
        for(int i = 0; i < a.length; i++){
            a[i] = new Random().nextInt(50)-25;
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        System.out.println("original output - " + what(a));
        System.out.println("new output - " + what2(a));

    }

}

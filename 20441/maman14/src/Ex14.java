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
        return res;
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
        int totalSum = f(a,0,a.length-1);
        for(int i = 0; i < a.length; i++){
            int tempSum = f(a,i,a.length-1);
            for(int j = a.length-1; j > i; j--){
                if(tempSum % 3 == 0){
                    System.out.println("what3 j = " + j + ", i = " + i + ", tempSum = " + tempSum);
                    return j-i+1;
                }
                tempSum -= a[j];
            }
        }
        return 0;
    }

    public static int what4(int a[])
    {
        int totalSum = f(a,0,a.length-1);
        if(totalSum % 3 == 0){
            return a.length;
        }

        for(int i = 1; i < a.length; i++){
            totalSum -= a[i];
            int tempSum = totalSum;
            int low = 0, high = a.length-1;
            boolean step = false;
            while(low <= high){
                if(step){
                    tempSum -= a[low++];
                }
                else {
                    tempSum -= a[high--];
                }
                if(tempSum % 3 == 0){
                    return high-low+1;
                }
                step = !step;
            }
        }
        return 0;
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
    }

    /**
     * Goes through the given array of integers (expecting zeros and ones, at least one zero) and marks the distance in
     * array cells of 1's to the nearest 0's
     * @param a an integer array that includes at least one zero, and is made only of 0s and 1s
     */
    public static void zeroDistance(int a[])
    {

        int begin = 0;
        int count = 0;

        for(int i = 0; i < a.length; i++){ // O(n)
            if(a[i] == 0){
                if(begin == 0 && count > 1){
                    int addition = 1;
                    for(int j = begin+1; j < i; j++){
                        a[j] += addition++;
                    }
                }
                else if(count > 2){
                    boolean isEven = (count % 2 == 0);
                    int mid = begin + (isEven ? (count/2) : (count/2)+1);
                    int addition = 1;
                    for(int j = begin+2; j < i-1; j++){
                        a[j] += addition;
                        if(j == mid){
                            if(isEven){
                                mid++;
                                isEven = false;
                            }
                            else {
                                addition--;
                            }
                        }
                        else if(j < mid) {
                            addition++;

                        }
                        else {
                            addition--;
                        }
                    }
                }
                count = 0;
                begin = i;
            }
            else {
                count++;
            }
        }

        if(count > 1){
            int addition = 1;
            for(int i = begin+2; i < a.length; i++){
                a[i] += addition++;
            }
        }
    }

    public static boolean isTrans(String s, String t)
    {
        if(s.length() == 0 || t.length() == 0){
            return false;
        }
        if(s.length() == 1){
            if(t.length() == 1) {
                if (t.charAt(0) == s.charAt(0)) {
                    return true;
                }
            }
            else if(t.charAt(0) != s.charAt(0)){
                return false;
            }
            return isTrans(s,t.substring(1));
        }

        // [a,a,b,c]
        // [a,b,c]
        if(s.charAt(0) == t.charAt(0)){
            if(t.charAt(0) == t.charAt(1)){
                if(s.charAt(0) == s.charAt(1)){
                    return isTrans(s.substring(1),t.substring(1));
                }
                else {
                    return isTrans(s,t.substring(1));
                }
            }
            else {
                if(s.charAt(0) == s.charAt(1)){
                    return false;
                }
                else {
                    return isTrans(s.substring(1),t.substring(1));
                }
            }
        }
        else {
            return false;
        }
    }

    public static void main(String[] args)
    {
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++){
            a[i] = new Random().nextInt(50)-25;
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        System.out.println("original output - " + what(a));
        System.out.println("what2 output - " + what2(a));
        System.out.println("what4 output - " + what4(a));



        int b[] = new int[] {1,1,1,0,1,1,1,1,1,0,1,1,1};
        for(int i = 0; i < b.length; i++){
            System.out.print("["+b[i]+"]");
        }
        System.out.println();
        zeroDistance(b);
        for(int i = 0; i < b.length; i++){
            System.out.print("["+b[i]+"]");
        }
        System.out.println();
        String str1 = "abbc";
        String str2 = "aabbcccccccccccccd";
        System.out.println("str1 = " + str1 + ", str2 = " + str2 + ", isTrans? " + isTrans(str1,str2));
    }

}

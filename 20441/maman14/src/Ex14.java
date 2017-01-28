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
    public static int what(int a[])
    {
        for(int numOfSlots = a.length; numOfSlots > 0; numOfSlots--){ //worst case O(n)
            for(int i = 0; i <= a.length-numOfSlots; i++){ //n+(n-1)+(n-2)...
                int b = f(a,i,i+numOfSlots-1);
                if(b % 3 == 0){
                    return numOfSlots;
                }
            }
        }
        return 0;
    }

    public static int betterWhat(int a[])
    {
        int f0 = -1, f1 = -1, f2 = -1, l0, l1, l2, d0 = -1, d1 = -1, d2 = -1, total = 0;

        for(int i = 0; i < a.length; i++){
            total += abs(a[i]);
            int totalMod = total % 3;
            switch (totalMod) {
                case 0:
                    if(f0 == -1){
                        f0 = i;
                    }
                    break;
                case 1:
                    if(f1 == -1){
                        f1 = i;
                    }
                    break;
                case 2:
                    if(f2 == -1){
                        f2 = i;
                    }
                    break;
                default:
                    System.out.println("something went wrong, mod is not in range.");
                    break;
            }
        }

        total = 0;

        for(int i = a.length-1; i >= 0; i--){
            total += abs(a[i]);
            int totalMod = total % 3;
            switch (totalMod) {
                case 0:
                    if(d0 == -1){
                        d0 = abs(i - f0);
                    }
                    break;
                case 1:
                    if(d1 == -1){
                        d1 = abs(i - f1);
                    }
                    break;
                case 2:
                    if(d2 == -1){
                        d2 = abs(i - f2);
                    }
                    break;
                default:
                    System.out.println("something went wrong, mod is not in range.");
            }
        }
        return max(d0,d1,d2);
    }

    private static int abs(int a)
    {
        return a < 0 ? -a : a;
    }

    private static int max(int a, int b, int c)
    {
        if(a > b && a > c){
            return a;
        }
        else if (b > a && b > c){
            return b;
        }
        else if (c > a && c > b) {
            return c;
        }
        return a;
    }

    /**
     * Goes through the given array of integers (expecting zeros and ones, at least one zero) and marks the distance in
     * array cells of 1's to the nearest 0's
     * time complexity - O(N)
     * @param a an integer array that includes at least one zero, and is made only of 0s and 1s
     */
    public static void zeroDistance(int a[])
    {/**
     * Goes through the given array of integers (expecting zeros and ones, at least one zero) and marks the distance in
     * array cells of 1's to the nearest 0's
     * @param a an integer array that includes at least one zero, and is made only of 0s and 1s
     */
        int counter = 1;
        int mid = -1;
        int firstZeroIndex = -1;
        boolean reachedLastZero = false;

        //we run through the array once from begin to end, counting up from 1 up until the next 0 slot, where we reset
        //the counter - we also mark the first zero index for a later calculation. (There must be one since we are guaranteed
        //one in the requirements)
        for(int i = 0; i < a.length; i++){
            if(a[i] != 0){
                a[i] = counter++;
            }
            else {
                if(firstZeroIndex == -1){
                    firstZeroIndex = i;
                }
                counter = 1;
            }
        }

        //we run through the array again, this time end to beginning. Counting again, but now only in certain conditions -
        //1. we have not reached the mid value of the counted cells (we know this because we know the highest value from
        //counting forward
        //2. we have not reached the first zero index we marked previously
        //3. we have reached the last zero in the array
        for(int i = a.length-1; i >= 0; i--){
            if(a[i] != 0){
                if (mid == -1){
                    mid = a[i] / 2;
                    if(reachedLastZero){
                        counter = 1;
                    }
                }
                if((a[i] > mid || i <= firstZeroIndex) && reachedLastZero){
                    a[i] = counter++;
                }
            }
            else {
                if(!reachedLastZero)
                    reachedLastZero = true;
                mid = -1;
            }
        }
    }


    /**
     * Returns true if the second given string is a transformation of the first given string
     * ("transformation of" - when a string contains all the originals string characters in the same order, but might
     * have random extra copies of characters inserted as well.
     * @param s the original string
     * @param t the string to test for transformation
     * @return true if t is a transformation of s, false if not.
     */
    public static boolean isTrans(String s, String t)
    {
        //if strings are null or empty, then t is a transformation of s
        if(s == null && t == null){
            return true;
        }
        if(s.length() == 0 || t.length() == 0){
            return true;
        }
        //if the length of s is 1, then we can only run through t and confirmed all characters there match the on in s
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
        //if the current character at location 0 match, we need to further investigate
        if(s.charAt(0) == t.charAt(0)){
            //if a character appears in location 0 and in location 1 of t, there might be a transformation
            if(t.charAt(0) == t.charAt(1)){
                //we check if there is a double character also in s, if so, we can move forward in both strings, if not,
                //only move forward in t
                if(s.charAt(0) == s.charAt(1)){
                    return isTrans(s.substring(1),t.substring(1));
                }
                else {
                    return isTrans(s,t.substring(1));
                }
            }
            else {
                //if the next letter in t is different than the current one, and in s they are the same, there is no
                //transformation, return false
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

    /**
     * Returns true if an array has a subsequent subarray that matches to a given pattern array.
     * To match to a pattern means that for each 0, there should be a 1 or 2 digit number,
     * for each 1 there should be a 1 digit number, and for each 2 there should be a 2 digit number.
     * @param a the given array to test for a match to the pattern
     * @param pattern the given pattern to test against
     * @return true if a has any matches to pattern, false if not.
     */
    public static boolean match(int[] a, int[] pattern)
    {
        //if one of the arrays are null there is no point to continue
        if(a == null || pattern == null){
            return false;
        }
        //also, if a is larger than pattern, it could not possibly match it
        if(a.length < pattern.length){
            return false;
        }
        //call internal recursive backtracking method match
        return match(a,pattern,0,0);
    }

    /**
     * Returns true if an array has a subsequent subarray that matches to a given pattern array.
     * To match to a pattern means that for each 0, there should be a 1 or 2 digit number,
     * for each 1 there should be a 1 digit number, and for each 2 there should be a 2 digit number.
     * @param a the given array to test for a match to the pattern
     * @param pattern the given pattern to test against
     * @param i an index for a
     * @param j and index for pattern
     * @return true if a has any matches to pattern, false if not.
     */
    private static boolean match(int[] a, int[] pattern, int i, int j)
    {
        //if we have reached the end of the pattern array, it means we continued to its end without a mismatch.
        if(j == pattern.length){
            return true;
        }
        //if we have reached the end of a, it means we could not find a sub-array to match the pattern.
        if(i == a.length){
            return false;
        }
        //if the current number in index i matches the one in j, we advance both i and j. If they did not match, we
        //advance i and pass j in its current value (we are only looking for
        //consecutive matches).
        if(matchPattern(a[i],pattern[j])){
            return match(a,pattern,i+1,j+1);
        }
        else {
            return match(a,pattern,i+1,j);
        }

    }

    /**
     * Returns true if i matches j
     * A match means - if j is 0, i is single or double digit, if j is 1 i is single digit, if j is 2 i is double digit.
     * @param i the number to check for match
     * @param j the pattern number to check for match
     * @return true if i matches j
     */
    private static boolean matchPattern(int i, int j)
    {
        if(j == 0 && i >=0 && i <= 99){
            return true;
        }
        else if (j == 1 && i >=0 && i <= 9){
            return true;
        }
        else if (j == 2 && i >= 10 && i <= 99){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args)
    {
        for(int f = 0; f < 10; f++){
            int[] a = new int[10];
            for(int i = 0; i < a.length; i++){
                a[i] = new Random().nextInt(50)-25;
                System.out.print("["+a[i]+"]");
            }
            System.out.println();
            System.out.println("what  - " + what(a));
            System.out.println("betterWhat  - " + betterWhat(a));
        }


//
//        int b[] = new int[] {1,1,1,0,1,1,1,1,1,0,1,1,1};
//        int c[] = new int[] {1,1,1,0,1,1,1,1,1,0,1,1,1};
//        for(int i = 0; i < b.length; i++){
//            System.out.print("["+b[i]+"]");
//        }
//        System.out.println();
//        zeroDistance(b);
//        for(int i = 0; i < b.length; i++){
//            System.out.print("["+b[i]+"]");
//        }
//        System.out.println();
//        String str1 = "abbc";
//        String str2 = "aabbcccccccccccccd";
//        System.out.println("str1 = " + str1 + ", str2 = " + str2 + ", isTrans? " + isTrans(str1,str2));
//        System.out.println();
//
//        int[] d = new int[5];
//        int[] pat = new int[5];
//
//        for(int i = 0; i < d.length; i++){
//            d[i] = new Random().nextInt(21);
//            pat[i] = new Random().nextInt(3);
//        }
//
//        for(int i = 0; i < d.length; i++){
//            System.out.print("["+d[i]+"]");
//        }
//        System.out.println();
//        for(int i = 0; i < pat.length; i++){
//            System.out.print("["+pat[i]+"]");
//        }
//        System.out.println();
//        System.out.println("match = " + match(d,pat));
    }

}

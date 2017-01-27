/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class TesterForStudents
{
    public static void main (String[] args)
    {
        int res, n; 
        boolean result;
        int[] a={1,2,3,4};
        
        Scanner scan=new Scanner(System.in);
        System.out.println("************************** Test what - Started ***************************");
        res=Ex14.what(a);
        System.out.println(res);
        System.out.println("************************** Test what - Finished **************************\n");

        System.out.println("******************** Test checkZeroDistance - Started ********************");
        Ex14.zeroDistance(a);
        System.out.println("******************* Test checkZeroDistance - Finished ********************\n");

        System.out.println("************************ Test isTrans - Started  ***********************");
        result=Ex14.isTrans("abbcd","aabbccdd");
        System.out.println(result); //expected true
        result=Ex14.isTrans("abbcd","abcd");
        System.out.println(result); //expected false
        System.out.println("************************ Test isTrans - Finished ***********************\n");

        System.out.println("***************** Test match - Started  ******************");
        int[] a1= {2,3,57}, a2= {1,0,2};// expected true
        result=Ex14.match(a1, a2);
        System.out.println(result);
        int[] b1= {2,3,573,4,324,35} , b2= { }; // expected true
        result=Ex14.match(b1, b2);
        System.out.println(result);
        int[] c1= {2,3} , c2= {1,0,2}; //expected false
        result=Ex14.match(c1, c2);
        System.out.println(result);
        
        System.out.println("****************** Test match - Finished *****************\n");
       
  }
}   
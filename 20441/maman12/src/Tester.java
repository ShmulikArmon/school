/**
 * Created by shmulikarmon on 31/10/16.
 *
 *
 */
public class Tester {

    public static void main(String[] args)
    {
        Date date = new Date(12,2,1985);
        System.out.println(date);
        Date date2 = new Date(date);
        System.out.println(date2);
        date.setYear(2004);
        System.out.println(date);
        System.out.println(date2);
    }
}

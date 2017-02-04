
public class Test15_Students
{
	public static void main(String[] args)
	{
		Set s1 = new Set();
		Set s2 = new Set();
		/*# constructor*/

		System.out.println(s1.numOfElements() != 0);
		s1.addToSet(1);
		System.out.println(s1.numOfElements() == 1);

		/*#isMember */
		s1 = new Set();
		System.out.println(s1.isMember(0));
		s1.addToSet(5);
		System.out.println(s1.isMember(5));

		/*# removeFromSet */
		s1 = new Set();
		s1.addToSet(5);
		System.out.println(s1);
		s1.removeFromSet(5);
		System.out.println(s1);

		/*# equals */
		s1 = new Set();
		s1.addToSet(3); s1.addToSet(5); 
		s2 = new Set();
		s2.addToSet(3); s2.addToSet(5);

		System.out.println(s1.equals(s2));

		/*# subSet */

		s1 = new Set();
		s1.addToSet(1); s1.addToSet(3); s1.addToSet(9); s1.addToSet(17);
		s2 = new Set();
		s2.addToSet(1);

		System.out.println(s1.subSet(s2)); 

		/*# intersection  */
		s1 = new Set();
		s1.addToSet(1);	s1.addToSet(3);
		s2 = new Set();
		s2.addToSet(4);	s2.addToSet(3);
		Set s3 = s1.intersection(s2);
		System.out.println(s3);



		/*# union  */
		s1 = new Set();
		s1.addToSet(1);	s1.addToSet(3);
		s2 = new Set();
		s2.addToSet(4);	s2.addToSet(3);
		s3 = s1.union(s2);
		System.out.println(s3);


		/*# difference  */
		s1 = new Set();
		s1.addToSet(1);	s1.addToSet(3);

		s2 = new Set();
		s2.addToSet(1);	s2.addToSet(7);

		s3 = s1.difference(s2);
		System.out.println(s3);
	}
}

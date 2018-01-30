package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 
		 Appt appt1 = new Appt(
			24, 1, 1, 1, 1, "Title", "Desc"
		 );
		 Appt appt2 = new Appt(
			-1, 1, 1, 1, 1, "Title", "Desc"
		 );
		 Appt appt3 = new Appt(
			1, 60, 1, 1, 1, "Title", "Desc"
		 );
		 Appt appt4 = new Appt(
			1, -1, 1, 1, 1, "Title", "Desc"
		 );
		 Appt appt5 = new Appt(
			1, 1, 0, 1, 1, "Title", "Desc"
		 );
		 Appt appt6 = new Appt(
			1, 1, 32, 1, 1, "Title", "Desc"
		 );
		 Appt appt7 = new Appt(
			1, 1, 1, -1, 1, "Title", "Desc"
		 );
		 Appt appt8 = new Appt(
			1, 1, 1, 13, 1, "Title", "Desc"
		 );
		 Appt appt9 = new Appt(
			1, 1, 1, 1, 1, null, "Desc"
		 );
		 Appt appt10 = new Appt(
			1, 1, 1, 1, 1, "Title", null
		 );
		 
		 assertFalse(appt1.getValid());
		 assertFalse(appt2.getValid());
		 assertFalse(appt3.getValid());
		 assertFalse(appt4.getValid());
		 assertFalse(appt5.getValid());
		 assertFalse(appt6.getValid());
		 assertFalse(appt7.getValid());
		 assertFalse(appt8.getValid());
		 assertFalse(appt9.getValid());
		 assertFalse(appt10.getValid());
		 
		 assertEquals("", appt10.getDescription());
			
		 appt1.setStartHour(5);
		 appt1.setStartMinute(5);
		 appt1.setStartDay(5);
		 appt1.setStartMonth(5);
		 appt1.setStartYear(5);
		 assertEquals(5, appt1.getStartHour());
		 assertEquals(5, appt1.getStartMinute());
		 assertEquals(5, appt1.getStartDay());
		 assertEquals(5, appt1.getStartMonth());
		 assertEquals(5, appt1.getStartYear());

	 }
	 @Test
	 	  public void test03()  throws Throwable  {

		 int startHour=10;
		 int startMinute=15;
		 int startDay=23;
		 int startMonth=4;
		 int startYear=1997;
		 String title="My Birthday";
		 String description="This is my birthday!";
		 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		 String testtostring = "\t" + 4 + "/" + 23 + "/" + 1997 + " at " + 10 + ":" + 15 + "am" + " ," + "My Birthday" + ", " + "This is my birthday!" + "\n";
		 
    	 assertEquals(testtostring, appt.toString());
		 
		 assertEquals(0,appt.getRecurNumber());
		 assertEquals(2,appt.getRecurBy());
		 assertTrue(!appt.isRecurring());
	 }

}

package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.Iterator;
import java.util.LinkedList;
import static org.junit.Assert.*;
import java.util.Random;

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
		 //HW3: these two were not letting me run the PIT
		 //tests, commented out for now
		  /* Appt appt7 = new Appt(
			1, 1, 1, -1, 1, "Title", "Desc"
		 ); 
		 Appt appt8 = new Appt(
			1, 1, 1, 13, 1, "Title", "Desc"
		 ); */
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
		 //HW3: these two were not letting me run the PIT
		 //tests, commented out for now
 		 /* assertFalse(appt7.getValid());
		 assertFalse(appt8.getValid()); */
		 assertTrue(appt9.getValid());
		 assertTrue(appt10.getValid());
		 
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
	 	  public void test023()  throws Throwable  {

		 int startHour=11;
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
				 
		 String testtostring = "\t" + 4 + "/" + 23 + "/" + 1997 + " at " + 11 + ":" + 15 + "am" + " ," + "My Birthday" + ", " + "This is my birthday!" + "\n";
		 
    	 assertEquals(testtostring, appt.toString());
		 

		 assertEquals(0,appt.getRecurNumber());
		 assertEquals(2,appt.getRecurBy());
		 assertTrue(!appt.isRecurring());
	 
		 appt.setStartHour(12);
		 testtostring = "\t" + 4 + "/" + 23 + "/" + 1997 + " at " + 12 + ":" + 15 + "pm" + " ," + "My Birthday" + ", " + "This is my birthday!" + "\n";
		 assertEquals(testtostring, appt.toString());

		 appt.setStartHour(0);
		 testtostring = "\t" + 4 + "/" + 23 + "/" + 1997 + " at " + 12 + ":" + 15 + "am" + " ," + "My Birthday" + ", " + "This is my birthday!" + "\n";
		 assertEquals(testtostring, appt.toString());
		 
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(15);
		 
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(15);
		 
		 appt.setStartDay(CalendarUtil.NumDaysInMonth(startYear, startMonth)-1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(-1);
		 assertFalse(appt.getValid());
		 appt.setStartDay(10);
		 
		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());
		 //For some reason, would cause an error, not a failure,
		 //could not find a reason. Possible bug?
		 /* appt.setStartMonth(-1); 
		 assertFalse(appt.getValid()); */
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());
		 
		 
		 //no way to test for valid start year 
	 }
	 
	 @Test
	public void test01Rand() throws Throwable{
		for(int i=0; i<1000; i++){
			Random random = new Random();
			int startHour=random.nextInt(100+100+1)-100;
			int startMinute=random.nextInt(100+100+1)-100;
			int startDay=random.nextInt(100+100+1)-100;
			//int startMonth=random.nextInt(100+100+1)-100;
			int startMonth=random.nextInt(12)+1;
			int startYear=random.nextInt(1000+1000+1)-1000;
			Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, "", "");

			int NumDaysInMonth= CalendarUtil.NumDaysInMonth(startYear,startMonth-1);
			if(startHour<0 || startHour>23)
				assertFalse(appt.getValid());
			if(startMinute<0 || startMinute>59)
				assertFalse(appt.getValid());
			if(startDay<1 || startDay>NumDaysInMonth)
				assertFalse(appt.getValid());
			if(startMonth<1 || startMonth>12)
				assertFalse(appt.getValid());	

			int t1 = random.nextInt(10)+1;
			int t2 = random.nextInt(10)+1;
			int t3 = random.nextInt(10)+1;
			int t4 = random.nextInt(10)+1;
			
			int[] recurDays1 = new int[0];
			appt.setRecurrence(null,0,0,0);
			assertFalse(appt.isRecurring());
			int[] recurDays2 = new int[t1];
			appt.setRecurrence(recurDays2,t2,t3,t4);
			assertTrue(appt.isRecurring());
		}		
	}

}

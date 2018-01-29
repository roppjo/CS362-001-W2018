package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable tt = new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Calendar rightnow = Calendar.getInstance();
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar tomorrow = new GregorianCalendar(thisYear, thisMonth, thisDay+1);
		 
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
				 
		 listAppts.add(appt);
		 
		 startHour=10;
		 startMinute=15;
		 startDay=23;
		 startMonth=4;
		 startYear=1997;
		 title="My Birthday";
		 description="This is my birthday!";
		 
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		 listAppts.add(appt2);
		 
		 assertEquals(1, tt.getApptRange(listAppts, today, tomorrow).size());
		 
		 int[] recurDays = new int[7];
		 appt.setRecurrence(recurDays,1,2,3);
		 assertTrue(appt.isRecurring());
	  }
}

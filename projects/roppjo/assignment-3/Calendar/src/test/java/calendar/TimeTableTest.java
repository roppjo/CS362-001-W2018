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
		 
		 assertEquals(7, appt.getRecurDays().length);
		 assertEquals(1, appt.getRecurBy());	
		 assertEquals(2, appt.getRecurIncrement());
		 assertEquals(3, appt.getRecurNumber());
		 assertTrue(appt.isRecurring());
		 
		 appt.setRecurrence(null,1,2,3);
		 assertEquals(0, appt.getRecurDays().length);
		 


	  }
	  @Test
	  public void test02()  throws Throwable  {
		 TimeTable tt = new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar begining = new GregorianCalendar(1,1,1);
		 GregorianCalendar end = new GregorianCalendar(1,1,20);
		 
		 Appt appt1 = new Appt(
			1, 1, 1, 1, 1, "Title", "Desc"
		 );
		 Appt appt2 = new Appt(
			2, 2, 2, 2, 2, "Title", "Desc"
		 );
		 Appt appt3 = new Appt(
			3, 3, 3, 3, 3, "Title", "Desc"
		 );
		 Appt appt4 = new Appt(
			-1, 4, 4, 4, 4, "Title", "Desc"
		 );
		
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt4);
		 
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt2, listAppts.get(1));
		 assertEquals(appt3, listAppts.get(2));
		 assertEquals(appt4, listAppts.get(3));
		 
		 try {
			LinkedList<Appt> permuteCal = tt.permute(listAppts, new int[]{1,2,3,4,6});
		}
		 catch (IllegalArgumentException e) {
		}
		 LinkedList<Appt> permuteDays = tt.permute(new LinkedList<Appt>(), new int[]{});
		 assertEquals(0, permuteDays.size());		
		
		 LinkedList<CalDay> days = tt.getApptRange(listAppts, begining, end);
		 assertEquals(19, days.size());
		 
		 tt.deleteAppt(listAppts, appt4);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt2, listAppts.get(1));
		 assertEquals(appt3, listAppts.get(2));
		 assertEquals(appt4, listAppts.get(3));
		 
		 tt.deleteAppt(listAppts, appt2);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
	
		 tt.deleteAppt(null, appt1);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
		 
		 tt.deleteAppt(listAppts, null);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
		 
		 tt.deleteAppt(null, null);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
		 
		 Appt appt5 = new Appt(5, 5, 5, 5, 5, "Title", "Desc");
		 appt5.setRecurrence(new int[]{}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt5);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
		 assertEquals(appt5, listAppts.get(3));
		 
		 tt.deleteAppt(listAppts, appt5);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
		 
		 tt.deleteAppt(listAppts, appt5);
		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt3, listAppts.get(1));
		 assertEquals(appt4, listAppts.get(2));
	}
}

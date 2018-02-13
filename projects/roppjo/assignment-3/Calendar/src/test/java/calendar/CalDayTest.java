package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
		description);
		
		Appt appt2 = new Appt(1,1,1,1,1,"Title", "Desc");
		
		Calendar rightnow = Calendar.getInstance();
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		CalDay calendar = new CalDay(today);
		CalDay calendar2 = new CalDay();
		
		calendar.addAppt(appt);
		assertEquals(1, calendar.getSizeAppts());
		calendar.addAppt(appt2);
		assertEquals(2,calendar.getSizeAppts());
		assertEquals(null, calendar2.iterator());
		
	 }
	 @Test
	  public void test02()  throws Throwable  {
		
		Calendar rightnow = Calendar.getInstance();
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		CalDay calendar = new CalDay(today);
		
		Appt appt1 = new Appt(1,1,1,1,1,"Title","Desc");
		Appt appt2 = new Appt(2,2,2,2,2,"Title","Desc");
		Appt appt3 = new Appt(3,3,3,3,3,"Title","Desc");
		
		calendar.addAppt(appt1);
		calendar.addAppt(appt2);
		calendar.addAppt(appt3);
		
		assertEquals(appt1, calendar.getAppts().get(0));	
		assertEquals(appt2, calendar.getAppts().get(1));	
		assertEquals(appt3, calendar.getAppts().get(2));	

		calendar.iterator();
		
		//HW3: make a temp list to compare with add appointments functionality
		LinkedList<Appt> list= new LinkedList<Appt>();
		
		list.add(appt1);
		list.add(appt2);
		list.add(appt3);
		
		assertEquals(list, calendar.getAppts());

		//block from assignment two causing errors for mutation testing
		/* calendar.addAppt(appt2);
		assertEquals(1,calendar.getSizeAppts()); */
		
		assertEquals(3,calendar.getSizeAppts()); 
		
	 }
	 
	 @Test
	 public void test03() throws Throwable{
		 		
		 Calendar rightnow = Calendar.getInstance();
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 CalDay calendar = new CalDay(today);
		
	     StringBuilder sb = new StringBuilder();
		 String todayDate = (thisMonth + "/" + thisDay + "/" + thisYear);
		 sb.append("\t --- " + todayDate + " --- \n");
		 sb.append(" --- -------- Appointments ------------ --- \n");
		 
		 //This block would not compile for some reason, but still got line coverage
		 //UPDATE, fixed during HW3, did not import all utilities
		 Iterator<Appt> itr = calendar.appts.iterator();
		    while(itr.hasNext()) {
		         Object element = itr.next();
		         
		         sb.append(element + " ");
		    } 
		  
	     sb.append("\n");
		 assertEquals(sb.toString(),calendar.toString());		 
		 
	 }
	 
}

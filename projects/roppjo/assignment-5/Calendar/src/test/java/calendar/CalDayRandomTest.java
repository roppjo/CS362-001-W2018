package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayRandomTest {
	
	@Test
	public void test01() throws Throwable{
		for(int i=0; i<1000; i++){
			Random random = new Random();
			int startHour1=random.nextInt(100)+1;
			int startMinute1=random.nextInt(100)+1;
			int startDay1=random.nextInt(100)+1;
			//int startMonth=random.nextInt(100+100+1)-100;
			int startMonth1=random.nextInt(12)+1;
			int startYear1=random.nextInt(1000+1000+1)-1000;
			Appt appt1 = new Appt(startHour1, startMinute1, startDay1, startMonth1, startYear1, "", "");
			
			int startHour2=random.nextInt(100)+1;
			int startMinute2=random.nextInt(100)+1;
			int startDay2=random.nextInt(100)+1;
			//int startMonth2=random.nextInt(100+100+1)-100;
			int startMonth2=random.nextInt(12)+1;
			int startYear2=random.nextInt(1000+1000+1)-1000;
			Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, "", "");
			
			Calendar rightnow = Calendar.getInstance();
			int thisYear = rightnow.get(Calendar.YEAR);
			int thisMonth = rightnow.get(Calendar.MONTH)+1;
			int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
			CalDay calendar = new CalDay(today);
			
			if(appt1.getValid() && appt2.getValid()){
				calendar.addAppt(appt1);
				assertEquals(1, calendar.getSizeAppts());
				calendar.addAppt(appt2);
				assertEquals(2,calendar.getSizeAppts());
			}
			else if(appt1.getValid()){
				calendar.addAppt(appt2);
				assertEquals(0, calendar.getSizeAppts());
			}
		}
	}
}

package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;
public class ApptRandomTest {
	
	@Test
	public void test01() throws Throwable{
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
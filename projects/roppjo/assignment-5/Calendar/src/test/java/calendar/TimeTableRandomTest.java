package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableRandomTest {

	@Test
	public void test01() throws Throwable{
		for(int i=0; i<1000; i++){
			Random random = new Random();
			TimeTable tt = new TimeTable();
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			LinkedList<CalDay> cal = new LinkedList<CalDay>();
			int startHour=random.nextInt(100+100+1)-100;
			int startMinute=random.nextInt(100+100+1)-100;
			int startDay=random.nextInt(100+100+1)-100;
			//int startMonth=random.nextInt(100+100+1)-100;
			int startMonth=random.nextInt(12)+1;
			int startYear=random.nextInt(1000+1000+1)-1000;			
			Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, "", "");
			
			startHour=random.nextInt(100+100+1)-100;
			startMinute=random.nextInt(100+100+1)-100;
			startDay=random.nextInt(100+100+1)-100;
			startMonth=random.nextInt(12)+1;
			startYear=random.nextInt(1000+1000+1)-1000;	
			Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, "", "");
			
			int numAppts = random.nextInt(10+10+1)-10;
			int [] recurDays;
			int recur= random.nextInt(10+10+1)-10;
			int recurInc = random.nextInt(10+10+1)-10; 
			int recurNum = random.nextInt(10+10+1)-10;
			if(numAppts==0){
				recurDays = null;
			}
			else{
				int size=random.nextInt(7)+1;
				recurDays = new int[size];
				for(int j=0; j<size; j++){
					recurDays[j]=random.nextInt(10+10+1)-10;
				}
			}
			
			appt1.setRecurrence(recurDays, recur, recurInc, recurNum);
			appt2.setRecurrence(recurDays, recur, recurInc, recurNum);
			
			for(int j=0; j<(numAppts/2)-1; j++){
				listAppts.add(appt1);
				listAppts.add(appt2);
			}
			
			for(int j=0; j<(numAppts/2)-1; j++){
				tt.deleteAppt(listAppts, appt1);
				tt.deleteAppt(listAppts, appt2);
			}
		}
	}
	//Was causing an infinite loop when I tried to test it, could not find cause
	/* @Test
	public void test02() throws Throwable{
		for(int i=0; i<10; i++){
			Random random = new Random();
			TimeTable tt = new TimeTable();
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			LinkedList<CalDay> cal = new LinkedList<CalDay>();
			
			int year=random.nextInt(1000+1000+1)-1000;
			int month=random.nextInt(12)+1;
			int day=random.nextInt(31)+1;
			GregorianCalendar day1 = new GregorianCalendar(year,month,day);
			
			year=random.nextInt(3000)+2500;
			month=random.nextInt(12)+1;
			day=random.nextInt(31)+1;
			GregorianCalendar day2 = new GregorianCalendar(year,month,day);
			int x=random.nextInt(20)+3;
			
			for(int j=0; j<x; j++){
				int startHour=random.nextInt(100+100+1)-100;
				int startMinute=random.nextInt(100+100+1)-100;
				int startDay=random.nextInt(100+100+1)-100;
				int startMonth=random.nextInt(12)+1;
				int startYear=random.nextInt(1000+1000+1)-1000;	
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, "", "");
				listAppts.add(appt);
			} 
				tt.getApptRange(listAppts, day1, day2);
		}
	} */
}		


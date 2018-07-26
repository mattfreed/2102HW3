import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake1 E2 = new Earthquake1();
  Earthquake1 E3 = new Earthquake1();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> NoDates = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    OctReports.add(new MaxHzReport(20151013.0,10.0));
    OctReports.add(new MaxHzReport(20151020.0,50.0));
  }

  @Test //test for november dates
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }
  @Test //test for october dates
  public void instructorTestEQ2() { 
    assertEquals(OctReports, 
                 E2.dailyMaxForMonth(threeDates, 10));
  }
  @Test //tests no dates are in the data set
  public void instructorTestEQ3() { 
	    assertEquals(NoDates, 
	                 E3.dailyMaxForMonth(threeDates, 12));
	  }
}
/* Subtasks:
dailyMaxForMonth needs to do the following:
	-take in a list of sensor data and a month
	-checks each piece of data to see if it is a date or not
	-if it is a date then it should check if the month part of the date is the same month as the month provided
	-cycle through the data for each day until the max value is found
    -return LinkedList<MaxHzReport>, with MaxHzReport parameters as the date and the max
*/


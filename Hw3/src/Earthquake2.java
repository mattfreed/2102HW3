import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  //Takes parameters data (which is a linkedlist of double) and month
  //loops through data
  //value of boolean is set to false initially so that no initial dates are recorded
  //if the data is a date and the month is the same as the input parameter, it sets getvalues to true, stating the data collection
  //as long as the date is the same and month is correct, a comparison between the values will happen
  //once a new date is reached, the max value is determined, get values is set to false, and the max value/date are added to reports
  //return the reports
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  LinkedList<MaxHzReport> reports = new LinkedList<>();
	  boolean getValues = false;
	  double maxValue = 0;
	  double previousDate = 0;
	  
	  for(double data2: data) {
		  if (getValues == true) {
			  if (isDate(data2)) {
				  if (extractMonth(data2)==month) {
				  getValues = false;
				  reports.add(new MaxHzReport(previousDate, maxValue));
				  }
				  else {
					  getValues = false;
				  }
			  }
			  else if (maxValue < data2) {
				  maxValue = data2;
			  }
		  }
		  if (isDate(data2)) {
			  if (extractMonth(data2)==month) {
			  getValues = true;
			  previousDate = data2;
			  }
			  maxValue = 0;
		  }
	  }
	  if (maxValue != 0) {
		  reports.add(new MaxHzReport(previousDate, maxValue));
	  }
    return reports;
  }
}
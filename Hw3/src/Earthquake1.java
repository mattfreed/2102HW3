import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
  //Takes a LinkedList<Double> of data and a month
  //checks to see if the the data is a date and the date is the same as the month.
  //If date and month is correct then cycles through the list to find this date, records the values, determines max value,
  //and stops when it hits next date. Returns LinkedList<maxHzReports>
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  LinkedList<MaxHzReport> reports = new LinkedList<>(); 
	  for(double data2:data) {
		  if (isDate(data2)) {
			  if (extractMonth(data2) == month) {
				  for(int i = 0; i<data.size();i++) {
					  int j = i+1;
					  if (data.get(i) == data2) {
						  double max = data.get(j);
						  while (isDate(data.get(j)) == false && j<(data.size()-1)) {
							  if (max<data.get(j)) {
								  max = data.get(j);
							  }
							  j=j+1;
						  }
						  reports.add(new MaxHzReport(data2, max));
					  }
					}
				 }
			  }
			  
		  }	  
   return reports;
  }
}  


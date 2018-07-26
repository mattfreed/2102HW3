
import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
  //intakes parameter LinkedList<show>
  //loops through linked list of shows, and then loops through that shows episodes to average all the times
  //adds the average time to a new list
  //loops through the averaged data, setting the relevant smoothing data to a new list and returning a list of list
  //loops through the list of lists, averaging the values inside of the list of lists 
  //sets these values to the new smoothed list 
  //returns the smoothed list
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<LinkedList<Double>> listOfList = new LinkedList<>();
	  LinkedList<Double> averagedData = new LinkedList<>();
	  LinkedList<Double> smoothed = new LinkedList<>();
	  for(Show show: shows) {
		  double runTime = 0;
		  for(Episode episode: show.episodes) {
			  runTime = runTime + episode.runTime;	  
		  }
		  double avgRunTime = runTime/(show.episodes.size());
		  averagedData.add(avgRunTime);
	  }  
	  for(int i = 0; i < averagedData.size(); i++) {
		  LinkedList<Double> addToList = new LinkedList<>();
		  if (i == 0 || (i == averagedData.size()-1)) {
			  addToList.add(averagedData.get(i));
		  }
		  else {
			  addToList.add(averagedData.get(i-1));
			  addToList.add(averagedData.get(i));
			  addToList.add(averagedData.get(i+1));
		  }
		  listOfList.add(addToList);				
	  }
	  for(LinkedList<Double> list: listOfList) {
		  double sum = 0;
		  for(double singles: list) {
			  sum = sum + singles;
		  }
		  smoothed.add(sum/(list.size()));
	  	}
	  return smoothed;
  }
}
import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  
  //method takes in a linked list of shows, runs through the shows to determine average run time per show
  //adds the average run time per show to a new linked list
  //smoothes the average run times
  //sets the smoothed data per show to a new linked list
  //returns the smoothed data list
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> averagedData = new LinkedList<>();
	  LinkedList<Double> smoothedData = new LinkedList<>();
	  
	  for(Show show: shows) {
		  double runTime = 0;
		  for(Episode episode: show.episodes) {
			  runTime = runTime + episode.runTime;	  
		  }
		  double avgRunTime = runTime/(show.episodes.size());
		  averagedData.add(avgRunTime);
	  }
	  if (averagedData.size()>0) {
		smoothedData.add(averagedData.getFirst());
		for(int i = 1; i<(averagedData.size()-1);i++) {
			smoothedData.add((averagedData.get(i)+averagedData.get(i-1)+averagedData.get(i+1))/3);			
		}
		smoothedData.add(averagedData.getLast());
	}
	  return smoothedData;
  }
}
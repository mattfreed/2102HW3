import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}

	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> cleanedList = new LinkedList<>();
		LinkedList<Show> dayTime = new LinkedList<>();
		LinkedList<Show> primeTime = new LinkedList<>();
		for(Show show: shows) {
			if (show.broadcastTime>=600 && show.broadcastTime<2300) {
				cleanedList.add(show);
			}
		}
		for (Show show2: cleanedList) {
			if (show2.broadcastTime<1700) {
				dayTime.add(show2);
			}
			else {
				primeTime.add(show2);
			}
		}
		ShowSummary organizedShows = new ShowSummary(dayTime, primeTime);
		return organizedShows;
	}
}

import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> dayTime = new LinkedList<Show>();
		LinkedList<Show> primeTime = new LinkedList<Show>();
		for(Show show: shows) {
			if (show.broadcastTime>=0600 && show.broadcastTime<1700) {
				dayTime.add(show);
			}
			else if (show.broadcastTime>=1700 && show.broadcastTime<2300) {
				primeTime.add(show);
			}
			else {
				continue;
			}
		}
		ShowSummary organizedShows = new ShowSummary(dayTime, primeTime);
		return organizedShows;

	}
}

/* creates 2 LinkedLists, 1 for daytime shows and 1 for primetime shows
 * runs through entire list of shows provided
 * if the show is equal to/greater than 6am and less than 5pm, adds show to daytime list
 * if show is equal to/greater than 5pm and less than 11pm, adds show to primetime list
 * otherwise ignores the show and continues throughout the list
 * after all shows have been analyzed, looks to see if daytime or nighttime shows have been added to the created lists
 * if yes, creates a new organizedShow Show Summary
 * else returns null
 */

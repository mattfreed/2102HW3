import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	ShowManager2 sm2 = new ShowManager2();
	ShowManager1 sm3 = new ShowManager1();
	ShowManager2 sm4 = new ShowManager2();
	ShowManager1 sm5 = new ShowManager1();
	ShowManager2 sm6 = new ShowManager2();
	ShowManager1 sm7 = new ShowManager1();
	ShowManager2 sm8 = new ShowManager2();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	ShowSummary report3 = new ShowSummary();
	ShowSummary report5 = new ShowSummary();
	ShowSummary report7 = new ShowSummary();
	LinkedList<Show> shows2 = new LinkedList<Show>();
	LinkedList<Show> shows3 = new LinkedList<Show>();
	LinkedList<Show> shows4 = new LinkedList<Show>();
	
	
	public ShowExamples()
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1);
		shows.add(s1);
		report1.primetime.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2);
		shows.add(s2);
		report1.primetime.add(s2);
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3);
		shows.add(s3);
		report1.daytime.add(s3);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4);
		shows.add(s4);
		report1.daytime.add(s4);
		
		//test 2 see if only primetimes
		LinkedList<Episode> eps5 = new LinkedList<Episode>();
		eps5.add(new Episode("Best of Both Worlds", 88));
		eps5.add(new Episode("Trials and Tribble-ations", 43));		
		Show s5 = new Show("Star Trek", 1800, eps5);
		shows2.add(s5);
		report3.primetime.add(s5);
		
		LinkedList<Episode> eps6 = new LinkedList<Episode>();
		eps6.add(new Episode("Fear of a Bot Planet", 23));
		eps6.add(new Episode("The Why of Fry", 21));
		eps6.add(new Episode("Meanwhile", 22));
		Show s6 = new Show("Futurama", 1900, eps6);
		shows2.add(s6);
		report3.primetime.add(s6);
		
		LinkedList<Episode> eps7 = new LinkedList<Episode>();
		eps7.add(new Episode("Yakko's World", 21));
		Show s7 = new Show("Animaniacs", 1700, eps7);
		shows2.add(s7);
		report3.primetime.add(s7);
		
		//test3 when no daytimes or primetimes
		
		//test 4 only daytimes
		LinkedList<Episode> eps9 = new LinkedList<Episode>();
		eps9.add(new Episode("Best of Both Worlds", 88));
		eps9.add(new Episode("Trials and Tribble-ations", 43));		
		Show s9 = new Show("Star Trek", 1100, eps9);
		shows4.add(s9);
		report7.daytime.add(s9);
		
		LinkedList<Episode> eps10 = new LinkedList<Episode>();
		eps10.add(new Episode("Fear of a Bot Planet", 23));
		eps10.add(new Episode("The Why of Fry", 21));
		eps10.add(new Episode("Meanwhile", 22));
		Show s10 = new Show("Futurama", 900, eps10);
		shows4.add(s10);
		report7.daytime.add(s10);
		
		LinkedList<Episode> eps11 = new LinkedList<Episode>();
		eps11.add(new Episode("Yakko's World", 21));
		Show s11 = new Show("Animaniacs", 700, eps11);
		shows4.add(s11);
		report7.daytime.add(s11);
		
	}
	
	@Test //Test 1 regular test, all times
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	/*@Test
	public void instructorTestOrganizeShows2() 
	{
		ShowSummary report2 = sm2.organizeShows(shows);
		assertEquals(report1, report2);
	}
	*/
	
	@Test //Test2 only prime times
	public void instructorTestOrganizeShows3() 
	{
		ShowSummary report4 = sm3.organizeShows(shows2);
		assertEquals(report3, report4);
	}
	/*@Test 
	public void instructorTestOrganizeShows4() 
	{
		ShowSummary report4 = sm4.organizeShows(shows2);
		assertEquals(report3, report4);
	}
	*/
	@Test //test3 no primetimes or daytimes
	public void instructorTestOrganizeShows5() 
	{
		ShowSummary report6 = sm5.organizeShows(shows3);
		assertEquals(report5, report6);
	}
	/*@Test
	public void instructorTestOrganizeShows6() 
	{
		ShowSummary report6 = sm6.organizeShows(shows3);
		assertEquals(report5, report6);
	}
	*/
	@Test //test4 only day times
	public void instructorTestOrganizeShows7() 
	{
		ShowSummary report8 = sm7.organizeShows(shows4);
		assertEquals(report7, report8);
	}
	/*@Test
	public void instructorTestOrganizeShows8() 
	{
		ShowSummary report8 = sm8.organizeShows(shows4);
		assertEquals(report7, report8);
	}
	*/
}	
/* Subtasks:
organizeShows needs to do the following:
	-check which shows, in the provided list of shows, are daytime shows(have a start time at or after 6:00 am and before 5:00 pm)
	-check which shows, in the provided list of shows, are primetime shows(Primetime shows have a start time at or after 5:00 pm and before 11:00 pm)
	-store the shows that are daytime and the shows that are primetime into new daytime and primetime lists
	-create a  ShowSummary that has the parameters of lists of the daytime and primetime shows
	-return the report
*/
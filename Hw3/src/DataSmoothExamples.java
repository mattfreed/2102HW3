//Matt Freed and Dillon Arnold
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Show> shows2 = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  LinkedList<Double> showResults2 = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth2 D2 = new DataSmooth2();
  DataSmooth1 D3 = new DataSmooth1();
  DataSmooth2 D4 = new DataSmooth2();
  
  public DataSmoothExamples() 
  {
	  	//Test 1
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4));

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);
	    
	    //Test 2 no middle numbers
	    LinkedList<Episode> eps5 = new LinkedList<Episode>();
		eps5.add(new Episode("Yakko's World", 4));
		eps5.add(new Episode("Hello Nice Warners", 8));
		eps5.add(new Episode("Where Rodents Dare", 9));
		shows2.add(new Show("Animaniacs", 1630, eps5));
		
		LinkedList<Episode> eps6 = new LinkedList<Episode>();
		eps6.add(new Episode("The Letter W", 59));
		eps6.add(new Episode("The Letter P", 57));
		eps6.add(new Episode("The Letter I", 58));
		shows2.add(new Show("Sesame Street", 900, eps6));

	    showResults2.add(7.0);
	    showResults2.add(58.0);
  }
  
  // test1 given example
  @Test 
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
  /*@Test   //tests method 2
  public void instructorTestDS2() 
  {
	  LinkedList<Double> runtimes = D2.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }
  */
  // tests when there are no middle numbers, only first and last
  @Test 
  public void instructorTestDS3() 
  {
	  LinkedList<Double> runtimes = D3.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults2.get(i), .01);
	  }
  }
  /*@Test //tests method 2
  public void instructorTestDS4() 
  {
	  LinkedList<Double> runtimes = D4.dataSmooth(shows2);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults2.get(i), .01);
	  }
  }
  */
}
/* Subtasks:
dataSmooth needs to do the following:
	-take in a list of shows
	-take the episodes from each show and average their runtimes
	-take the runtimes and smooth the data
	-return the modified smooth list
*/

 
public class CD {

	private String artist; // artist
	private String title; // titel
	
	/** Skapar en cd med artisten artist och titeln title */
	public CD(String artist, String title) {
	this.artist = artist;
	this.title = title;
	}
	/** Returnerar namnet p� artisten */
	 public String getArtist() {
	 return artist;
	 }
	 /** Returnerar titeln */
	 public String getTitle() {
	 return title;
	 }
	/** Returnerar en str�ng som best�r av skivans artist och titel */
	 public String toString() {
	 return artist + "    \t" + title; 
	 }
	 

}

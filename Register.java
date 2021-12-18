import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import javax.lang.model.util.Elements;
import javax.swing.text.html.parser.Element;

public class Register {

	private ArrayList<CD> reg; // registret skall lagras i en ArrayList
	Dialog D= new Dialog();

	//skapa en tomm reg
	public Register() {
		reg= new ArrayList<CD>();
	}

	public ArrayList<CD> getList() {//retrun the Arraylist
		return reg;
	}
	
	public void add (String artist, String tittel) {

		reg.add(new CD(artist, tittel));
		sorteraArt();
	}

	//... Konstruktor och alla metoderna för registerhanteringen
	/** Läser registret från filen med namn fileName. */
	public void readFromFile(String fileName) {
		//... Se ledning för filhanteringen sist i uppgiften
		Scanner scan = null; 
		try { 
			scan = new Scanner(new File(fileName)); 
		}
		catch (FileNotFoundException e) { 
			System.err.println("Filen kunde inte öppnas"); 
			System.exit(1); 
		}
		
		
		while(scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();
            reg.add(new CD ( a,b));

		}
		scan.close();

	}


	/** Sparar registret på fil med namnet fileName. */
	public void writeToFile(String fileName) {
		//... Se ledning för filhanteringen sist i uppgiften
	
//		String Artist;
//		String view="";
//		String Tittle;
//		for(int i=0; i<reg.size();i++) {
//			Artist= reg.get(i).getArtist();
//			Tittle=reg.get(i).getTitle();
//			view=view+ Artist+"  "+Tittle;
//		}
	
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File (fileName));
		}
		catch (FileNotFoundException e) { 
			System.err.println("Filen kunde inte öppnasi"); 
			System.exit(1); 
			}
		String Artist;
        StringBuilder view = new StringBuilder();
        String Title;
        for(int i=0; i<reg.size();i++) {
            Artist= reg.get(i).getArtist();
            Title=reg.get(i).getTitle();
            view.append(Artist);
            view.append("\n");
            view.append(Title);
            view.append("\n");
        }
        System.out.print(view.toString());

        //            out.write(D.printString(sb.toString()));
        out.write(view.toString());
        out.close();


	}
	
	
	
	//	ny metod for att ta bort namnet
	public void remove(String s) {
		for(int i=0; i<reg.size(); i++) {//tabort namnet
			if (reg.get(i).getArtist().toLowerCase().indexOf(s)>=0 || reg.get(i).getTitle().toLowerCase().indexOf(s)>=0){
				reg.remove(reg.get(i));
				i--;
			}
		}
	}

	public void search(String s) {
		String Artist_s, Tittle_s;
		String res="";
		for(int i=0; i<=reg.size()-1; i++) {

			if(reg.get(i).getArtist().indexOf(s)>=0 || reg.get(i).getTitle().indexOf(s)>=0 ) {
				
					Artist_s=reg.get(i).getArtist();
					Tittle_s= reg.get(i).getTitle();
					res= res+ Artist_s+"  "+Tittle_s+"\n";
			}
		}
		D.printString(res);
		
	}
	//visa registet som en string
	public String showReg() {
		StringBuilder str= new StringBuilder();
		for(CD cd : reg) {
			str.append(cd.toString());
//			str.append("\n");
		}
		return str.toString();
	}
	
	
	public String view() {
//		String Artist;
//		String View="";
//		String Tittle;
//		for(int i=0; i<reg.size();i++) {
//			Artist= reg.get(i).getArtist();
//			Tittle=reg.get(i).getTitle();
//			View=View+ Artist+"  "+Tittle+"\n";
//		}
		StringBuilder gg= new StringBuilder();
		for(CD cd : reg) {
			gg.append(cd.toString());
			gg.append("\n");
		}
		return gg.toString();
//		writeToFile(View);
	}

	public void sorteraArt() {
		CD sort;
		for (int i = 0; i < reg.size(); i++) {
			for (int j = i + 1; j < reg.size(); j++) {
				if(reg.get(i).getArtist().toLowerCase().compareTo(reg.get(j).getArtist().toLowerCase())>0) {
					sort = reg.get(i);
					reg.set(i,reg.get(j));
					reg.set(j,sort);
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(CD cd:reg) {
			sb.append(cd.toString() +"\n");
		}
		D.printString(sb.toString());
	}

	public void sorteraTite() {
		CD sort;
		for (int i = 0; i < reg.size(); i++) {
			for (int j = i + 1; j < reg.size(); j++) {
				if(reg.get(i).getTitle().toLowerCase().compareTo(reg.get(j).getTitle().toLowerCase())>0) {
					sort = reg.get(i);
					reg.set(i,reg.get(j));
					reg.set(j,sort);
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(CD cd:reg) {
			sb.append(cd.toString() +"\n");
		}
		D.printString(sb.toString());	
	}

}

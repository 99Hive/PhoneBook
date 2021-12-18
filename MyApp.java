import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.View;

import java.io.FileNotFoundException; 
import java.io.File; 
import java.util.Scanner; 
import java.io.PrintWriter;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;


public class MyApp {

	public static void main(String[] args) {
		
		Register re= new Register();//hämta registret
		Dialog D= new Dialog();//hänsta dialog
		
		String menuItems = "Menue                " +                          "\n"
				+ "1: creat a new albom                                    " + "\n" 
				+ "2: delete                              " + "\n"
				+ "3: search a song or an artist           "+ "\n"
				+ "4: show all                                       "+ "\n"
				+ "5: show by the artist               "+ "\n"
				+ "6: show by the song"+              "\n"
				+ "7: save the file"+                               "\n"
				+ "8: read the file"        +                 "\n" ;

		int command=0;
		while (command!=Integer.MAX_VALUE) {

			command= D.readInt(menuItems);
			switch (command) {
			case 1:
			
			String a=D.readString("vad heter artisten"); 
			
			String y= D.readString("vad heter tittlen"); 

//			CD c= new CD(D.readString(quesA), " ");
//			CD v= new CD(" ",D.readString(quesT));
			re.add(a, y);//ändrat
			System.out.println("Listan är "+re.getList());
			break;
			
			case 2:
//				String Remove_name = "Vilken cd ska du ta bort"; 
				String d= D.readString("Vilken cd ska du ta bort");
				re.remove(d);
				System.out.println("Listan efter remove"+re.getList());
				break;
			case 3:
				String sok =D.readString("Sök ett cd") ; 
				re.search(sok);
				break;
			case 4:
				re.sorteraArt();

//				re.view();
				break;
			case 5:
				re.sorteraArt();
				break;
			case 6:
				re.sorteraTite();
				break;
			case 7:
				String s= D.readString("vad är fil namn");
				re.writeToFile(s);				
				break;
			case 8:
				String b= D.readString("vad är fil namn");
				re.readFromFile(b);		
				break;
			}
		}
	}
}

package textExcel;
import java.util.Scanner;
public class TextExcel
{

public static void main(String[] args)
{


   // Add your command loop here

	Spreadsheet x = new Spreadsheet();
	Scanner sc = new Scanner(System.in);
	System.out.println("enter");
	String input = sc.nextLine();
		while(!input.equals("quit")) {
		    input = sc.nextLine();
			System.out.println(x.processCommand(input));

		}
  }




	}

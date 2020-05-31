package textExcel;
import java.util.*;
public class Spreadsheet implements Grid
{

   Cell[][]spreadsheet = new Cell[20][12];
   public Spreadsheet() {
	   for(int i = 0; i < spreadsheet.length; i++) {
		   for(int j = 0; j < spreadsheet[0].length; j++) {
			   spreadsheet[i][j] = new EmptyCell();
		   }
	   }
   }

@Override
	public String processCommand(String command) {
	if(command.equalsIgnoreCase("clear")) {
		   for(int i = 0; i < getRows(); i++) {
			   for(int j = 0; j < getCols(); j++) {
				   this.spreadsheet[i][j] = new EmptyCell();
				   
			   }
		   }
		  return getGridText();
	   }
	 if(command.contains("=") && command.contains("\"")) {
		 String[] equalsArr = command.split(" ", 3);
		 String commandArr0 = equalsArr[0].toUpperCase();
		 String commandArr2 = equalsArr[2];
		 if(commandArr0.length() >= 2) {
			    char x = commandArr0.charAt(0);
				String y = commandArr0.substring(1, commandArr0.length());
				int row = Integer.parseInt(y) - 1;
				int col = (int)(x - 'A');
				Cell a = new TextCell(commandArr2);
				spreadsheet[row][col] = a;
				return getGridText();
		 }

		
	   }
	 String upperCaseCommand = command.toUpperCase();
	 if(upperCaseCommand.contains("CLEAR") && command.contains(" ")) {
		   String[] commandArr = command.split(" ", 2);
		   String commandArr1 = commandArr[1].toUpperCase();
		   SpreadsheetLocation loc = new SpreadsheetLocation(commandArr1);
		   this.spreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
		   return getGridText();
		   
	   }
	if(command.length() >= 2 && !command.contains("=")) {
		char x = command.toUpperCase().charAt(0);
		String y = command.substring(1, command.length());
		int row = Integer.parseInt(y) - 1;
		int col = (int)(x - 'A');
		return spreadsheet[row][col].fullCellText();
   }
  
	  	
return "";
	}


@Override
public int getRows()
{
// TODO Auto-generated method stub
return this.spreadsheet.length;
}

@Override
public int getCols()
{
// TODO Auto-generated method stub
return this.spreadsheet[0].length;
}

@Override
public Cell getCell(Location loc)
{
	return this.spreadsheet[loc.getRow()][loc.getCol()];
}

@Override
	public String getGridText() {
	String gridText = "   |";
	for(int i = 0; i < 12; i++) {
		gridText +=(char)(i + 65) + "         |";
		
	}
	gridText +="\n";
	
	for(int i = 1; i < 21; i++) {
		gridText+=String.format("%-3.3s|",i);
		for(int j = 0; j < 12; j++) {
			gridText+=String.format("%-10.10s|", (spreadsheet[i-1][j].abbreviatedCellText()));
		}
		gridText+="\n";
		
	}
	return gridText;
}

}
	

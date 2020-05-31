package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String loc;
	int row;
	int col;
    @Override
    
    
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        this.loc = cellName;
        row = Integer.parseInt(cellName.substring(1,cellName.length())) - 1;
        col = (int)cellName.charAt(0) - 65;
    }
     
        
        

}

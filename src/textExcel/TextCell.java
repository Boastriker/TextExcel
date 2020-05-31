package textExcel;

public class TextCell implements Cell {
	private String textCell;
	public TextCell(String textCell) {
		this.textCell = textCell;
	}
	public String abbreviatedCellText() {
		String x = this.textCell.replaceAll("\"", "");
		if(x.length()>10) {
			return x.substring(0,10); 
		}
		
				
	x = String.format("%-10.10s",x);	
	return x;	
	
		
	}
	public String fullCellText() {
		return this.textCell;
	}
}

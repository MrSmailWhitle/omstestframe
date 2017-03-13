package java.datainteractive;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.*;
import oracle.sql.DATE;

//import org.apache.poi.ss.usermodel.Sheet;

public class ResolveExcel {
	private static final CellStyle String = null;
	private Sheet sheet;
	//更新了datalist类型为数组类型；
	private List<String[]> datalist=new ArrayList<>();
	public ResolveExcel(Sheet sheet){
		this.sheet=sheet;
		SetSheetData();
	}
	private void SetSheetData() {
		//解析第一行开始
		int columnnum=0;
		//获取列数
		if(sheet.getRow(0)!=null){
			columnnum=sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
		}
		//列数大于0，我们进行行的解析判断；
		if(columnnum>0){
			for(Row row:sheet){
				//定义一个空的行数组，长度为上面解析的列数
				String[] singlerow=new String[columnnum];
				//为每个行数组赋值
				int n=0;
				for(int col=0;col<columnnum;col++){
					singlerow[n]=this.getCellText(row,col);
					n++;
					
				}
				if("".equals(singlerow[0])){continue;}
				datalist.add(singlerow);
			}
			
		}
		
		
	}
	private String getCellText(Row row, int col) {
		// TODO Auto-generated method stub
		String celltext=null;
		Cell cell=row.getCell(col,Row.CREATE_NULL_AS_BLANK);
		int cellType = cell.getCellType();  
        java.lang.String temp;
		switch (cellType) {  
        case Cell.CELL_TYPE_STRING:  
        	celltext = cell.getStringCellValue().trim();  
            break;  
        case Cell.CELL_TYPE_BOOLEAN:
        	celltext =Boolean.toString(cell.getBooleanCellValue());  
            break;  
        case Cell.CELL_TYPE_FORMULA:
			celltext=cell.getStringCellValue().toString();
			if(celltext!=null){
				celltext=celltext.replaceAll("#N/A", "").trim();
				
			}
			break; 
        case Cell.CELL_TYPE_NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				celltext=java.lang.String.valueOf(cell.getBooleanCellValue());
			}else{
				String value=cell.getStringCellValue();
					if(value.indexOf(".")>-1){
						celltext=(new Double(value)).toString().trim();
					}else{
						celltext=value.trim();
					}
			}
			break;
        case Cell.CELL_TYPE_BLANK:  
            temp = "NULL";  
            break;  
        case Cell.CELL_TYPE_ERROR:  
            temp = "ERROR";  
            break;  
        default:  
            temp = cell.toString().trim();  
            break;  
        }  

		return celltext;
	}
	 public List<String[]> getSheetDataSet(){
		 return datalist;
	 }
	 public int getRowCount(){
		 return sheet.getLastRowNum();
	 }
	 public int getColumnCount(){
		 Row row=sheet.getRow(0);
		 if(row!=null&&row.getLastCellNum()>0){
			 return row.getLastCellNum();
			 
		 }
		 return 0;
	 }
	 public String[] getRowData(int rowIndex){
		 String[] dataArray=null;
		 if(rowIndex>this.getRowCount()){
			 return dataArray;
		 }else{
			 dataArray=new String[this.getColumnCount()];
			 return this.datalist.get(rowIndex);
		 }
		 
	 }
	 public String[] getColumnData(int colIndex){
		 String[] dataArray=null;
		 if(colIndex>this.getColumnCount()){
			 return dataArray;
			 
		 }else{
			 if(this.datalist!=null&&this.datalist.size()>0){
				 dataArray=new String[this.getColumnCount()+1];
				 int index=0;
				 for(String[] rowData:datalist){
					 if(rowData!=null){
						 dataArray[index]=rowData[colIndex];
						 index++;
						 
					 }
				 }
			 }
		 }
		 return dataArray;
	 }
	 public String getText(int row,int column){
		 return getRowData(row)[column];
		 
	 }

	 
}



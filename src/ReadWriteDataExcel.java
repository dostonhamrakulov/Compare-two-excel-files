import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteDataExcel {
	static Boolean check = false;

	public static void main(String args[]) throws IOException {

		try {

			ArrayList arr1 = new ArrayList();
			ArrayList arr2 = new ArrayList();
			ArrayList arr3 = new ArrayList();

			FileInputStream file1 = new FileInputStream(new File(
					"D://Europa.xlsx"));

			FileInputStream file2 = new FileInputStream(new File(
					"D://WorldCity.xlsx"));

			// Get the workbook instance for XLS file
			XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
			XSSFWorkbook workbook2 = new XSSFWorkbook(file2);

			// Get first sheet from the workbook
			XSSFSheet sheet1 = workbook1.getSheetAt(0);
			XSSFSheet sheet2 = workbook2.getSheetAt(0);

			// Compare sheets

			// Get iterator to all the rows in current sheet1
			Iterator<Row> rowIterator1 = sheet1.iterator();
			Iterator<Row> rowIterator2 = sheet2.iterator();

			while (rowIterator1.hasNext()) {
				Row row = rowIterator1.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					// This is for read only one column from excel
					if (cell.getColumnIndex() == 1) {
						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue());
							arr1.add(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							arr1.add(cell.getStringCellValue());
							System.out.print(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							arr1.add(cell.getBooleanCellValue());
							System.out.print(cell.getBooleanCellValue());
							break;
						}

					}

				}

				System.out.println(" ");
			}

			file1.close();

			System.out.println("\n-----------------------------------");
			// For retrive the second excel data
			while (rowIterator2.hasNext()) {
				Row row1 = rowIterator2.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator1 = row1.cellIterator();

				while (cellIterator1.hasNext()) {

					Cell cell1 = cellIterator1.next();
					// Check the cell type and format accordingly

					// This is for read only one column from excel
					if (cell1.getColumnIndex() == 1) {
						switch (cell1.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							arr2.add(cell1.getNumericCellValue());
							System.out.print(cell1.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							arr2.add(cell1.getStringCellValue());
							System.out.print(cell1.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							arr2.add(cell1.getBooleanCellValue());
							System.out.print(cell1.getBooleanCellValue());
							break;

						}

					}
					// this continue is for
					// continue;
				}

				System.out.println("");
			}

			System.out.println("\nbook1.xls -- " + arr1.size());
			System.out.println("book1.xls -- " + arr2.size());

			// compare two arrays
			for (Object process : arr1) {
				if (!arr2.contains(process)) {
					arr3.add(process);
				}
			}
			System.out.println("\narr3 list values, here arr1 has some values which arr2 DOES NOT have : " + arr3);
			writeStudentsListToExcel(arr3);

			// closing the files
			file1.close();
			file2.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// write into new file excel

	private static void writeStudentsListToExcel(ArrayList arr3) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(
					"D://ResultFile.xlsx");

			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet spreadSheet = workBook.createSheet("New");
			XSSFRow row;
			XSSFCell cell;
			// System.out.println("array size is :: "+minusArray.size());

			int cellnumber = 1;
			for (int i1 = 0; i1 < arr3.size(); i1++) {
				row = spreadSheet.createRow(i1);
				cell = row.createCell(cellnumber);
				// System.out.print(cell.getCellStyle());
				cell.setCellValue(arr3.get(i1).toString().trim());
			}
			int cellnumber2 = 4;
			for (int i2 = 0; i2 < arr3.size(); i2++) {
				row = spreadSheet.createRow(3);
				cell = row.createCell(cellnumber);
				// System.out.print(cell.getCellStyle());
				cell.setCellValue(arr3.get(i2).toString().trim());
			}
			workBook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	// end -write into new file

	//Store data to HashMap
	private static void StoreArraysToHashMap(ArrayList arr1, ArrayList arr2) {

		HashMap hashMap1 = new HashMap();

		for(int i = 0; i < arr1.size(); i++) {
			hashMap1.put(i, arr1.get(i).toString());
		}

		HashMap hashMap2 = new HashMap();
		for(int j = 0; j < arr1.size(); j++) {
			hashMap1.put(j, arr1.get(j).toString());
		}
		
		
	}
}
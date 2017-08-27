# Compare-two-excel-files
1. Excel.java class demostres how hashmap works


2. ReadWriteDataExcel.java compares two excel file and writes into result file.


3. Secondtype.java takes data from excel and writes into hashmap, even if the excel file has more sheets it writes one by one, here how it works:

Hashmap myHashmap = 
{ sheet1 =  {row1 = [column1, column2, ...], row2 = [column1, column2, ...], row3 ...}, sheet2 = {row1 = [column1, column2, ...], row2 = [column1, column2, ...], row3 ...}, sheet3 = { ... }, ...};

# Compare-two-excel-files

First of all, you need to import apache poi library in order to read and wrtie excel file:
Downloading apache poi :
Potential exceptions first time: 
1. java.lang.ClassNotFoundException: org.apache.xmlbeans.XmlException
Solution, you need to add one more library which is xmlbeans-x.x.x.jar: https://stackoverflow.com/questions/23080945/java-lang-classnotfoundexception-org-apache-xmlbeans-xmlexception

1. Excel.java class demostres how hashmap works


2. ReadWriteDataExcel.java compares two excel file and writes into result file.


3. Secondtype.java takes data from excel and writes into hashmap, even if the excel file has more sheets it writes one by one, here how it works:

Hashmap myHashmap = 
{ sheet1 =  {row1 = [column1, column2, ...], row2 = [column1, column2, ...], row3 ...}, sheet2 = {row1 = [column1, column2, ...], row2 = [column1, column2, ...], row3 ...}, sheet3 = { ... }, ...};

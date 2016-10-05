package ChromeScripts;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import jxl.read.biff.BiffException;
import jxl.Workbook;


public class ValidatationTest {

	public static void main(String[] args) throws Exception{
		//for this test we are going to take a list of possible usernames from an excel spreadsheet
		//and test which ones are able to be used create a new gmail account
		
		//since we are testing possible gmail usernames are testPage is the gmail login page
		String testPage = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
		//the username box id is "Email"
		String argId = "Email";
		//to see whether a email is taken we click the continue box
		String action = "click";
		//this is where are action needs to occur
		String actionId = "next";
		//we expect this error message to appear if it is available
		String expected = "Sorry, Google doesn't recognize that email.";
		//and this is where we expect to find it
		String expectedId = "errormsg_0_Email";
		
		
		
		//gmail uses a divider to discourage automated testing
		boolean divider = true;
		
		
		
		//this is where your excel file is located
		File src = new File("C:\\Users\\Craskan Avenger\\Documents\\Excel files\\readable_files\\gmail_sample_usernames.xls");
		
		//this loads the excel file
		//eventually I'll have all this handled by it's own class
		Workbook wb = Workbook.getWorkbook(src);
		
		//this finds out how many entries we need to work with
		int rows = wb.getSheet(0).getRows();
		
		//this finds out the number of columns in the spreadsheet
		int columns = wb.getSheet(0).getColumns();
		
		
		//here is where we keep track of the available (sucessful) usernames
		String [] success = new String [rows];
		Arrays.fill(success,"");
		
		
		if(columns == 1)
		{	
			//we start at 1 because index zero labels the types
			for(int i = 1; i < rows; i++)
			{
				BasePage nameTaken = new BasePage();
				nameTaken.setup();
				String arg1 = wb.getSheet(0).getCell(0,i).getContents();
				nameTaken.Confirmation(testPage,arg1,argId,action,actionId,expected);
				if(nameTaken.IsTestElementPresent(expected,expectedId) == true){
					success[i] = arg1;
				}
				nameTaken.tearDown();
				
				
			}
		}
		System.out.println("these are all the non-taken usernames.");
		int len = success.length;
		for(int i = 0; i < len; i++)
		{	
			if(success[i] != "")
			{
				System.out.println(success[i]);
			}
			
		}
		
		
		
	}
	

}

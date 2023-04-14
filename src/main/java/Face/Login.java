package Face;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;



public class Login
{
		WebDriver driver;
		String url="https://www.facebook.com/";
	   String CSV_file="C:\\Users\\Dell\\eclipse-workspace\\Facebook\\Data\\Assignment1.csv";
	  
	   String[] csvCell;
	   
	       
	       
	       @BeforeTest
	   	   public void openBrowser()
	   	   {
	   		   driver=new ChromeDriver();
	   		   driver.manage().window().maximize();
	   		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   	    }
	   		   
	      
	   	 @Test
	   	   public void veify_login() throws CsvValidationException, IOException, InterruptedException
	   	   {
	   		   driver.get(url);
	   		  
	   		   
	   		   
	   		CSVReader reader=new CSVReader(new FileReader(CSV_file));
	   		 
	   		 while((csvCell=reader.readNext())!=null)
			   {
	   			
	   			for(int i=0;i<1;i++)
	   				
	   				{
	   				
	   					
			   String UN=csvCell[i];
			   String pass=csvCell[i+1];
			   
			   driver.findElement(By.xpath("//input[@id='email']")).sendKeys(UN);
			   driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
			   driver.findElement(By.xpath("//div[.='Log in']")).click();
			   Thread.sleep(4000);
			   driver.navigate().back();
			   driver.findElement(By.xpath("//input[@id='email']")).clear();
			   
			  }
			   }
	   	   }
	   @AfterTest
	   public void writing() throws IOException
	        {
	   			
	   		 String outputfile="C:\\Users\\Dell\\eclipse-workspace\\Facebook\\Data\\Assignment1.csv";
	   		 CSVWriter out=new CSVWriter(new FileWriter(outputfile,true));
	   		 
	   			
	   			
	   		 
	        }
	   	  
	   		
			 
	   		 

}
			   
			   
	   		
	   		   

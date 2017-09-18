package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FaceBook {
	 WebDriver driver;
		
		@BeforeTest
		public  void OpenBrowser(){
			driver =new FirefoxDriver();
			
			driver.manage().window().maximize();
			
			
			
		}
		@AfterTest
		public void closeBrowser(){
			System.out.println("Facebook SignUp Successful");
			System.out.println("Facebook SignUp Successful");
			driver.close();
		}
		
		@Test(dataProvider="FacebookData")
		public void FacebookTest(String FN, String LN,String EM,String AEM,String PW,String Sex,String Month,String Day,String Year) throws InterruptedException{
			driver.get("https://www.facebook.com/");
			driver.findElement(By.name("firstname")).sendKeys(FN);
			driver.findElement(By.name("lastname")).sendKeys(LN);
			driver.findElement(By.name("reg_email__")).sendKeys(EM);
			Thread.sleep(3000);
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys(AEM);
			driver.findElement(By.name("reg_passwd__")).sendKeys(PW);
			
			if(Sex.equalsIgnoreCase("Female")){
			driver.findElement(By.xpath(".//*[@id='u_0_6']")).click();
			Thread.sleep(3000);
			}
			else if(Sex.equalsIgnoreCase("Male")){
				driver.findElement(By.xpath(".//*[@id='u_0_7']")).click();
				Thread.sleep(3000);
			}
			Select monthselect=new Select(driver.findElement(By.id("month")));
			monthselect.selectByVisibleText(Month);
			Select dayselect=new Select(driver.findElement(By.id("day")));
			dayselect.selectByVisibleText(Day);
			Select yearselect=new Select(driver.findElement(By.xpath(".//*[@id='year']")));
			
			yearselect.selectByVisibleText(Year);
			Thread.sleep(3000);
			
			
		}
		@DataProvider(name="FacebookData")
		public Object [][] GetData(){
			return new Object [][]{
				{"Sonia","sultana","soni123@yahoo.com","soni123@yahoo.com","1234","Female","Nov","12","1933"},
				{"Kafi","Khan","kafi123@yahoo.com","kafi123@yahoo.com","1234","Male","Nov","14","1985"},
				{"Rima","Oulhaci","rima1234@yahoo.com","rima1234@yahoo.com","1234","Female","Nov","27","1986"},
				{"Soni","sultana","sonia1234@yahoo.com","sonia1234@yahoo.com","1234","Female","Nov","22","1987"},
				{"Raza","sultan","raza123@yahoo.com","raza123@yahoo.com","1234","Male","Nov","17","1984"}
			};
			
		}
		
}

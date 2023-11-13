import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArrayListConcepts {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://seleniumPractise/");
		//Concept 1
		Thread.sleep(8000);
		//driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
		String[] ItemsNeeded= {"Cucumber","Beans","Mushroom","Corn"};
		for(int i=0;i<ItemsNeeded.length;i++) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+ItemsNeeded[i]+"')]//following::button[contains(text(),'ADD TO CART')][1]")).click();	
		}
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(4000);
        //Concept 2
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		addItems(driver,itemsNeeded);
      }
	
	public static void addItems(WebDriver driver, String[] itemsNeeded)

	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		//System.out.println(products.get(0).getText());
		
		for (int i = 0; i < products.size(); i++)
		{
			// Brocolli - 1 Kg
			// Brocolli, 1 kg
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// format it to get actual vegetable name
			// convert array into array list for easy search
			// check whether name you extracted is present in arrayList or not-
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if (itemsNeededList.contains(formattedName))
			{

  			   j++;
				// click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)
				{
					break;
				}

			}

		}

	}
	
}

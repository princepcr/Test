package com.PrinceChristianRonquillo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) {
		
		System.out.println("Start: Automation Tester Exam");
		
		ChromeDriver driver = new ChromeDriver();
		
		//Access the URL
		driver.get("https://www.fragrancex.com");
		driver.manage().window().maximize();
		
		System.out.println("Done loading the URL");
		
		try {
            Thread.sleep(1000); // wait for 1 seconds to verify URL is displayed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		//Find and Store all Links in the Page
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Done finding all Links: "+allLinks.size()); //Included links count for verification
		
		//Locate the 'Top Picks for You' section
		WebElement topPicks = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[3]/div/div/div[1]"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(topPicks).perform();
		
		System.out.println("Done hovering on 'Top Picks for you' section");
		
		  try {
	            Thread.sleep(3000); // wait for 3 seconds to verify 'Top picks for you' section is displayed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
		//Store all Perfume Names under 'Top Picks for You' section
		List<WebElement> perfumeNames = driver.findElements(By.xpath("//div[@id='recommended-items' and @class='serif h3']"));

        System.out.println("Perfume Names under Top Picks For You:");
        for (WebElement perfume : perfumeNames) {
            System.out.println(perfume.getText());
        }
		
		// Click the 3rd item from the list
		WebElement thirdProduct = driver.findElement(By.xpath("//h2[text()='Top picks for you']/following-sibling::div//div[3]//a"));
        thirdProduct.click();
		
        System.out.println("Done selecting the 3rd item form the 'Top picks for you' section");
		
        /*Verify that the product name was selected
        WebElement selectedProductName = driver.findElement(By.xpath("//div[@class='serif h3']"));
        String expectedProductName = perfumeNames.get(2).getText();
        String actualProductName = selectedProductName.getText();

        if (actualProductName.equals(expectedProductName)) {
            System.out.println("Selected product name is displayed: " + actualProductName);
        } else {
            System.out.println("Selected product name is not displayed");
        }*/
        
        try {
            Thread.sleep(3000); // wait for 3 seconds to verify 3rd product has been selected
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Add the 2nd product variant to the shopping bag
        List<WebElement> buttons = driver.findElements(By.className("add-to-cart"));
        WebElement secondButton = buttons.get(2);
        secondButton.click();
        
        System.out.println("Done adding the second variation to the bag");
        
        // Update quantity to 5
        WebElement quantityInput = driver.findElement(By.xpath("//*[@id='CartQuantityAsyncForm']/div/div[2]/div[2]/div[3]/div[2]/div[1]/select"));
        quantityInput.sendKeys("5");
        
        System.out.println("Done updating the quantity of items in the bag to 5");
        
        try {
            Thread.sleep(3000); // wait for 3 seconds to verify quantity has been updated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Close the URL
        driver.quit();
        
        System.out.println("End: Automation Tester Exam");
	}
}

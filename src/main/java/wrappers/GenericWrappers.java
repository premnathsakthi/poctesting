package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {
  
	RemoteWebDriver driver;
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub 
		try {
			if(browser.equalsIgnoreCase("chrome")) { 
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			    driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				 driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver","drivers.IEDriverServer.exe");
				 driver =new InternetExplorerDriver();
			    }
			driver.manage().window().maximize();
			driver.get(url);
			System.out.println("The browser" +browser+ "is launched sucessfully with given url"+url);
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser" +browser+"is not lanuched due to session not created error");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The browser "+browser+" is not launched due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The element with id "+idValue+" is entered with data"+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id " +idValue+ "is not present in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id" +idValue+ "is not visible in application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id" +idValue+ "is not interactable in application");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id" +idValue+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elemet with id" +idValue+ "is not entered with data" +data+ "with a unknown error");
		}finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("This element with name"+nameValue+ "is entered with data"+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with name" +nameValue+ "is not present in dom");
		
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
		    System.err.println("The element with name" +nameValue+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with name" +nameValue+ "is not interactable in the applaication");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with name " +nameValue+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			
			System.err.println("The element with name" +nameValue+ "is eneterd with data" +data+ "with an unknown error");
		}finally {
			takeSnap();
		}
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("This element in xpath" +xpathValue+ "is entered with data"+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath" +xpathValue+ "is not present in dom");
			
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath" +xpathValue+ "is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath" +xpathValue+ " is not interactable in application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath" +xpathValue+ " is not selectable in application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath" +xpathValue+ " is not stable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath" +xpathValue+ "is eneterd with data"+data+"with an unknown error");
		}finally {
			takeSnap();
		}
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		 try {
			 String actualTitle =driver.getTitle();
			 if(actualTitle.equals(title)) {
			System.out.println("Excepted title "+title+" matches the actual title "+actualTitle);
			}
			else {
				System.err.println("Excepted title does not match the actual title");
				}
		
		 }catch (NoSuchElementException e) {
			// TODO: handle exception
			 System.err.println("Unable to get title since window is not launched");
		}
		 catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The title "+title+"is not verified due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
    try {
		String expectedText = driver.findElementById(id).getText();
			if(expectedText.equals(text))
			{
				System.out.println("The Actual text" +text+ "is exactly matched with expected text" +text);
			}
			else {
				System.out.println("Excepted title does not match the actual title ");
			}
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("The given text "+text+" is not verified due to the element with the id" +id+ "is not present in DOM ");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("The given text "+text+" is not verified due to the element with the id" +id+ "is not interactable in application");
	}catch (ElementNotSelectableException e) {
		// TODO: handle exception
		System.err.println("The given text "+text+" is not verified due to the element with the id" +id+ "is not selectable in application");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("The given text "+text+" is not verified due to the element with the id" +id+ "is not stable in application");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("The given text "+text+" is not verified due to unknown error");
	}finally {
		takeSnap();
	}
		
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String expectedtext =driver.findElementByXPath(xpath).getText();
			if(expectedtext.equals(text)){
				System.out.println("The expected text "+text+ " is partially matched with actualtext "+expectedtext+"located in xpath "+xpath);
			}else {
				System.err.println("The expected text "+text+ " is partially not matched with actualtext " +expectedtext+ "located in xpath "+xpath );
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not present in DOM");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with verifyTextByXpath"+xpath+"is  not able to selectable in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not visible in application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not interactable in application ");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not stable in application ");
		}catch (WebDriverException e) {
			// TODO: handle exception
		System.err.println("The given text "+text+" is not verified due to unknown error");
		}finally {
			takeSnap();
		}
	}


	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String expectedResult=driver.findElementByXPath(xpath).getText();
			if(expectedResult.contains(text))
			{
				System.out.println("Excepted title matches the actual title");
			}else {
				System.err.println("Excepted title does not match the actual title");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not present in DOM");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with verifyTextByXpath"+xpath+"is  not able to selectable in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not selectable in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not interactable in application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to the element with the xpath" +xpath+ "is not stable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The given text "+text+" is not verified due to unknown error");
		}finally {
			takeSnap();
		}
		
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			System.out.println("The element with the id " +id+ "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id " +id+ "is not in the dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id " +id+ "is not visbile in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with id " +id+ "is not selectable in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id " +id+ "is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id " +id+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "with an unknown error");
		}finally {
			takeSnap();
		}
		
	}

	public void clickByClassName(String classVal)   {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("This element with the class" +classVal+ "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with class" +classVal+  "is not in the dom");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with class" +classVal+ "is not interactable in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with class" +classVal+ "is not selectable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with clickByClassName" +classVal+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with class" +classVal+ "with an unknown error");
		}finally {
			takeSnap();
		}
		
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			System.out.println("The element with the name " +name+ "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with Name" +name+ "is not in the dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with Name " +name+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with Name " +name+ "is not interactable in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with Name " +name+ "is not selectable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with cName " +name+"is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with Name" +name+ "with an unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("This element with LinkText" +name+ "is clicked succuessfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with LinkText" +name+ "is not in the dom");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText" +name+ "is not selectable in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText" +name+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText" +name+ "is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText" +name+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText" +name+ "with an unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("This element with linktext " +name+ "is clicked succuessfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with linktext " +name+ "is not in the dom");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with linktext " + name+ "is not selectable in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with linktext " +name+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with linktext " +name+ "is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with linktext" +name+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with clickByLinkNoSnap" +name+ "with an unknown error");
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("This element with xpath " +xpathVal+ "is clicked succuessfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with Xpath " +xpathVal+ "is not in the dom");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not selectable in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception 
			System.err.println("The element with Xpath " +xpathVal+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "with an unknown error");
		}finally {
			takeSnap();
		}
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("This element with Xpath" +xpathVal+ "is clicked succuessfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with Xpath " +xpathVal+ "is not in the dom");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not selectable in the application");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "with an unknown error");
		}
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String result = null;
		try {
			
			result= driver.findElementById(idVal).getText();
			System.out.println("This atualtext available in the "+idVal+" is holding the text "+result);
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id " +idVal+ "is not in the dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id " +idVal+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id " +idVal+ "is not interactable in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with id " +idVal+ "is not selectable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id " +idVal+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The text with id " +idVal+ "with an unknown error");
		}finally {
			takeSnap();
		}
		return result;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String result =null;
		try {
			result =driver.findElementByXPath(xpathVal).getText();
			System.out.println("The actualtext available in the xpath  "+xpathVal);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with Xpath" +xpathVal+ "is not in the dom");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not interactable in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not selectable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "with an unknown error");
		}finally {
			takeSnap();
		}
		
		return result;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown =driver.findElementById(id);
			Select list =new Select(dropdown);
			list.selectByVisibleText(value);
			System.out.println("This element with id" +id+ "is entered with data"+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id" +id+ "is not in the dom");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not selectable in the application");
		
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is eneterd with data"+value+"with an unknown error");
		
		}
		
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown1= driver.findElementById(id);
			Select index = new Select(dropdown1);
			index.selectByIndex(value);
			System.out.println("This element with id" +id+ "is entered with data"+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id" +id+ "is not in the dom");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not interactable in the application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not selectable in the application");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id" +id+ "is eneterd with data"+value+"with an unknown error");
		}finally {
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			
		Set<String>allWindowAfterClick= driver.getWindowHandles();
		for(String eachid:allWindowAfterClick) {
			driver.switchTo().window(eachid);
			break;
		}
		System.out.println("It will succusessfully switch to parent window");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("unable to switch to parent window due to nosuchelement");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("unable to switch to parent window due to session is not created");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("unable to switch to parent window due to unknown error");
		}finally {
			takeSnap();
		}
	}
	

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try { 
		Set<String>allWindowAfterClick= driver.getWindowHandles();
		for(String eachid:allWindowAfterClick) {
			driver.switchTo().window(eachid);
			
			
		}
		System.out.println("The driver has witched to Last Window successfully");	
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("unable to switch to last window due to nosuchelement");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("unable to switch to last window due to session is not created");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("unable to switch to last window due to session is not created");
		}finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			System.out.println("The alert has accepted successfully");
		
		}catch (NoAlertPresentException e) {
			// TODO: handle exception
			System.err.println("Alert is not present in the acceptAlert");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with acceptAlert is not stable with the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with acceptAlert as an unknown error");
		}finally {
			takeSnap();
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The element will dismiss the dismissAlert");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("dismiss is not present in the dismissAlert");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("cant able to handle the dismiss exception");
		}
		  catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with acceptAlert as an unknown error");
		}  finally {
			takeSnap();
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
			System.out.println("This element with getAlertText "+text);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("alert is not present in the alerttext");
			
		}catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("cant able to handle the alert exception");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with getAlertText is  not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with getAletText as an unknown error");
		}finally {
			takeSnap();
		}
		return text;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		File temp;
		File dest;
		try {
			temp = driver.getScreenshotAs(OutputType.FILE);
			dest = new File("./drivers/screenshots/snap.png");
			FileUtils.copyFile(temp, dest);
			System.out.println("snap file is copied successfully");
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("FIle not able to copy due to IOexception");
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("Cant able to take snap due to session handling");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Not able to take snap due to unknown error");
		}
		
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("The broswer will close successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Active broswer is not able to close");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("Session is not created so active is not able to close");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Cant able to close the active broswer due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("The all active browser will quit successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Cant able to quit all the active broswer");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("session is not created so all active broswer is not able to quit");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Cant able to quit the active browser due to unknown error");
		}
	}

	public void waitProperty(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectVisibileTextByXpath(String id, String value) throws ElementNotVisibleException {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown2 =driver.findElementByXPath(id);
			Select text = new Select(dropdown2) ;
			text.selectByVisibleText(value);
			System.out.println("The element with the id" +id+" is selected successfully with the value"+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with the id "+id+"is not available in DOM");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with the id "+id+"is not interactable in application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with the id "+id+"is not selectable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with the id "+id+"is not selected due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void selectValueById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown3 =driver.findElementById(id);
			Select val =  new Select(dropdown3);
			val.selectByValue(value);
			System.out.println("The element with the id" +id+" is selected successfully with the value"+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with the id "+id+" is not available in DOM");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with the id "+id+" is not interactable in application");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with the id " +id+ "is not selectable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with the id " +id+ "is not selected due to unknown error");
		}finally {
			takeSnap();
		}
		
	}
	public void enterByXpath(String xpathValue, Keys pageDown) {
		try {
			driver.findElementByXPath(xpathValue).sendKeys(pageDown);
			System.out.println("");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("");
		}
	}

	public void selectVisibleTextByName(String id, String value) {
		// TODO Auto-generated method stub
	try {
		WebElement dropdown5=	driver.findElementByName(id);
		Select text = new Select(dropdown5);
		text.selectByVisibleText(value);
		System.out.println("The element with the id" +id+" is selected successfully with the value\"+value");
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("The element with the id "+id+" is not available in DOM");
		
	}catch (ElementNotSelectableException e) {
		// TODO: handle exception
		System.err.println("The element with the id "+id+" is not selectable in application");
	}catch (ElementNotVisibleException e) {
		// TODO: handle exception
		System.err.println("The element with the id "+id+" is not visible in application");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("The element with the id " +id+ "is not selected due to unknown error");
	}finally {
		takeSnap();
	}
	}

	

	public void mouseOver(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			WebElement stays =driver.findElementByXPath(xpathVal);
			Actions builder = new Actions(driver);
			builder.moveToElement(stays).perform();
			System.out.println("This element with xpath " +xpathVal+ "is clicked succuessfully");
		} 
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with Xpath " +xpathVal+ "is not in the dom");
			
		}
		catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not selectable in the application");
		}
		catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "is not visible in the application");
		}
		catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with Xpath " +xpathVal+ "with an unknown error");
		}
		finally {
			takeSnap();
		}
	}

	public void navigatebackward() {
		// TODO Auto-generated method stub
		
		try {
			driver.navigate();
			System.out.println("The all active browser will navigate successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Cant able to navigate all the active broswer");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("session is not created so all active broswer is not able to navigate");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Cant able to quit the active browser due to unknown error");
		}
		
	}

	public void navigateforward() {
		// TODO Auto-generated method stub
		try {
			driver.navigate();
			System.out.println("The all active browser will navigate successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Cant able to navigate all the active broswer");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("session is not created so all active broswer is not able to navigate");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Cant able to quit the active browser due to unknown error");
		}
		
	}

	public String getURL( ) {
		// TODO Auto-generated method stub
		String currenturl = null;
		try {
			 currenturl=driver.getCurrentUrl();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return currenturl;
	}

	
	public void getclearbyXpath(String xpathval) {
		
		
		try {
			driver.findElementByXPath(xpathval).clear();
			
		System.out.println("This element with xpath"+xpathval+"is cleared succuessfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		// TODO Auto-generated method stub

	
	public void getclearbyid(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).clear();
			System.out.println("This element with id"+id+"is cleared succuessfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

}

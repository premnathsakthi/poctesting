using System;
using System.Linq;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using AventStack.ExtentReports;
using ECOM;


namespace ECOM

{
    [TestFixture]
    public class Amazon :LaunchingBrowser
    {

        String searchItem = "men running shoes";
       
        
        [Test]
        public void searchingItems()
        {
            try

            {
                test.Log(Status.Info, "In search box ,Entering the product name");
                driver.FindElement(By.XPath("//input[@id='twotabsearchtextbox']")).SendKeys(searchItem);


                test.Log(Status.Info, "And clicking the search icon");
                driver.FindElement(By.XPath("//*[@id='nav-search-submit-button']")).Click();


                test.Log(Status.Info, "Selecting the items");
                driver.FindElement(By.XPath("(//img[@class='s-image'])[1]")).Click();


                test.Log(Status.Info, "Window Handling");
                driver.SwitchTo().Window(driver.WindowHandles.Last());


                test.Log(Status.Info, "Clicking on the Addcart button");
                driver.FindElement(By.Id("add-to-cart-button")).Click();


                test.Log(Status.Info, "Adding the wait time");
                System.Threading.Thread.Sleep(3000);


                test.Log(Status.Info, "clicking on the cart");
                driver.FindElement(By.Id("nav-cart-count")).Click();


                test.Log(Status.Info, "Adding the wait time");
                System.Threading.Thread.Sleep(2000);


                test.Log(Status.Info, "Deleting the item");
                driver.FindElement(By.XPath("(//span[@data-action='delete'])[1]")).Click();


                test.Log(Status.Pass, "TestPass");

            }
            catch(Exception e)
            {
                test.Log(Status.Fail, e.ToString());
            }
        }

    }
}



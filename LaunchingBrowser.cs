using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using ECOM;
using AventStack.ExtentReports;
using AventStack.ExtentReports.Reporter;
using System;

namespace ECOM
{
    public class LaunchingBrowser:Report
    {
        public IWebDriver driver;
        public ExtentTest test;

        [OneTimeSetUp]
        public void Setup()
           
        {
            try
            {
                ReportClass();
                test = extentReports.CreateTest("Nuint Test").Info("Amazon Test");
                driver = new ChromeDriver("/Users/premnaths/Downloads");

                test.Log(Status.Info, "Window maximize");
                driver.Manage().Window.Maximize();

                test.Log(Status.Info, " Browser Launched Successfully");
                driver.Navigate().GoToUrl("https://www.amazon.in/");
            }catch(Exception e)
            {
                test.Log(Status.Fail, e.ToString());
            }
        }


        [OneTimeTearDown]
        public void CloseTheBrowser()
        {
            extentReports.Flush();
            driver.Quit();
        }
    }
}

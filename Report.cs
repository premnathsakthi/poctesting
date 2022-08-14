using System;
using NUnit.Framework;
using AventStack.ExtentReports;
using AventStack.ExtentReports.Reporter;

namespace ECOM
{
    public class Report
    {
        public ExtentReports extentReports;
        public void ReportClass()
        {
            extentReports = new ExtentReports();
            var htmlReporter = new ExtentHtmlReporter("/Users/premnaths/Projects/ECOM/ECOM/ExtendReport/report.html");
            extentReports.AttachReporter(htmlReporter);


        }
    }
}


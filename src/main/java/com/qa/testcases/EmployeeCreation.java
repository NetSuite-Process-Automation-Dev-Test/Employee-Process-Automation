package com.qa.testcases;

import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.exceldataReader.ExcelReader;
import com.qa.exceldataReader.ExcelReaderbycolumnname;
import com.qa.functions.employee_functions;
import com.qa.pages.AuthPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class EmployeeCreation extends TestBase {
	TestUtil testUtil;
	ExcelReader reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	employee_functions emp;
	AuthPage authpage;
	String file_path="C:\\Users\\Sindhuja\\Desktop\\Employee_data.xlsx";

	public void send_email() throws EmailException
	{
		EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("./employee_report/EmployeeReport.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
		  email.setSSLOnConnect(true);
		  email.addTo("sindhuja.b@tvarana.com", "Sindhu");
		  email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
		  email.setSubject("Vendor Test Report");
		  email.setMsg("Here is the report please find the attachment");
		  email.attach(attachment);
		  email.send();
	}
	@BeforeTest
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/employee_report/EmployeeReport.html");
		System.out.println("Report is generating");
		htmlReporter.config().setDocumentTitle("Employee Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Employee Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Sindhuja");
	}

	@AfterTest
	public void endReport() throws EmailException {
		extent.flush();
		send_email();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}
	@DataProvider
	public Object[][] employee_invalid_validations() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\Employee_data.xlsx", 1);
	}
	@Test(priority = 2)
	public void update_bank_primary() throws Exception
	{
		ExcelReaderbycolumnname reader=new ExcelReaderbycolumnname();
		String[] employee_name=reader.excelReader(file_path, 1, "employee_name".trim());
		String[] type=reader.excelReader(file_path, 1, "type");
		String [] bank_name=reader.excelReader(file_path, 1, "bank_name");
		test=extent.createTest("Employee Bank type updation as Pirmary");
		for(int i=0;i<employee_name.length;i++)
		{
			authpage=new AuthPage();
			emp=new employee_functions();
			emp.bank_edit_primary(employee_name[i], type[i], bank_name[i],test);
		}
		
		
	}
	@Test(priority = 1)
	public void employee_validations() throws IOException, InterruptedException
	{
		ExcelReaderbycolumnname reader=new ExcelReaderbycolumnname();
		String[] firstname=reader.excelReader(file_path, 0, "firstname");
		String[] lastname=reader.excelReader(file_path, 0, "lastname");
		String[] supervisior=reader.excelReader(file_path, 0, "supervisior");
		String[] email=reader.excelReader(file_path, 0, "email");
		String[] phone=reader.excelReader(file_path, 0, "phone");
		String[] fax=reader.excelReader(file_path, 0, "fax");
		String [] bank_details_name=reader.excelReader(file_path, 0, "bank_details_name");
		String [] payment_file_format=reader.excelReader(file_path, 0, "payment_file_format");
		String[] type=reader.excelReader(file_path, 0, "type");
		String[] account_number=reader.excelReader(file_path, 0, "account_number");
		String [] financial_institute_number=reader.excelReader(file_path, 0, "financial_institute_number");
		String[] bank_transit_numbr=reader.excelReader(file_path, 0, "bank_transit_number");
		String[] country=reader.excelReader(file_path, 0, "country");
		String[] address_phone=reader.excelReader(file_path, 0, "address_phone");
		String[] address=reader.excelReader(file_path, 0, "address");
		String[] city=reader.excelReader(file_path, 0, "city");
		String[] state=reader.excelReader(file_path, 0, "state");
		String[] zip=reader.excelReader(file_path, 0, "zip");		
		test=extent.createTest("Verifying Employee Creation");
		for(int i=0;i<firstname.length;i++)
		{
			authpage=new AuthPage();
			emp=new employee_functions();
			emp.employee_Creation(firstname[i], lastname[i], supervisior[i], email[i], phone[i], fax[i],bank_details_name[i],payment_file_format[i],type[i],account_number[i],financial_institute_number[i],bank_transit_numbr[i],country[i],address_phone[i],address[i],city[i],state[i],zip[i], test);
		}
	

		
	}
		
}

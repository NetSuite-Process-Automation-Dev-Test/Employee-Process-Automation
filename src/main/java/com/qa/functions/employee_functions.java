package com.qa.functions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.qa.util.TestBase;

public class employee_functions  extends TestBase{
	
	@FindBy(xpath = "//li[@id='ns-header-menu-main-item5']")
	WebElement lists;
	
	@FindBy(xpath = "//li[@data-title='Supply Chain']//following::li[@data-title='Employees']")
	List<WebElement> employees;
	
	@FindBy(xpath = "//li[@id='ns-header-menu-main-item40']")
	WebElement new_employee;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='fax']")
	WebElement fax;
	
	@FindBy(xpath = "//img[@id='inpt_supervisor2_arrow']")
	WebElement supervisior_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> drop_down_lists;
	
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement submit_employee;
	
	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement secondary_employee_save;	
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement employee_name;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement saved_successully;
	
	//employee bank details
	
	@FindBy(xpath = "//td[@id='custom492lnk']")
	WebElement bank_payment_details_tab;
	
	@FindBy(xpath = "//input[@value='New Entity Bank Details']")
	WebElement new_entity_bank_details;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement bank_details_name;
	
	@FindBy(xpath = "//img[@id='inpt_custpage_2663_entity_file_format1_arrow']")
	WebElement payment_file_format_arrow;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> payment_file_format_dropdown;
	
	@FindBy(xpath = "//img[@id='inpt_custrecord_2663_entity_bank_type2_arrow']")
	WebElement type_arrow;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> type_dropdown;
	
	@FindBy(xpath = "//input[@id='custrecord_2663_entity_acct_no']")
	WebElement bank_account_number;
	
	@FindBy(xpath = "//input[@id='custrecord_2663_entity_bank_no']")
	WebElement financial_institution_number;
	
	@FindBy(xpath = "//input[@id='custrecord_2663_entity_branch_no']")
	WebElement bank_transit_number;
	
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement submit_bank_details;
	
	
	//employee address
	
	@FindBy(xpath = "//td[@id='addresslnk']")
	WebElement address_tab;
	
	@FindBy(xpath = "//a[@id='addressbookaddress_helper_popup']")
	WebElement address_edit;
	
	@FindBy(xpath = "//img[@id='inpt_country1_arrow']")
	WebElement country_arrow;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> country_dropdown_list;
	
	@FindBy(xpath = "//input[@id='addrphone']")
	WebElement address_phone;
	
	@FindBy(xpath = "//input[@id='addr1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath = "//img[@id='inpt_dropdownstate2_arrow']")
	WebElement state_arrow;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> state_dropdown_list;
	
	@FindBy(xpath = "//input[@id='zip']")
	WebElement zip;
	
	@FindBy(xpath = "//input[@id='ok']")
	WebElement address_save;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[count(//td[@data-label='Job Title']//preceding-sibling::td)]")
	List<WebElement> employee_name_list;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[count(//td[@data-label='Internal ID']//preceding-sibling::td)]//a[@class='dottedlink viewitem']")
	List<WebElement> employee_view_link;
	
	@FindBy(xpath = "//table[@id='recmachcustrecord_2663_parent_employee__tab']//tbody//tr[contains(@id,'recmachcustrecord_2663_parent_employeerow')]//td[count(//div[@id='recmachcustrecord_2663_parent_employee__div']//td[@data-label='Type']//preceding-sibling::td)]")
	List<WebElement> bank_names_list;
	
	@FindBy(xpath = "//table[@id='recmachcustrecord_2663_parent_employee__tab']//tbody//tr[contains(@id,'recmachcustrecord_2663_parent_employeerow')]//td[count(//div[@id='recmachcustrecord_2663_parent_employee__div']//td[@data-label='Payment File Format']//preceding-sibling::td)]")
	List<WebElement> bank_type_list;
	
	@FindBy(xpath = "//table[@id='recmachcustrecord_2663_parent_employee__tab']//tbody//tr[contains(@id,'recmachcustrecord_2663_parent_employeerow')]//td[count(//div[@id='recmachcustrecord_2663_parent_employee__div']//td[@data-label='Name']//preceding-sibling::td)]//a")
	List<WebElement> bank_edit_link_list;
	
	
	JavascriptExecutor jsx = (JavascriptExecutor)driver;

	Actions action=new Actions(driver);
	
	public employee_functions()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean isAlertPresent_() {
		try {
			Alert a = new WebDriverWait(driver, 3).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}

	}
	public void navigate_to_employee() throws InterruptedException
	{
		action.moveToElement(lists).build().perform();
		Thread.sleep(2000);
		action.moveToElement(employees.get(0)).build().perform();
		Thread.sleep(2000);
		action.moveToElement(employees.get(1)).build().perform();
		Thread.sleep(2000);
		action.moveToElement(new_employee).click().build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
	}
	
	public void employee_Creation(String firstname2, String lastname2, String supervisior, String email2, String phone2, String fax2, String bank_details_name, String payment_file_format, String type, String account_number, String financial_institute_number, String bank_transit_numbr, String country, String address_phone2, String address, String city2, String state, String zip2, ExtentTest test) throws InterruptedException
	{
		String [] two_bank_name=new String[2];
		String[] two_type=new String[2];
		String[] two_payment_file_format=new String[2];
		String[] two_account=new String[2];
		String[] two_financial_number=new String[2];
		String[] two_transit_number=new String[2];
		for(int i=0;i<2;i++)
		{
		two_bank_name=bank_details_name.trim().split(",");	
		two_type=type.trim().split(",");
		two_payment_file_format=payment_file_format.trim().split(",");
		two_account=account_number.trim().split(",");
		two_financial_number=financial_institute_number.trim().split(",");
		two_transit_number=bank_transit_numbr.trim().split(",");
		}
		//ExtentTest test=test1.createNode("Employee data);
		boolean supervisior_flag=false;
		boolean email_flag=false;
		boolean phone_flag=false;
		boolean fax_flag=false;
		boolean country_flag=false;
		boolean address_phone_flag=false;
		boolean state_flag=false;
		boolean payment_file_format_flag=false;
		boolean type_flag=false;
		boolean error_flag_incorrect=false;
		boolean error_flag_no_data=false;
		navigate_to_employee();
		firstname.sendKeys(firstname2);
		lastname.sendKeys(lastname2);
		supervisior_arrow.click();
		Thread.sleep(2000);
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(supervisior.trim()))
			{
				drop_down_lists.get(i).click();
				supervisior_flag=true;
				break;
			}
		}
		if(supervisior_flag)
		{
			email.sendKeys(email2);
			action.sendKeys(Keys.TAB).build().perform();
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				email_flag=true;
				alert.accept();
				this.email.clear();
			}
			if(!email_flag)
			{
			this.phone.sendKeys(phone2);
			action.sendKeys(Keys.TAB).build().perform();
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				if(alert.getText().equals("Phone number should have seven digits or more."))
				{
					phone_flag=true;
				}
				alert.accept();
				this.phone.clear();
			}
			if(!phone_flag)
			{
			
			this.fax.sendKeys(fax2);
			action.sendKeys(Keys.TAB).build().perform();
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				if(alert.getText().equals("Phone number should have seven digits or more."))
				{
					fax_flag=true;
				}
				alert.accept();
				this.fax.clear();
				
			}
			if(!fax_flag)
			{
				address_tab.click();
				address_edit.click();
				driver.switchTo().frame("childdrecord_frame");
				Thread.sleep(2000);
				country_arrow.click();
				for(int i=0;i<country_dropdown_list.size();i++)
				{
					if(country_dropdown_list.get(i).getText().equals(country.trim()))
					{
						country_flag=true;
						country_dropdown_list.get(i).click();
						break;
						
					}
				}
				Thread.sleep(6000);
				if(country_flag)
				{
					this.address_phone.sendKeys(phone2.trim());
					action.sendKeys(Keys.TAB).build().perform();
					if(isAlertPresent_()==true)
					{
						Alert alert=driver.switchTo().alert();
						if(alert.getText().equals("Phone number should have seven digits or more."))
						{
							alert.accept();
							this.phone.clear();
							address_phone_flag=true;
							
						}
					}
					if(!address_phone_flag)
					{
						address1.sendKeys(address);
						city.sendKeys(city2);
						
						 try {	
						state_arrow.click();
						for(int i=0;i<state_dropdown_list.size();i++)
						{
							if(state_dropdown_list.get(i).getText().equals(state.trim()))
							{
								state_flag=true;
								state_dropdown_list.get(i).click();
								break;
							}
						}
						 }
						 catch(ElementNotInteractableException e)
						 {
							 
							 this.state.sendKeys(state);
							 state_flag=true;
						 }
						 if(state_flag)
						 {
							 zip.sendKeys(zip2);
								address_phone.click();
								Thread.sleep(3000);
								address_save.click();
							    driver.switchTo().defaultContent();
							    Thread.sleep(3000);
								jsx.executeScript("arguments[0].scrollIntoView(true);",secondary_employee_save);
								secondary_employee_save.click(); 
								
								for(int k=0;k<two_account.length;k++)
								{
									payment_file_format_flag=false;
									type_flag=false;
									error_flag_incorrect=false;
									error_flag_no_data=false;
								jsx.executeScript("arguments[0].scrollIntoView(true);",bank_payment_details_tab);
								Thread.sleep(2000);
								bank_payment_details_tab.click();
								Thread.sleep(2000);
								new_entity_bank_details.click();
								payment_file_format_arrow.click();
								for(int i=0;i<payment_file_format_dropdown.size();i++)
								{
						if(payment_file_format_dropdown.get(i).getText().equals(two_payment_file_format[k].trim()))
						{
							payment_file_format_flag=true;
							payment_file_format_dropdown.get(i).click();
							break;
						}
						
					}

				
					
					if(payment_file_format_flag)
					{
					this.bank_details_name.sendKeys(two_bank_name[k].trim());
					Thread.sleep(2000);
					type_arrow.click();
					for(int i=0;i<type_dropdown.size();i++)
					{
						if(type_dropdown.get(i).getText().equals(two_type[k].trim()))
						{
							type_flag=true;
							type_dropdown.get(i).click();
							break;
						}
					}
					if(type_flag)
					{
						bank_account_number.sendKeys(two_account[k].trim());
						financial_institution_number.sendKeys(two_financial_number[k].trim());
						bank_transit_number.sendKeys(two_transit_number[k].trim());
						submit_bank_details.click();
						String error_incorrect=null;
						String error_no_data=null;
						Thread.sleep(5000);
						if(isAlertPresent_()==true)
						{
							Alert alert=driver.switchTo().alert();
							if(alert.getText().contains("Please correct the values of the following fields before submitting the form:"))
							{
								error_flag_incorrect=true;
								error_incorrect=alert.getText();
								alert.accept();
							}
							else if (alert.getText().contains("Please enter value(s) for:"))
							{
								error_flag_no_data=true;
								error_no_data=alert.getText();
								alert.accept();
							}
							else
							{
								System.out.println("some other alert");
								alert.accept();
								Thread.sleep(2000);
								error_flag_incorrect=false;
							}
						}
						if(!error_flag_incorrect&&!error_flag_no_data)
						{
							test.pass("Bank Details are added Successfully with name "+two_bank_name[k]);
						}
						else
						{
							if(error_flag_incorrect)
							{
							test.fail(error_incorrect+" for "+two_bank_name[k]);
							break;
							}
							if(error_flag_no_data)
							{
								test.fail(error_no_data+" for "+two_bank_name[k]);
								break;
							}
						}
						
					}
					else
					{
						test.fail("Type is not present in the list....Please select type from the list");
						System.out.println("Type is incorrect");
						break;
					}
					}
					else
					{
						
						test.fail("Payment file format is incorrect...Please select Payment file format from the list");
						System.out.println("Payment file format is incorrect");
						break;
					}	
					
				}
								
								
								
								
						 }
						 else
						 {
							 test.fail("State is invalid...Please give correct state value");
							 System.out.println("State is incorrect");
						 }
						
						
					}
					else
					{
						test.fail(" Address Phone number is invalid...Please give correct phone number");
						System.out.println("Address phone number is invalid");
						
					}
					
					
				}
				else
				{
					test.fail("Country is not present in the list...Please select country from the list");
					System.out.println("Country is invalid");
				}
			}
			else
			{
				test.fail("Fax number is invalid...Please give valid fax number");
				System.out.println("Fax number is invalid");
			}
			}
	
	
			else
			{
				test.fail("Phone number is invalid..Please give valid phone number");
				System.out.println("Phone number is invalid");
			}
	
			}
			else
			{
				test.fail("Email is invalid...Please give valid email address");
				System.out.println("Email is invalid");
			}
		
		}
		else
		{
			System.out.println("Supervisior is not present in the list...Please select supervisior from the list");
			test.fail("Supervisior is not present in the list...Please select supervisior from the list");
		}
		if(phone_flag==false&&email_flag==false&&fax_flag==false&&supervisior_flag==true&&country_flag==true&&address_phone_flag==false&&state_flag==true)
		{
		
			test.pass(employee_name.getText()+" is created successfully");
			System.out.println("Employee is created successfully");
		}
		else
		{
			test.fail("Employee is not created");
		}
	}
	
	public void bank_edit_primary(String employee_name,String type,String bank_name,ExtentTest test) throws InterruptedException
	{
		boolean employee_found=false;
		driver.navigate().to("https://tstdrv939178.app.netsuite.com/app/common/entity/employeelist.nl");
		for(int i=0;i<employee_name_list.size();i++)
		{
			if(employee_name_list.get(i).getText().equals(employee_name.trim()))
			{
				employee_view_link.get(i).click();
				Thread.sleep(4000);
				employee_found=true;
				break;
			}
		}
		if(!employee_found)
		{
			test.fail("Given Employee is not found in the vendor list...Please give existing vendor");
		}
		jsx.executeScript("arguments[0].scrollIntoView(true);",bank_payment_details_tab);
		Thread.sleep(3000);
		boolean bank_found=false;
		boolean bank_type=false;
		bank_payment_details_tab.click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;     
		jse.executeScript("window.scrollBy(-1000,0)");
		Thread.sleep(3000);
		for(int i=0;i<bank_names_list.size();i++)
		{
			String bank_names=bank_names_list.get(i).getText().trim();
			if(bank_names.equals(bank_name.trim()))
			{
				bank_found=true;
				if(bank_type_list.get(i).getText().trim().equals(type.trim()))
				{
					bank_type=true;
				}
				else
				{
					test.pass(bank_name+" bank type before updating is: "+bank_type_list.get(i).getText());
					bank_edit_link_list.get(i).click();
					break;
				}
				
				
			}
			if(!bank_names_list.get(i).getText().equals(bank_name))
			{
				test.pass(bank_names_list.get(i).getText()+" bank type before updating is: "+bank_type_list.get(i).getText());
			}

			
		}
						
		
		if(!bank_found)
		{
			test.fail("Given Bank name is not found in the bank list");
		}
		if(bank_type)
		{
			test.fail("Given bank is already a primary bank");
		}
		if(bank_found&&!bank_type)
		{
			Thread.sleep(3000);
			type_arrow.click();
			for(int i=0;i<type_dropdown.size();i++)
			{
				if(type_dropdown.get(i).getText().equals(type.trim()))
				{
					type_dropdown.get(i).click();
					break;
				}
			}
			submit_bank_details.click();
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				alert.accept();		
			}
			Thread.sleep(5000);
			jsx.executeScript("arguments[0].scrollIntoView(true);",bank_payment_details_tab);
			Thread.sleep(3000);
			bank_payment_details_tab.click();
			Thread.sleep(1000);
			for(int i=0;i<bank_names_list.size();i++)
			{
				if(bank_names_list.get(i).getText().equals(bank_name.trim()))
				{
					if(bank_type_list.get(i).getText().trim().equals(type.trim()))
					{
						test.pass( bank_name+" type after updating is: "+bank_type_list.get(i).getText());
					}
					else
					{
						test.fail(bank_name+" Bank type is not updated as primary");
					}
	
				}
				if(!bank_names_list.get(i).getText().equals(bank_name))
				{
					if(bank_type_list.get(i).getText().trim().equals("Secondary"))
					{
						test.pass(bank_names_list.get(i).getText()+" bank type after updating is: "+bank_type_list.get(i).getText());
					}
					else
					{
						test.fail(bank_names_list.get(i).getText()+" bank type is not updated as Secondary ");
					}

					
				}
				
			}
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

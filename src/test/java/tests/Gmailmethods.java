package tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import junit.framework.Assert;
import pages.Forgotemailpage;
import pages.Homepage;
import pages.Loginpage;
import pages.Mailboxpage;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class Gmailmethods {
	public WebDriver driver;
	public Scenario s;
	Homepage hp;
	Forgotemailpage fp;
	Loginpage lp;
	Mailboxpage mp;
	public void screenshot(){
		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 s.embed(ss,"image/png");
	}
	@Before
	public void method1(Scenario s)
	{
		this.s=s;	
	}
	@Given("^launch gmail site$")
	public void method2() throws Exception
	{
		File f=new File("siva.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties ps=new Properties();
		ps.load(fis);
		System.setProperty("webdriver.chrome.driver",ps.getProperty("bdpath"));
		driver=new ChromeDriver();
		driver.get(ps.getProperty("url"));
		Thread.sleep(5000);
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		fp=new Forgotemailpage(driver);
		mp=new Mailboxpage(driver);
		}
	@Then("^title is \"(.*)\" for home page$")
	public void method3(String x) throws Exception
	{
		String t=driver.getTitle();
		Thread.sleep(5000);
		if(t.equals(x))
		{
			s.write("Title test was passed");
		}
		else
		{
			s.write("Title test was failed");
			this.screenshot();
			Assert.fail();
		}
	}
	@And("^close site$")
	public void method4()throws Exception
	{
		driver.close();
		Thread.sleep(3000);
	}
	@When("^click forgot email link$")
	public void method5()throws Exception
	{
		hp.clickforgotemail();
		Thread.sleep(5000);
	}
	@Then("^phone number or email is displayed$")
	public void method6()
	{
		if(fp.remail.isDisplayed())
		{
			s.write("Forgot email test was passed");
		}
		else
		{
			s.write("Forgot email test was failed");
			this.screenshot();
			Assert.fail();
		}
	}
	@When("^enter userid as \"(.*)\" value$")
	public void method7(String u)throws Exception
	{
		hp.filluid(u);
		Thread.sleep(5000);
	}
	@And("^click next button$")
	public void method8()throws Exception
	{
		hp.clickuidnext();
		Thread.sleep(5000);
	}
	@Then("^validate userid depends on criteria \"(.*)\" value$")
	public void method9(String c)
	{
		if(c.equalsIgnoreCase("valid") && lp.pwd.isDisplayed())
		{
			s.write("valid userid test was passed");
		}
		else if(c.equalsIgnoreCase("invalid"))
		{
			try
			{
				if(hp.uidblankerr.isDisplayed())
				{
					s.write("uid blank field test was passed");
				}
			}
			catch(Exception e)
			{
				try
				{
					if(hp.uidinvaliderr.isDisplayed())
					{
						s.write("invalid userid test was passed");
					}
				}
				catch(Exception ex)
				{
					s.write("userid test failed");
					this.screenshot();
					Assert.fail();
				}
			}
			
		}
		else
		{
			s.write("userid test failed");
			this.screenshot();
			Assert.fail();
		}
	}
	@When("^enter password as \"(.*)\" value$")
	public void method10(String p)
	{
		lp.fillpwd(p);
	}
	@And("^click password Next button$")
	public void method11()throws Exception
	{
		lp.clickpwdnext();
		Thread.sleep(5000);
	}
	@Then("^validate password depends on criteria \"(.*)\" value$")
	public void method12(String c)
	{
		if(c.equalsIgnoreCase("valid") && mp.comp.isDisplayed())
		{
			s.write("valid pwd test was passed");
		}
		else if(c.equalsIgnoreCase("invalid"))
		{
			try
			{
				if(lp.pwdblankerr.isDisplayed())
				{
					s.write("pwd blank field test was passed");
				}
			}
			catch(Exception e)
			{
				try
				{
					if(lp.pwdinvaliderr.isDisplayed())
					{
						s.write("invalid pwd test was passed");
					}
				}
				catch(Exception ex)
				{
					s.write("pwd test failed");
					this.screenshot();
					Assert.fail();
				}
			}
		}
		else
		{
			s.write("pwd test failed");
			this.screenshot();
			Assert.fail();
		}
	}
}

package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects extends BasePage {

	
	public LoginObjects(WebDriver driver) {
		super(driver);
		
	}

	private By  EmailTextBox =  By.xpath("//input[contains(@id, 'identifierId')]");
	
	
	private By EmailNextButton = By.xpath("//span[contains(text(),'Next')]"); 
    
	//div[@id='identifierNext']/div/button
	
	
	private By PasswordTextBox = By.xpath("//input[contains(@name,'Passwd')]");
	
	
	private By passwordNextButton = By.xpath("//div[@id='passwordNext']/div/button");
	// //div[@id='passwordNext']/div/button
	// //span[normalize-space()='Next'][1]
	
	private By GoogleAccountButton = By.xpath("//a[@class='gb_A gb_La gb_f']/img");
	
	private By VerifyLoginEmail = By.xpath("//a[@class='gb_A gb_La gb_f']"); 
	
	private By InboxLink = By.xpath("//div[@id=':lj']/div/div[2]/span/a");
	
	
	
	
	public void getLoginpage(String URL) {
		getURL(URL);
	}
	
	public void EnterUsernameNdClick(String Username) {
		
		GiveEmailId().sendKeys(Username);
		waitForEmailNextButtonPresent();
		ClickEmailNextButton();
		
	
		
	}
	
	public void EnterPasswordNdClick(String password) {
		
		waitForPsswdTextBoxPresent();
		ClickUntilElementPresent(GivePassword());
		GivePassword().sendKeys(password);
		waitForPsswdNextButtonPresent();
		ClickpasswordNextButton();
	}
	
	
	public String GetGmailHomeTitle() {
		return getPageTitle();
	}
	
	public String getAttributeGoogleAccount() {
		return getElement(VerifyLoginEmail).getAttribute("aria-label");
		
	}
	
	public String getImageGoogleAccount() {
		return getElement(GoogleAccountButton).getAttribute("src");
		
	}
	
	public String getInboxLink() {
		return getElement(InboxLink).getAttribute("href");
		
	}
	
	public WebElement GiveEmailId() {
		return getElement(EmailTextBox);
	}
	
	public void ClickEmailNextButton() {
		 getElement(EmailNextButton).click();;
	}
	
	public WebElement GivePassword() {
		return getElement(PasswordTextBox);
	}
	
	public void ClickpasswordNextButton() {
		 getElement(passwordNextButton).click();;
	}
	
	public void waitForPsswdTextBoxPresent() {
		waitForElementPresent(PasswordTextBox);
	}
	
	public void waitForPsswdNextButtonPresent() {
		waitForElementPresent(passwordNextButton);
	}
	
	public void waitForEmailNextButtonPresent() {
		waitForElementPresent(EmailNextButton);
	}
	
	public void ClickUntilElementPresent(WebElement element) {
		
		try {
			if(element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element");
				element.click();
			}
			else {
				System.out.println("Unable to click on element");
			}
		}catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

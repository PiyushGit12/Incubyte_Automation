package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeObjects extends BasePage {

	protected ComposeObjects(WebDriver driver) {
		super(driver);
}

	
	
	private By composeButton = By.cssSelector(".T-I.T-I-KE.L3");

	private By ComposerHeaderName = By.xpath("//h2[@class='a3E']/div[2]/span");
	
	private By MinimizeButton = By.xpath("//td[@class='Hm']/img[1]");
	
	private By MaximizeButton = By.xpath("//td[@class='Hm']/img[2]");
	
	private By CloseButton = By.xpath("//td[@class='Hm']/img[3]");
	
	private By RecipientsTO = By.xpath("//div[@peoplekit-id='P3anae']/div/div/div/div/input");
	
	private By SubjectLine = By.xpath("//input[@name='subjectbox']");
	
	private By EmailBody = By.xpath("//div[@class='Ar Au']/div");
	
	//private By FullEmailBody = By.xpath("//table[@class='iN']/tbody/tr[1]");
	
	private By AttachmentButton = By.xpath("//td[@class='a8X gU']/div/div[1]/div/div/div");
	
	private By AttachmentClose_Button = By.xpath("//div[@class='dL']/div");
	
	private By Attachment_Text = By.xpath("//div[@class='dL']/div");
	
	private By Attachment_Text_Size = By.xpath("//div[@class='dL']/a/div[2]");
	

	
	private By CC_Button = By.xpath("//div[@class='wO nr l1']/div[2]/span/span/span[1]");
	
	private By CC_textBox = By.xpath("//table[@class='GS']/tbody/tr[2]/td[2]/div/div/div/div/div[3]/div/div/div/div/div/input");
	
	private By BCC_Button = By.xpath("//div[@class='wO nr l1']/div[2]/span/span/span[2]");
	
	private By BCC_textBox = By.xpath("//table[@class='GS']/tbody/tr[3]/td[2]/div/div/div/div/div[3]/div/div/div/div/div/input");
	
	private By SendButton = By.xpath("//div[@class='dC']/div[1]");
	
	private By Sent_Button = By.xpath("//a[normalize-space()='Sent']");
	
	private By Sent_Email = By.xpath("//div[@class='ae4 UI nH oy8Mbf']/div[1]/div[1]/table/colgroup[1]/col[11]");  //incomplete
	
	
	String file="C:\\Users\\Piyush\\Downloads\\Test_Upload_File.txt";
		
	
	public void ComposeButtonIsClickable() {
		
		try {
			if(getElement(composeButton).isEnabled() && getElement(composeButton).isDisplayed()) {
				System.out.println("Clicking on element");
				waitForcomposeButtonPresent();
				getElement(composeButton).click();
			}
			else {
				System.out.println("Unable to click on element");
			}
		}catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
			
		}
		
	}
	
	public void getInboxUrl(String URL) {
		getURL(URL);
	}
	
	public void waitForcomposeButtonPresent() {
		waitForElementPresent(composeButton);
	}
	
	
	
	public String getComposerHeaderName() {
		return getElement(ComposerHeaderName).getText();
	}
	

	public WebElement MinimizeButton() {
		return getElement(MinimizeButton);
	}
	
	public WebElement MaximizeButton() {
		return getElement(MaximizeButton);
	}
	
	public WebElement CloseButton() {
		 return getElement(CloseButton);
			
	}
	
	public WebElement SendButton() {
		 return getElement(SendButton);
			
	}
	
	public WebElement Sent_Button() {
		 return getElement(Sent_Button);
			
	}
	
	public WebElement Sent_Email_Box() {
		 return getElement(Sent_Email);
			
	}
	
	
	
	public boolean DisplaySendButton() {
		return getElement(SendButton).isDisplayed() && getElement(SendButton).isEnabled();
	}
	
	public boolean DisplayRecipientsTOTextBox() {
		return getElement(RecipientsTO).isDisplayed() && getElement(RecipientsTO).isEnabled();
	}
	
	public boolean SubjectBoxEnabled() {
		return getElement(SubjectLine).isEnabled() && getElement(SubjectLine).isDisplayed();
	}
	
	public boolean EmailBodyEnabled() {
		return getElement(EmailBody).isEnabled() && getElement(EmailBody).isDisplayed();
	}
	
	public boolean AttachmentButtonEnabled() {
		return getElement(AttachmentButton).isEnabled() && getElement(AttachmentButton).isDisplayed();
	}
	
	
	public void addEmail_Id() {
		getElement(RecipientsTO).sendKeys("ashu123@gmail.com");
	}
	
	public WebElement TORecipients() {
		return getElement(RecipientsTO);
	}
	
	public WebElement CC_Recipients_Button() {
		return getElement(CC_Button);
	}
	
	public WebElement CC_Recipients_Text() {
		return getElement(CC_textBox);
	}
	
	public WebElement BCC_Recipients_Button() {
		return getElement(BCC_Button);
	}
	
	public WebElement BCC_Recipients_Text() {
		return getElement(BCC_textBox);
	}
	
	public WebElement Email_Body() {
		return getElement(EmailBody);
	}
	
	public WebElement AttachmentButton() {
		return getElement(AttachmentButton);
	}
	
	public String Attachment_Text() {
		return getElement(Attachment_Text).getAttribute("aria-label");
	}
	
	public WebElement Attachment_Text_Size() {
		return getElement(Attachment_Text_Size);
	}
	
	public WebElement AttachmentClose_Button() {
		return getElement(AttachmentClose_Button);
	}
	

	
	public void EnterEmailIDs_Recipients_TO(String EmailId) {
		TORecipients().click();
		TORecipients().sendKeys(EmailId);
	}
	
	public void EnterEmailIDs_Recipients_CC(String EmailId) {
		CC_Recipients_Button().click();
		CC_Recipients_Text().sendKeys(EmailId);
	}
	
	public void EnterEmailIDs_Recipients_BCC(String EmailId) {
		BCC_Recipients_Button().click();
		BCC_Recipients_Text().sendKeys(EmailId);
	}
	
	public String RecipientsTextCapture() {
		return getElement(RecipientsTO).getText();
	}
	
	public void Email_Body_Text() {
		getElement(EmailBody).sendKeys("Hi Automation Testing this is  Email Body");
	}
	
	public String Email_Body_TextCapture() {
		return getElement(EmailBody).getText();
	}
	
	public void Upload_Attachment_File() {
		getElement(AttachmentButton).click();
		getElement(AttachmentButton).sendKeys(file);
	}
	
	public void SubjectLineText() {
		
		getElement(SubjectLine).click();
		getElement(SubjectLine).sendKeys("Subject Line is:-  Automation_Testing");
		
		
	}
	
	public void SendEmail_In_Sent_Box() {
		
		Sent_Button().click();
		Sent_Email_Box();
		
	}
	
	
}

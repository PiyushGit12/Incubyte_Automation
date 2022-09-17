package Incubyte_StepDefinitions;


import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import POM.BasePage;
import POM.ComposeObjects;
import POM.LoginObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ComposeEmailSteps extends BaseTest {

	
	String email= prop.getProperty("Email_ID");
	String password = prop.getProperty("password");
	String Recipients_TO_Id = prop.getProperty("Recipients_TO_Id");
	String Recipients_CC_Id = prop.getProperty("Recipients_CC_Id");
	String Recipients_BCC_Id = prop.getProperty("Recipients_BCC_Id");
	


	@Before
	public void setup_Browser(Scenario sc) {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--profile-directory=Default");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-plugins-discovery");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		options.addArguments("--user-data-dir=C:/Users/{Username}/AppData/Local/Google/Chrome/User Data/Profile {#}");
		
		driver = new ChromeDriver(options);
		System.out.println("******** Launching Chrome Browser*******");
		System.out.println("Name of the Scenario:-" + sc.getName());

		page = new BasePage(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
	
//	********* TC_001  ************ Started******************	
	
	@Given("^User Should be on Login Page$")
	public void user_should_be_on_login_page() {

		page.getInstance(LoginObjects.class).getLoginpage("https://accounts.google.com/signin");
	}

	@When("^Enter Valid username and click next button$")
	public void Enter_Valid_username_and_click_next_button() {
		
		page.getInstance(LoginObjects.class).EnterUsernameNdClick(email);
		
	}

	@And("^Enter Valid password and click next button$")
	public void Enter_Valid_password_and_click_next_button() {


		page.getInstance(LoginObjects.class).EnterPasswordNdClick(password);
		System.out.println("Login SuccessFull");
	}

	@Then("^User Should be Successful Login$")
	public void user_should_be_successful_login() {

		String HomePageTitle = page.getInstance(LoginObjects.class).GetGmailHomeTitle();
		System.out.println("HomePageTitle is:-> " + HomePageTitle);

		String getGoogleAccountName = page.getInstance(LoginObjects.class).getAttributeGoogleAccount();
		System.out.println("getGoogleAccountName is-> " + getGoogleAccountName);

		String ImageLogo = page.getInstance(LoginObjects.class).getImageGoogleAccount();
		System.out.println("ImageLogo is -> " + ImageLogo);
	}

	@And("^Gmail Inbox should be shown$")
	public void gmail_inbox_should_be_shown() {

		String InboxLink = page.getInstance(LoginObjects.class).getInboxLink();
		System.out.println("InboxLink is -> " + InboxLink);
		
	}

	
	
//	********* TC_002  ************ Started******************

	@Given("Click on Compose Button visible on the top-left corner in Home page.")
	public void click_on_compose_button_visible_on_the_top_left_corner_in_home_page() {

	
		page.getInstance(ComposeObjects.class).ComposeButtonIsClickable();

	}

	@When("A new popup should be displayed with the headers as a new message.")
	public void a_new_popup_should_be_displayed_with_the_headers_as_a_new_message() {

		String ComposerHeaderName = page.getInstance(ComposeObjects.class).getComposerHeaderName();
		System.out.println("ComposerHeaderName:- " + ComposerHeaderName);
		Assert.assertEquals(ComposerHeaderName, "New Message");
	}

	@Then("A popup should contain Recipients,subject,email body,maximize,minimize button and send button gets displayed.")
	public void a_popup_should_contain_recipients_subject_email_body_maximize_minimize_button_and_send_button_gets_displayed() {

		boolean DisplayMinimizeButton = page.getInstance(ComposeObjects.class).MinimizeButton().isDisplayed();
		System.out.println("DisplayMinimizeButton is:->" + DisplayMinimizeButton);
		// Assert.assertEquals(DisplayMinimizeButton, true);

		boolean DisplayMaximizeButton = page.getInstance(ComposeObjects.class).MaximizeButton().isDisplayed();
		System.out.println("DisplayMaximizeButton is Enabled:-> " + DisplayMaximizeButton);

		boolean DisplayCloseButton = page.getInstance(ComposeObjects.class).CloseButton().isDisplayed();
		System.out.println("DisplayCloseButton is Enabled:-> " + DisplayCloseButton);

		boolean DisplayRecipientsTOTextBox = page.getInstance(ComposeObjects.class).DisplayRecipientsTOTextBox();
		System.out.println("DisplayRecipientsTOTextBox is Enabled :-> " + DisplayRecipientsTOTextBox);

		boolean SubjectBoxEnabled = page.getInstance(ComposeObjects.class).SubjectBoxEnabled();
		System.out.println("SubjectBoxEnabled is :-> " + SubjectBoxEnabled);

		boolean EmailBodyEnabled = page.getInstance(ComposeObjects.class).EmailBodyEnabled();
		System.out.println("EmailBodyEnabled is :-> " + EmailBodyEnabled);

		boolean AttachmentButtonEnabled = page.getInstance(ComposeObjects.class).AttachmentButtonEnabled();
		System.out.println("AttachmentButtonEnabled is  :-> " + AttachmentButtonEnabled);

		boolean DisplaySendButton = page.getInstance(ComposeObjects.class).DisplaySendButton();
		System.out.println("DisplaySendButton is Enabled :-> " + DisplaySendButton);

	}

//	********* TC_003  ************ Started******************
	
	
	@Given("Click on Recipients TextBox and enter Email ids")
	public void click_on_recipients_text_box_and_enter_email_ids() {
	    

		page.getInstance(ComposeObjects.class).EnterEmailIDs_Recipients_TO(Recipients_TO_Id);
	}

	@And("Click on CC and add email ids")
	public void click_on_cc_and_add_email_ids() {
	    
		page.getInstance(ComposeObjects.class).EnterEmailIDs_Recipients_CC(Recipients_CC_Id);
		
	}

	@And("Click on Bcc and add email ids")
	public void click_on_bcc_and_add_email_ids() {
		
		page.getInstance(ComposeObjects.class).EnterEmailIDs_Recipients_BCC(Recipients_BCC_Id);
	    
	}

	@Then("Provided Email ids should be visible in the Recipient TextBox")
	public void provided_email_ids_should_be_visible_in_the_recipient_text_box() {
	    
		String RecipientsTextCapture = page.getInstance(ComposeObjects.class).RecipientsTextCapture();
		System.out.println("Recipients Email Ids:-" + RecipientsTextCapture);
		
	}
	
//	********* TC_004  ************ Started******************
	
	@Given("Click on Recipients TextBox and enter Email ids with comma seperated")
	public void click_on_recipients_text_box_and_enter_email_ids_with_comma_seperated() {
	    
		page.getInstance(ComposeObjects.class).EnterEmailIDs_Recipients_TO(Recipients_TO_Id);
		page.getInstance(ComposeObjects.class).TORecipients().sendKeys(Recipients_TO_Id);
		page.getInstance(ComposeObjects.class).TORecipients().sendKeys(Recipients_TO_Id);
		
	}

	@And("Click on CC and add email ids with comma seperated")
	public void click_on_cc_and_add_email_ids_with_comma_seperated() {
		
		page.getInstance(ComposeObjects.class).EnterEmailIDs_Recipients_CC(Recipients_CC_Id);
		page.getInstance(ComposeObjects.class).CC_Recipients_Text().sendKeys(Recipients_CC_Id);
		page.getInstance(ComposeObjects.class).CC_Recipients_Text().sendKeys(Recipients_CC_Id);
		
	    
	}

	@And("Click on Bcc and add email ids with comma seperated")
	public void click_on_bcc_and_add_email_ids_with_comma_seperated() {
		
		page.getInstance(ComposeObjects.class).EnterEmailIDs_Recipients_BCC(Recipients_BCC_Id);
		page.getInstance(ComposeObjects.class).BCC_Recipients_Text().sendKeys(Recipients_BCC_Id);
		page.getInstance(ComposeObjects.class).BCC_Recipients_Text().sendKeys(Recipients_BCC_Id);
	    
	}
	
//	********* TC_005  ************ Started******************
	

	@Given("Click on  email-body section and type some Text.")
	public void click_on_email_body_section_and_type_some_text() {
	   
		page.getInstance(ComposeObjects.class).Email_Body_Text();
		
	}

	@Then("Provided email-body should be visible in the email-body TextBox.")
	public void provided_email_body_should_be_visible_in_the_email_body_text_box() {
	    
		String Email_Body_TextCapture = page.getInstance(ComposeObjects.class).Email_Body_TextCapture();
			System.out.println("Email Body Text Captured:-  " + Email_Body_TextCapture);
		
	}

//	********* TC_006  ************ Started******************
	
	@Given("Click on attachment button and system window gets open")
	public void click_on_attachment_button_and_system_window_gets_open() {
	   
		page.getInstance(ComposeObjects.class).AttachmentButton().click();
		
	}

	@And("Select any file from windows and click on Open button shown in bottom")
	public void select_any_file_from_windows_and_click_on_open_button_shown_in_bottom() {
	    
		page.getInstance(ComposeObjects.class).Upload_Attachment_File();
		
		
	}

	@Then("Uploaded File should be shown in Email body with size and remove button")
	public void uploaded_file_should_be_shown_in_email_body_with_size_and_remove_button() {
	    
		String Attachment_File_Capture  = page.getInstance(ComposeObjects.class).Attachment_Text();
		System.out.println("Attachment_FileName_Captured:- " + Attachment_File_Capture);
		
		String Attachment_Text_Size = page.getInstance(ComposeObjects.class).Attachment_Text_Size().getText();
		System.out.println("Attachment_File upload Size is:- " +Attachment_Text_Size);
		
		
		boolean Attachment_Close_Button_Displayed = page.getInstance(ComposeObjects.class).AttachmentClose_Button().isDisplayed();
		System.out.println("Attachment_Close_Button_Displayed:- " +Attachment_Close_Button_Displayed);
		
		
		
	}
//	********* TC_007  ************ Started******************
	
	@Given("Click on Subject Line and type some text")
	public void click_on_subject_line_and_type_some_text() {
	    
		page.getInstance(ComposeObjects.class).SubjectLineText();
		
	}

	@And("Click on email body and Type some Body")
	public void click_on_email_body_and_type_some_body() {
	    
		page.getInstance(ComposeObjects.class).Email_Body_Text();
		
	}

	@And("Click on Send Button")
	public void click_on_send_button() {
	    
		page.getInstance(ComposeObjects.class).SendButton().click();
	}

	@Then("Sent Email should be in Sent Mail Section Box")
	public void sent_email_should_be_in_sent_mail_section_box() {
	    
		page.getInstance(ComposeObjects.class).SendEmail_In_Sent_Box();
		
	}
	
//	********* TC_008  ************ Started******************

	@Given("Click on Close Button")
	public void click_on_close_button() {
	    
		page.getInstance(ComposeObjects.class).CloseButton().click();
		
	}

	@Then("The Email shown in Draft section and User should be able to rewrite it and sent to the intended Recipient")
	public void the_email_shown_in_draft_section_and_user_should_be_able_to_rewrite_it_and_sent_to_the_intended_recipient() {
	    
		
		
	}

	@After
	public void tearDown_Close(Scenario sc) {

		driver.quit();
		System.out.println("******** Quitting Chrome Browser*******");
		System.out.println("Status of the Scenario:-" + sc.getStatus());

	}


}

Feature: Test Copmpose Functionality for Gmail account 

# TC_001

@Login
Scenario: 
	Verify if a user will be able to login with a valid username and valid password 
	Given     User Should be on Login Page 
	When      Enter Valid username and click next button 
	And       Enter Valid password and click next button 
	Then      User Should be Successful Login 
	And       Gmail Inbox should be shown 
	
	# TC_002
@compose_Tc_002
Scenario: 
	Verify that on clicking compose button a frame to compose a mail gets displayed. 
	Given     Click on Compose Button visible on the top-left corner in Home page. 
	When      A new popup should be displayed with the headers as a new message. 
	Then      A popup should contain Recipients,subject,email body,maximize,minimize button and send button gets displayed. 
	
	# TC_003	
Scenario: Verify that user can enter email ids in To,cc and bcc sections 
	Given     Click on Recipients TextBox and enter Email ids 
	And       Click on CC and add email ids 
	And       Click on Bcc and add email ids 
	Then      Provided Email ids should be visible in the Recipient TextBox 
	
	
	# TC_004
Scenario: 
	Verify that user can enter multiple comma-seperated email ids in To,cc and bcc sections 
	Given     Click on Recipients TextBox and enter Email ids with comma seperated 
	And       Click on CC and add email ids with comma seperated 
	And       Click on Bcc and add email ids with comma seperated 
	Then      Provided Email ids should be visible in the Recipient TextBox 
	
	
	# TC_005
Scenario: Verify that user can type the email in the email-body section 
	Given     Click on  email-body section and type some Text. 
	Then      Provided email-body should be visible in the email-body TextBox. 
	
	# TC_006
Scenario: Verify that user can attach file as an attachment to the email 
	Given     Click on attachment button and system window gets open 
	And       Select any file from windows and click on Open button shown in bottom 
	Then      Uploaded File should be shown in Email body with size and remove button 
	
	# TC_007
Scenario: 
	Verify that after entering email ids in either of the To,cc,Bcc sections, entering Subject line ,mail body and clicking send button, mail gets delivered to intended receivers. 
	Given     Click on Recipients TextBox and enter Email ids 
	And       Click on CC and add email ids 
	And       Click on Bcc and add email ids 
	And       Click on Subject Line and type some text 
	And       Click on email body and Type some Body 
	And       Click on Send Button 
	Then      Sent Email should be in Sent Mail Section Box 
	
	
	#TC_008
Scenario: 
	Verify that the emails composed but not sent remain in the draft section 
	Given     Click on Recipients TextBox and enter Email ids 
	And       Click on CC and add email ids 
	And       Click on Bcc and add email ids 
	And       Click on Subject Line and type some text 
	And       Click on email body and Type some Body 
	And       Click on Close Button 
	Then      The Email shown in Draft section and User should be able to rewrite it and sent to the intended Recipient 
	
	
	
	
	
	
	
	
	
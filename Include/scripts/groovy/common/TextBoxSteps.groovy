package common
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.testng.annotations.BeforeTest
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class TextBoxSteps {


	@Given("User is on the Text Box page")
	def user_is_on_the_text_box_page() {
		WebUI.openBrowser('')
        WebUI.navigateToUrl('https://demoqa.com/text-box')

	}

	@When("User fills all fields with valid data")
	def user_fills_all_fields_with_valid_data() {
		WebUI.setText(findTestObject('Elements/TextBox/Input_FullName'), 'Nizam Aditya')

		WebUI.setText(findTestObject('Elements/TextBox/Input_UserEmail'), 'nizam@demoqa.com')

		WebUI.setText(findTestObject('Elements/TextBox/Input_CurrentAddress'), 'jalan imam bonjol')

		WebUI.setText(findTestObject('Elements/TextBox/Input_PermanentAddress'), 'jalan ir soekarno')
	}

	@And("User clicks the Submit button")
	def user_clicks_the_submit_button() {
		WebUI.click(findTestObject('Elements/TextBox/btn_Submit'))
	}

	@Then("The result should display the entered name {string}")
	def the_result_should_display_the_entered_name(String ExpectedName) {
		WebUI.waitForElementPresent(findTestObject('Elements/TextBox/output_Name'), 0)

		String nameText = WebUI.getAttribute(findTestObject('Elements/TextBox/output_Name'), 'textContent')

		WebUI.verifyMatch(nameText, ".*${ExpectedName}.*", true)
	}
	
	@When("User fills only the Full Name field")
	def fill_only_name(){
		WebUI.setText(findTestObject('Elements/TextBox/Input_FullName'), 'Nizam Aditya')
	}
	
	@Then("The result section should not appear")
	def result_not_appear(){
		WebUI.verifyElementNotPresent(findTestObject('Elements/TextBox/output_Name'), 2)
	}
	
	@When("User fills but incorrect email format")
	def incorrect_email_format() {
		WebUI.setText(findTestObject('Elements/TextBox/Input_FullName'), 'Nizam Aditya')
		
		WebUI.setText(findTestObject('Elements/TextBox/Input_UserEmail'), 'nizam@demoqa')
		
		WebUI.setText(findTestObject('Elements/TextBox/Input_CurrentAddress'), 'jalan imam bonjol')
		
		WebUI.setText(findTestObject('Elements/TextBox/Input_PermanentAddress'), 'jalan ir soekarno')
	}
	
	@Then("The email field should be marked as error")
	def email_should_be_error() {
//		emailClass = WebUI.getAttribute(findTestObject('Elements/TextBox/Input_UserEmail'), 'class')
//		
//		WebUI.verifyMatch(emailClass, '.*field-error.*', true, FailureHandling.STOP_ON_FAILURE)
		
		TestObject emailInput = findTestObject('Elements/TextBox/Input_UserEmail')
		
		WebUI.waitForElementPresent(emailInput, 5)
		
		String emailClass = WebUI.getAttribute(emailInput, 'class')
		println "DEBUG: emailClass = ${emailClass}"
		
		assert emailClass != null : "emailClass is null! Elemen tidak ditemukan atau tidak punya atribut class."
		
		WebUI.verifyMatch(emailClass, '.*field-error.*', true, FailureHandling.STOP_ON_FAILURE)
	}
}
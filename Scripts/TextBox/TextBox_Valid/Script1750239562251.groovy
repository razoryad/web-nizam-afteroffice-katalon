import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://demoqa.com')

WebUI.waitForElementClickable(findTestObject('Elements/btn_Elements'), 0)

WebUI.click(findTestObject('Elements/btn_Elements'))

WebUI.waitForElementClickable(findTestObject('Elements/TextBox/btn_TextBox'), 0)

WebUI.click(findTestObject('Elements/TextBox/btn_TextBox'))

WebUI.waitForElementVisible(findTestObject('Elements/TextBox/Input_FullName'), 0)

WebUI.setText(findTestObject('Elements/TextBox/Input_FullName'), 'Nizam Aditya')

WebUI.setText(findTestObject('Elements/TextBox/Input_UserEmail'), 'nizam@demoqa.com')

WebUI.setText(findTestObject('Elements/TextBox/Input_CurrentAddress'), 'jalan imam bonjol')

WebUI.setText(findTestObject('Elements/TextBox/Input_PermanentAddress'), 'jalan ir soekarno')

WebUI.click(findTestObject('Elements/TextBox/btn_Submit'))

WebUI.waitForElementPresent(findTestObject('Elements/TextBox/output_Name'), 0)

String nameText = WebUI.getAttribute(findTestObject('Elements/TextBox/output_Name'), 'textContent')

WebUI.verifyMatch(nameText, '.*Nizam.*', true)

emailText = WebUI.getAttribute(findTestObject('Elements/TextBox/output_Email'), 'textContent')

WebUI.verifyMatch(emailText, '.*nizam.*', true)

WebUI.closeBrowser()


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
import java.nio.file.*

WebUI.openBrowser(GlobalVariable.baseUrl)

WebUI.click(findTestObject('Elements/btn_Elements'))

WebUI.click(findTestObject('Elements/Upload and Download/btn_UploadAndDownload'))

WebUI.click(findTestObject('Elements/Upload and Download/btn_Download'))

WebUI.delay(3)

String downloadPath = 'C:\\Users\\nizam\\Downloads\\sampleFile.jpeg' // ganti sesuai sistemmu

File file = new File(downloadPath)

if (file.exists()) {
    println('File ditemukan: ' + file.getName())
} else {
    KeywordUtil.markFailed('❌ File belum terunduh.')
}

file.delete()

println('File dihapus setelah test.')


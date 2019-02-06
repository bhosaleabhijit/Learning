package java.oWeb;

import org.testng.annotations.Test;

import oWeb.helper.browserConfig.config.ObjectReader;
import oWeb.helper.excel.ExcelHelper;
import oWeb.helper.resource.ResourceHelper;
import oWeb.pageObjects.selfMe.orgWeb.SignUp;
import oWeb.testBase.TestBase;

public class SignUpTest extends TestBase {
	Object[][] signUpData = null;
	String url = null;
	SignUp signUpPage = null;

	@Test(description = "initializing SignUpData")
	public void initializeSignUpPageTest() {
		ExcelHelper excelHelper = new ExcelHelper();
		signUpData = excelHelper.getExcelData(ResourceHelper.getResourcePath("/src/main/resources/TestData.xlsx"),
				"SignUp");

		signUpPage = new SignUp(driver);

		url = ObjectReader.reader.getBaseURL();
		driver.get(url);

	}

	@Test(description = "Verifying all requierd fields are marked with asterisk.")
	public void verifyRequiredFieldsMarkedWithAsterisk() {

		signUpPage.clearAllFormData();

		if (signUpPage.getOrganizationFieldText().contains("*") && signUpPage.getFirstNameFieldText().contains("*")
				&& signUpPage.getLastNameFieldText().contains("*")
				&& signUpPage.getEmailAddressFieldText().contains("*")
				&& signUpPage.getPhoneNumberFieldText().contains("*") && signUpPage.getPasswordFieldText().contains("*")
				&& signUpPage.getConfirmPasswordFieldText().contains("*")) {
			AssertHelper.markTrue();
		} else {
			AssertHelper.markFalse();
		}

	}

}

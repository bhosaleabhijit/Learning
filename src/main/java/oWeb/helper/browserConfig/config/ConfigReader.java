package oWeb.helper.browserConfig.config;

import org.openqa.selenium.remote.BrowserType;

public interface ConfigReader {
	public int getImplicityWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getBaseURL();

}

package com.vitalii.vitaliiFramework2.listeners;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.vitalii.vitaliiFramework2.driver.DriverFactory;

public class ScreenshotListener extends TestListenerAdapter {

	private Logger logger;
	
	public ScreenshotListener() {
		this.logger = Logger.getLogger(ScreenshotListener.class);
	}
	
	private boolean createFile(File screenshot) throws IOException {
		boolean fileCreated = false;
		if (screenshot.exists()) {
			fileCreated = true;
		} else {
			File parentDirectory = new File(screenshot.getParent());
			if (parentDirectory.exists() || parentDirectory.mkdirs()) {
				fileCreated = screenshot.createNewFile();
			}
		}
		return fileCreated;
	}

	//private void writeScreenshotToFile(WebDriver driver, File screenshot)
	private void writeScreenshotToFile(File screenshot) throws IOException {
		FileOutputStream screenshotStream = new FileOutputStream(screenshot);
		try {
			screenshotStream.write(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshotStream.close();
	}

	@Override
	public void onTestFailure(ITestResult failingTest) {
		try {
			//WebDriver driver = getDriver();
			String screenshotDirectory = System.getProperty("user.dir") + "\\target\\screenshots";
			String screenshotAbsolutePath = screenshotDirectory	+ File.separator + System.currentTimeMillis() + "_"	+ failingTest.getName() + ".png";
			File screenshot = new File(screenshotAbsolutePath);
			if (createFile(screenshot)) {
				try {
					//writeScreenshotToFile(driver, screenshot);
					writeScreenshotToFile(screenshot);
				} catch (ClassCastException weNeedToAugmentOurDriverObject) {
					//writeScreenshotToFile(new Augmenter().augment(DriverFactory.getDriver()),
							writeScreenshotToFile(screenshot);
				}
				logger.warn("Written screenshot to "	+ screenshotAbsolutePath);
			} else {System.err.println("Unable to create " + screenshotAbsolutePath);
			}
		} catch (Exception ex) {
			System.err.println("Unable to capture screenshot...");
			ex.printStackTrace();
		}
	}
}

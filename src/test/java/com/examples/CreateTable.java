package com.examples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class CreateTable {

    private static WebDriver driver;
    private static SQLEditor sqlEditorPage;

    private String statement1 = "SELECT * FROM [Categories]";

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
        driver = new ChromeDriver(options);
        sqlEditorPage = new SQLEditor(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test(description = "Run a simple sql statement", groups = {"simple","checklist critico"})
    public void testMethod() throws InterruptedException{
        sqlEditorPage.runSQL(statement1);
    }
}
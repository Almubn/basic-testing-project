package com.examples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.xpath.XPathResult;

public class SQLEditor {

    public static WebDriverWait wait;
    public static WebDriver driver;

    //webElements
    @FindBy(xpath = "//*[@id=\"tryitform\"]/div/div[6]/div[1]/div/div/div/div[5]/pre[1]")
    private WebElement textAreaCodeSQL;

    @FindBy(xpath = "//button[@class='w3-green w3-btn']")
    private WebElement runButton;

    public SQLEditor(WebDriver d2){
        driver = d2;
        PageFactory.initElements(driver, this);
    }

    public void runSQL(String product) {
        driver.get("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_distinct");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.evaluate('//*[@id=\"tryitform\"]/div/div[6]/div[1]/div/div/div/div[5]/pre[1]/span', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.innerHTML = \"CREATE TABLE table_name (ColumnOne int, ColumnTwo string, ColomnThree datetime)\";");
        runButton.click();
    }


    public void checkTableCreated(){

    }
}
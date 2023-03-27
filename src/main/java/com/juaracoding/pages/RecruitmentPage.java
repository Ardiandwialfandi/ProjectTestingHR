package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecruitmentPage {

    private WebDriver driver;
    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    public JavascriptExecutor js;

    DateFormat tanggal = new SimpleDateFormat("MM-dd-yyyy");
    Date hariini = new Date();
    String dateNow = tanggal.format(hariini);
    @FindBy (xpath= "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[5]/a[1]")
    WebElement btnrecrruitment;
        @FindBy( xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
                WebElement btnAdd;
        @FindBy( name ="firstName")
                WebElement firstName;
        @FindBy( name = "middleName")
                WebElement middleName;
        @FindBy( name ="lastName")
                WebElement lastName;
        @FindBy(xpath = "//div[@class='oxd-select-text-input']")
                WebElement selectJob;
        @FindBy( xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
                WebElement email;
        @FindBy( xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/input[1]")
                WebElement noTelp;
        @FindBy( xpath = "//input[@type='file']")
                WebElement doc;
        @FindBy( xpath = "//input[@placeholder='Enter comma seperated words...']")
                WebElement note;
        @FindBy( tagName = "input")
                WebElement tgl;
        @FindBy( tagName = "textarea")
                WebElement text;
        @FindBy( xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
                WebElement icon;
        @FindBy( xpath= " //button[normalize-space()='Save']")
                WebElement save;
        @FindBy( xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/h6")
                WebElement dashboardText;

    public String getTextDashboard(){
        return dashboardText.getText();
    }
    public void recruitment(){
        btnrecrruitment.click();
        btnAdd.click();
        firstName.sendKeys("Juara");
        middleName.sendKeys("cod");
        lastName.sendKeys("dingg");
        selectJob.sendKeys("Software");
        email.sendKeys("dyugdfdsy@gmail.com");
        noTelp.sendKeys("087899847080");
        String pathDoc = "F:\\Download\\IMK_LIA APRILIA_201743601900_R61.docx";
        doc.sendKeys(pathDoc);
        delay(3);
        note.sendKeys("Test");
        tgl.sendKeys(dateNow);
        text.sendKeys("Noted");
        icon.click();
        save.click();
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

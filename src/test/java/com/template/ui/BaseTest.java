package com.template.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.TextReport;
import com.template.ui.helpers.listener.AllureScreenShooter;
import com.template.ui.helpers.listener.Listener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.template.ui.helpers.properties.UrlLinksProp.MAIN_URL;

@Listeners({AllureScreenShooter.class, TextReport.class, Listener.class})
public class BaseTest {

    public String baseUrl = MAIN_URL;

    @BeforeTest
    public void setup(){
        Configuration.browser =  "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout =  5000;
        Configuration.reportsFolder = "target/test-result/reports";
    }

}


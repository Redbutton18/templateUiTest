package com.template.ui.helpers.listener;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Listener implements ITestListener, IMethodInterceptor, IAnnotationTransformer {

//    private DbWorker dbCon = new DbWorker();

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> testsToRun = new ArrayList<>();
        for (IMethodInstance method : methods) {
            Test testClass = method.getInstance()
                    .getClass()
                    .getAnnotation(Test.class);
            System.out.println("intercept" + getMethodName(method));
            if (testClass == null || testClass.enabled()) {
                testsToRun.add(method);
            }
//            if (dbCon.getDbConnection() != null) {
//                if (dbCon.getTestClassNameStatus(method.getMethod().getMethodName()) == null ||
//                        dbCon.getTestClassNameStatus(method.getMethod().getMethodName()).equals("null")) {
//                    dbCon.insertClassNameInTable(method.getMethod().getTestClass().getName(), method.getMethod().getMethodName());
//                }
//            }
        }
        return testsToRun;
    //    return null;
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        System.out.println("transform - " + testMethod.getName());
//        try {
//            if (dbCon.getDbConnection() != null) {
//                if (!dbCon.getDbConnection().isClosed()) {
//                    if (dbCon.getTestStatus(testMethod.getName()) == null) {
//                        dbCon.insertClassAndMethodNameInTable(null, testMethod.getName());
//                        annotation.setEnabled(true);
//                    } else annotation.setEnabled(dbCon.getTestStatus(testMethod.getName()));
//                }
//            } else annotation.setEnabled(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private String getMethodName(IMethodInstance method) {
        return method.getMethod().getTestClass().getName()
                + "." + method.getMethod().getMethodName();
    }


    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - START");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - SUCCESS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - FAILURE");
//        takeScreenshot(getMethodName(iTestResult));
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " FailedButWithinSuccessPercentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Context Tests case name: " + iTestContext.getName() + " ON START");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Context Tests case name: " + iTestContext.getName() + " ON FINISH");
    }

    private String getMethodName(ITestResult iTestResult) {
        return iTestResult.getTestClass().getName()
                + "." + iTestResult.getMethod().getMethodName();
    }
}


package com.template.ui.helpers.listener;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

public class AllureScreenShooter extends ExitCodeListener {
    public static boolean captureSuccessfulTests = true;

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        AllureHelpers.takeScreenshot(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
    }
}


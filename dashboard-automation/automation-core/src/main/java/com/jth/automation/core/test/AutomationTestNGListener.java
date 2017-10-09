package com.jth.automation.core.test;

import java.lang.reflect.Method;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

/*
 * Listener interface for receiving Automation events
 * This listener is hooked to the TestNG test which are run using ServiceLoader mechanism
 * You will need to add this listener to the TestNG Test class by adding
 * <code>@Listeners({com.erac.rfs.automation.core.AutomationTestNG.class})</code>
 * before the test class
 * 
 */
public class AutomationTestNGListener implements IInvokedMethodListener, ITestListener {
	private long methodStartTime = 0;
	private long testSuiteStartTime = 0;

	private static void println(String msg) {
		System.out.println(msg);
	}

	private static void printf(String msg, Object ... args) {
		System.out.printf(msg, args);
	}
	
	private static void printSeparator() {
		println("-----------------------------------------------");
	}

	@Override
	public void onFinish(ITestContext context) {
		long elapseTime = System.nanoTime() - testSuiteStartTime;
		println("Ending Suite: " + context.getName());
		printf("Elapsed time (ns): %,d\n", elapseTime);
		printSeparator();
	}

	@Override
	public void onStart(ITestContext context) {
		println("Starting Test Suite: " + context.getName());
		testSuiteStartTime = System.nanoTime();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		println("Test Failed: " + result.getName());
		printSeparator();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		println("Skipped: " + result.getName());
		printSeparator();
	}

	@Override
	public void onTestStart(ITestResult result) {
		if(result.getMethod().isTest()) {
			Method testMethod = result.getMethod().getConstructorOrMethod().getMethod();
			if(testMethod.isAnnotationPresent(Automation.class)) {
				Automation annotation = testMethod.getAnnotation(Automation.class);
				println("Annotation: " + annotation);
				executeEnvToSkipAnnotation(annotation);	
			}
			println("Starting: " + result.getName());				
			methodStartTime = System.nanoTime();
		}
	}

	private void executeEnvToSkipAnnotation(Automation annotation) {
		for (String environment : annotation.envToSkip()){
			if(environment.equalsIgnoreCase(AutomationProperties.Util.getProperty("env"))) {
				throw new SkipException("Skip test on env");
			}
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getMethod().isTest()) {
			long elapsedTime = System.nanoTime() - methodStartTime;
			println("Ending: " + result.getName());
			printf("Test Method Time (ns): %,d\n", elapsedTime);
			printSeparator();
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		// TODO Auto-generated method stub
	}

}

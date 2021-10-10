package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result){
		System.out.println("onTestStart Method:"+result.getName());
	}	
	@Override
	public void onTestSuccess(ITestResult result){
		System.out.println("onTestSuccess Method:"+result.getName());
	}	
	@Override
	public void onTestFailure(ITestResult result){
		System.out.println("onTestFailure Method:"+result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult result){
		System.out.println("onTestSkipped Method:"+result.getName());
	}
	@Override
    public void onFinish(ITestContext context){
		
	}	
	
	

}

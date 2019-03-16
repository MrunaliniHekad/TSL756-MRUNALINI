package day8;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups="Smoke")
  public void smoke() {
	  System.out.println("Smoke");
  }
  
  @Test(groups= {"Smoke","Regression"})
  public void smoke1() {
	  System.out.println("Smoke Testing with regression");
  }
  @Test(groups="Sanity")
  public void sanity() {
	  System.out.println("Sanity Testing");
  }
  @Test(groups="Functional")
  public void functional() {
	  System.out.println("Functional Testing");
  }
  @Test(groups="Performance")
  public void perform() {
	  System.out.println("Performance");
  }
  
  @Test(groups="Regression")
  public void regression() {
	  System.out.println("Regression");
  }
}

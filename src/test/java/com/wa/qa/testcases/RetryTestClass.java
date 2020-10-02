package test.java.com.wa.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryTestClass {

    @Test
    public void testA(){
        Assert.assertEquals("a", "b");
    }

    @Test
    public void testB(){
        Assert.assertEquals("A", "a");
    }

    @Test
    public void testC(){
        Assert.assertEquals("a", "a");
    }
}

package base;

import org.junit.After;
import org.junit.Before;

public class BaseTest extends Driver {


    @Before
    public void beforeTest() {
        Log.info("Test are starting...");
        getDriver();
        pagefactory(driver);
    }

    @After
    public void afterTest() {
        Log.info("Test are ending...");
        closeDriver();
    }

}


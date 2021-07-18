package baseEntities;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final static int WAIT_FOR_PAGE_LOADING_SEC = 20;
    protected WebDriver driver;
    protected ReadProperties properties;

    protected abstract void openPage();

    public abstract boolean isPageOpen();

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        properties = new ReadProperties();

        if (openPageByUrl)
            openPage();

        waitForOpen();
    }

    protected void waitForOpen() {

        int secondsCount = 0;
        boolean isPageOpenIndicator = isPageOpen();

        while (!isPageOpenIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenIndicator = isPageOpen();
        }

        if (!isPageOpenIndicator)
            throw new AssertionError("Page wasn't opened.");
    }
}

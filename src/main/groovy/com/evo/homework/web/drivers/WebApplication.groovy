package com.evo.homework.web.drivers

import com.evo.homework.web.Configuration
import org.apache.commons.io.FileUtils
import org.joda.time.DateTime
import org.joda.time.Duration
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */
class WebApplication {

    WebDriver driver

    WebApplication(WebDriver webDriver) {
        this.driver = webDriver
    }

    def open(String url) {
        driver.get(url)
    }

    def takeScreenshot(String postTimestampName) {
        String screenshotsFolderPath = "screenshots"
        if (screenshotsFolderPath != null) {
            DateTime dateTime = new DateTime()
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
            try {
                FileUtils.copyFile(scrFile, new File(screenshotsFolderPath + "/" + dateTime.toString("dd.MM_HH.mm.ss_") + postTimestampName + ".png"))
            } catch (IOException e) {
                e.printStackTrace()
            }
        }
    }

    byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
    }

    def deleteAllCookies() {
        driver.manage().deleteAllCookies()
    }

    def close() {
        driver.close()
    }

    WebElement findElement(By by, boolean stopOnFailure = true) {
        waitUntil(visibilityOfElementLocated(by), Duration.standardSeconds(2), false)
        WebElement elementToFind = null
        try {
            elementToFind = driver.findElement(by)
        } catch (Exception e) {
            if (stopOnFailure) {
                takeScreenshot("findElement")
                throw e
            } else {
                if (elementToFind == null) elementToFind = findElement(by, true)
                println "${e.class} exception in finding $by \n"
            }
        }
        return elementToFind
    }

    List<WebElement> findElements(By by) {
        return driver.findElements(by)
    }

    String getText(WebElement element, int tries = 3) {
        try {
            return element.getText()
        } catch (Exception exc) {
            println "\nRetrying to get text ... ${exc.class}"
            if (tries > 0) {
                getText(element, tries - 1)
            } else {
                takeScreenshot("getText")
                throw exc
            }
        }
    }

    String getText(By by) {
        return getText(findElement(by, false))
    }

    def waitUntil(ExpectedCondition<?> until, Duration duration, boolean stopOnFailure = true) {
        WebDriverWait wait = new WebDriverWait(driver, duration.getStandardSeconds())
        try {
            wait.until(until)
        } catch (Exception e) {
            if (stopOnFailure) {
                takeScreenshot("waitUntil")
                throw e
            }
        }
    }

    def waitUntil(ExpectedCondition<?> until, boolean stopOnFailure = true) {
        waitUntil(until, Duration.standardSeconds(Configuration.DEFAULT_TIMEOUT_SECONDS), stopOnFailure)
    }

    def waitFor(Duration duration) {
        try {
            waitUntil(visibilityOfElementLocated(By.xpath("//nonexisting")), duration, false)
        } catch (Exception e) {
        }
    }

    boolean isDisplayed(By by) {
        def elementIsDisplayed = false
        try {
            elementIsDisplayed = isDisplayed(findElement(by, false))
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                println "\nisDisplayed $by exception ${e.class}"
            }
        }
        elementIsDisplayed
    }

    static boolean isDisplayed(WebElement element) {
        def elementIsDisplayed = false
        try {
            elementIsDisplayed = element.isDisplayed()
        } catch (Exception e) {
        }
        try {
            elementIsDisplayed = element.isDisplayed()
        } catch (Exception e) {
        }
        elementIsDisplayed
    }

    def scroll(int x, int y) {
        JavascriptExecutor jse = (JavascriptExecutor) driver
        jse.executeScript("window.scrollBy($x,$y)")
    }

    def scrollUp() {
        scroll(windowSize.height - 1, 0)
        waitFor(Duration.standardSeconds(1))
    }

    def scrollDown() {
        scroll(0, windowSize.height - 1)
        waitFor(Duration.standardSeconds(1))
    }

    Dimension getWindowSize() {
        return driver.manage().window().size
    }

    def type(By by, String text) {
        waitFor(Duration.standardSeconds(1))
        findElement(by, false).clear()
        findElement(by, false).sendKeys(text)
    }
}

package com.evo.homework.web.drivers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */
class SeleniumDriverFactory {

    static WebDriver getWebdriver() {
        def chromedriverExe = this.class.getResource('/drivers/chrome/chromedriver.exe')
        System.setProperty('webdriver.chrome.driver', chromedriverExe.getFile())
        new ChromeDriver()
    }
}

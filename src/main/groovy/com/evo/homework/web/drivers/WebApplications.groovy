package com.evo.homework.web.drivers

import com.evo.homework.web.utils.ValueStorage
import cucumber.api.java.After
import cucumber.api.java.Before

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */
class WebApplications {

    private static WebApplication webApp

    static WebApplication newOrExistingWebApp() {
        if (!webApp) {
            webApp = new WebApplication(SeleniumDriverFactory.webdriver)
            webApp.driver.manage().window().maximize()
        }
        webApp
    }

    @Before
    static setUp() {
        ValueStorage.reset()
    }

    @After
    static tearDown() {
        webApp.driver.quit()
        webApp = null
    }
}

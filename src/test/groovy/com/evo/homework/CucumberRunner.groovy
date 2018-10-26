package com.evo.homework

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "@memo", plugin = ["html:report/cucumber", "json:report/cucumber/json/report.json", "pretty"])
class CucumberRunner {
}

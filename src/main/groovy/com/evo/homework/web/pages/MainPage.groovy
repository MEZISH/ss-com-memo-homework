package com.evo.homework.web.pages

import org.openqa.selenium.By

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */
class MainPage extends WebPage {

    private static final By GENERAL_CATEGORY_XPATH = By.xpath("//a[contains(@id,'mtd')]")

    static open() {
        web().open('http://www.ss.com/en')
    }

    static selectRandomCategory() {
        def categories = web().findElements(GENERAL_CATEGORY_XPATH)
        def randomCategoryIndex = new Random().nextInt(categories.size())
        categories.get(randomCategoryIndex).click()
    }
}

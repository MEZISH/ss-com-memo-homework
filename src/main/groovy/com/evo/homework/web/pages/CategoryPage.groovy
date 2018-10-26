package com.evo.homework.web.pages


import org.openqa.selenium.By

/**
 * Created by Kristaps Mezavilks on 23.10.2018.
 */
class CategoryPage extends WebPage {

    private static final By GENERAL_SUBCATEGORY_XPATH = By.xpath("//a[contains(@id,'ahc')]")

    static selectRandomSubcategory() {
        def subcategories = web().findElements(GENERAL_SUBCATEGORY_XPATH)
        if (subcategories) {
            def randomSubcategoryIndex = new Random().nextInt(subcategories.size())
            subcategories.get(randomSubcategoryIndex).click()
        }
    }
}

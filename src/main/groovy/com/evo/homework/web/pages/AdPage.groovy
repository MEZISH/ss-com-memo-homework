package com.evo.homework.web.pages

import org.openqa.selenium.By

/**
 * Created by Kristaps Mezavilks on 25.10.2018.
 */
class AdPage extends WebPage {

    private static final By ADD_TO_MEMO_BUTTON = By.xpath("//*[@id='a_fav']")

    static addToMemo() {
        web().scrollDown()
        while (!web().isDisplayed(ADD_TO_MEMO_BUTTON)) {
            web().scrollDown()
        }
        web().findElement(ADD_TO_MEMO_BUTTON).click()
    }
}

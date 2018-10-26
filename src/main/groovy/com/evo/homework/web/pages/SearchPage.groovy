package com.evo.homework.web.pages

import org.openqa.selenium.By

/**
 * Created by Kristaps Mezavilks on 23.10.2018.
 */
class SearchPage extends WebPage {

    private static final By PHRASE_INPUT_FIELD = By.xpath("//*[@id='ptxt']")

    static open() {
        web().open("https://www.ss.com/en/search/")
    }

    static search(String phrase) {
        web().type(PHRASE_INPUT_FIELD, phrase + "\n")
    }
}

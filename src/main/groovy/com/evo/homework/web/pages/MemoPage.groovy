package com.evo.homework.web.pages

import org.openqa.selenium.By

/**
 * Created by Kristaps Mezavilks on 23.10.2018.
 */
class MemoPage extends WebPage {

    private static final By GENERAL_AD_XPATH = By.xpath("//*[contains(@id,'tr')]")
    private static final By GENERAL_AD_TITLE_XPATH = By.xpath("//*[contains(@id,'tr')]//" +
            "a[contains(@id,'dm')]")

    static open() {
        web().open("https://www.ss.com/en/favorites/")
    }

    static int getAdCount() {
        def ads = web().findElements(GENERAL_AD_XPATH)
        ads.size()
    }

    static ArrayList<String> getMemoAdTitles() {
        ArrayList<String> memoAdTitles = new ArrayList<>()
        def adTitles = web().findElements(GENERAL_AD_TITLE_XPATH)
        for (int i = 0; i < adCount; i++) {
            memoAdTitles.add(adTitles.get(i).text)
        }
        memoAdTitles
    }
}
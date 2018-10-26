package com.evo.homework.web.pages

import com.evo.homework.web.utils.ValueStorage
import org.openqa.selenium.By

/**
 * Created by Kristaps Mezavilks on 23.10.2018.
 */
class AdListPage extends WebPage {

    private static final By GENERAL_AD_XPATH = By.xpath("//tr[contains(@id,'tr')]")
    private static final By ADD_TO_MEMO_BUTTON = By.xpath("//*[@id='a_fav_sel']")
    private static final By SUCCESS_POPUP_ALERT = By.xpath("//*[@id='alert_dv']")

    static int getAdCount() {
        def ads = web().findElements(GENERAL_AD_XPATH)
        ads.size()
    }

    static addToMemoAds(int count) {
        ArrayList<String> memoAdTitles = new ArrayList<>()
        for (int i = 1; i <= count; i++) {
            def adCheckboxLocator = By.xpath("//tr[contains(@id,'tr')][$i]//input[@type='checkbox']")
            web().findElement(adCheckboxLocator).click()
            def adTitleLocator = By.xpath("//tr[contains(@id,'tr')][$i]//a[contains(@id,'dm')]")
            def adTitle = web().findElement(adTitleLocator).text
            memoAdTitles.add(adTitle)
        }
        web().scrollDown()
        while (!web().isDisplayed(ADD_TO_MEMO_BUTTON)) {
            web().scrollDown()
        }
        web().findElement(ADD_TO_MEMO_BUTTON).click()
        ValueStorage.store("memoAdTitles", memoAdTitles)
    }

    static boolean successPopupIsDisplayed() {
        web().isDisplayed(SUCCESS_POPUP_ALERT)
    }

    static openAd(int adIndex) {
        def adTitleLocator = By.xpath("//tr[contains(@id,'tr')][$adIndex]//a[contains(@id,'dm')]")
        def adTitle = web().findElement(adTitleLocator).text
        ValueStorage.store("memoAdTitles", [adTitle].toArray())
        def ads = web().findElements(GENERAL_AD_XPATH)
        ads.get(adIndex).click()
    }
}

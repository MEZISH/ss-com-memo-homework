package com.evo.homework.stepdefs

import com.evo.homework.utils.StringUtils
import com.evo.homework.web.pages.*
import com.evo.homework.web.utils.ValueStorage
import cucumber.api.groovy.EN

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */

this.metaClass.mixin(EN)

When(/user adds {int} ads to memo from list/) { Integer expectedAdCount ->
    MainPage.open()
    MainPage.selectRandomCategory()
    CategoryPage.selectRandomSubcategory()
    while (AdListPage.adCount < expectedAdCount) {
        MainPage.open()
        MainPage.selectRandomCategory()
        CategoryPage.selectRandomSubcategory()
    }
    AdListPage.addToMemoAds(expectedAdCount)
}

Then(/success pop-up should be visible/) { ->
    assert AdListPage.successPopupIsDisplayed()
}

When(/opens memo section/) { ->
    MemoPage.open()
}

Then(/the ads should be available in Memo section/) { ->
    ArrayList expectedMemoTitles = ValueStorage.get("memoAdTitles") as ArrayList
    def actualMemoTitles = MemoPage.memoAdTitles
    assert expectedMemoTitles.size() == actualMemoTitles.size()
    for (String actualTitle : actualMemoTitles) {
        assert StringUtils.listContainsElementContainingString(expectedMemoTitles, actualTitle)
    }
}

Given(/user has made advanced search {string}/) { String searchPhrase ->
    SearchPage.open()
    SearchPage.search(searchPhrase)
}

When(/user adds {int} ads to memo from search results/) { Integer expectedAdCount ->
    AdListPage.addToMemoAds(expectedAdCount)
}

Given(/user has opened an ad/) { ->
    MainPage.open()
    MainPage.selectRandomCategory()
    CategoryPage.selectRandomSubcategory()
    while (AdListPage.adCount < 1) {
        MainPage.open()
        MainPage.selectRandomCategory()
        CategoryPage.selectRandomSubcategory()
    }
    def randomAdIndex = new Random().nextInt(AdListPage.adCount)
    AdListPage.openAd(randomAdIndex)
}

When(/user adds the ad to memo/) { ->
    AdPage.addToMemo()
}
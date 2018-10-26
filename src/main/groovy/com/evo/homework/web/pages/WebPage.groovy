package com.evo.homework.web.pages

import com.evo.homework.web.drivers.WebApplication
import com.evo.homework.web.drivers.WebApplications

/**
 * Created by Kristaps Mezavilks on 22.10.2018.
 */
class WebPage {
    static WebApplication web() {
        WebApplications.newOrExistingWebApp()
    }
}

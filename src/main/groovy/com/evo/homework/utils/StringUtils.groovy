package com.evo.homework.utils

/**
 * Created by Kristaps Mezavilks on 24.10.2018.
 */
class StringUtils {

    static boolean listContainsElementContainingString(ArrayList<String> stringArrayList, String phrase) {
        def isContaining = false
        stringArrayList.each { String s ->
            if (s.contains(phrase)) {
                isContaining = true
            }
        }
    }
}

package com.evo.homework.web.utils
/**
 * Created by Kristaps Mezavilks on 23.10.2018.
 */
class ValueStorage {

    private static Map valueStorage

    static reset() {
        valueStorage = new HashMap<String, Object>()
    }

    static store(String key, Object value) {
        valueStorage.put(key, value)
    }

    static Object get(String key) {
        valueStorage.get(key)
    }
}

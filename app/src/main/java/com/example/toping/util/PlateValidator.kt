package com.example.toping.util

import java.util.regex.Pattern

class PlateValidator {
    fun isPlateValid(plate: String): Boolean {
        val platePattern = Pattern.compile("^(0[1-9]|[1-7][0-9]|8[01])(([A-Z])(\\d{4,5})|([A-Z]{2})(\\d{3,4})|([A-Z]{3})(\\d{2,4}))\$")
        val plateMatcher = platePattern.matcher(plate)
        return plateMatcher.find()
    }
}
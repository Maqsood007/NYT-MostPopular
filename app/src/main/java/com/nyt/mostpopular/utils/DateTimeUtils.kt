package com.nyt.mostpopular.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
object DateTimeUtils {

    val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)

    private val inPutFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    private val outFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)

    fun getParsedDate(date: String): String = outFormatter.format(inPutFormatter.parse(date) ?: Date())
}

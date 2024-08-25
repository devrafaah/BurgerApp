package com.example.burgersapp.util

import com.google.gson.Gson
import retrofit2.HttpException
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale


inline fun <reified T> HttpException.getErrorResponse(): T? {
    return try {
        Gson().fromJson(response()?.errorBody()?.string(), T::class.java)
    } catch (e: Exception) {
        null
    }
}

fun Float?.formattedValue(removeSymbol: Boolean = false): String {
    val moneyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    moneyFormatter.currency = Currency.getInstance("BRL")

    val value = if(this == null) {
        moneyFormatter.format(0f)
    }else {
        moneyFormatter.format(this)
    }

    return if(removeSymbol) value.replace("R\$NBSP", "") else value
}
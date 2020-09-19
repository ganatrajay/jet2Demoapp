package com.example.jet2demoapp.util

import java.text.DecimalFormat

class DigitFormatter {

    companion object{
        fun digiCount(number: Number): String? {
            val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
            val numValue: Long = number.toLong()
            val value = Math.floor(Math.log10(numValue.toDouble())).toInt()
            val base = value / 3
            return if (value >= 3 && base < suffix.size) {
                DecimalFormat("#0.0").format(
                    numValue / Math.pow(
                        10.0,
                        base * 3.toDouble()
                    )
                ) + suffix[base]
            } else {
                DecimalFormat("#,##0").format(numValue)
            }
        }
    }



}
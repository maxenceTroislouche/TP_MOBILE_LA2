package com.example.myshoppinglist.utils

import java.math.RoundingMode
import java.text.NumberFormat
/**
 * Number formatter for the count of a ShoppingItem.
 */
object ShoppingItemCountFormatter {
    private val formatter = NumberFormat.getInstance()
    init {
        formatter.apply {
            maximumFractionDigits = 2
            minimumFractionDigits = 2
            minimumFractionDigits = 2
            roundingMode = RoundingMode.FLOOR
        }
    }
    /**
     * Convert a number into a formatted string matching this pattern :
    "^([1-9][\d]+|[\d])\.\d{2}$".
     */
    fun format(number: Number): String = formatter.format(number)
}
package com.albertomagalhaes.doggos.commons.extensions

import java.util.Locale

fun String.capitalizeFirst() = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault())
    else it.toString()
}
package com.example.guilhermedeconto.financaskotlin.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 02/01/2019
 **/

fun Calendar.formatToBrazilianFormat() : String{
    val brazilianDateFormat = "dd/MM/yyyy"
    val format = SimpleDateFormat(brazilianDateFormat)
    return format.format(this.time)
}
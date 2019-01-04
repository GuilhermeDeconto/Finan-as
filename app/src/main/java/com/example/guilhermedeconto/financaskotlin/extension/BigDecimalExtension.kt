package com.example.guilhermedeconto.financaskotlin.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 03/01/2019
 **/

fun BigDecimal.brlFormat(): String {
    val currencyInstance = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))

    return currencyInstance.format(this).replace("R$", "R$ ")

}
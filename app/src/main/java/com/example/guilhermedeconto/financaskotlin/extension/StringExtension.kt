package com.example.guilhermedeconto.financaskotlin.extension

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 03/01/2019
 **/

fun String.limitString(number: Int): String {
    if (this.length > number) {
        return "${this.substring(0, number)}..."
    }
    return this
}
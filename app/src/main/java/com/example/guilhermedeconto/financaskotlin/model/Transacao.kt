package com.example.guilhermedeconto.financaskotlin.model

import java.math.BigDecimal
import java.util.Calendar

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 02/01/2019
 **/
class Transacao(value: BigDecimal, category: String, data: Calendar) {
    private val value: BigDecimal = value
    private val category: String = category
    private val data: Calendar = data

    fun getValue() :BigDecimal{
        return value
    }
}
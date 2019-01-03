package com.example.guilhermedeconto.financaskotlin.model

import java.math.BigDecimal
import java.util.Calendar

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 02/01/2019
 **/
class Transacao(
    val value: BigDecimal,
    val category: String = "Indefinida",
    val type: Type,
    val data: Calendar = Calendar.getInstance())
// {
////    constructor(value: BigDecimal, type: Type) : this(value, "Indefinida", type)
////    constructor(value: BigDecimal, type: Type, data: Calendar) : this(value, "Indefinida", type, data)
//}

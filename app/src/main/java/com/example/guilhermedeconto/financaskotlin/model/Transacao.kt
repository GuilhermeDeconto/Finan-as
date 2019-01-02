package com.example.guilhermedeconto.financaskotlin.model

import java.math.BigDecimal
import java.util.Calendar

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 02/01/2019
 **/
class Transacao(val value: BigDecimal, val category: String, val data: Calendar) {
}
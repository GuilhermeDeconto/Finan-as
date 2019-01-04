package com.example.guilhermedeconto.financaskotlin.ui

import android.view.View
import com.example.guilhermedeconto.financaskotlin.extension.brlFormat
import com.example.guilhermedeconto.financaskotlin.model.Transacao
import com.example.guilhermedeconto.financaskotlin.model.Type
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 04/01/2019
 **/
class ViewSummary(private val view: View, private val transacoes: List<Transacao>) {

    fun addIncome() {
        var totalIncome = BigDecimal.ZERO

        for (transacao in transacoes) {
            if (transacao.type == Type.INCOME) {
                totalIncome = totalIncome.plus(transacao.value)
            }
        }
        view.resumo_card_receita.text = totalIncome.brlFormat()
    }

    fun addExpense() {
        var totalExpense = BigDecimal.ZERO

        for (transacao in transacoes) {
            if (transacao.type == Type.EXPENSE) {
                totalExpense = totalExpense.plus(transacao.value)
            }
        }
        view.resumo_card_despesa.text = totalExpense.brlFormat()
    }

    fun addTotal(){

    }
}
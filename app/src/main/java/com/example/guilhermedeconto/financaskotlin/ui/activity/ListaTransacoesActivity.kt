package com.example.guilhermedeconto.financaskotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.guilhermedeconto.financaskotlin.R
import com.example.guilhermedeconto.financaskotlin.model.Transacao
import com.example.guilhermedeconto.financaskotlin.model.Type
import com.example.guilhermedeconto.financaskotlin.ui.ViewSummary
import com.example.guilhermedeconto.financaskotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 28/12/2018
 **/
class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        findViewById<ListView>(R.id.lista_transacoes_listview)

        val transacoes = transacoesExemple()

        configureSummary(transacoes)
        configureList(transacoes)
    }

    private fun configureSummary(transacoes: List<Transacao>) {
        val view = window.decorView
        val viewSummary = ViewSummary(view,transacoes)
        viewSummary.addIncome()
        viewSummary.addExpense()
    }

    private fun configureList(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesExemple(): List<Transacao> {
        return listOf(
            Transacao(
                type = Type.EXPENSE,
                category = "Almoço de final de semana",
                data = Calendar.getInstance(),
                value = BigDecimal(20.5)
            ),
            Transacao(value = BigDecimal(100.0), category = "Economia", type = Type.INCOME),
            Transacao(value = BigDecimal.valueOf(200.0), type = Type.EXPENSE),
            Transacao(value = BigDecimal.valueOf(500.0), category = "Premio", type = Type.INCOME)
        )
    }
}
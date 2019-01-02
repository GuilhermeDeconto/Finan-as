package com.example.guilhermedeconto.financaskotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.guilhermedeconto.financaskotlin.R
import com.example.guilhermedeconto.financaskotlin.model.Transacao
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
        val transacoes = listOf(Transacao(BigDecimal(20.5),
            "Comida", Calendar.getInstance()),
        Transacao(BigDecimal(100.0),"Economia", Calendar.getInstance()))
        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes,this))
    }
}
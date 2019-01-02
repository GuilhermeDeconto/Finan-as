package com.example.guilhermedeconto.financaskotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.guilhermedeconto.financaskotlin.R
import com.example.guilhermedeconto.financaskotlin.extension.formatToBrazilianFormat
import com.example.guilhermedeconto.financaskotlin.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 02/01/2019
 **/
class ListaTransacoesAdapter(transacoes: List<Transacao>, context: Context) : BaseAdapter() {

    private val transacoes = transacoes
    private val context = context

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]
        viewCreated.transacao_valor.text = transacao.value.toString()
        viewCreated.transacao_categoria.text = transacao.category
        viewCreated.transacao_data.text = transacao.data.formatToBrazilianFormat()

        return viewCreated
    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}
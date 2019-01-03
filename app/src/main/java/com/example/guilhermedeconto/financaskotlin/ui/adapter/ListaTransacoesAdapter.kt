package com.example.guilhermedeconto.financaskotlin.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.guilhermedeconto.financaskotlin.R
import com.example.guilhermedeconto.financaskotlin.extension.brlFormat
import com.example.guilhermedeconto.financaskotlin.extension.formatToBrazilianFormat
import com.example.guilhermedeconto.financaskotlin.model.Transacao
import com.example.guilhermedeconto.financaskotlin.model.Type
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

        if (transacao.type == Type.RECIPE) {
            viewCreated.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.receita))
        } else {
            viewCreated.transacao_valor.setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }

        if (transacao.type == Type.RECIPE) {
            viewCreated.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
        } else {
            viewCreated.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }

        viewCreated.transacao_valor.text = transacao.value.brlFormat()
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
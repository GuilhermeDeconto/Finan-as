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
import com.example.guilhermedeconto.financaskotlin.extension.limitString
import com.example.guilhermedeconto.financaskotlin.model.Transacao
import com.example.guilhermedeconto.financaskotlin.model.Type
import kotlinx.android.synthetic.main.transacao_item.view.*

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 02/01/2019
 **/
class ListaTransacoesAdapter(private val transacoes: List<Transacao>, private val context: Context) : BaseAdapter() {
    private val limitCategory = 14

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
        val transacao = transacoes[position]
        addValue(transacao, viewCreated)
        addIcon(transacao, viewCreated)
//        var formatedCategory = transacao.category
//        if (formatedCategory.length > 14) {
//            formatedCategory = "${formatedCategory.substring(0, 14)}..."
//        }
        addCategory(viewCreated, transacao)
        addData(viewCreated, transacao)
        return viewCreated
    }

    private fun addData(
        viewCreated: View,
        transacao: Transacao
    ) {
        viewCreated.transacao_data.text = transacao.data.formatToBrazilianFormat()
    }

    private fun addCategory(
        viewCreated: View,
        transacao: Transacao
    ) {
        viewCreated.transacao_categoria.text = transacao.category.limitString(limitCategory)
    }

    private fun addIcon(transacao: Transacao, viewCreated: View) {
        val icon = iconWith(transacao.type)

        viewCreated.transacao_icone.setBackgroundResource(icon)
    }

    private fun iconWith(type: Type): Int {
        if (type == Type.INCOME) {
            return R.drawable.icone_transacao_item_receita
        }
        return R.drawable.icone_transacao_item_despesa

    }

    private fun addValue(transacao: Transacao, viewCreated: View) {

        val color: Int = colorType(transacao.type)
        viewCreated.transacao_valor.setTextColor(color)
        viewCreated.transacao_valor.text = transacao.value.brlFormat()
    }

    private fun colorType(type: Type): Int {
        if (type == Type.INCOME) {
            return ContextCompat.getColor(context, R.color.receita)
        }
        return ContextCompat.getColor(context, R.color.despesa)

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
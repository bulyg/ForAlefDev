package ru.bulyg.foralefdev.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import ru.bulyg.foralefdev.R
import ru.bulyg.foralefdev.mvp.presenter.adapter.MainRVListPresenter
import ru.bulyg.foralefdev.mvp.view.item.MainRVItemView
import ru.bulyg.foralefdev.util.loadPictures

class MainRVAdapter(val presenter: MainRVListPresenter) :
    RecyclerView.Adapter<MainRVAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
        holder.itemView.iv_item.setOnClickListener {
            presenter.openDetailScreen(holder.pos)
        }
    }

    override fun getItemCount() = presenter.getCount()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view), MainRVItemView {
        override var pos = -1

        override fun setPicture(url: String) {
            loadPictures(url, itemView.iv_item)
        }
    }
}
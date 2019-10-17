package com.safeboda.presentation.ui.comics

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.marvel.com.R
import com.safeboda.presentation.ui.entity.ComicUI
import com.safeboda.presentation.extensions.inflate
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicsAdapter(
    private val onItemClick: (ComicUI) -> Unit
) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    var list = mutableListOf<ComicUI>()
        private set

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            parent.inflate(R.layout.item_comic),
            onItemClick
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].itemViewType.ordinal

    fun addItemsToList(newList: List<ComicUI>) {
        if (list.isEmpty()) {
            list.addAll(newList)
            notifyDataSetChanged()
        } else {
            val previousSize = list.size
            list.addAll(newList)
            notifyItemRangeChanged(previousSize, list.size)
        }
    }

    class ViewHolder(itemView: View, val onItemClick: (ComicUI) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bind(comicUI: ComicUI) = with(itemView) {
            setOnReactiveClickListener { onItemClick(comicUI) }
            test.text = ""
        }

    }

}


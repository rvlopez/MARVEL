package developer.marvel.com.presentation.ui.comics

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.marvel.com.R
import developer.marvel.com.presentation.ui.entity.ComicUI
import developer.marvel.com.presentation.ui.inflate
import developer.marvel.com.presentation.ui.recyclerview.RecyclerViewObject
import developer.marvel.com.presentation.ui.setOnReactiveClickListener
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicsAdapter(
    onItemClick: (ComicUI) -> Unit
) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    var list = mutableListOf<RecyclerViewObject>()
        private set

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_comic))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].itemViewType.ordinal

    fun addItemsToList(newList: List<RecyclerViewObject>) {
        if (list.isEmpty()) {
            list.addAll(newList)
            notifyDataSetChanged()
        } else {
            val previousSize = list.size
            list.addAll(newList)
            notifyItemRangeChanged(previousSize, list.size)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(recyclerViewObject: RecyclerViewObject) = with(itemView) {
            setOnReactiveClickListener {  }
            test.text = ""
        }

    }

}


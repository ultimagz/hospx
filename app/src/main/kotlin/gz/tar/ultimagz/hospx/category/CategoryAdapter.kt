package gz.tar.ultimagz.hospx.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val inflater: LayoutInflater
) : ListAdapter<CategoryModel, RecyclerView.ViewHolder>(CategoryDiffCallback()) {

    enum class Mode {
        SINGLE, MULTIPLE
    }

    companion object {
        const val ITEM_VIEW_TYPE_HEADER = 0
        const val ITEM_VIEW_TYPE_ITEM = 2
    }

    var selectionMode: Mode = Mode.SINGLE

    fun positionOf(categoryModel: CategoryModel): Int = currentList.indexOf(categoryModel)

    fun getSelectedItems(): List<CategoryModel> =
        currentList
            .filter { it.isSelected }
            .sortedBy { it.name.toInt() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> CategorySectionViewHolder.create(inflater, parent, false)
            else -> CategoryItemViewHolder.create(inflater, parent, false)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is CategorySectionViewHolder -> {
                holder.bind(item)
            }
            is CategoryItemViewHolder -> {
                holder.bind(position, item)
                holder.setOnClickListener {
                    checkSelectionMode(position)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.isHeader) {
            ITEM_VIEW_TYPE_HEADER
        } else {
            ITEM_VIEW_TYPE_ITEM
        }
    }

    private fun checkSelectionMode(position: Int) {
        val item = getItem(position)
        if (selectionMode == Mode.SINGLE) {
            currentList
                .filter { it.isSelected }
                .map { it.isSelected = false }
        }

        item.isSelected = !item.isSelected
        notifyDataSetChanged()
    }
}

class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryModel>() {
    override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem.name == newItem.name && oldItem.categoryType == newItem.categoryType
    }
}
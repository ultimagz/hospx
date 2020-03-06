package gz.tar.ultimagz.hospx.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import gz.tar.ultimagz.hospx.category.viewholder.CategoryItemViewHolder
import gz.tar.ultimagz.hospx.category.viewholder.CategorySectionViewHolder
import gz.tar.ultimagz.hospx.category.viewholder.CategoryViewHolder

@Suppress("unused")
class CategoryAdapter(
    private val inflater: LayoutInflater
) : ListAdapter<CategoryAdapterModel, CategoryViewHolder>(CategoryDiffCallback()) {

    companion object {
        const val ITEM_VIEW_TYPE_HEADER = 0
        const val ITEM_VIEW_TYPE_ITEM = 2
    }

    enum class SelectionMode {
        SINGLE, MULTIPLE
    }

    var selectionMode: SelectionMode = SelectionMode.SINGLE

    fun positionOf(categoryModel: CategoryAdapterModel): Int = currentList.indexOf(categoryModel)

    fun getSelectedItems(): List<CategoryAdapterModel> =
        currentList
            .filter { it.isSelected }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> CategorySectionViewHolder.create(inflater, parent, false)
            else -> CategoryItemViewHolder.create(inflater, parent, false)
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        when {
            (holder is CategorySectionViewHolder && item is CategoryHeaderModel) -> bindHeaderView(holder, item)
            (holder is CategoryItemViewHolder && item is CategoryItemModel) -> bindItemView(holder, item, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CategoryHeaderModel -> ITEM_VIEW_TYPE_HEADER
            else -> ITEM_VIEW_TYPE_ITEM
        }
    }

    private fun bindHeaderView(holder: CategorySectionViewHolder, item: CategoryHeaderModel) {
        holder.bind(item)
    }

    private fun bindItemView(holder: CategoryItemViewHolder, item: CategoryItemModel, position: Int) {
        holder.bind(position, item)
        holder.setOnClickListener {
            if (selectionMode == SelectionMode.SINGLE) {
                clearAllSelection()
            }

            toggleSelectionAt(position)
        }
    }

    private fun toggleSelectionAt(position: Int) {
        val item = getItem(position)
        item.isSelected = !item.isSelected
        notifyDataSetChanged()
    }

    private fun clearAllSelection() {
        currentList
            .filter { it.isSelected }
            .map { it.isSelected = false }
    }
}


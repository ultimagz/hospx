package gz.tar.ultimagz.hospx.category.adapter

import androidx.recyclerview.widget.DiffUtil

class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryAdapterModel>() {
    override fun areItemsTheSame(oldItem: CategoryAdapterModel, newItem: CategoryAdapterModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CategoryAdapterModel, newItem: CategoryAdapterModel): Boolean {
        val sameClass = oldItem::class == newItem::class
        val sameYear = oldItem.year == newItem.year
        val sameMonth = if (oldItem is CategoryItemModel && newItem is CategoryItemModel) {
            oldItem.month == newItem.month
        } else {
            true
        }

        return sameClass && sameYear && sameMonth
    }
}
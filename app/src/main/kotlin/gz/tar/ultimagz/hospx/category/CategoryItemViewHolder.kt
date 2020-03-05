package gz.tar.ultimagz.hospx.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gz.tar.ultimagz.hospx.databinding.ItemCategoryBinding

class CategoryItemViewHolder(
    private val binding: ItemCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var clickListener: ((View) -> Unit)? = null

    companion object {
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup?,
            attachToRoot: Boolean
        ): CategoryItemViewHolder = CategoryItemViewHolder(
            ItemCategoryBinding.inflate(
                inflater,
                parent,
                attachToRoot
            )
        )
    }

    fun bind(position: Int, model: CategoryModel) {
        binding.position = position
        binding.category = model
        binding.tvCategoryName.isActivated = model.isSelected
        binding.tvCategoryName.setOnClickListener {
            clickListener?.invoke(it)
        }
        binding.executePendingBindings()
    }

    fun setOnClickListener(listener: ((View) -> Unit)?) {
        clickListener = listener
    }
}
package gz.tar.ultimagz.hospx.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gz.tar.ultimagz.hospx.databinding.SectionCategoryBinding

class CategorySectionViewHolder(
    private val binding: SectionCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup?,
            attachToRoot: Boolean
        ): CategorySectionViewHolder = CategorySectionViewHolder(
            SectionCategoryBinding.inflate(
                inflater,
                parent,
                attachToRoot
            )
        )
    }

    fun bind(model: CategoryModel) {
        binding.category = model
    }
}
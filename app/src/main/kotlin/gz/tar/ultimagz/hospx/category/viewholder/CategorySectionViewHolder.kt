package gz.tar.ultimagz.hospx.category.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import gz.tar.ultimagz.hospx.category.adapter.CategoryHeaderModel
import gz.tar.ultimagz.hospx.databinding.SectionCategoryBinding

class CategorySectionViewHolder(
    private val binding: SectionCategoryBinding
) : CategoryViewHolder.BaseCategoryViewHolder(binding.root) {

    companion object {
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup?,
            attachToRoot: Boolean
        ): CategorySectionViewHolder =
            CategorySectionViewHolder(
                SectionCategoryBinding.inflate(
                    inflater,
                    parent,
                    attachToRoot
                )
            )
    }

    fun bind(model: CategoryHeaderModel) {
        binding.category = model
    }
}
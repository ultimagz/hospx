package gz.tar.ultimagz.hospx.category.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

sealed class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open class BaseCategoryViewHolder(view: View) : CategoryViewHolder(view)
}

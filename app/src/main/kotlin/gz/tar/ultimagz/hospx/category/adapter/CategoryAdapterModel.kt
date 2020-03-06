package gz.tar.ultimagz.hospx.category.adapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.Month

sealed class CategoryAdapterModel {
    abstract val year: Int
    var isSelected: Boolean = false
}

@Parcelize
data class CategoryItemModel(
    override val year: Int,
    val month: Month
) : CategoryAdapterModel(), Parcelable

@Parcelize
data class CategoryHeaderModel(
    override val year: Int
) : CategoryAdapterModel(), Parcelable
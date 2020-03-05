package gz.tar.ultimagz.hospx.category

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    val name: String = "",
    val categoryType: String,
    val isHeader: Boolean = false,
    var isSelected: Boolean = false
) : Parcelable
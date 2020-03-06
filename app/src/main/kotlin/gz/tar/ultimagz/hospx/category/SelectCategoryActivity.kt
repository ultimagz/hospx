package gz.tar.ultimagz.hospx.category

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import gz.tar.ultimagz.hospx.category.adapter.CategoryAdapter
import gz.tar.ultimagz.hospx.category.adapter.CategoryAdapterModel
import gz.tar.ultimagz.hospx.category.adapter.CategoryHeaderModel
import gz.tar.ultimagz.hospx.category.adapter.CategoryItemModel
import gz.tar.ultimagz.hospx.databinding.ActivitySelectCategoryBinding
import org.threeten.bp.YearMonth
import org.threeten.bp.ZoneId

class SelectCategoryActivity : AppCompatActivity() {

    private val binding: ActivitySelectCategoryBinding by lazy { ActivitySelectCategoryBinding.inflate(layoutInflater) }
    private val adapter by lazy { CategoryAdapter(layoutInflater) }

    private val categoryList: MutableList<CategoryAdapterModel> by lazy {
        val currentDate = YearMonth.now(ZoneId.of("GMT+07:00"))
        return@lazy (0..6L)
            .map { currentDate.minusMonths(it) }
            .sortedWith(compareBy({ it.month }, { it.year }))
            .toList()
            .fold(arrayListOf<CategoryAdapterModel>()) { accumulator, item ->
                accumulator
                    .lastOrNull { it.year == item.year }
                    ?: accumulator.add(CategoryHeaderModel(item.year))

                accumulator.add(CategoryItemModel(month = item.month, year = item.year))
                accumulator
            }
    }

    private val gridLayoutManager: GridLayoutManager by lazy {
        GridLayoutManager(this, 3).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (adapter.getItemViewType(position)) {
                        CategoryAdapter.ITEM_VIEW_TYPE_HEADER -> 3
                        else -> 1
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = gridLayoutManager
        binding.recyclerView.adapter = adapter

        adapter.submitList(ArrayList(categoryList))
        adapter.selectionMode = CategoryAdapter.SelectionMode.SINGLE

        binding.btnSelectionConfirm.setOnClickListener {
            val selectionText = adapter.getSelectedItems().joinToString("\n") { it.toString() }
            Toast.makeText(
                this,
                if (selectionText.isEmpty()) "No Item Selected." else selectionText,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

package gz.tar.ultimagz.hospx.category

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import gz.tar.ultimagz.hospx.databinding.ActivitySelectCategoryBinding

class SelectCategoryActivity : AppCompatActivity() {

    private val binding: ActivitySelectCategoryBinding by lazy { ActivitySelectCategoryBinding.inflate(layoutInflater) }
    private val adapter by lazy { CategoryAdapter(layoutInflater) }

    private val categoryList: MutableList<CategoryModel> by lazy {
        (1..10)
            .map {
                val type = if (it % 2 == 0) "Even" else "Odd"
                CategoryModel("$it", type)
            }
            .sortedWith(compareBy({ it.categoryType }, { it.name.toInt() }))
            .toMutableList()
            .apply {
                val firstEven = first { it.categoryType == "Even" }
                add(indexOf(firstEven), CategoryModel(categoryType = "Even", isHeader = true))

                val firstOdd = first { it.categoryType == "Odd" }
                add(indexOf(firstOdd), CategoryModel(categoryType = "Odd", isHeader = true))
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
        adapter.selectionMode = CategoryAdapter.Mode.SINGLE

        binding.btnSelectionConfirm.setOnClickListener {
            val selectionText = adapter.getSelectedItems().joinToString(", ") { it.name }
            Toast.makeText(
                this,
                if (selectionText.isEmpty()) "No Item Selected." else selectionText,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

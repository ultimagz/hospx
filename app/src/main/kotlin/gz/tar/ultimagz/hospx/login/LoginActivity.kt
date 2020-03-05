package gz.tar.ultimagz.hospx.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gz.tar.ultimagz.hospx.category.SelectCategoryActivity
import gz.tar.ultimagz.hospx.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, SelectCategoryActivity::class.java))
        }
    }
}

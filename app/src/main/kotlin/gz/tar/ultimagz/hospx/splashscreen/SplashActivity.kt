package gz.tar.ultimagz.hospx.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gz.tar.ultimagz.hospx.databinding.ActivitySplashBinding
import gz.tar.ultimagz.hospx.login.LoginActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    var transitionJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        transitionToLogin()
    }

    override fun onPause() {
        super.onPause()
        val active = transitionJob?.isActive ?: false
        if (active) {
            transitionJob?.cancel()
        }
    }

    private fun transitionToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        transitionJob = GlobalScope.launch {
            delay(2000L)
            startActivity(intent)
            finish()
        }
    }
}

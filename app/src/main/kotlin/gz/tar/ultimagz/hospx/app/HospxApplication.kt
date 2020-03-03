package gz.tar.ultimagz.hospx.app

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HospxApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HospxApplication)
            modules(listOf())
            logger(TimberLogger())
        }
    }
}
package gz.tar.ultimagz.hospx.app

import androidx.multidex.MultiDexApplication
import gz.tar.ultimagz.hospx.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class HospxApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HospxApplication)
            modules(listOf())
            logger(TimberLogger())
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
//            Timber.plant(CrashReportingTree())
        }
    }
}
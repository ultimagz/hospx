package gz.tar.ultimagz.hospx

import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

class TimberLogger(
    tag: String? = null
) : Logger() {

    private val tree: Timber.Tree = if (tag === null) Timber.DebugTree() else Timber.tag(tag)

    override fun log(level: Level, msg: MESSAGE) {
        if (this.level <= level) {
            logOnLevel(msg)
        }
    }

    private fun logOnLevel(msg: MESSAGE) {
        when (this.level) {
            Level.DEBUG -> tree.d(msg)
            Level.INFO -> tree.i(msg)
            Level.ERROR -> tree.e(msg)
        }
    }
}
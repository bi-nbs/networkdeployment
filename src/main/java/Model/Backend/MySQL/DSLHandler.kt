package Model.Backend.MySQL

import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.conf.Settings
import org.jooq.impl.DSL

object DSLHandler {

    fun getContext(): DSLContext {
        val settings = Settings()
        settings.isExecuteLogging = true

        return DSL.using(MySQLHandler.getConnection(), SQLDialect.MYSQL, settings)
    }


}
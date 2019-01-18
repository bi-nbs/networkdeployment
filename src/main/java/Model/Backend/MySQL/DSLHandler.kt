package Model.Backend.MySQL

import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL

object DSLHandler {

    fun getContext(): DSLContext {
        return DSL.using(MySQLHandler.getConnection(), SQLDialect.MYSQL)
    }


}
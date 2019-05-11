package Structural.Facade

import java.sql.Connection

class MySqlHelper {

    companion object {
        fun getMySqlDBConnection(): Connection?{
            return null
        }
    }

    fun generateMySqlPDFReport(tableName: String, con: Connection?){
        println("get data from $tableName MySQL and generate pdf report")
    }

    fun generateMySqlHtmlReport(tableName: String, con: Connection?){
        println("get data from $tableName MySQL and generate HTML report")
    }
}
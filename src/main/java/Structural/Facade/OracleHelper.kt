package Structural.Facade

import java.sql.Connection

class OracleHelper {

    companion object {
        fun getOracleConnection(): Connection?{
            return null
        }
    }

    fun generateOraclePDFReport(tableName: String, con: Connection?) {
        println("get data from $tableName Oracle and generate pdf report")
    }

    fun generateOracleHtmlReport(tableName: String, con: Connection?){
        println("get data from $tableName Oracle and generate HTML report")
    }
}
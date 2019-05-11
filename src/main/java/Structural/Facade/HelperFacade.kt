package Structural.Facade

import java.sql.Connection

class HelperFacade {

    companion object {
        enum class DBTypes {
            MYSQL, ORACLE
        }

        enum class ReportTypes {
            HTML, PDF
        }

        fun generateReport(dbType: DBTypes, reportType: ReportTypes, tableName: String){
            var con: Connection?  = null

            when(dbType){
                Companion.DBTypes.MYSQL -> {
                    con = MySqlHelper.getMySqlDBConnection()
                    val mySqlHelper = MySqlHelper()

                    when(reportType){
                        Companion.ReportTypes.HTML -> mySqlHelper.generateMySqlHtmlReport(tableName, con)
                        Companion.ReportTypes.PDF -> mySqlHelper.generateMySqlPDFReport(tableName, con)
                    }
                }

                Companion.DBTypes.ORACLE -> {
                    con = OracleHelper.getOracleConnection()
                    val oracleHelper = OracleHelper()

                    when(reportType){
                        Companion.ReportTypes.HTML -> oracleHelper.generateOracleHtmlReport(tableName, con)
                        Companion.ReportTypes.PDF -> oracleHelper.generateOraclePDFReport(tableName, con)
                    }
                }
            }
        }

    }
}
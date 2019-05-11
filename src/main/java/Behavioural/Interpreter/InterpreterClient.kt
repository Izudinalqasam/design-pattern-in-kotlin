package Behavioural.Interpreter

class InterpreterClient(
        private val ic: InterpreterContext
) {

    fun interpret(str: String): String {
        var expression: Expression? = null

        when {
            str.contains("Hexadecimal") -> {
                expression = IntToHexExpression(str.substring(0, str.indexOf(" ")).toInt())
            }
            str.contains("Binary") -> {
                expression = IntToBinaryExpression(str.substring(0, str.indexOf(" ")).toInt())
            }
            else -> return str
        }

        return expression.interpret(ic)
    }

}
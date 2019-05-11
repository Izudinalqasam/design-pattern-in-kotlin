package Behavioural.Interpreter

class IntToHexExpression(private val rawData: Int) : Expression {

    override fun interpret(ic: InterpreterContext) = ic.getHexaDecimalFormat(rawData)
}
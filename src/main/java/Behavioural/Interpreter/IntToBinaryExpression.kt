package Behavioural.Interpreter

class IntToBinaryExpression(private val rawData: Int) : Expression {

    override fun interpret(ic: InterpreterContext) = ic.getBinaryFormat(rawData)
}
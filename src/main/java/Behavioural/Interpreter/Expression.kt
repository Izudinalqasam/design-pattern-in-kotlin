package Behavioural.Interpreter

interface Expression {

    fun interpret(ic: InterpreterContext): String
}
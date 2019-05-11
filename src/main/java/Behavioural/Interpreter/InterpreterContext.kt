package Behavioural.Interpreter

class InterpreterContext {

    fun getBinaryFormat(data: Int) = Integer.toBinaryString(data)

    fun getHexaDecimalFormat(data: Int) = Integer.toHexString(data)
}
package Behavioural.ChainOfResponsibility

interface DispenseChain{

    fun setNextChain(chain: DispenseChain)

    fun dispense(currencyCOR: CurrencyCOR)
}
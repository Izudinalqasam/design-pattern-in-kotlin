package Behavioural.ChainOfResponsibility

class Dollar50Dispenser : DispenseChain{

    private var chain: DispenseChain? = null

    override fun setNextChain(chain: DispenseChain) {
        this.chain = chain
    }

    override fun dispense(currencyCOR: CurrencyCOR) {
        if (currencyCOR.amount >= 50){
            val num = currencyCOR.amount / 50
            val remainder = currencyCOR.amount % 50

            println("Dispensing $num 50$ note")

            if (remainder != 0) this.chain?.dispense(CurrencyCOR(remainder))
        }else {
            chain?.dispense(currencyCOR)
        }
    }

}
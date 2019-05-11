package Behavioural.ChainOfResponsibility

class Dollar10Dispenser : DispenseChain {
    private var chain: DispenseChain? = null

    override fun setNextChain(chain: DispenseChain) {
        this.chain = chain
    }

    override fun dispense(currencyCOR: CurrencyCOR) {
        if (currencyCOR.amount >= 10){
            val num = currencyCOR.amount / 10
            val remainder = currencyCOR.amount % 10

            println("Dispensing $num 10$ note")

            if (remainder != 0) this.chain?.dispense(CurrencyCOR(remainder))
        }else {
            this.chain?.dispense(currencyCOR)
        }
    }
}
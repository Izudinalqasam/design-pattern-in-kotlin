package Behavioural.ChainOfResponsibility

class Dollar20Dispenser : DispenseChain {

    private var chain: DispenseChain? = null

    override fun setNextChain(chain: DispenseChain) {
        this.chain = chain
    }

    override fun dispense(currencyCOR: CurrencyCOR) {
        if (currencyCOR.amount >= 20){
            val num = currencyCOR.amount / 20
            val remainder = currencyCOR.amount % 20

            println("Dispensing $num 20$ note")

            if (remainder != 0) this.chain?.dispense(CurrencyCOR(remainder))
        }else{
            this.chain?.dispense(currencyCOR)
        }
    }
}
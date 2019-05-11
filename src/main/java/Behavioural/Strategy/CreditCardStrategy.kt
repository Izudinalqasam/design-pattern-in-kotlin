package Behavioural.Strategy

class CreditCardStrategy(
        private val name: String,
        private val cardNumber: String,
        private val cvv: String,
        private val dateOfExpiry: String
) : PaymentStrategy {

    override fun pay(amount: Int) {
        println("$amount paid with credit/debit card")
    }
}
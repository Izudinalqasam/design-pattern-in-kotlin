package Behavioural.Strategy

class PaypalStrategy(
        private val emailId: String,
        private val password: String
) : PaymentStrategy {

    override fun pay(amount: Int) {
        println("$amount paid using paypal")
    }
}
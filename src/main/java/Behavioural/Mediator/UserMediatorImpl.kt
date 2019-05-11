package Behavioural.Mediator

class UserMediatorImpl(
        val med: ChatMediator,
        val nama: String
) : UserMediator(med,nama){
    override fun receive(message: String) {
        println("$nama Receive message $message")
    }

    override fun send(message: String) {
        println("$nama send message $message")
        med.sendMessage(message, this)
    }

}
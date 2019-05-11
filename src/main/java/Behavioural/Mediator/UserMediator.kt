package Behavioural.Mediator

abstract class UserMediator(
        val mediator: ChatMediator,
        val name: String
){
    abstract fun send(message: String)
    abstract fun receive(message: String)
}
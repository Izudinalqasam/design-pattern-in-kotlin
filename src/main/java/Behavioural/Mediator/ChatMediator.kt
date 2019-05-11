package Behavioural.Mediator

interface ChatMediator {

    fun sendMessage(message: String, userMediator: UserMediator)

    fun addUser(userMediator: UserMediator)
}
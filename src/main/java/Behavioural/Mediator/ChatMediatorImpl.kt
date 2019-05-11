package Behavioural.Mediator

class ChatMediatorImpl : ChatMediator{

    private var listUser = ArrayList<UserMediator>()

    override fun sendMessage(message: String, userMediator: UserMediator) {
        for (user in listUser){
            if (user != userMediator){
                user.receive(message)
            }
        }
    }

    override fun addUser(userMediator: UserMediator) {
        listUser.add(userMediator)
    }

}
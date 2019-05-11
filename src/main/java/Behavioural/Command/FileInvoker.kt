package Behavioural.Command

class FileInvoker(
        private val command: Command
) {

    fun execute(){
        command.execute()
    }
}
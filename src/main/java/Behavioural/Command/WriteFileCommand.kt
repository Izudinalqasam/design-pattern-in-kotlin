package Behavioural.Command

class WriteFileCommand(
        private val fileSystemReceiver: FileSystemReceiver
) : Command {

    override fun execute() {
        fileSystemReceiver.writeFile()
    }
}
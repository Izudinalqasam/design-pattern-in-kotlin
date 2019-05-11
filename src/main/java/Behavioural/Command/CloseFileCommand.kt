package Behavioural.Command

class CloseFileCommand(
        private val fileSystemReceiver: FileSystemReceiver
) : Command {

    override fun execute() {
        fileSystemReceiver.closeFile()
    }
}
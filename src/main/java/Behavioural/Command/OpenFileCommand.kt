package Behavioural.Command

class OpenFileCommand(
        private val fileSystem: FileSystemReceiver
) : Command{

    override fun execute() {
        fileSystem.openFile()
    }
}
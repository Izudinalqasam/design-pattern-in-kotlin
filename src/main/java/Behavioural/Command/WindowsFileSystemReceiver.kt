package Behavioural.Command

class WindowsFileSystemReceiver : FileSystemReceiver {

    override fun openFile() {
        println("Opening file in windows OS")
    }

    override fun writeFile() {
        println("Writing file in windows OS")
    }

    override fun closeFile() {
        println("Closing file in windows OS")
    }
}
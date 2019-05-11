package Behavioural.Command

class UnixFileSystemReeiver : FileSystemReceiver {

    override fun openFile() {
        println("Opening file in unix os")
    }

    override fun writeFile() {
        println("Writing file in unix os")
    }

    override fun closeFile() {
        println("Closing file in unix os")
    }
}
package Behavioural.Command

interface FileSystemReceiver {
    fun openFile()
    fun writeFile()
    fun closeFile()
}
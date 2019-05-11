package Behavioural.Command

object FileSystemReceiveUtil {

    fun getUnderLyingFileSystem(): FileSystemReceiver{
        val osName = System.getProperty("os.name")
        println("Underlying OS is: $osName")

        if (osName.contains("Windows")){
            return WindowsFileSystemReceiver()
        }else{
            return UnixFileSystemReeiver()
        }
    }
}
package Structural.Proxy

interface CommandExecutor{

    @Throws(Exception::class)
    fun runCommand(cmd: String)
}
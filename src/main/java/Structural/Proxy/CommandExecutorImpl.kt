package Structural.Proxy

class CommandExecutorImpl : CommandExecutor {

    override fun runCommand(cmd: String) {
        // some heavy implementation
        Runtime.getRuntime().exec(cmd)
        println("' $cmd ' command executed")
    }
}
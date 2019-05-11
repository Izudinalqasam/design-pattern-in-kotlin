package Structural.Proxy

import java.lang.Exception

class CommandExecutorProxy(val user: String, val pwd: String) : CommandExecutor {

    private var isAdmin = false
    private var executor = CommandExecutorImpl()


    override fun runCommand(cmd: String) {
        if (isAdmin){
            executor.runCommand(cmd)
        }else{
            if (cmd.trim().startsWith("rm")){
                throw Exception("rm Command is not " +
                        "allowed for non-admin users")
            }else{
                executor.runCommand(cmd)
            }
        }
    }
}
package creational.Factory

class ComputerFactory {

    companion object {
        fun getComputer(type: String, ram: String, hdd: String, cpu: String) : Computer?{
            if (type.equals(type, ignoreCase = true)) return PC(ram, hdd, cpu)
            else if (type.equals("Server", ignoreCase = true)) return Server(ram, hdd, cpu)
            return null
        }
    }
}
package creational.Factory

class PC(private val ram: String,
         private val hdd: String,
         private val cpu: String) : Computer(){

    override fun getRAM() : String{
        return this.ram
    }

    override fun getHdd(): String {
        return this.hdd
    }

    override fun getCpu(): String {
        return this.cpu
    }

}
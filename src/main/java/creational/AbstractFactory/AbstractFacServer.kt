package creational.AbstractFactory

class AbstractFacServer(
        private val ram: String,
        private val hdd: String,
        private val cpu: String
) : AbstractFacComputer(){

    override fun getRAM(): String {
        return this.ram
    }

    override fun getHDD(): String {
        return this.hdd
    }

    override fun getCPU(): String {
        return this.cpu
    }

}
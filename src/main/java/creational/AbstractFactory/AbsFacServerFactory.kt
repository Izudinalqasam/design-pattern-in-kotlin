package creational.AbstractFactory

class AbsFacServerFactory(
        private val ram: String,
        private val hdd: String,
        private val cpu: String
) : AbsFacComputerAbstarkFac {

    override fun createComputer(): AbstractFacComputer {
        return AbstractFacServer(ram,hdd,cpu)
    }
}
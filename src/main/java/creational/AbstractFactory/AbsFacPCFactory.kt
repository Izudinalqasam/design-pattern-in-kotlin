package creational.AbstractFactory

class AbsFacPCFactory(
        private val ram: String,
        private val hdd: String,
        private val cpu: String
) : AbsFacComputerAbstarkFac {

    override fun createComputer() : AbstractFacComputer {
        return AbstractFacPC(ram, hdd, cpu)
    }

}
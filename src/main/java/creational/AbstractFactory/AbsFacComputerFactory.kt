package creational.AbstractFactory

object AbsFacComputerFactory {
    fun getComputer(factory: AbsFacComputerAbstarkFac) : AbstractFacComputer{
        return factory.createComputer()
    }
}
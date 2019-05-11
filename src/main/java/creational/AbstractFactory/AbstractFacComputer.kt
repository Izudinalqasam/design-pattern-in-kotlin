package creational.AbstractFactory

abstract class AbstractFacComputer {

    abstract fun getRAM() : String
    abstract fun getHDD() : String
    abstract fun getCPU() : String

    override fun toString(): String {
        return "RAM= ${this.getRAM()} , HDD= ${this.getHDD()} , CPU= ${this.getCPU()}"
    }
}
package creational.Factory

abstract class Computer {

    abstract fun getRAM() : String
    abstract fun getHdd() : String
    abstract fun getCpu() : String

    override fun toString(): String {
        return "RAM= ${this.getRAM()} , HDD= ${this.getHdd()} , CPU= ${this.getCpu()}"
    }
}
package Structural.Decorator

open class CarDecorator(
        protected val car: Car
) : Car{

    override fun assemble() {
        car.assemble()
    }
}
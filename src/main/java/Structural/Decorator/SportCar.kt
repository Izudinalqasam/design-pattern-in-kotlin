package Structural.Decorator

class SportCar(car: Car) : CarDecorator(car) {

    override fun assemble() {
        super.assemble()
        print("adding features of sport car. ")
    }
}
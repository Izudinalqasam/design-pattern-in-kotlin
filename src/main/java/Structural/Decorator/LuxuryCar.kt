package Structural.Decorator

class LuxuryCar(car: Car) : CarDecorator (car){

    override fun assemble() {
        super.assemble()
        print("Adding features of luxury car. ")
    }
}
package Behavioural.TemplateDesign

class WoodHouse : HouseTemplate(){
    override fun buildWalls() {
        println("Building Wooden Walls")
    }

    override fun buildPillars() {
        println("Building Pillars with Wood coating")
    }

}
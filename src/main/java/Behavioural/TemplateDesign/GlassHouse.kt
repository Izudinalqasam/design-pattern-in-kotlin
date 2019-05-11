package Behavioural.TemplateDesign

class GlassHouse : HouseTemplate(){

    override fun buildWalls() {
        println("Building Glass Walls")
    }

    override fun buildPillars() {
        println("Building Pillars with glass coating")
    }
}
package Behavioural.TemplateDesign

abstract class HouseTemplate {

    // template method, final , so subclasses can't ovveride
    fun buildHouse(){
        buildFoundation()
        buildPillars()
        buildWalls()
        buildWindows()
        println("House is built")
    }

    abstract fun buildWalls()
    abstract fun buildPillars()

    private fun buildWindows(){
        println("Building Glass Windows")
    }

    private fun buildFoundation(){
        println("Building foundation with cement, iron rods and sand")
    }
}
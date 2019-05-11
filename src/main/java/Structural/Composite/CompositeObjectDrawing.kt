package Structural.Composite

class CompositeObjectDrawing : BaseComponentShape {

    private var shapes = ArrayList<BaseComponentShape>()

    override fun draw(fillColor: String) {
        shapes.forEach {
            it.draw(fillColor)
        }
    }

    fun add(shape: BaseComponentShape){
        this.shapes.add(shape)
    }

    fun remove(shape: BaseComponentShape){
        this.shapes.remove(shape)
    }

    fun clear(){
        println("Clearing all the shapes from drawing")
        this.shapes.clear()
    }
}
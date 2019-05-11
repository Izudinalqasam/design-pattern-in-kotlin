package Structural.FlyWeight

import javafx.scene.shape.Circle
import java.util.HashMap



class ShapeFactoryFWPattern {

    companion object {
        var circleMap = HashMap<String, ShapeFWPattern>()

        fun getCircle(color: String): ShapeFWPattern{
            var circle: ShapeFWPattern? = circleMap.get(color) ?: null

            if (circle == null){
                circle = CircleFWPattern(color)
                circleMap.put(color, circle)
                println("Creating circle of color : $color")
            }
            return circle as ShapeFWPattern
        }
    }
}
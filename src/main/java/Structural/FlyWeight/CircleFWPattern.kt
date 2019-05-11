package Structural.FlyWeight

import java.awt.Graphics

data class CircleFWPattern(
        val color: String,
        var x: Int = 0,
        var y: Int = 0,
        var radius: Int = 0
        ) : ShapeFWPattern{

    override fun draw() {
        println("Circle: Draw() [Color : $color, x : $x, y : $y, radius : $radius")
    }
}
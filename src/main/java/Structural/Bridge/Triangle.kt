package Structural.Bridge

class Triangle(c: ColorBridge) : ShapeBridge(c) {

    override fun applyColor() {
        print("Triangle filled with color ")
        colorBridge.applyColor()
    }
}
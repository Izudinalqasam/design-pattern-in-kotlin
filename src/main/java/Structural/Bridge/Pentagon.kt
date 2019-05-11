package Structural.Bridge

class Pentagon(c: ColorBridge) : ShapeBridge(c){

    override fun applyColor() {
        print("Pentagon filled with color ")
        colorBridge.applyColor()
    }
}
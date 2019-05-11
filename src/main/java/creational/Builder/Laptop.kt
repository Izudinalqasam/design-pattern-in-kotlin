package creational.Builder

data class Laptop private constructor(
        val Ram: String,
        val Hdd: String,
        val isGraphicsCardEnabled: Boolean,
        val isBluetoothEnabled: Boolean
) {
    class LaptopBuilder(private val HDD: String, private val RAM: String) {

        // Optional Parameters
        private var isGraphicsCardEnabled: Boolean = false
        private var isBluetoothEnabled: Boolean = false

        fun setGrapichCardEnabled(isGraphicsCardEnabled: Boolean) = apply {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled
        }

        fun setBluetoothEnabled(isBluetoothEnabled: Boolean) = apply {
            this.isBluetoothEnabled = isBluetoothEnabled
        }

        fun build() = Laptop(HDD, RAM, isGraphicsCardEnabled, isBluetoothEnabled)
    }
}


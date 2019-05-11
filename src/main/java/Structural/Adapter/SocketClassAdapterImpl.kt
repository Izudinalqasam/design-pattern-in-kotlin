package Structural.Adapter

class SocketClassAdapterImpl : Socket(), SocketAdapter{

    override fun get120Volt(): Volt = convertVolt(getVolt(), 1)

    override fun get12Volt(): Volt = convertVolt(getVolt(), 10)

    override fun get3Volt(): Volt = convertVolt(getVolt(), 40)

    fun convertVolt(v: Volt, decided: Int ) : Volt = Volt(v.volt/decided)

}
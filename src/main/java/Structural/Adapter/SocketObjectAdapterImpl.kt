package Structural.Adapter

class SocketObjectAdapterImpl : SocketAdapter{

    private var sock = Socket()

    override fun get12Volt(): Volt = convertVolt(sock.getVolt(), 1)

    override fun get3Volt(): Volt = convertVolt(sock.getVolt(), 10)

    override fun get120Volt(): Volt = convertVolt(sock.getVolt(), 40)

    fun convertVolt(v: Volt, devided: Int) = Volt(v.volt / devided)

}
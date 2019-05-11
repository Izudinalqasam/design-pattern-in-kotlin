package Structural.Adapter

open class Socket{
    open fun getVolt(): Volt{
        return Volt(120)
    }
}
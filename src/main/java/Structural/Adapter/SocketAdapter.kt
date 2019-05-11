package Structural.Adapter

interface SocketAdapter{

    fun get120Volt() : Volt
    fun get12Volt() : Volt
    fun get3Volt() : Volt
}
package Behavioural.Observer

interface Subject {

    fun register(observer: Observer)
    fun unRegister(observer: Observer)
    fun notifyObservers()
    fun getUpdate(): Any
}
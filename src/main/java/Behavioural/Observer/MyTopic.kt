package Behavioural.Observer

import java.lang.NullPointerException

class MyTopic : Subject {

    private var observers = mutableListOf<Observer>()
    private var message: String = ""
    private var changed: Boolean = false
    private val MUTEX = Any()

    override fun register(observer: Observer) {
        if (observer == null) throw NullPointerException("Null Observer")

        synchronized(MUTEX){
            if (!observers.contains(observer)){
                observers.add(observer)
            }
        }
    }

    override fun unRegister(observer: Observer) {
        synchronized(MUTEX){
            observers.remove(observer)
        }
    }

    override fun notifyObservers() {
        synchronized(MUTEX){
            if (!changed)
                return@synchronized
            this.changed = false
        }

        for (obj in observers){
            obj.update()
        }
    }

    override fun getUpdate(): Any  = this.message

    fun postMessage(msg : String){
        println("Message posted to Topic: $msg")
        this.message = msg
        this.changed = true
        notifyObservers()
    }
}
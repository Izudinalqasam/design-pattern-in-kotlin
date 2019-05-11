package Behavioural.Observer

interface Observer {

    fun update()
    fun setSubject(sub: Subject)
}
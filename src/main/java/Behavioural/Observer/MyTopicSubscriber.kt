package Behavioural.Observer

class MyTopicSubscriber(val name: String) : Observer{

    private lateinit var topic: Subject

    override fun update() {
        val msg = topic.getUpdate() as String
        msg?.let {
            println("$name Consuming message:: $msg")
        }
    }

    override fun setSubject(sub: Subject) {
        this.topic = sub
    }
}
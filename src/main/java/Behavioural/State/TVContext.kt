package Behavioural.State

data class TVContext(
        var stateTV: StateTV
) : StateTV {

    override fun doAction() {
        stateTV.doAction()
    }
}
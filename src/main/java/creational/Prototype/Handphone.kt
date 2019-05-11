package creational.Prototype

data class Handphone(
        private var SOC: String,
        private var MEMORY: String,
        private var GPU : String
) : Cloneable {

    fun setSOC(soc: String){
        this.SOC = soc
    }

    fun setMEMORY(memory: String){
        this.MEMORY = memory
    }

    fun setGPU(gpu: String){
        this.GPU = gpu
    }

    fun loadData(){
        SOC = "MEDIATEK"
        MEMORY = "SAMSUNG"
        GPU = "MALI"
    }

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        return super.clone()
    }
}
package Behavioural.Strategy

class Item(
        private val upcCode: String,
        private val price: Int
){
    fun getUpcode() = upcCode

    fun getPrice() = price

}
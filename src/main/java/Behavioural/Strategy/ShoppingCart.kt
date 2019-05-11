package Behavioural.Strategy

class ShoppingCart {

    private var items: ArrayList<Item> = ArrayList()

    fun addItem(item: Item){
        items.add(item)
    }

    fun removeItem(item: Item){
        items.remove(item)
    }

    fun calculateTotal(): Int {
        var sum = 0
        for (item in items){
            sum += item.getPrice()
        }

        return sum
    }

    fun pay(paymentStrategy: PaymentStrategy){
        val amount = calculateTotal()
        paymentStrategy.pay(amount)
    }
}

package Behavioural.Visitor

class ShoppingCartVisitorImpl : ShoppingCartVisitor {

    override fun visit(book: BookVisitor): Int {
        var cost = 0

        if (book.cost > 50){
            cost= book.cost - 5
        }else{
            cost = book.cost
        }

        println("Book ISBN::${book.isbn} cost =$cost")
        return cost
    }

    override fun visit(fruitVisitor: FruitVisitor): Int {
        val cost = fruitVisitor.priceKg * fruitVisitor.weight
        println("${fruitVisitor.nm} cost = $cost")
        return cost
    }
}
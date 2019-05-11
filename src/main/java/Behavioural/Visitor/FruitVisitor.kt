package Behavioural.Visitor

data class FruitVisitor(
        var priceKg: Int,
        var weight: Int,
        var nm: String
) : ItemElement {

    override fun accept(visitor: ShoppingCartVisitor) = visitor.visit(this)
}
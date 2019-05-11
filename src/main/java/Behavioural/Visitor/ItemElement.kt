package Behavioural.Visitor

interface ItemElement {
    fun accept(visitor: ShoppingCartVisitor): Int
}
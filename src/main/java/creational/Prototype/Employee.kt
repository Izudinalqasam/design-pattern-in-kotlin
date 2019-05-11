package creational.Prototype

import java.util.ArrayList



class Employee : Cloneable{

    private var empList: MutableList<String>

    constructor(){
        empList = ArrayList()
    }

    constructor(list: MutableList<String>) {
        this.empList = list
    }

    fun loadData(){
        empList.add("Pankaj")
        empList.add("Raj")
        empList.add("David")
        empList.add("Lisa")
    }

    fun getEmpList() = empList

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        var temp: MutableList<String> = ArrayList()

        getEmpList().forEach {
            temp.add(it)
        }

        return Employee(temp)

    }
}

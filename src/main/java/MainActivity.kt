import Behavioural.ChainOfResponsibility.*
import Behavioural.Command.*
import Behavioural.Interpreter.InterpreterClient
import Behavioural.Interpreter.InterpreterContext
import Behavioural.Iterator.Channel
import Behavioural.Iterator.ChannelCollection
import Behavioural.Iterator.ChannelTypeEnum
import Behavioural.Mediator.ChannelCollectionImpl
import Behavioural.Mediator.ChatMediatorImpl
import Behavioural.Mediator.UserMediatorImpl
import Behavioural.Memento.FileWriterCaretaker
import Behavioural.Memento.FileWriterUtil
import Behavioural.Observer.MyTopic
import Behavioural.Observer.MyTopicSubscriber
import Behavioural.State.TVContext
import Behavioural.State.TVStartState
import Behavioural.State.TVStopState
import Behavioural.Strategy.CreditCardStrategy
import Behavioural.Strategy.Item
import Behavioural.Strategy.PaypalStrategy
import Behavioural.Strategy.ShoppingCart
import Behavioural.TemplateDesign.GlassHouse
import Behavioural.TemplateDesign.HouseTemplate
import Behavioural.TemplateDesign.WoodHouse
import Behavioural.Visitor.*
import Structural.Adapter.SocketAdapter
import Structural.Adapter.SocketClassAdapterImpl
import Structural.Adapter.Volt
import Structural.Bridge.GreenColor
import Structural.Bridge.Pentagon
import Structural.Bridge.RedColor
import Structural.Bridge.Triangle
import Structural.Composite.CompositeObjectDrawing
import Structural.Composite.LeafObjectCircle
import Structural.Composite.LeafObjectTriangle
import Structural.Decorator.BasicCar
import Structural.Decorator.CarDecorator
import Structural.Decorator.LuxuryCar
import Structural.Decorator.SportCar
import Structural.Facade.HelperFacade
import Structural.FlyWeight.CircleFWPattern
import Structural.FlyWeight.ShapeFactoryFWPattern
import Structural.Proxy.CommandExecutorProxy
import creational.AbstractFactory.AbsFacComputerFactory
import creational.AbstractFactory.AbsFacPCFactory
import creational.AbstractFactory.AbsFacServerFactory
import creational.Builder.Laptop
import creational.Builder.LaptopJava
import creational.Factory.ComputerFactory
import creational.Prototype.Employee
import creational.Prototype.Handphone
import creational.Singleton.BillPughSingleton
import java.lang.Exception



fun main() {
    val single = BillPughSingleton.instance

    val overNumber = 1_000
    println(Int.MAX_VALUE)
    println(overNumber)

//    mementoPattern()
}

fun mementoPattern(){
    val careTaker = FileWriterCaretaker()

    val fileWriter = FileWriterUtil("data.txt")
    fileWriter.write("First Set of Data\n")
    println("$fileWriter\n\n")

    careTaker.save(fileWriter)

    fileWriter.write("Second Set of Data\n")
    println("$fileWriter\n\n")

    careTaker.undo(fileWriter)

    println("$fileWriter\n\n")
}

fun iteratorPattern(){
    val channels = getPopulateChannel()
    val baseIterator = channels.iterators(ChannelTypeEnum.ALL)

    while (baseIterator.hasNext()){
        var c = baseIterator.nextt()
        println(c.toString())
    }

    println("************")

    val englishIterator = channels.iterators(ChannelTypeEnum.ENGLISH)

    while (englishIterator.hasNext()){
        var c = englishIterator.nextt()
        println(c.toString())
    }
}

fun getPopulateChannel(): ChannelCollection {
    val channel = ChannelCollectionImpl()
    channel.addChannel(Channel(98.5, ChannelTypeEnum.ENGLISH))
    channel.addChannel(Channel(99.5, ChannelTypeEnum.HINDI))
    channel.addChannel(Channel(100.5, ChannelTypeEnum.FRENCH))
    channel.addChannel(Channel(101.5, ChannelTypeEnum.ENGLISH))
    channel.addChannel(Channel(102.5, ChannelTypeEnum.HINDI))
    channel.addChannel(Channel(103.5, ChannelTypeEnum.FRENCH))
    channel.addChannel(Channel(104.5, ChannelTypeEnum.ENGLISH))
    channel.addChannel(Channel(105.5, ChannelTypeEnum.HINDI))
    channel.addChannel(Channel(106.5, ChannelTypeEnum.FRENCH))

    return channel
}

fun interpreterPattern(){
    val str1 = "28 in Binary"
    val str2 = "28 in Hexadecimal"

    val ec = InterpreterClient(InterpreterContext())

    println("$str1 = ${ec.interpret(str1)}")
    println("$str2 = ${ec.interpret(str2)}")
}

fun visitorPattern(){
    val items: Array<ItemElement> = arrayOf(BookVisitor(20, "1234"), BookVisitor(100, "5678"), FruitVisitor(10, 2, "Banana"), FruitVisitor(5, 5, "Apple"))

    val total = calculatePrice(items)
    println("Total Cost = $total")
}

fun calculatePrice(items: Array<ItemElement>): Int{
    val visitor: ShoppingCartVisitor = ShoppingCartVisitorImpl()

    var sum = 0
    for (element in items){
        sum += element.accept(visitor)
    }
    return sum
}

fun statePattern(){

    val tvStartState = TVStartState()
    val tvStopState = TVStopState()

    val context = TVContext(tvStartState)
    context.doAction()

    context.stateTV = tvStopState
    context.doAction()


}

fun commandPattern(){
    val filesystem = FileSystemReceiveUtil.getUnderLyingFileSystem()

    val openFileCommand = OpenFileCommand(filesystem)
    var file = FileInvoker(openFileCommand)
    file.execute()

    val writeFileCommand = WriteFileCommand(filesystem)
    file = FileInvoker(writeFileCommand)
    file.execute()

    val closeFileCommand = CloseFileCommand(filesystem)
    file = FileInvoker(closeFileCommand)
    file.execute()
}

fun strategyPattern(){
    val shoppingCart = ShoppingCart()

    val item1 = Item("1234", 100)
    val item2 = Item("5678", 400)

    shoppingCart.addItem(item1)
    shoppingCart.addItem(item2)

    shoppingCart.pay(PaypalStrategy("izzudin@popbox.asia", "mypopbox"))
    shoppingCart.pay(CreditCardStrategy("Izzudin A Q", "12345678910", "786", "12/15"))
}

fun observerPattern(){
    val topic = MyTopic()

    var obs1 = MyTopicSubscriber("obs1")
    var obs2 = MyTopicSubscriber("obs2")
    var obs3 = MyTopicSubscriber("obs3")

    topic.register(obs1)
    topic.register(obs2)
    topic.register(obs3)

    obs1.setSubject(topic)
    obs2.setSubject(topic)
    obs3.setSubject(topic)

    obs1.update()

    topic.postMessage("Hellow")
}

fun chainOfResponsiblityPattern(){
    val chain1 = Dollar50Dispenser()
    val chain2 = Dollar20Dispenser()
    val chain3 = Dollar10Dispenser()

    chain1.setNextChain(chain2)
    chain2.setNextChain(chain3)

    chain1.dispense(CurrencyCOR(45))
}

fun mediatorPattern(){
    val mediator = ChatMediatorImpl()

    val user1 = UserMediatorImpl(mediator, "Pankaj")
    val user2 = UserMediatorImpl(mediator, "Lisa")
    val user3 = UserMediatorImpl(mediator, "Saurabh")
    val user4 = UserMediatorImpl(mediator, "David")

    mediator.addUser(user1)
    mediator.addUser(user2)
    mediator.addUser(user3)
    mediator.addUser(user4)

    user1.send("Hellow")
}

fun templateDesignPattern(){
    var houseTemplate: HouseTemplate = WoodHouse()
    houseTemplate.buildHouse()

    println("***************")

    houseTemplate = GlassHouse()
    houseTemplate.buildHouse()
}

fun decoratorPattern() {
    val sportCar = SportCar(BasicCar())
    sportCar.assemble()
    println("\n*****")

    val sportLuxuryCar = SportCar(LuxuryCar(BasicCar()))
    sportLuxuryCar.assemble()

    val carDecorator = CarDecorator(BasicCar())
    carDecorator.assemble()
}

fun bridgePattern(){
    val tri = Triangle(RedColor())
    tri.applyColor()

    val pent = Pentagon(GreenColor())
    pent.applyColor()
}

fun facadePattern(){
    HelperFacade.generateReport(HelperFacade.Companion.DBTypes.MYSQL, HelperFacade.Companion.ReportTypes.HTML, "Employee")
}

fun flyWeightPattern(){
    val colors = arrayOf("Red", "Green", "Blue", "White", "Black")

    for (i in 1..20) {
        var circle = ShapeFactoryFWPattern.getCircle(getRandomColor(colors)) as CircleFWPattern
        circle.apply {
            x = getRandomX(colors) as Int
            y = getRandomY(colors) as Int
            radius = 100
            draw()
        }
    }
}

fun getRandomColor(colors: Array<String>) = colors[(Math.random() * colors.size).toInt()]

fun getRandomX(colors: Array<String>) = colors[(Math.random() * 100).toInt()]

fun getRandomY(colors: Array<String>) = colors[(Math.random() * 100).toInt()]

fun proxyPattern(){
    val executor = CommandExecutorProxy("Pankaj", " wrong_pwd")
    try {
        executor.runCommand("ls -ltr")
        executor.runCommand(" rm -rf abc.pdf")
    }catch (e: Exception){
        println("Exception Message:: ${e.message}")
    }
}


fun compositePattern(){
    val tri = LeafObjectTriangle()
    val cir = LeafObjectCircle()

    val drawing = CompositeObjectDrawing()
    drawing.add(tri)
    drawing.add(cir)

    drawing.draw("White and Black")
    drawing.clear()

    drawing.add(tri)
    drawing.add(cir)
    drawing.draw("Yellow, White and Black")
}

fun adapterPattern(){
    var socket: SocketAdapter = SocketClassAdapterImpl()

    val v3  = getVolt(socket, 3)
    val v12  = getVolt(socket, 12)
    val v120 = getVolt(socket, 120)

    println("V3 volts using Class Adapter ${v3.volt}")
    println("V12 volts using Class Adapter ${v12.volt}")
    println("V120 volts using Class Adapter ${v120.volt}")
}

fun getVolt(sockAdapter: SocketAdapter, voltDeman: Int): Volt{
    return when(voltDeman){
        12 -> sockAdapter.get120Volt()
        120 -> sockAdapter.get12Volt()
        3 -> sockAdapter.get3Volt()
        else -> sockAdapter.get120Volt()
    }
}

fun prototypePatternObj(){
    val hp = Handphone("","","")
    hp.loadData()

    val hpClone1 = hp.clone() as Handphone
    hpClone1.setSOC("SNAPDRAGON")
    val hpClone2 = hp.clone() as Handphone
    hpClone2.setSOC("KIRIN")
    hpClone2.setGPU("ADRENO")

    hp.setMEMORY("Hynix")

    println(hp)
    println(hpClone1)
    println(hpClone2)
}

fun prototyprPattern(){
    val employ = Employee()
    employ.loadData()

    val employClone1 = employ.clone() as Employee
    val employClone2 = employ.clone() as Employee

    // Change data
    val listClone1 = employClone1.getEmpList()
    listClone1.remove("Pankaj")
    val listClone2 = employClone2.getEmpList()
    listClone2.add("Fahri")

    println("empty List : ${employ.getEmpList()}")
    println("empty List Clone 1 : ${employClone1.getEmpList()}")
    println("empty List Clone 2 : ${employClone2.getEmpList()}")
}

fun builderPatternInKotlin(){
    val laptop = Laptop.LaptopBuilder("1 TB", "16 GB")
            .setBluetoothEnabled(true)
            .build()

    println(laptop)
}

fun builderPattern(){
    val laptop: LaptopJava = LaptopJava.LaptopJavaBuilder("500 GB", "2 GB")
            .setBluetoothEnabled(true)
            .build()

    println(laptop)
}

fun abstrackFactoryPattern(){
    val pc = AbsFacComputerFactory.getComputer(AbsFacPCFactory("2 GB", "500 Gb", "2.4 Ghz"))
    val server = AbsFacComputerFactory.getComputer(AbsFacServerFactory("16 GB", "500 TB", "2.9 Ghz"))

    println("AbstractFactory PC Config::$pc")
    println("AbstractFactory Server Config::$server")
}

fun factoryPattern(){
    val pc  = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 Ghz")
    val server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz")

    println("Factory PC config:: $pc")
    println("Factory Server config::$server")
}

fun reflectSingleton(){
    // can be used to destroy all the above singleton Implementation approaches
    val instanceOne = BillPughSingleton.instance
    var instanceTwo : BillPughSingleton? = null

    try {
        var constractor = BillPughSingleton::class.java.declaredConstructors

        constractor.forEach{i ->
            i.isAccessible = true
            instanceTwo = i.newInstance() as BillPughSingleton
            return@forEach
        }
    }catch (e : Exception){
        e.printStackTrace()
    }

    println(instanceOne.hashCode())
    println(instanceTwo.hashCode())
}

fun testLAbelAnotate(){
    first@ for (i in 1..9){
        for (j in 1.. 9){
            println("yang Ke 1 -> $i and ke 2 -> $j")
            j?.let {
                return@let
            }
        }
    }
}
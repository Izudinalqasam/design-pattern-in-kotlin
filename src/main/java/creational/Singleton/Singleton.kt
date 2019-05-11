package creational.Singleton


object BillPughSingleton {

    val instance: BillPughSingleton
        get() = BillPughSingleton.SingletonHelper.INSTANCE

    lateinit var namaClass: String
        private set

    private object SingletonHelper {
        val INSTANCE = BillPughSingleton
    }
}

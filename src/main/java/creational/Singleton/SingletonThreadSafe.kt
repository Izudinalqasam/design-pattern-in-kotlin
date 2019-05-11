package creational.Singleton

class SingletonThreadSafe{

    private constructor()

    companion object {
        private lateinit var instance: SingletonThreadSafe

        fun getInstanceUsingDoubleLocking(): SingletonThreadSafe {
            if (instance == null) {
                synchronized(SingletonThreadSafe::class.java) {
                    if (instance == null) {
                        instance = SingletonThreadSafe()
                    }
                }
            }
            return instance
        }
    }
}
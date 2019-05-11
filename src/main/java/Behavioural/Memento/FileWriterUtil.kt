package Behavioural.Memento

data class FileWriterUtil(
        private var fileName: String,
        private var content: StringBuilder = StringBuilder()

) {

    fun write(str: String){
        content.append(str)
    }

    override fun toString() = content.toString()

    fun save() = MementoInner(fileName, content)

    fun undoToLastSave(obj: Any){
        val momento = obj as MementoInner
        fileName = momento.fileName
        content = momento.content
    }

    class MementoInner(
            val fileName: String,
            contents: StringBuilder
    ) {
        var content = StringBuilder(contents)

    }

}


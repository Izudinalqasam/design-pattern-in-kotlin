package Behavioural.Memento

class FileWriterCaretaker {

    private lateinit var obj: Any

    fun save(fileWriterUtil: FileWriterUtil){
        this.obj = fileWriterUtil.save()
    }

    fun undo(fileWriterUtil: FileWriterUtil){
        fileWriterUtil.undoToLastSave(obj)
    }
}
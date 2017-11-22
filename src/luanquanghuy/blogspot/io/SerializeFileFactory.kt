package luanquanghuy.blogspot.io

import luanquanghuy.blogspot.module.SanPham
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class SerializeFileFactory : FileFactory {
    override fun saveFile(database: MutableList<SanPham>, path: String): Boolean {
        try {
            var fos: FileOutputStream = FileOutputStream(path)
            var oos: ObjectOutputStream = ObjectOutputStream(fos)
            oos.writeObject(database)
            oos.close()
            fos.close()
            return true
        } catch (ex: Exception){
            ex.printStackTrace()
        }
        return false
    }

    override fun loadFile(path: String): MutableList<SanPham> {
        var database : MutableList<SanPham> = mutableListOf()
        try {
            var fis : FileInputStream = FileInputStream(path)
            var ois : ObjectInputStream = ObjectInputStream(fis)
            var obj = ois.readObject()
            database = obj as MutableList<SanPham>
            ois.close()
            fis.close()
        }catch (ex : Exception){
            ex.printStackTrace()
        }
        return database
    }

}
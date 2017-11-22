package luanquanghuy.blogspot.io

import luanquanghuy.blogspot.module.SanPham

interface FileFactory {
    fun saveFile(database : MutableList<SanPham>, path : String) : Boolean
    fun loadFile(path: String) : MutableList<SanPham>
}
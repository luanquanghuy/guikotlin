package luanquanghuy.blogspot.test

import luanquanghuy.blogspot.module.SanPham
import luanquanghuy.blogspot.ui.SanPhamPanel
import luanquanghuy.blogspot.ui.SanPhamUI
import java.awt.Toolkit
import javax.swing.JFrame

class SanPhamApp{
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            var gui : SanPhamUI = SanPhamUI("Quang Huy")
            gui.showWindow()
        }
    }
}
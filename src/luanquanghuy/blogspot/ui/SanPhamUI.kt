package luanquanghuy.blogspot.ui

import luanquanghuy.blogspot.io.FileFactory
import luanquanghuy.blogspot.io.SerializeFileFactory
import luanquanghuy.blogspot.module.SanPham
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.util.ArrayList
import javax.swing.*

class SanPhamUI : JFrame {
    var menuBar : JMenuBar = JMenuBar()
    var menuSystem : JMenu = JMenu()
    var menuSaveSerializeFile : JMenuItem = JMenuItem()
    var menuLoadSerializeFile : JMenuItem = JMenuItem()

    var fileFactory : FileFactory? = null
    var sanPhamPanel : SanPhamPanel? = null

    constructor(title:String) : super(title){
        sanPhamPanel = SanPhamPanel()
        contentPane = sanPhamPanel!!.panel1
        createMenu()
        createEvent()

        addWindowListener(object : WindowAdapter(){
            override fun windowClosing(e: WindowEvent?) {
                fileFactory = SerializeFileFactory()
                var kq = fileFactory!!.saveFile(sanPhamPanel!!.database, "thongtin.dat")
                super.windowClosing(e)
//                System.exit(0)
            }

            override fun windowOpened(e: WindowEvent?) {
                fileFactory = SerializeFileFactory()
                sanPhamPanel!!.database = fileFactory!!.loadFile("thongtin.dat")
                sanPhamPanel!!.showDataOnJTable()
                super.windowOpened(e)
            }


        })
    }


    private fun createEvent(){

        menuSaveSerializeFile.addActionListener {

            fileFactory = SerializeFileFactory()
            var kq = fileFactory!!.saveFile(sanPhamPanel!!.database, "thongtin.dat")
            if (kq) JOptionPane.showMessageDialog(null, "Ban da save thanh cong")
        }
        menuLoadSerializeFile.addActionListener {
            fileFactory = SerializeFileFactory()
            sanPhamPanel!!.database = fileFactory!!.loadFile("thongtin.dat")
            sanPhamPanel!!.showDataOnJTable()
            JOptionPane.showMessageDialog(null, "Ban da load thanh cong")

        }
    }

    private fun createMenu(){
        menuBar = JMenuBar();
        jMenuBar = menuBar
        menuSystem = JMenu("File")
        menuBar.add(menuSystem)
        menuSaveSerializeFile = JMenuItem("Save File")
        menuSystem.add(menuSaveSerializeFile)
        menuLoadSerializeFile = JMenuItem("Load File")
        menuSystem.add(menuLoadSerializeFile)
        menuSystem.addSeparator()

    }

    fun showWindow(){
        setSize(500, 500)
        setLocationRelativeTo(null)
        extendedState = JFrame.MAXIMIZED_BOTH
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isVisible = true
    }
}





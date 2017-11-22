package luanquanghuy.blogspot

import java.awt.event.WindowEvent
import java.awt.event.WindowListener

class CustomWindowListener : WindowListener {
    override fun windowDeiconified(e: WindowEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowClosing(e: WindowEvent?) {
        println("Ban dang thoat")
    }

    override fun windowClosed(e: WindowEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowActivated(e: WindowEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowDeactivated(e: WindowEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowOpened(e: WindowEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowIconified(e: WindowEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
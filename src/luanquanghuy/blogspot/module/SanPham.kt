package luanquanghuy.blogspot.module

import java.io.Serializable

class SanPham : Serializable{
    var tenSanPham : String? = null
    var soLuong : Int? = null
    var gia : Int? = null
    constructor()
    constructor(tenSanPham: String, soLuong : Int, gia : Int){
        this.tenSanPham = tenSanPham
        this.soLuong = soLuong
        this.gia = gia
    }
    override fun toString() : String{
        return "$tenSanPham\t$soLuong\t$gia"
    }
}
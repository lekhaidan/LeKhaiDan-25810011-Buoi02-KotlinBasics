//LeKhaiDan-25810011
interface CoTheTinhDienTich {
    fun tinhDienTich() : Double
}
class HinhVuong(val canh: Double) : CoTheTinhDienTich {
    override fun tinhDienTich(): Double {
        return canh * canh
    }
}
class HinhTron(val radius: Double) : CoTheTinhDienTich {
    override fun tinhDienTich(): Double {
        return radius * radius * Math.PI
    }
}
val hv = HinhVuong(5.0)
val ht = HinhTron(5.0)
println(hv.tinhDienTich())
println(ht.tinhDienTich())
//LeKhaiDan-25810011
class SanPham(val tenSanPham: String, val gia: Double, val soLuongTonKho: Int = 0) {

}
val sp1 = SanPham(tenSanPham = "SP1", gia = 1.0, soLuongTonKho = 1)
val sp2 = SanPham(tenSanPham = "SP2", gia = 2.0)
println("${sp1.tenSanPham} - ${sp1.gia} - ${sp1.soLuongTonKho}")
println("${sp2.tenSanPham} - ${sp2.gia} - ${sp2.soLuongTonKho}")
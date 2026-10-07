//LeKhaiDan-25810011

class NhanVien(maNhanVien: String, val ten: String, var luongThang: Double) {
    constructor(ten: String) : this(maNhanVien = "M", ten = ten, luongThang = 0.0)
}
val nv1 = NhanVien(maNhanVien = "A", ten = "aaa", luongThang = 1.1)
// maNhanVien khong phai thuoc tinh cua lop
//println(nv1.maNhanVien)
val nv2 = NhanVien(ten = "aaa")
println(nv2.ten)
println(nv2.luongThang)
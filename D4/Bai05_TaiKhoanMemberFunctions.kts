//LeKhaiDan-25810011
class TaiKhoanNganHang(soTaiKhoan: String, soDuBanDau: Double) {
    var soDu = soDuBanDau
    init {
        if (soDuBanDau < 0.0) {
            println("So du khong hop le")
        } else {
            println("Tạo tài khoản thành công, số dư: $soDu")
        }
    }

    fun napTien(soTien: Double) {
        soDu += soTien
    }

    fun rutTien(soTien: Double): Boolean {
        if (soDu >= soTien) {
            soDu -= soTien
            return true
        }
        return false
    }
}

val tk1 = TaiKhoanNganHang(soTaiKhoan = "tk1", soDuBanDau = 1.0)
tk1.napTien(1.0)
println(tk1.rutTien(3.0))
println(tk1.rutTien(2.0))
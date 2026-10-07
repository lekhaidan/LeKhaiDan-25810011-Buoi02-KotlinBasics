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
}

val tk1 = TaiKhoanNganHang(soTaiKhoan = "tk1", soDuBanDau = 1.0)
val tk2 = TaiKhoanNganHang(soTaiKhoan = "tk1", soDuBanDau = -1.0)
// Họ và tên: Lê Khải Dân - MSSV: 25810011
fun main() {
    val soDuBanDau: Double = 5_000_000.0
    var soDuHienTai: Double = soDuBanDau
    println("Số dư ban đầu: $soDuHienTai VND")
    soDuHienTai += 2_000_000.0
    println("Sau khi gửi 2.000.000 VND: $soDuHienTai VND")
    soDuHienTai -= 1_500_000.0
    println("Sau khi rút 1.500.000 VND: $soDuHienTai VND")
}
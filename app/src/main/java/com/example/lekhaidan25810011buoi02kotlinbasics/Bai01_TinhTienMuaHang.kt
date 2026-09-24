// Họ và tên: Lê Khải Dân - MSSV: 25810011
fun main() {
    val soLuong: Int = 5
    val donGia: Double = 120000.0

    val tienHang: Double = soLuong.toDouble() * donGia
    val thue: Double = tienHang * 0.08
    val tongTien: Double = tienHang + thue

    println("Tiền hàng: $tienHang VND")
    println("Thuế 8%: $thue VND")
    println("Tổng tiền phải trả: $tongTien VND")
}
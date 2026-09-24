// Họ và tên: Lê Khải Dân - MSSV: 25810011
fun main() {
    val diem: Double = 8.7

    val xepLoai = when (diem) {
        in 8.5..10.0 -> "Xuất sắc"
        in 7.0..8.4 -> "Giỏi"
        in 5.5..6.9 -> "Khá"
        in 4.0..5.4 -> "Trung bình"
        in 0.0..3.9 -> "Yếu"
        else -> "Điểm không hợp lệ"
    }

    println("Điểm: $diem")
    println("Xếp loại: $xepLoai")
}
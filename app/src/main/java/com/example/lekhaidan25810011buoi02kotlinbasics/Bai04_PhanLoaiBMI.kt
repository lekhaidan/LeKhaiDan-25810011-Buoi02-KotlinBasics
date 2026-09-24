// Họ và tên: Lê Khải Dân - MSSV: 25810011
fun main() {
    val canNang: Double = 65.0
    val chieuCao: Double = 1.70

    val bmi: Double = canNang / (chieuCao * chieuCao)
    val phanLoai: String
    if (bmi < 18.5) {
        phanLoai = "Gầy"
    } else if (bmi < 25.0) {
        phanLoai = "Bình thường"
    } else if (bmi < 30.0) {
        phanLoai = "Thừa cân"
    } else {
        phanLoai = "Béo phì"
    }
    println("BMI: %.2f".format(bmi))
    println("Phân loại: $phanLoai")
}
// Họ và tên: Lê Khải Dân - MSSV: 25810011
fun main() {
    var a = 0
    var b = 1
    for (viTri in 0..20) {
        if (a >= 100) {
            break
        }
        println("Vị trí $viTri: $a")
        val tiepTheo = a + b
        a = b
        b = tiepTheo
    }
}
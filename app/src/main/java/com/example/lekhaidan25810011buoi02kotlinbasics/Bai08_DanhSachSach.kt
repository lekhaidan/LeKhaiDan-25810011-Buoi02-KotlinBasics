// Họ và tên: Lê Khải Dân - MSSV: 25810011
fun main() {
    val danhSachSach = mutableListOf(
        "Kotlin",
        "Clean Code",
        "Design Patterns",
        "Java cơ bản",
        "Cấu trúc dữ liệu"
    )
    println("Danh sách ban đầu:")
    danhSachSach.forEach {
        println("- $it")
    }

    danhSachSach.add("Android Development")
    danhSachSach.add("Lập trình hướng đối tượng")

    danhSachSach.remove("Java cơ bản")

    danhSachSach.sort()

    println("\nDanh sách sau khi xử lý:")
    danhSachSach.forEach {
        println("- $it")
    }
}
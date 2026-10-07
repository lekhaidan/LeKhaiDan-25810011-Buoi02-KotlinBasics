//LeKhaiDan-25810011

class KhachHang(var ho: String, var ten: String) {
    var hoTen: String
        get() {return "$ho $ten"}
        set(value) {
            val components = value.split(" ")
            ho = components[0]
            ten = components[1]
        }
}
val kh = KhachHang("A", ten = "B")
println(kh.hoTen)
kh.ten = "C"
println(kh.hoTen)
kh.hoTen = "F G"
println(kh.hoTen)
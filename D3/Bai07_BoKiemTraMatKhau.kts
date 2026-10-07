//LeKhaiDan-25810011
fun BoKiemTraMatKhau() {
    val kiemTraDoDai: (String) -> Boolean = { input -> input.length > 8 }
    println(kiemTraDoDai("asdfghjk"))
    println(kiemTraDoDai("sssdaxcv"))
    println(kiemTraDoDai("sada"))
}

BoKiemTraMatKhau()
//LeKhaiDan-25810011
fun datTenRieng(param: String): String {
    return param.uppercase()
}

fun xuLyVanBan(input: String, thucthi: (String) -> String): String {
    return thucthi(input)
}

println(xuLyVanBan("  abcdefgh ", { input -> input.trim() }))
println(xuLyVanBan("abcdefgh", ::datTenRieng))
val kq = xuLyVanBan("abc def gh") {input -> input.lowercase().replace(" ", "-")}
println(kq)
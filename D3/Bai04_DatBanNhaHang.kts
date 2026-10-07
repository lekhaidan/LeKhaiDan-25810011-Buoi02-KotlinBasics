//LeKhaiDan-25810011
fun datBan(tenkhachhang: String, soluongkhachhang: Int, loaiban: String = "Bàn thường") {
    println("$tenkhachhang - $soluongkhachhang - $loaiban")
}

datBan("KH1", 1)
datBan("KH2", 2, "VIP")
datBan(tenkhachhang = "KH3", soluongkhachhang = 3, loaiban = "PRO")
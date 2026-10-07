//LeKhaiDan-25810011
abstract class PhuongTienDiChuyen {
    abstract val tocDoToiDa : Int
    fun moTa() {
        println(tocDoToiDa)
    }
}
class XeMay(override val tocDoToiDa: Int) : PhuongTienDiChuyen() {

}
class Oto(override val tocDoToiDa: Int) : PhuongTienDiChuyen() {

}
val xemay = XeMay(100)
val oto = Oto(200)
println(xemay.tocDoToiDa)
println(oto.tocDoToiDa)
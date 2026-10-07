//LeKhaiDan-25810011
open class DongVat(val ten: String) {
    open fun keu(): String {
        TODO("Provide the return value")
    }
}
class Cho(ten: String) : DongVat(ten = ten) {
    override fun keu(): String {
        return "Cho"
    }
}
class Meo(ten: String) : DongVat(ten = ten) {
    override fun keu(): String {
        return "Meo"
    }
}
val lst = listOf(Cho("cho1"), Cho("cho2"), Cho("cho3"), Meo("meo1"), Meo("meo2"), Meo("meo3"))
for (obj in lst) {
    println("${obj.ten} - ${obj.keu()}")
}
//LeKhaiDan-25810011
fun locEagerVaLazy() {
    val dsnc = listOf("Guitar", "Piano", "Drum")
    println(dsnc.filter { it[0] == 'G' })
    val filtered = dsnc.asSequence().filter { it[0] == 'P' }
    println(filtered.toList())
}

locEagerVaLazy()


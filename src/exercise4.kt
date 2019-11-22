fun main() {
    for (i in 320 downTo 160) {
        if (i.rem(20).equals(0)) {
            println(i)
        }
    }
}
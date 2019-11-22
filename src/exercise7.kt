import kotlin.random.Random

fun main() {
    val secureCode = List(4) { Random.nextInt(0,9)}.joinToString("")
    var codeEnter : String? = null
    var option : String? = null
    val accept = "1"
    val type = "2"
    val close = "3"
    Menu@ while (true) {
        println(secureCode)
        println("Escriba su opción")
        if (codeEnter.equals(null)){
            println("2.- Escribir un código para la caja fuerte")
        } else {
            println("1.- Aceptar código")
            println("2.- Volver a escribir el código de la caja fuerte")
        }
        println("3.- Salir")
        option = readLine()
        when (option) {
            accept -> {
                println("El código que ingresaste es $codeEnter y el código de la caja es $secureCode")
                if (codeEnter != null) {
                    if (codeEnter.length.equals(4)) {
                        if (secureCode.equals(codeEnter)) {
                            println("El codigo es correcto")
                            System.exit(1)
                        }
                    } else {
                        println("El código debe tener 4 caracteres")
                        continue@Menu
                    }
                } else {
                    println("Debe escribir un código")
                    codeEnter = null
                    continue@Menu
                }
            }
            type -> {
                println("${ if (codeEnter.equals(null)) "Escribé" else "Vuelve a escribir"} el código")
                codeEnter = readLine()
                continue@Menu
            }
            close -> {
                println("Cerrando programa")
                System.exit(1)
            }
        }
    }
}
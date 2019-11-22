fun main() {
    var recipes:HashMap<String, List<String>> = hashMapOf()
    var option:Int? = null
    val make = 1
    val show = 2
    val close = 3
    do {
        println("""
        :: Bienvenido a Recipe Maker ::

        Selecciona la opción deseada:
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent())

        do {
            try {
                println("Tipea la opción")
                option = readLine()?.toInt()
            } catch (e: NumberFormatException) {
                println("Numero no válido")
            }
            if (option?.equals(make) ?: false || option?.equals(show) ?: false ) {
                println(
                    "Acaba de elegir ${if (option?.equals(make) ?: false) "hacer una receta" else "ver mis recetas"}"
                )
                continue
            } else if (option?.equals(close) ?: false) {
                println("Cerrando programa")
                System.exit(1)
            } else {
                println("No es una opción correcta")
                option = null
            }
        } while (option?.equals(null) ?: true )
        when (option) {
            1 -> makeRecipe(recipes)
            2 -> showRecipes(recipes)
        }
        println(recipes)
        print(option)
    } while (option?.equals(close)?.not() ?: true)

}

fun makeRecipe(recipes: HashMap<String, List<String>>) {
    val ingredients:List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
    var selectedIngredients:List<String> = listOf()
    var selected:Int? = null
    var make:Boolean = true
    println("Escribe el nombre de la receta")
    var nameRecipe = readLine()
    makeRecipeLoop@ while (make) {
        println("Los ingredientes son:")
        ingredients.forEachIndexed { index, element ->
            println("$index.$element")
        }
        if (selectedIngredients.any()) {
            println("${ingredients.size}.Crear Receta")
        }
        println("${ingredients.size.inc()}.Cancelar Receta")
        println("Selecciona un ingrediente")
        selectedOption@ while (selected?.equals(null) ?: true) {
            try {
                selected = readLine()?.toInt()
            } catch (e: java.lang.NumberFormatException) {
                println("Ingrese un número válido")
            }
            if (selected != null) {
                when (selected) {
                    ingredients.size -> {
                        if (selectedIngredients.any()){
                            recipes.put(nameRecipe.toString(), selectedIngredients)
                            break@makeRecipeLoop
                        } else {
                            println("No hay ingredientes registrados")
                        }
                    }
                    ingredients.size.inc() -> {
                        println("Receta cancelada")
                        break@makeRecipeLoop
                    }
                    else -> {
                        var optionVerification:Int? = null
                        println("""
                            Seleccione una opción:
                            1. Aceptar
                            2. Eliminar
                        """.trimIndent())
                        do {
                            try {
                                optionVerification = readLine()?.toInt()
                            } catch (e: java.lang.NumberFormatException) {
                                println("Ingrese un número válido")
                            }
                        } while (optionVerification?.equals(null) ?: true)
                        if (optionVerification?.equals(1) ?: false) {
                            selectedIngredients += ingredients.get(selected)
                            println("El ingrediente ${ingredients.get(selected)} se añadio a la receta $nameRecipe")
                            selected = null
                            break@selectedOption
                        } else {
                            println("El ingrediente ${ingredients.get(selected)} no se añadió")
                            selected = null
                            break@selectedOption
                        }
                    }
                }
            } else {
                println("Tiene que tipear algun número")
            }
        }
    }

}

fun showRecipes(recipes: HashMap<String, List<String>>) {
    while (true) {
        println("Las recetas son:")
        recipes.forEach{ name, ingredients ->
            println("===================== $name =====================")
            println("Los ingredientes a usarse són:")
            ingredients.forEach{
                println(it)
            }
        }
        println("Teclea 1 para volver al menú")
        if (readLine()?.toInt()?.equals(1) ?: false) {
            println("saliendo")
            break
        }
    }
}
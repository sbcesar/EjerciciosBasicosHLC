package org.example


fun ej1() {
    println("¡Hola, mundo!")
}

fun ej2() {
    val vida = 100
    println("La vida del personaje es $vida")
}

fun ej3() {
    var valorAtaque = 0
    for (i in 0..<3) {
        val damage = multiplicarAtaques(2)
        valorAtaque += damage
        println("Has atacado con $damage de daño")
    }
    println("El daño total es $valorAtaque")
}

fun multiplicarAtaques(num: Int): Int {
    return num * 5
}

fun ej4() {
    var moneda = 0
    for (i in 0..<10) {
        moneda += 5
        println("En tu monedero tienes: $moneda")
    }
}

fun ej5() {
    println("Introduce el nivel de tu personaje: ")
    val nivelPersonaje = readln().toInt()
    when {
        nivelPersonaje < 10 -> println("Personaje principiante")
        nivelPersonaje in 10..19 -> println("Personaje intermedio")
        nivelPersonaje >= 20 -> println("Personaje avanzado")
        else -> println("Error al introducir el nivel del personaje")
    }
}

fun ej6() {
    println("Introduce el daño de ataque que tienes: ")
    val attackDamage = readln().toInt()
    println(critDamage(attackDamage))
}

fun critDamage(ataque: Int): Int {
    return if (ataque > 50) {
        println("¡Golpe crítico!")
        ataque * 2
    } else {
        return ataque
    }
}

fun ej7() {
    val A = Personaje(100, 10)
    val B = Personaje(100, 20)

    var ronda = 0
    var ganador = false
    while (!ganador) {
        println("Ronda $ronda")
        println("Elige el atacante (A o B): ")
        when (readln()) {
            "A" -> A.attack(B)
            "B" -> B.attack(A)
        }

        println("A: $A")
        println("B: $B")

        ronda++

        if (A.vida <= 0 || B.vida <= 0) {
            ganador = true
            println("El jueguito ha terminado")
        }
    }
}

fun ej8() {
    val inventario = mutableListOf<String>()
    var salir = false

    while (!salir) {
        println("Elige una opción:\n1. Añadir objeto\n2. Quitar objeto\n3. Mostrar Objeto\n4. Salir")
        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("¿Qué objeto deseas añadir?")
                val objeto = readln()
                inventario.add(objeto)
                println("Has añadido $objeto al inventario")
            }
            2 -> {
                if (inventario.isEmpty()) {
                    println("El inventario está vacío")
                } else {
                    println("¿Qué objeto deseas quitar?")
                    val objeto = readln()
                    if (!inventario.contains(objeto)) {
                        println("El objeto no está en el inventario")
                    }
                    inventario.remove(objeto)
                }
            }
            3 -> {
                if (inventario.isEmpty()) println("No hay nada en el inventario")
                else inventario.forEach { println(it) }
            }
            4 -> salir = true
            else -> println("Opción incorrecta")
        }
    }
}

fun ej9() {
    val goblin = Personaje(100, 50, 0)
    val ogro = Personaje(500, 50, 0)

    var ronda = 0
    var ganador = false
    while (!ganador) {
        println("Ronda $ronda")
        println("Elige el atacante (ogro o goblin): ")
        when (readln()) {
            "goblin" -> goblin.attack(ogro)
            "ogro" -> ogro.attack(goblin)
        }

        println("Goblin: $goblin")
        println("Ogro: $ogro")

        ronda++

        if (goblin.vida <= 0 || ogro.vida <= 0) {
            ganador = true
            println("El juego ha terminado")
        }
    }
}

fun ej10() {
    val goblin = Personaje(100, 75)
    val ogro = Personaje(100, 50)
    val jefe = Personaje(500, 20)

    var ronda = 0
    var ganador = false
    while (!ganador) {
        println("Ronda $ronda")

        val ataqueTotal = goblin.ataque + ogro.ataque
        jefe.perderVida(ataqueTotal)

        println("El jefe perdió $ataqueTotal vida")
        println(jefe)

        ronda++

        if (jefe.vida <= 0) {
            println("El escuadrón ha derrotado al jefe!")
            ganador = true
        }
    }
}

fun main() {
    var salirPrograma = false

    while (!salirPrograma) {
        println(
            """
            Elige una opción:
            1. Ejercicio 1: Hola Mundo
            2. Ejercicio 2: Mostrar vida del personaje
            3. Ejercicio 3: Ataques y daño total
            4. Ejercicio 4: Monedero
            5. Ejercicio 5: Nivel del personaje
            6. Ejercicio 6: Daño crítico
            7. Ejercicio 7: Batalla entre personajes
            8. Ejercicio 8: Inventario
            9. Ejercicio 9: Goblin vs Ogro
            10. Ejercicio 10: Jefe final
            11. Salir
            """.trimIndent()
        )

        val opcionPrograma = readln().toInt()

        when (opcionPrograma) {
            1 -> ej1()
            2 -> ej2()
            3 -> ej3()
            4 -> ej4()
            5 -> ej5()
            6 -> ej6()
            7 -> ej7()
            8 -> ej8()
            9 -> ej9()
            10 -> ej10()
            11 -> {
                println("Saliendo del programa...")
                salirPrograma = true
            }
            else -> println("Opción no válida")
        }
    }
}


























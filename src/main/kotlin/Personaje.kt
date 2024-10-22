package org.example

data class Personaje(
    var vida: Int,
    val ataque: Int
) {
    var experiencia = 0
    constructor( vida: Int,  ataque: Int,  experiencia: Int): this(vida, ataque)

    fun attack(personaje: Personaje) {
        personaje.vida -= ataque
    }

    fun perderVida(ataque: Int) {
        this.vida -= ataque
    }

    override fun toString(): String {
        return "hp -> $vida damage -> $ataque experiencia -> $experiencia"
    }
}
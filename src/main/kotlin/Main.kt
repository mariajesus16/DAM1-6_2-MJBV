interface Disparar {
    var tipoDeMunicion: String
    var municion: Int
    var municionARestar: Int
    val danio: Int
    val radio: String

    fun dispara() {
        if (municion >= municionARestar) {
            municion -= municionARestar
        }
    }

    fun recarga(n: Int) {
        municion += n
    }
}

abstract class ArmaDeFuego(
    private val nombre: String,
    override var municion: Int,
    override var municionARestar: Int = 1,
    override var tipoDeMunicion: String,
    override val danio: Int,
    override val radio: String
) : Disparar {

    override fun toString(): String {
        return "El arma $nombre tiene un total de $municion munición de tipo $tipoDeMunicion, con un daño $danio y un radio $radio."
    }
}

class Pistola(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int = 50,
    radio: String = "Pequeño"
) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {}

class Rifle(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int = 70,
    radio: String = "Pequeño"
) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {
    override fun dispara() {
        if (municion >= municionARestar * 2) {
            municion -= municionARestar * 2
        }
    }
}

class Bazooka(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int = 100,
    radio: String = "Amplio"
) : ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {
    override fun dispara() {
        if (municion >= municionARestar * 3) {
            municion -= municionARestar * 3
        }
    }
}

class Casa(
    private val nombre: String,
    override var municion: Int,
    override var municionARestar: Int = 1,
    override var tipoDeMunicion: String,
    override val danio: Int,
    override val radio: String
) : Disparar {
    override fun toString(): String {
        return "La casa $nombre tiene un total de $municion munición de tipo $tipoDeMunicion, con un daño $danio y un radio $radio."
    }
}

class Coche(
    private val nombre: String,
    override var municion: Int,
    override var municionARestar: Int = 1,
    override var tipoDeMunicion: String,
    override val danio: Int,
    override val radio: String
) : Disparar {
    override fun toString(): String {
        return "El coche $nombre tiene un total de $municion munición de tipo $tipoDeMunicion, con un daño $danio y un radio $radio."
    }
}

class Bocadillo(
    private val nombre: String,
    override var municion: Int,
    override var municionARestar: Int = 1,
    override var tipoDeMunicion: String,
    override val danio: Int,
    override val radio: String
) : Disparar {
    override fun toString(): String {
        return "El bocadillo $nombre tiene un total de $municion munición de tipo $tipoDeMunicion, con un daño $danio y un radio $radio."
    }
}
/*b) ¿Que beneficios obtienes al usar una clase abstracta? ¿Y de una interface?
Al usar una clase abstracta podemos definir tipos que permitan múltiples implementaciones.
Al utilizar una interfaz nos da mucha mayor versatilidad a la hora de organizar nuestro código.

c) ¿Que modificadores y mecanismos has utilizado para bloquear y forzar la herencia de clases y métodos?
He utilizado override y private.
 */

fun main() {
    val pistola = Pistola("Pistola", 20, 1, "Calibre 20")
    val rifle = Rifle("Rifle", 40, 1, "Calibre 7")
    val bazooka = Bazooka("Bazooka", 80, 1, "Calibre 60")
    val casa = Casa("Pedro", 30,1,"Calibre 30",40,"Amplio")
    val coche = Coche("Renault", 50,1,"Calibre 40",60,"Amplio")
    val bocadillo = Bocadillo("Jamón", 10,1,"Calibre 30",60,"Pequeño")

    val listaArmas = listOf(pistola, rifle, bazooka, casa, coche, bocadillo)
    val mapaArmas = mutableMapOf<String, Disparar>()
    for (i in 0 until 6) {
        mapaArmas["$i"] = listaArmas.random()
    }

    mapaArmas.mapValues { it.value.dispara(); println(it.value) }

}
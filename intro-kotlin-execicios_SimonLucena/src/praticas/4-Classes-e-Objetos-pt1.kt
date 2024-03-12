package praticas

import java.util.*
import kotlin.math.PI
import kotlin.math.pow

// Questão 1
class Produto1 {
    val nome: String = "Produto"
    val preco: Double = 0.0
    override fun toString(): String {
        return "Produto: Nome = $nome, Preco = $preco"
    }
}
class Produto2(val nome:String){
    val preco: Double = 0.0
    override fun toString(): String {
        return "Produto: Nome = $nome, Preco = $preco"
    }
}
class Produto3(val nome:String, val preco:Double){
    override fun toString(): String {
        return "Produto: Nome = $nome, Preco = $preco"
    }
}


// Questão 2
class Cliente(var nome:String="", private var idade:Int=0) {
    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão

    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    fun mostrarIdade() {
        println("Idade de $nome = $idade")
    }
}


// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar()
}

class Guerreiro : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Guerreiro
        println("O guerreiro usa sua espada")
    }
}

class Mago : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Mago
        println("O mago lança uma bola de fogo")
    }
}


// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
        val area:Double = altura*largura
        return area
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        val area:Double = PI*(raio.pow(2))
        return area
    }
}


// Questão 5
class ContaBancaria(var numeroConta: String = "",
                    nomeTitular: String = "",
                    saldo: Double = 0.0) {

    // Implemente um getter personalizado para a propriedade nomeTitular conforme especificado na questão
    var nomeTitular: String = nomeTitular
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    // Implemente override do setter para o atributo saldo conforme especificado na questão
    var saldo: Double = saldo
        set(value) {
            field = if (value >= 0.0) value else 0.0
        }

    override fun toString(): String {
        return "Conta: Nome = $nomeTitular, Saldo = $saldo"
    }
}


// Main
fun main() {
    // Questão 1
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    val produto1 = Produto1()
    val produto2 = Produto2("Teste1")
    val produto3 = Produto3("Teste2", 15.50)
    println(produto1.toString())
    println(produto2.toString())
    println(produto3.toString())

    // Questão 2
    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    val cliente = Cliente("Simon", 22)
    cliente.mostrarIdade()

    // Questão 3
    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    val guerreiro = Guerreiro()
    val mago      = Mago()
    guerreiro.atacar()
    mago.atacar()

    // Questão 4
    val retangulo   = Retangulo(2.0, 3.0)
    val circulo     = Circulo(4.0)
    println("Área do retângulo: ${retangulo.calcularArea()}")
    println("Área do circulo: ${circulo.calcularArea()}")

    // Questão 5
    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    val contaBancaria = ContaBancaria(numeroConta = "142077", nomeTitular = "simon", saldo = -1000.0)
    val contaBancaria2 = ContaBancaria(numeroConta = "250299", nomeTitular = "teste", saldo = 1000.0)
    println(contaBancaria.toString())
    println(contaBancaria2.toString())
}

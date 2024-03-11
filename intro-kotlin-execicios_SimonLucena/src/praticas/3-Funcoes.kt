// Aluno: Simon Lucena de Castro
package praticas

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas:MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            println("Matéria: $materia")
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
            println(calcularMedia(materia))
        }
        else{
            println("Não foi possível mostrar as notas da matéria $materia")
        }

        println()
    }


}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg notas:Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        for (nota in notas){
            notasDaMateria.add(nota)
        }
        true
    } else {
        false
    }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(materia:String): String{
    if(!materiasENotas.containsKey(materia)){
        return ("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var sum = 0.0
            var count = 0
            for(nota:Double in listaNotas){
                sum += nota
                count++
            }

            val media = (sum/count)

            return ("Média: ${media.format(2)}\n")
        }
        else{
            return ("Não foi possível mostrar as notas da matéria $materia")
        }
    }
}

fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("PDM", mutableListOf(7.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(notas=mutableListOf(8.0), materia="GPS")

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    // FEITO

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Legislação Social")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("PDM", 8.0)
    adicionarNota("GPS", 10.0)
    adicionarNota("Legislação Social", 10.0)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("PDM")
    mostrarNotas("GPS")
    mostrarNotas("Legislação Social")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Estagio")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    // FEITO

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Estagio", 10.0, 9.0, 10.0)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Estagio")

    // Bônus: (Não vai ganhar nada, ou melhor vai ganhar mais conhecimento >:O)

    // 11: calcularMedia -> Implemente a função calcularMedia()
    // FEITO

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    // println(calcularMedia("PDM"))
    // println(calcularMedia("Estagio"))

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    // FEITO

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("PDM")
}
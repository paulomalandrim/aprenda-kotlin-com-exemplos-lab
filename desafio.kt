enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val codigo: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, 
                    val conteudos: List<ConteudoEducacional>, 
                    val nivel: Nivel
                    ) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (aluno in usuarios){
            inscritos.add(aluno)
        }
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
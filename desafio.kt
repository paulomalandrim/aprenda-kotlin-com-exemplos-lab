enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

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
    }
    
    fun cancelarMatricula(vararg usuarios: Usuario){
        for (usuario in usuarios){
            val inscritoEncontrado = inscritos.find( { it.nome.contains(usuario.nome) })
            if (inscritoEncontrado != null){
                inscritos.remove(inscritoEncontrado)
                println("Aluno ${usuario.nome} removido da formação")
            } else {
                println("Aluno ${usuario.nome} não encontrado")
            }  
        }
    }
    
    fun listarInscritos(){
        println()
        for (inscrito in inscritos){
            println(" - ${inscrito.nome}")
        }
    }
    
    fun listarConteudoEducacional(){
        println()
        for (conteudo in conteudos){
            println(" - ${conteudo.nome} com duração de ${conteudo.duracao} minutos")
        }
    }
}

fun main() {
    
    // FORMACAO KOTLIN BASICO 
    val conteudoKotlin = listOf(ConteudoEducacional("Introcução Kotlin", 10),
                               ConteudoEducacional("Comandos Básicos", 20))
    val formacaoKotlin: Formacao = Formacao("Formação Kotlin Básico",
                                           conteudoKotlin ,
                                           Nivel.BASICO)
    println("A ${formacaoKotlin.nome} tem o seguinte conteúdo: ")
    formacaoKotlin.listarConteudoEducacional()
    println()
    
    // MATRICULAR APENAS UM ALUNO NA FORMACAO
    formacaoKotlin.matricular(Usuario("Paulo Malandrim"))
    
    print("Alunos matriculados na formação de Kotlin Básico:")
    formacaoKotlin.listarInscritos()
    println()
    
    // MATRICULAR VÁRIOS ALUNOS DE UMA SÓ VEZ NA FORMACAO
    formacaoKotlin.matricular(Usuario("João Lucas"),
                              Usuario("Eduardo"),
                              Usuario("José Antonio"),
                              Usuario("Luiz Henrique"),
                              Usuario("Maria Clara"))
    
    print("Alunos matriculados na formação de Kotlin Básico:")
    formacaoKotlin.listarInscritos()
    println()
    
    // TENTATIVA DE REMOVER UM ALUNO INEXISTENTE DA FORMACAO
    formacaoKotlin.cancelarMatricula(Usuario("Fernando"))
    
    // REMOVER APENAS UM ALUNO DA FORMACAO
    formacaoKotlin.cancelarMatricula(Usuario("João Lucas"))
    
    // REMOVER VÁRIOS ALUNOS DA FORMACAO
    formacaoKotlin.cancelarMatricula(Usuario("José Antonio"),
                                     Usuario("Eduardo"),
                                     Usuario("Paulo Malandrim"))

    print("Alunos matriculados na formação de Kotlin Básico:")
    formacaoKotlin.listarInscritos()
    println()
        
}
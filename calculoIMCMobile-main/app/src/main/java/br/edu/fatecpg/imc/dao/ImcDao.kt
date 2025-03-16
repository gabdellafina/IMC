package br.edu.fatecpg.imc.dao

class ImcDao private constructor() {

    private val imcs = mutableListOf<Double>()

    // Função para inserir IMC
    fun inserir(imc: Double) {
        imcs.add(imc)
    }

    // Função para obter o último IMC calculado
    fun getUltimo(): Double? {
        return imcs.lastOrNull()
    }

    // Função para acessar a instância do DAO
    companion object {
        @Volatile
        private var INSTANCE: ImcDao? = null

        fun getInstance(): ImcDao {
            return INSTANCE ?: synchronized(this) {
                val instance = ImcDao()
                INSTANCE = instance
                instance
            }
        }
    }
}

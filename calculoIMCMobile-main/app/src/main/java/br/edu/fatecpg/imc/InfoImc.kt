package br.edu.fatecpg.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.imc.dao.ImcDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InfoImc : AppCompatActivity(R.layout.activity_info_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = ImcDao.getInstance()
        val imc = dao.getUltimo()

        val txtImc = findViewById<TextView>(R.id.txtImc)
        val txtCategoria = findViewById<TextView>(R.id.txtCategoria)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fabVoltar)

        imc?.let {
            txtImc.text = "IMC: %.2f".format(it)

            // Classificação do IMC
            val categoria = when {
                it < 18.5 -> "Abaixo do Peso"
                it in 18.5..24.9 -> "Peso Ideal"
                it in 25.0..29.9 -> "Sobrepeso"
                else -> "Obesidade"
            }
            txtCategoria.text = "Categoria: $categoria"
        }

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}

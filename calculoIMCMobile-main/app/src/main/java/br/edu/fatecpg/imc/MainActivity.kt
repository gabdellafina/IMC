package br.edu.fatecpg.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.imc.dao.ImcDao

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val dao = ImcDao.getInstance()

        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString().toDouble()
            val altura = edtAltura.text.toString().toDouble()

            // Cálculo do IMC
            val imc = peso / (altura * altura)
            dao.inserir(imc)

            // Passa para a próxima tela para exibir o IMC
            val intent = Intent(this, InfoImc::class.java)
            startActivity(intent)
        }
    }
}

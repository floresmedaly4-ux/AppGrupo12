package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta7Binding
import java.util.Locale

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityPregunta7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> evaluarTemperatura()
        }
    }

    private fun evaluarTemperatura() {
        val tempTexto = binding.etTemperatura.text.toString().trim()


        if (tempTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese la temperatura medida.", Toast.LENGTH_SHORT).show()
            return
        }

        val temperatura = tempTexto.toDoubleOrNull()
        if (temperatura == null) {
            Toast.makeText(this, "Ingrese un número válido.", Toast.LENGTH_SHORT).show()
            return
        }

        binding.tvResultado.visibility = View.VISIBLE


        if (temperatura <= 35.0) {
            binding.tvResultado.text = "Parámetro térmico en norma ambiental."
        } else {
            val excesoTermico = temperatura - 35.0
            val sancionBase = 3200.00
            val costoPorGrado = 450.00
            val sancionTotal = sancionBase + (excesoTermico * costoPorGrado)


            val textoResultado = """
                • Temperatura registrada: ${String.format(Locale.US, "%.2f", temperatura)} °C
                • Exceso térmico: ${String.format(Locale.US, "%.2f", excesoTermico)} °C
                • Sanción total calculada: S/ ${String.format(Locale.US, "%,.2f", sancionTotal)}
            """.trimIndent()

            binding.tvResultado.text = textoResultado
        }
    }
}
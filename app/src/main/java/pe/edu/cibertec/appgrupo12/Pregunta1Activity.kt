package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta1Binding
import java.util.Locale

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularRecargo()
        }
    }

    private fun calcularRecargo() {

        val consumo = binding.etConsumo.text.toString().toDoubleOrNull()

        if (consumo == null) {
            binding.etConsumo.error = "Ingrese el volumen consumido"
            return
        }

        if (consumo <= 20) {

            binding.tvResultado.text =
                "Consumo dentro de la asignación regular."

        } else {

            val exceso = consumo - 20
            val recargo = 45.0 + (exceso * 8.50)

            binding.tvResultado.text = String.format(
                Locale.US,
                "Volumen consumido: %.2f m³\nExceso: %.2f m³\nMonto total del recargo: S/ %.2f",
                consumo,
                exceso,
                recargo
            )
        }
    }
}
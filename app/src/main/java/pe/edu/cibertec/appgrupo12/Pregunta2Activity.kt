package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta2Binding
import java.util.Locale

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularRecargo()
        }
    }

    private fun calcularRecargo() {

        val textoConsumo = binding.etConsumo.text.toString()

        if (textoConsumo.isEmpty()) {
            binding.etConsumo.error = "Ingrese el consumo en kWh"
            return
        }

        val consumo = textoConsumo.toDouble()

        if (consumo <= 150) {

            binding.tvResultado.text =
                "Consumo eficiente sin sobrecosto."

        } else {

            val exceso = consumo - 150
            val recargo = 60.0 + (exceso * 1.80)

            binding.tvResultado.text = String.format(
                Locale.US,
                "Consumo ingresado: %.2f kWh\nExceso: %.2f kWh\nMonto total a pagar por recargo: S/ %.2f",
                consumo,
                exceso,
                recargo
            )
        }
    }
}
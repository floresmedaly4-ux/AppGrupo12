package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta6Binding

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCalcular -> calcularCobro()
        }
    }

    private fun calcularCobro() {

        val textoHoras = binding.etHoras.text.toString()

        if (textoHoras.isEmpty()) {
            binding.etHoras.error = "Ingrese las horas utilizadas"
            return
        }

        val horas = textoHoras.toDouble()

        if (horas <= 8) {

            binding.tvResultado.text =
                "Horas cubiertas por la membresía mensual."

        } else {

            val horasExcedentes = horas - 8
            val montoExtra = 50.0 + (horasExcedentes * 35.0)

            binding.tvResultado.text = String.format(
                java.util.Locale.US,
                "Horas totales: %.2f\nHoras excedentes: %.2f\nMonto extra a facturar: S/ %.2f",
                horas,
                horasExcedentes,
                montoExtra
            )
        }
    }
}
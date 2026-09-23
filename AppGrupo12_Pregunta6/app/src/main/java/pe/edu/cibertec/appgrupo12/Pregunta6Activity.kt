package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta6Binding
import java.util.Locale

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id != R.id.btnCalcular) return

        val horas = binding.edtHoras.text.toString().trim()
            .replace(',', '.')
            .toDoubleOrNull()

        if (horas == null || !horas.isFinite() || horas < 0.0) {
            binding.edtHoras.error = "Ingresa una cantidad de horas válida"
            binding.txtResultado.text = ""
            return
        }

        binding.edtHoras.error = null

        if (horas <= 8.0) {
            binding.txtResultado.text = "Horas cubiertas por la membresía mensual."
            return
        }

        val horasExcedentes = horas - 8.0
        val montoExtra = 50.0 + 35.0 * horasExcedentes

        binding.txtResultado.text = getString(
            R.string.resultado_coworking,
            formatear(horas),
            formatear(horasExcedentes),
            formatear(montoExtra)
        )
    }

    private fun formatear(valor: Double): String =
        String.format(Locale.US, "%.2f", valor)
}

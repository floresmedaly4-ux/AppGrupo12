package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta3Binding
import java.util.Locale

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btnCalcular) {
            calcularCobro()
        }
    }

    private fun calcularCobro() {
        val minutos = binding.etMinutos.text.toString().toIntOrNull()

        if (minutos == null) {
            binding.etMinutos.error = "Ingresa los minutos"
            binding.tvResultado.text = ""
            return
        }

        if (minutos <= 60) {
            binding.tvResultado.text =
                "Estacionamiento cubierto por periodo de cortesía."
            return
        }

        val exceso = minutos - 60
        val monto = 10.00 + (exceso * 0.50)
        val montoFormateado = String.format(Locale.US, "S/ %.2f", monto)

        binding.tvResultado.text =
            "Tiempo total registrado: $minutos minutos\n" +
                    "Minutos de exceso: $exceso\n" +
                    "Monto total a pagar: $montoFormateado"
    }
}
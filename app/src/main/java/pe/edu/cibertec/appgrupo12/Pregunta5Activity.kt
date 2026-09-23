package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta5Binding
import java.util.Locale

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == binding.btnCalcular.id) {
            calcularPago()
        }
    }

    private fun calcularPago() {

        val cantidadTexto = binding.etBolsas.text.toString()

        if (cantidadTexto.isEmpty()) {
            binding.etBolsas.error = "Ingrese la cantidad de bolsas"
            return
        }

        val bolsas = cantidadTexto.toIntOrNull()

        if (bolsas == null || bolsas < 0) {
            binding.etBolsas.error = "Ingrese una cantidad válida"
            return
        }

        if (bolsas <= 5) {

            binding.tvResultado.text =
                "Carga permitida sin costo adicional."

        } else {

            val exceso = bolsas - 5
            val total = 80.0 + (15.0 * exceso)

            binding.tvResultado.text =
                """
                Cantidad ingresada: $bolsas bolsas
                Exceso: $exceso bolsas
                Total a abonar: ${String.format(Locale.US, "S/ %.2f", total)}
                """.trimIndent()
        }
    }
}
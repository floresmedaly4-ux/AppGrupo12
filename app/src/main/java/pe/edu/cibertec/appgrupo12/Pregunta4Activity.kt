package pe.edu.cibertec.appgrupo12

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo12.databinding.ActivityPregunta4Binding

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom
            )
            insets
        }

        binding.button.setOnClickListener(this)
    }

    fun calcularDatos() {

        val datos = binding.txtgigas.text.toString().toDouble()

        if (datos <= 30) {

            binding.textView2.text =
                "Consumo dentro de su plan contratado."

        } else {

            val exceso = datos - 30
            val cobro = 25 + (exceso * 6)

            val datosFormateados = String.format("%.2f", datos)
            val excesoFormateado = String.format("%.2f", exceso)
            val cobroFormateado = String.format("%.2f", cobro)

            binding.textView2.text =
                "Datos consumidos: $datosFormateados GB\n" +
                        "Exceso de GB: $excesoFormateado GB\n" +
                        "Cobro adicional generado: S/ $cobroFormateado"
        }
    }

    override fun onClick(p0: View) {
        calcularDatos()
    }
}
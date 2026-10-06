package pt.beatrizmartins.fuelapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distancia = intent.getIntExtra("DISTANCIA_PERCORRIDA", 0);
        val consumo = intent.getIntExtra("CONSUMO", 0);
        val precoCombustivel = intent.getDoubleExtra("PRECO_COMBUSTIVEL", 0.0)
        val valorTotal = intent.getDoubleExtra("CUSTO_TOTAL", 0.0);

        val tvPreco = findViewById<TextView>(R.id.precoResultado)
        val tvDistancia = findViewById<TextView>(R.id.tvDistancia)
        val tvConsumo = findViewById<TextView>(R.id.tvConsumo)
        val tvPrecoCombustivel = findViewById<TextView>(R.id.tvPreco)

        tvPreco.text = valorTotal.toString() + "€";
        tvConsumo.text = consumo.toString() + "L";
        tvDistancia.text = distancia.toString() + "km";
        tvPrecoCombustivel.text = precoCombustivel.toString() + "€";

    }
}
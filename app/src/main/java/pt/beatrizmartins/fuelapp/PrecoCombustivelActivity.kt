package pt.beatrizmartins.fuelapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrecoCombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val distanciaPercorrida = intent.getIntExtra("DISTANCIA_PERCORRIDA", 0);
        val consumo = intent.getIntExtra("CONSUMO", 0);
        val edtPrecoCombustivel = findViewById<TextView>(R.id.edtPrecoCombustivel);
        val btnCalcular = findViewById<Button>(R.id.btnCalcular);

        btnCalcular.setOnClickListener {

            val edtPrecoCombustivelValue = edtPrecoCombustivel.text.toString().toDouble();

            val intent = Intent(this, ResultadoActivity::class.java);

            val litrosNecessarios = distanciaPercorrida / consumo

            val custoTotal = litrosNecessarios * edtPrecoCombustivelValue

            intent.putExtra("CONSUMO", consumo)
            intent.putExtra("CUSTO_TOTAL", custoTotal)
            intent.putExtra("DISTANCIA_PERCORRIDA", distanciaPercorrida)
            intent.putExtra("PRECO_COMBUSTIVEL", edtPrecoCombustivelValue)

            startActivity(intent);

        }
    }
}
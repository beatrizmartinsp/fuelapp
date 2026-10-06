package pt.beatrizmartins.fuelapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distanciaPercorrida = intent.getIntExtra("DISTANCIA_PERCORRIDA", 0);
        val edtPrecoConsumo = findViewById<TextView>(R.id.edtPrecoConsumo);
        val btnConsumoProximo = findViewById<Button>(R.id.btnPrecoConsumoProximo);

        btnConsumoProximo.setOnClickListener {

            val edtPrecoConsumoValue = edtPrecoConsumo.text.toString().toInt();
            val intent = Intent(this, PrecoCombustivelActivity::class.java);

            intent.putExtra("DISTANCIA_PERCORRIDA", distanciaPercorrida);
            intent.putExtra("CONSUMO", edtPrecoConsumoValue);
            startActivity(intent);

        }


    }
}
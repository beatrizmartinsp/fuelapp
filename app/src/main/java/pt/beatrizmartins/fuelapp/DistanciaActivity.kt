package pt.beatrizmartins.fuelapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtDistanciaPercorrida = findViewById<TextView>(R.id.edtDistancia);
        val btnDistanciaProximo = findViewById<Button>(R.id.btnPrecoConsumoProximo);

        btnDistanciaProximo.setOnClickListener {

            val edtDistanciaPercorrida = edtDistanciaPercorrida.text.toString().toInt();
            val intent = Intent(this, ConsumoActivity::class.java);
            intent.putExtra("DISTANCIA_PERCORRIDA", edtDistanciaPercorrida);
            startActivity(intent);

        }
    }
}
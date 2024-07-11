package prova.web.snoopygame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import prova.web.snoopygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
// Recebe jogador Vs jogador
        binding.buttonJogadorVsJogador.setOnClickListener {
            val i = Intent(this, JogadorActivity::class.java)

            startActivity(i)
            finish()
        }
        // Recebe jogador Vs Maquina
        binding.buttonJogadorVsMaquina.setOnClickListener {
            val i = Intent(this, MaquinaActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
package com.example.velha

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.velha.databinding.ActivityJogadorBinding

class MainActivity : AppCompatActivity() {

    // Lista de perguntas do quiz
    private val questions = listOf(
        "A barbie tem mais de 70 anos?",
        "A Barbie ja usou verde?",
        "A cor do jatinho da barbie e azul?",
        "A barbie e loira?",
        "A Barbie e amiga da pollypocket?"

    )
    // Respostas corretas para as perguntas do quiz
    private val answers = listOf(
        true, // A barbie tem mais de 70 anos
        false, // A Barbie nunca usou verde
        false,  // A cor do jatinho da barbie e rosa
        true, // A barbie e loira
        true // A Barbie e amiga da pollypocket
    )
    // Índice da pergunta atual
    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Binding = ActivityMainBinding
        super.onCreate(savedInstanceState)
        val binding = null
        setContentView(binding.root)

        // Referências para os elementos do activity Main
        val R = null
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val trueButton: Button = findViewById(R.id.trueButton)
        val falseButton: Button = findViewById(R.id.falseButton)

        // Função para atualizar a pergunta na tela
        fun updateQuestion() {
            // Se houver mais perguntas, exibe a próxima pergunta
            if (currentQuestionIndex < questions.size) {
                questionTextView.text = questions[currentQuestionIndex]
            } else {
                // Se não houver mais perguntas, exibe uma mensagem e reinicia o quiz
                Toast.makeText(this, "Você completou o quiz!", Toast.LENGTH_SHORT).show()
                currentQuestionIndex = 0 // Reinicia o quiz
                updateQuestion()
            }
        }
        // Checar se a resposta esta correta ou nao
        fun checkAnswer(userAnswer: Boolean) {
            //Obtem a resposta correta
            val correctAnswer = answers[currentQuestionIndex]
// Se a resposta estiver correta, aparece uma mensagem que deu certo
            if (userAnswer == correctAnswer) {
                Toast.makeText(this, "Resposta correta!", Toast.LENGTH_SHORT).show()
                // Se a resposta estiver incorreta, exibe uma mensagem que deu errado
            } else {
                Toast.makeText(this, "Resposta incorreta!", Toast.LENGTH_SHORT).show()
            }
            //avanca para proxima questao
            currentQuestionIndex++
            //Atualiza a questao
            updateQuestion()
        }
// Butao para verificar a resposta como verdadeira
        trueButton.setOnClickListener {
            checkAnswer(true)
        }
// Butao para verificar como falsa
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
//Atualiza a pergunta
        updateQuestion()
    }
}
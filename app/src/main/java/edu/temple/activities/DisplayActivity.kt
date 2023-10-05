package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text
const val RESULT_KEY = "Launch the message"
class DisplayActivity : AppCompatActivity() {

    lateinit var resultTextView : TextView

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            it.data?.apply {
                resultTextView.text = getString(RESULT_OK)
            }

        }
    }

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)



        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        findViewById<Button>(R.id.lyricsDisplayTextView).setOnClickListener {
            val launchIntent = Intent(this@DisplayActivity, TextSizeActivity:: class.java)
            launchIntent.putExtra(RESULT_KEY, "Launch the message")
            launcher.launch(launchIntent)
        }

    }
}
package com.example.finalapplication.inkapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityBasicHandwitingRecognizerBinding
import com.google.mlkit.vision.digitalink.DigitalInkRecognition
import com.google.mlkit.vision.digitalink.DigitalInkRecognitionModel
import com.google.mlkit.vision.digitalink.DigitalInkRecognitionModelIdentifier
import com.google.mlkit.vision.digitalink.DigitalInkRecognizer
import com.google.mlkit.vision.digitalink.DigitalInkRecognizerOptions
import com.google.mlkit.vision.digitalink.Ink

class BasicHandwritingRecognizer : AppCompatActivity() {
    lateinit var binding: ActivityBasicHandwitingRecognizerBinding

    lateinit var recognizer: DigitalInkRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBasicHandwitingRecognizerBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        if (modelIdentifier != null) {


        binding.btnRecognize.setOnClickListener {

            val modelIdentifier = DigitalInkRecognitionModelIdentifier.fromLanguageTag("en-US")

            val model = DigitalInkRecognitionModel.builder(modelIdentifier!!).build()
            recognizer =
                DigitalInkRecognition.getClient(DigitalInkRecognizerOptions.builder(model).build())


//                var strokes: List<Ink.Stroke> = binding.dvDraw.getInk()
//                var ink = binding.dvDraw.getInk()
//                Log.d("HandWriting inside btn onSet", "${ink}")
//
//                if(ink.strokes.isEmpty()){
//                    Toast.makeText(this, "No strokes detected. Please write something.", Toast.LENGTH_SHORT).show()
//                    return@setOnClickListener
//                }

//                val ink = Ink.builder().apply {
//                    for (stroke in strokes) {
//                        addStroke(stroke)
//                    }
//                }.build()
            val ink = Ink.Builder().build()
            recognizer.recognize(ink)
                .addOnSuccessListener { result ->
                    val recognizedText = result.candidates[0].text
                    Log.d("HandWriting inside success", "$recognizedText")
                    if (recognizedText != null) {
                        // Show recognized text in Toast
                        Toast.makeText(this, "Recognized: $recognizedText", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this, "No text recognized", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { e ->
                    Log.d("HandWriting inside Failure", " ${e.message}", e)
                    Toast.makeText(this, "Recognition failed: ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }
        }

        binding.btnCancel.setOnClickListener {
            binding.dvDraw.clearStrokes()
        }
    }

//        else{
//            Toast.makeText(this, "Model for $modelIdentifier not found", Toast.LENGTH_SHORT).show()
//        }
}


//    private fun recognizeHandwriting() {
//
//    }

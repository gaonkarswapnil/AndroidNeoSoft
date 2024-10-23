package com.example.finalapplication.inkapi

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.google.mlkit.vision.digitalink.Ink

class DrawingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

//    private val inkBuilder = Ink.builder()
    private val strokeList = mutableListOf<Ink.Stroke>()            // multiple strokes list me store add karnar

    private var currentStrokeBuilder: Ink.Stroke.Builder? = null

    private val paint = Paint().apply {             // Paint Object Create karnar
        color = Color.BLACK                 // to change Stroke color
        strokeWidth = 8f                    // to change Stroke width
        isAntiAlias = true                  // to make line smoother(eliminate sharpe edges)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                currentStrokeBuilder = Ink.Stroke.builder()
                Log.d("HandWriting DrawView Inside Action_down", "${event}")
                addPoint(event.x,event.y)
            }

            MotionEvent.ACTION_MOVE -> {
                Log.d("HandWriting DrawView Inside Action_move", "${event}")
                addPoint(event.x,event.y)
            }

            MotionEvent.ACTION_UP -> {
//                strokeList.add(currentStrokeBuilder!!.build())
                currentStrokeBuilder?.let {
//                    Ink.Builder().addStroke(it.build())
                    strokeList.add(it.build())
                }
                Log.d("HandWriting DrawView Inside Action_up", "${strokeList.size}")
                currentStrokeBuilder = null
            }
        }
        invalidate()
        return true
    }

    private fun addPoint(x: Float, y: Float) {
        val point = Ink.Point.create(x, y, System.currentTimeMillis())
//        strokeList.add(point)
        currentStrokeBuilder!!.addPoint(point)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        for (i in strokeList.indices) {
//            if (i > 0) {
//                val prevPoint = strokeList[i - 1]
//                val currentPoint = strokeList[i]
//                canvas.drawLine(prevPoint.x, prevPoint.y, currentPoint.x, currentPoint.y, paint)
//            }
//        }

        for (stroke in strokeList) {
            val points = stroke.points
            for (i in 1 until points.size) {
                val prevPoint = points[i - 1]
                val currentPoint = points[i]
                canvas.drawLine(prevPoint.x, prevPoint.y, currentPoint.x, currentPoint.y, paint)
            }
        }
    }

    fun clearStrokes() {
        strokeList.clear()
        invalidate()
    }

    fun getInk(): Ink {
        val inkBuilder = Ink.builder()
        strokeList.forEach { stroke ->
            inkBuilder.addStroke(stroke)
        }
        return inkBuilder.build()
    }

}
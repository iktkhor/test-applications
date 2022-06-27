package com.example.fallingcircle

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class Circle(context: Context?, attrs: AttributeSet?) :
    View(context, attrs)  {

    private var r = 0f
    private var initialPoint: PointF = PointF(0f, 0f)

    private val timer = object: CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            initialPoint = PointF(initialPoint.x, initialPoint.y + 10)

            invalidate()
        }

        override fun onFinish() {
            r = 0f;
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val p = Paint()
        p.color = Color.RED

        canvas.drawCircle(initialPoint.x, initialPoint.y, r, p)
    }

    private fun setInitialPoint(x: Float, y: Float) {
        r = 50f
        initialPoint = PointF(x, y)
        invalidate()
    }

    private fun startFalling() {
        Thread(){
            while(initialPoint.y < height){
                initialPoint = PointF(initialPoint.x, initialPoint.y + 10)

                invalidate()
                Thread.sleep(10)
            }

            r = 0f;
            invalidate()
        }.start()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val eventX = event.x
        val eventY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                setInitialPoint(eventX, eventY)
            }
            MotionEvent.ACTION_UP -> {
                //startFalling()
                timer.start()
            }
        }

        return true
    }
}
package com.kos.solutioncup.widget

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import com.kos.solutioncup.R
import com.kos.solutioncup.utils.*

class CupButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : CupTextView(context, attrs) {

    init {
        setTextAppearance(R.style.TextAppearanceButton)

        gravity = Gravity.CENTER

        isClickable = true
        isFocusable = true
        setStyle(CupButtonStyle.NORMAL)
    }

    fun setStyle(style: CupButtonStyle) {
        when (style) {
            CupButtonStyle.NORMAL -> styleNormal()
            CupButtonStyle.FLAT -> styleFlat()
        }
    }

    private fun styleFlat() {
        setTextAppearance(R.style.TextAppearanceFlatButton)
        background = null
        setPadding(0, 0, 0, 0)
    }

    private fun styleNormal() {
        setTextAppearance(R.style.TextAppearanceButton)
        setBackgroundResource(R.drawable.button_background)
        val pd = px(ResourceManager.BUTTON_PADDING)
        setPadding(pd, pd, pd, pd)
    }

}
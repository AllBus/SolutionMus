package com.kos.solutioncup.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.updatePadding
import com.kos.solutioncup.R
import com.kos.solutioncup.utils.*

class CupCell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val image: ImageView = ImageView(context, attrs)
    private val title: CupTextView = CupTextView(context, attrs)
    private val description: CupTextView = CupTextView(context, attrs)
    private val textLayout: LinearLayout = LinearLayout(context, attrs)

    init {

        this.gravity = Gravity.CENTER_VERTICAL

        title.setTextAppearance(R.style.TextAppearanceTitle)
        description.setTextAppearance(R.style.TextAppearanceDescription)

        description.setPadding(0, px(ResourceManager.PADDING_DESCRIPTION), 0, 0)

        textLayout.apply {

            updatePadding(
                px(ResourceManager.IMAGE_PADDING),
                0,
                0,
                0,
            )
            orientation = LinearLayout.VERTICAL
            this.addView(title)
            this.addView(description)
        }

        orientation = LinearLayout.HORIZONTAL
        this.addView(image)
        this.addView(textLayout)
        updatePadding(
            px(ResourceManager.CELL_PADDING),
            px(ResourceManager.CELL_PADDING),
            px(ResourceManager.CELL_PADDING),
            px(ResourceManager.CELL_PADDING),
        )

        setStyle(CupStyle.NORMAL)

        title.matchParent_WrapContent()
        description.matchParent_WrapContent()
        image.size(ResourceManager.IMAGE_SIZE)
        description.margin(
            0,
            ResourceManager.PADDING_DESCRIPTION,
            0,
            0
        )
        setStyle(CupStyle.NORMAL)
    }

    fun setTitle(text: CharSequence) {
        title.setText(text)
    }

    fun setDescription(text: CharSequence) {
        description.setText(text)
    }

    fun setImage(drawable: Drawable?) {
        image.setImageDrawable(drawable)
    }

    fun hasCloseButton(enable: Boolean) {

    }

    fun setStyle(style: CupStyle) {
        when (style) {
            CupStyle.NORMAL -> styleNormal()
            CupStyle.FLAT -> styleFlat()
        }
    }

    private fun styleFlat() {
        elevation = dp(ResourceManager.FLAT_DIALOG_ELEVATION)
        background = drawable(ResourceManager.FLAT_DIALOG_BACKGROUND)
    }

    private fun styleNormal() {
        elevation = dp(ResourceManager.DIALOG_ELEVATION)
        background = drawable(ResourceManager.DIALOG_BACKGROUND)
    }


}
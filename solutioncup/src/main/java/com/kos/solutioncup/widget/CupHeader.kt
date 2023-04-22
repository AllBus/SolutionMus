package com.kos.solutioncup.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.updatePadding
import com.kos.solutioncup.R
import com.kos.solutioncup.utils.*

class CupHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs)
{

    private val image: ImageView = ImageView(context, attrs)
    private val title : TextView = CupTextView(context, attrs)
    private val description: TextView = CupTextView(context, attrs)
    private val button: CupButton = CupButton(context, attrs)
    private val editButton: CupButton = CupButton(context, attrs)
    private val textLayout: LinearLayout = LinearLayout(context, attrs)

    private val contentLayout: LinearLayout = LinearLayout(context, attrs)
    private val cardLayout: LinearLayout = LinearLayout(context, attrs)

    init {

        gravity = Gravity.CENTER_VERTICAL
        orientation = VERTICAL

        cardLayout.apply {
            gravity = Gravity.CENTER_VERTICAL

            title.setTextAppearance(R.style.TextAppearanceHeader)
            description.setTextAppearance(R.style.TextAppearanceSubHeader)

            description.setPadding(
                0,
                px(ResourceManager.PADDING_SUB_HEADER),
                0,
                0
            )

            textLayout.apply {

                updatePadding(
                   0,
                    0,
                    px(ResourceManager.IMAGE_PADDING),
                    0,
                )
                orientation = VERTICAL
                this.addView(title)
                this.addView(description)
            }

            orientation = HORIZONTAL
            this.addView(textLayout)
            this.addView(image)
            this.addView(editButton)



            updatePadding(
                px(ResourceManager.CELL_PADDING),
                px(ResourceManager.CELL_PADDING),
                px(ResourceManager.CELL_PADDING),
                px(ResourceManager.CELL_PADDING),
            )


            textLayout.matchConstraint_WrapContent()
            title.matchParent_WrapContent()
            description.matchParent_WrapContent()
            image.size(ResourceManager.IMAGE_SIZE)
            editButton.wrapContent_WrapContent()

            editButton.setStyle(CupButtonStyle.FLAT)
        }


        addView(cardLayout)
        addView(contentLayout)
        addView(button)


        button.matchParent_WrapContent()
        cardLayout.matchParent_WrapContent()
        contentLayout.matchParent_WrapContent()
        contentLayout.orientation = VERTICAL
        button.setStyle(CupButtonStyle.NORMAL)
        button.margin(ResourceManager.BUTTON_MARGIN)


        setButton(null)
        setEditButton(null)
        setImage(null)

        setStyle(CupStyle.NORMAL)
    }

    fun setTitle(text: CharSequence){
        title.setText(text)
    }

    fun setDescription(text:CharSequence?){
        description.visibility = if (text != null) View.VISIBLE else View.GONE
        description.setText(text)
    }

    fun setImage(drawable: Drawable?){
        image.visibility = if (drawable != null) View.VISIBLE else View.GONE
        image.setImageDrawable(drawable)
    }

    fun setButton(text: CharSequence?){
        button.visibility = if (text != null) View.VISIBLE else View.GONE
        button.text = text
    }

    fun setButtonListener(listener: View.OnClickListener?){
        button.setOnClickListener(listener)
    }

    fun setEditButton(text: CharSequence?){
        editButton.visibility = if (text != null) View.VISIBLE else View.GONE
        editButton.text = text
    }

    fun setEditButtonListener(listener: View.OnClickListener?){
        editButton.setOnClickListener( listener)
    }

    fun setStyle(style: CupStyle){
        when (style){
            CupStyle.NORMAL-> styleNormal()
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
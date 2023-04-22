package com.kos.solutioncup.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.updatePadding
import com.kos.solutioncup.R
import com.kos.solutioncup.utils.*

class CupContentItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs)
{

    private val image: ImageView = ImageView(context, attrs)
    private val title : CupTextView = CupTextView(context, attrs)
    private val description: CupTextView = CupTextView(context, attrs)
    private val textLayout: LinearLayout = LinearLayout(context, attrs)

    init {

        this.gravity = Gravity.CENTER_VERTICAL

        title.setTextAppearance(R.style.TextAppearanceTitle)
        description.setTextAppearance(R.style.TextAppearanceDescription)

        description.setPadding(0,px(ResourceManager.PADDING_DESCRIPTION), 0 ,0)

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
        margin(
            ResourceManager.CELL_PADDING,
            ResourceManager.CELL_VERTICAL_PADDING,
            ResourceManager.CELL_PADDING,
            ResourceManager.CELL_VERTICAL_PADDING,
        )

        title.matchParent_WrapContent()
        description.matchParent_WrapContent()
        image.size(ResourceManager.IMAGE_SIZE)

    }

    fun setTitle(text: CharSequence){
        title.setText(text)
    }

    fun setDescription(text:CharSequence){
        description.setText(text)
    }

    fun setImage(drawable: Drawable?){
        image.setImageDrawable(drawable)
    }

    fun setData(data: CupContentData){
        setTitle(data.title)
        setDescription(data.description)
        setImage(data.image)
    }

    fun setOrientation(orientation: ContentOrientation){
        when (orientation){
            ContentOrientation.VERTICAL -> styleVertical()
            ContentOrientation.HORIZONTAL -> styleHorizontal()
        }

        updateSize(orientation)
    }

    private fun updateSize(orientation: ContentOrientation){

        when (orientation){
            ContentOrientation.VERTICAL ->  this.matchParent_WrapContent()
            ContentOrientation.HORIZONTAL -> {
                this.matchConstraint_size(ResourceManager.ITEM_VERTICAL_SIZE)

            }
        }

    }

    private fun styleVertical() {
        elevation = dp(ResourceManager.FLAT_DIALOG_ELEVATION)
        background = null
        this.orientation = HORIZONTAL

        textLayout.matchParent_WrapContent()
        margin(
            ResourceManager.CELL_PADDING,
            ResourceManager.CELL_VERTICAL_PADDING,
            ResourceManager.CELL_PADDING,
            ResourceManager.CELL_VERTICAL_PADDING,
        )
    }

    private fun styleHorizontal() {
        elevation = dp(ResourceManager.DIALOG_ELEVATION)
        background = drawable(ResourceManager.CONTENT_HORIZONTAL_BACGROUND)
        this.orientation = VERTICAL

        textLayout.matchParent_MatchConstraint()
        margin(
            ResourceManager.CELL_HORIZONTAL_PADDING,
            ResourceManager.CELL_PADDING,
            ResourceManager.CELL_HORIZONTAL_PADDING,
            ResourceManager.CELL_PADDING,
        )
    }


}
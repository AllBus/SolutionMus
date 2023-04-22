package com.kos.solutioncup.utils

import android.app.ActionBar.LayoutParams
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.kos.solutioncup.R

object ResourceManager
{
    val CELL_PADDING = R.dimen.cellPadding
    val PADDING_DESCRIPTION = R.dimen.descriptionPadding
    val PADDING_SUB_HEADER = R.dimen.subHeaderPadding
    val BUTTON_PADDING = R.dimen.buttonPadding
    val BUTTON_MARGIN = R.dimen.buttonMargin


    val DIALOG_ELEVATION = R.dimen.dialogElevation
    val FLAT_DIALOG_ELEVATION = R.dimen.flatDialogElevation

    val IMAGE_SIZE = R.dimen.imageSize
    val IMAGE_PADDING = R.dimen.imagePadding

    val DIALOG_BACKGROUND = R.drawable.dialog_background
    val FLAT_DIALOG_BACKGROUND = R.drawable.flat_dialog_background
}

fun View.dp(resourceName:Int): Float =
    this.resources.getDimension(resourceName)

fun View.px(resourceName:Int): Int =
    this.resources.getDimensionPixelSize(resourceName)

fun View.drawable(resourceName:Int): Drawable? =
    ContextCompat.getDrawable(this.context, resourceName)

fun View.matchParent_WrapContent() {

    val lp = this.layoutParams
    lp.width = LayoutParams.MATCH_PARENT
    lp.height = LayoutParams.WRAP_CONTENT
    this.layoutParams = lp
}

fun View.matchConstraint_WrapContent() {

    val lp = this.layoutParams
    lp.width = 0
    lp.height = LayoutParams.WRAP_CONTENT
    if (lp is LinearLayout.LayoutParams){
        lp.weight = 1.0f
    }

    this.layoutParams = lp
}


fun View.wrapContent_WrapContent(){

    val lp = this.layoutParams
    lp.width = LayoutParams.WRAP_CONTENT
    lp.height = LayoutParams.WRAP_CONTENT
    this.layoutParams = lp
}


fun View.size(resourceName: Int){
    val s = px(resourceName)
    val lp = this.layoutParams
    lp.width = s
    lp.height = s
    this.layoutParams = lp
}

fun View.margin(resourceName: Int){
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { lp ->
        val s = px(resourceName)
        lp.setMargins(
            s,s,s,s
        )
        this.layoutParams = lp
    }

}
fun View.layoutGravityTop(){
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { lp ->
        this.layoutParams = lp
    }

}
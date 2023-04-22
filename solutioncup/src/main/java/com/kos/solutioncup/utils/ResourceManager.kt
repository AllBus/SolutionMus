package com.kos.solutioncup.utils

import android.app.ActionBar.LayoutParams
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.kos.solutioncup.R

object ResourceManager {
    val CELL_PADDING = R.dimen.cellPadding
    val CELL_VERTICAL_PADDING = R.dimen.cellVerticalPadding
    val CELL_HORIZONTAL_PADDING = R.dimen.cellHorizontalPadding
    val CELL_HORIZONTAL_OFFSET = R.dimen.cellHorizontallOffest
    val CARD_PADDING = R.dimen.cardPadding
    val HEADER_VERTICAL_PADDING = R.dimen.headerVerticalPadding
    val ITEM_VERTICAL_SIZE = R.dimen.itemVerticalSize
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
    val CONTENT_HORIZONTAL_BACGROUND = R.drawable.content_horizontal_background
}

fun View.dp(resourceName: Int): Float =
    this.resources.getDimension(resourceName)

fun View.px(resourceName: Int): Int =
    if (resourceName == 0) 0
    else
        this.resources.getDimensionPixelSize(resourceName)

fun View.drawable(resourceName: Int): Drawable? =
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
    if (lp is LinearLayout.LayoutParams) {
        lp.weight = 1.0f
    }

    this.layoutParams = lp
}

fun View.matchConstraint_size(resourceName: Int) {
    val s = px(resourceName)
    val lp = this.layoutParams
    lp.width = 0
    lp.height = s
    if (lp is LinearLayout.LayoutParams) {
        lp.weight = 1.0f
    }

    this.layoutParams = lp
}

fun View.matchParent_MatchConstraint() {

    val lp = this.layoutParams
    lp.width = LayoutParams.MATCH_PARENT
    lp.height = 0
    if (lp is LinearLayout.LayoutParams) {
        lp.weight = 1.0f
    }

    this.layoutParams = lp
}

fun View.wrapContent_WrapContent() {

    val lp = this.layoutParams
    lp.width = LayoutParams.WRAP_CONTENT
    lp.height = LayoutParams.WRAP_CONTENT
    this.layoutParams = lp
}


fun View.size(resourceName: Int) {
    val s = px(resourceName)
    val lp = this.layoutParams
    lp.width = s
    lp.height = s
    this.layoutParams = lp
}

fun View.margin(resourceName: Int) {
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { lp ->
        val s = px(resourceName)
        lp.setMargins(
            s, s, s, s
        )
        this.layoutParams = lp
    }
}

fun View.margin(l: Int, t: Int, r: Int, b: Int) {
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { lp ->

        lp.setMargins(
            px(l),
            px(t),
            px(r),
            px(b)
        )
        this.layoutParams = lp
    }
}
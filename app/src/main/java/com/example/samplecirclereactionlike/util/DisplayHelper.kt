package com.example.samplecirclereactionlike.util


import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by Yogesh Paliyal on 08/03/18.
 */

fun getScreenSize(context: Context): IntArray {
    val displaymetrics = DisplayMetrics()
    val windowManager =
        context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    if (windowManager != null) {
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        val h = displaymetrics.heightPixels
        val w = displaymetrics.widthPixels
        return intArrayOf(w, h)
    }
    return intArrayOf(0, 0)
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun setStatusBarGradient(activity: Activity, drawableResId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window = activity.window
        val background =
            activity.resources.getDrawable(drawableResId)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = activity.resources.getColor(android.R.color.transparent)
        window.setBackgroundDrawable(background)
    }
}

fun Context.getResourceDimenInPx(resId: Int): Int {
    return (resources.getDimension(resId) / resources
        .displayMetrics.scaledDensity).toInt()
}

/**
 * This method converts dp unit to equivalent pixels, depending on device density.
 *
 * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
 * @param context Context to get resources and device specific display metrics
 * @return A int value to represent px equivalent to dp depending on device density
 */
fun Context?.convertDpToPx(dp: Float): Int {
    if (this == null)
        return 0
    val metrics = resources.displayMetrics
    val px =
        dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    return px.toInt()
}

/**
 * This method converts device specific pixels to density independent pixels.
 *
 * @param px      A value in px (pixels) unit. Which we need to convert into db
 * @param context Context to get resources and device specific display metrics
 * @return A int value to represent dp equivalent to px value
 */
fun Context.convertPxToDp(px: Float): Int {
    val metrics = resources.displayMetrics
    val dp =
        px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    return dp.toInt()
}

fun Context.convertPxToSp(px: Float): Int {
    return Math.round(px / resources.displayMetrics.scaledDensity)
}

fun Context.convertSpToPx(sp: Float): Int {
    return Math.round(sp * resources.displayMetrics.scaledDensity)
}

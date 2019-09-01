package com.ekremozan.basemvparchitecture.utils

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import com.ekremozan.note.utils.Constants
import java.io.IOException
import java.nio.charset.Charset
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object CommonUtils {

    val timeStamp: String
        get() = SimpleDateFormat(Constants.TIMESTAMP_FORMAT, Locale("tr","TR")).format(Date())

    val simpleDateFormat: SimpleDateFormat
        get() = SimpleDateFormat(Constants.DATE_FORMAT, Locale("tr","TR"))

    val simpleTimeFormat: SimpleDateFormat
        get() = SimpleDateFormat(Constants.TIME_FORMAT, Locale("tr","TR"))

    fun convertTlFormat(money: Double): String{
        val nf = NumberFormat.getCurrencyInstance(Locale("tr", "TR"))
        return nf.format(money).toString()
    }

    fun showLoadingDialog(context: Context, message: String): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage(message)
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.show()
        return progressDialog
    }


    @SuppressLint("all")
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }


    fun makeToast(context: Context, message: String){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }

    fun showDialog(@NonNull context: Context, @NonNull cancelable: Boolean, @NonNull title: String, @NonNull msg: String,
                   @NonNull positiveBtnText: String, @Nullable negativeBtnText: String?,
                   @NonNull positiveBtnClickListener: DialogInterface.OnClickListener,
                   @Nullable negativeBtnClickListener: DialogInterface.OnClickListener?
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setCancelable(cancelable)
            .setPositiveButton(positiveBtnText, positiveBtnClickListener)
        if (negativeBtnText != null)
            builder.setNegativeButton(negativeBtnText, negativeBtnClickListener)
        val alert = builder.create()
        alert.show()
        return alert
    }

    fun isEmailValid(email: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }


    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {

        val manager = context.assets
        val `is` = manager.open(jsonFileName)

        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()

        return String(buffer, Charset.forName("UTF-8"))
    }
}
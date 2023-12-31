package com.kyawlinnthant.auth.presentation.common

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.core.content.FileProvider
import java.io.File

object ByteCalculator {
    const val BYTE = 1024
    const val DEFAULT_RETURN_NUMBER = -1
}
sealed interface ImageSize {
    object B : ImageSize
    object KB : ImageSize
    object MB : ImageSize
}

infix fun Long.asSize(expected: ImageSize): Long {
    val bytes = this
    val kb = bytes / ByteCalculator.BYTE
    val mb = kb / ByteCalculator.BYTE
    return when (expected) {
        ImageSize.B -> bytes
        ImageSize.KB -> kb
        ImageSize.MB -> mb
    }
}

infix fun Uri.asSize(context: Context): Long {
    val cursor = context.contentResolver.query(this, null, null, null, null)
    val sizeIndex = cursor?.getColumnIndex(OpenableColumns.SIZE) ?: -1
    cursor?.moveToFirst()
    val size = cursor?.getLong(sizeIndex)
    cursor?.close()
    return size ?: -1
}

fun getTmpFileUri(
    context: Context,
    prefix: String,
    suffix: String = ".jpg",
    authority: String = "com.kyawlinnthant.firetouch.provider"
): Uri {
    val tmpFile = File.createTempFile(prefix, suffix, context.cacheDir).apply {
        createNewFile()
        deleteOnExit()
    }
    return FileProvider.getUriForFile(
        context,
        authority,
        tmpFile
    )
}
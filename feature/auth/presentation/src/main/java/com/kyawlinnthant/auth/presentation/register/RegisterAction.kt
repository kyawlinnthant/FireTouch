package com.kyawlinnthant.auth.presentation.register

import android.net.Uri

sealed interface RegisterAction {
    data class UpdateTmpUri(val uri: Uri) : RegisterAction
}

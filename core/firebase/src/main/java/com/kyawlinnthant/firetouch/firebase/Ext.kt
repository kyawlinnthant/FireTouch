package com.kyawlinnthant.firetouch.firebase

import com.google.firebase.auth.FirebaseUser
import com.kyawlinnthant.model.CurrentUser

fun FirebaseUser.asUser(): CurrentUser {
    return CurrentUser(
        id = this.uid,
        name = this.displayName ?: "",
        email = this.email ?: "",
        photo = this.photoUrl?.toString() ?: ""
    )
}

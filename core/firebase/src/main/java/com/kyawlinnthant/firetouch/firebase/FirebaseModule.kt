package com.kyawlinnthant.firetouch.firebase

import android.app.Application
import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    private const val WEB_API_KEY =
        "854571229670-rkadonigdrgiishvp5fvvm70n95a31fi.apps.googleusercontent.com"

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class SignInRequest

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class SignupRequest

    @Provides
    @Singleton
    fun provideFirebaseOption(): FirebaseOptions = FirebaseOptions.Builder()
        .setProjectId("firetouch-47b2b")
        .setApplicationId("1:854571229670:android:2cac92f4fabc2a6a99f627")
        .setApiKey("AIzaSyDPekmztoB0pUcyTBifqv0E4yjD7bSenhg")
        .build()

    @Provides
    @Singleton
    fun provideFirebaseInstance(
        @ApplicationContext context: Context,
        firebaseOptions: FirebaseOptions
    ): FirebaseApp = Firebase.initialize(
        context = context,
        options = firebaseOptions,
        name = "one-touch"
    )

    @Provides
    @Singleton
    fun provideFirebaseAuth(
        app: FirebaseApp
    ): FirebaseAuth = Firebase.auth(app)

    @Provides
    @Singleton
    fun provideFirebaseFireStore(
        app: FirebaseApp
    ): FirebaseFirestore = Firebase.firestore(app)

    @Provides
    @Singleton
    fun provideOneTabClient(
        @ApplicationContext context: Context
    ): SignInClient = Identity.getSignInClient(context)

    @Provides
    @Singleton
    @SignInRequest
    fun provideSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(WEB_API_KEY)
                    .setFilterByAuthorizedAccounts(false) // true for remember
                    .build()
            )
            .setAutoSelectEnabled(false) // true for remember
            .build()
    }

    @Provides
    @Singleton
    @SignupRequest
    fun provideSignupRequest(): BeginSignInRequest {
        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(WEB_API_KEY)
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            ).build()
    }

    @Provides
    @Singleton
    fun provideGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(WEB_API_KEY)
            .requestEmail()
            .build()
    }

    @Provides
    @Singleton
    fun provideGoogleSignInClient(
        app: Application,
        options: GoogleSignInOptions
    ): GoogleSignInClient = GoogleSignIn.getClient(app, options)
}

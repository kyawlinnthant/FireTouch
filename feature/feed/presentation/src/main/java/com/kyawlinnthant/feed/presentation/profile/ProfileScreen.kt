package com.kyawlinnthant.feed.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kyawlinnthant.model.CurrentUser
import com.kyawlinnthant.theme.FireTouchTheme

@Composable
fun ProfileScreen() {
    val vm: ProfileViewModel = hiltViewModel()
    val user = vm.currentUser.collectAsState()
    Scaffold(topBar = {}) { innerPadding ->
        ProfileContent(
            paddingValues = innerPadding,
            user = user.value,
            onLogout = vm::doLogout
        )
    }
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    user: CurrentUser,
    onLogout: () -> Unit = {},
    profileImgRatio: Float = 1.33f
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = user.photo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(profileImgRatio)
        )
        Text(text = user.name)
        Text(text = user.email)
        Button(onClick = onLogout) {
            Text(text = "Logout")
        }
    }
}

@Preview
@Composable
private fun ProfilePreview() {
    FireTouchTheme {
        Surface {
            ProfileContent(
                paddingValues = PaddingValues(),
                user = CurrentUser(
                    id = "this is id",
                    name = "this is name",
                    email = "this is email",
                    photo = "this is photo"
                )
            )
        }
    }
}
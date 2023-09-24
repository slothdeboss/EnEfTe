package com.slothdeboss.enefte.ui.screens.setupProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

// TODO - refactor this screen to split into smaller components

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupProfileScreen(
    state: SetupProfileState,
    onEvent: (SetupProfileEvent) -> Unit,
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.setup_profile),
                        style = typography.h2.copy(color = colors.white)
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                onEvent(SetupProfileEvent.NavigateBack)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colors.dark
                )
            )
        },
        containerColor = colors.dark
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(vertical = 52.dp, horizontal = 24.dp)
        ) {

            Text(
                text = stringResource(id = R.string.upload_profile_photo),
                style = typography.body.copy(color = colors.white)
            )

            Spacer(modifier = Modifier.height(dimensions.default))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(dimensions.default),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .weight(1f),
                    painter = painterResource(id = R.drawable.ic_pfp),
                    contentDescription = null
                )

                OutlinedButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {}
                ) {
                    Text(
                        text = stringResource(id = R.string.upload_photo),
                        style = typography.button.copy(color = colors.white)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.name.value,
                onValueChange = { name ->
                    onEvent(SetupProfileEvent.UpdateField.updateName(value = name))
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colors.secondary,
                    unfocusedContainerColor = colors.secondary,
                    focusedTextColor = colors.white,
                    unfocusedTextColor = colors.grayLight,
                ),
                label = {
                    Text(
                        text = stringResource(id = R.string.username),
                        style = typography.body.copy(color = colors.grayLight)
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.email.value,
                onValueChange = { email ->
                    onEvent(SetupProfileEvent.UpdateField.updateEmail(value = email))
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colors.secondary,
                    unfocusedContainerColor = colors.secondary,
                    focusedTextColor = colors.white,
                    unfocusedTextColor = colors.grayLight,
                ),
                label = {
                    Text(
                        text = stringResource(id = R.string.email),
                        style = typography.body.copy(color = colors.grayLight)
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                value = state.bio.value,
                onValueChange = { bio ->
                    onEvent(SetupProfileEvent.UpdateField.updateBio(value = bio))
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colors.secondary,
                    unfocusedContainerColor = colors.secondary,
                    focusedTextColor = colors.white,
                    unfocusedTextColor = colors.grayLight,
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.bio),
                        style = typography.body.copy(color = colors.grayLight)
                    )
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            RoundedCornerButton(
                label = R.string.submit,
                onClick = {
                    onEvent(SetupProfileEvent.ValidateData)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SetupProfileScreenPreview() {
    EnEfTeTheme {
        SetupProfileScreen(
            state = SetupProfileState.default(),
            onEvent = {}
        )
    }
}

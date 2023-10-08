package com.slothdeboss.enefte.ui.screens.setupProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.components.imagePicker.ImagePicker
import com.slothdeboss.enefte.ui.components.textField.InputTextField
import com.slothdeboss.enefte.ui.components.topAppBar.TitleTopAppBar
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

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
            TitleTopAppBar(
                title = R.string.setup_profile,
                onBackPressed = { onEvent(SetupProfileEvent.NavigateBack) }
            )
        },
        containerColor = colors.dark
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(vertical = dimensions.dimension52, horizontal = dimensions.dimension24),
            verticalArrangement = Arrangement.spacedBy(dimensions.dimension24)
        ) {

            Text(
                text = stringResource(id = R.string.upload_profile_photo),
                style = typography.body.copy(color = colors.white)
            )

            ImagePicker(
                onButtonClick = { },
                buttonLabel = R.string.upload_photo,
                modifier = Modifier.fillMaxWidth()
            )

            InputTextField(
                state = state.name,
                onValueChanged = { name ->
                    onEvent(SetupProfileEvent.UpdateField.updateName(value = name))
                },
                label = R.string.username,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )

            InputTextField(
                state = state.email,
                onValueChanged = { email ->
                    onEvent(SetupProfileEvent.UpdateField.updateEmail(value = email))
                },
                label = R.string.email,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )

            InputTextField(
                state = state.bio,
                onValueChanged = { bio ->
                    onEvent(SetupProfileEvent.UpdateField.updateBio(value = bio))
                },
                label = R.string.bio,
                modifier = Modifier.fillMaxWidth(),
                height = 110.dp,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            RoundedCornerButton(
                label = R.string.submit,
                onClick = { onEvent(SetupProfileEvent.ValidateData) }
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

package com.slothdeboss.enefte.ui.components.textField

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.field.InputFieldState
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun InputTextField(
    state: InputFieldState,
    onValueChanged: (String) -> Unit,
    @StringRes label: Int,
    modifier: Modifier = Modifier,
    height: Dp = 56.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Column(
        modifier = modifier.wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(dimensions.dimension8)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
            value = state.value,
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colors.secondary,
                unfocusedContainerColor = colors.secondary,
                focusedTextColor = colors.white,
                unfocusedTextColor = colors.grayLight,
                errorContainerColor = colors.secondary,
            ),
            textStyle = typography.body,
            label = {
                Text(
                    text = stringResource(id = label),
                    style = typography.body.copy(color = colors.grayLight)
                )
            },
            isError = state.hasError(),
            keyboardOptions = keyboardOptions,
            singleLine = singleLine
        )

        if (state.hasError()) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = state.validation.error ?: stringResource(id = R.string.something_went_wrong),
                style = typography.body.copy(color = colors.danger)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    EnEfTeTheme {
        Column {
            InputTextField(
                state = InputFieldState.default(),
                onValueChanged = {},
                label = R.string.email
            )

            Spacer(modifier = Modifier.height(8.dp))

            InputTextField(
                state = InputFieldState.error(),
                onValueChanged = {},
                label = R.string.email
            )
        }
    }
}

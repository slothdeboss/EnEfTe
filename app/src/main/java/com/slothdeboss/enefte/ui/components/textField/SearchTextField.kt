package com.slothdeboss.enefte.ui.components.textField

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun SearchTextField(
    value: String,
    onValueChanged: (value: String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val colors = EnEfTeTheme.colors

    Surface(
        shape = EnEfTeTheme.shapes.default,
        color = colors.secondary
    ) {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChanged,
            textStyle = EnEfTeTheme.typography.body,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = stringResource(id = R.string.search)
                )
            },
            trailingIcon = if (value.isNotBlank()) {
                {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = stringResource(id = R.string.close)
                    )
                }
            } else {
                null
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colors.secondary,
                unfocusedBorderColor = colors.secondary,
                leadingIconColor = colors.grayLight,
                trailingIconColor = colors.grayLight,
                textColor = colors.white,
                placeholderColor = colors.grayLight
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_your_nft)
                )
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        SearchTextField(
            value = "",
            onValueChanged = {}
        )
    }
}

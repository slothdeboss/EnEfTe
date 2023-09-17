package com.slothdeboss.enefte.ui.components.clickableText

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

private const val TERMS_OF_SERVICES = "__terms_of_services"
private const val PRIVACY_POLICY = "__privacy_policy"

@Composable
fun TermsAndPolicyClickableText(
    onTermsClick: () -> Unit,
    onPolicyClick: () -> Unit,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {

    val termsAndPolicyText = provideTermsAndPolicyText()

    ClickableText(
        modifier = modifier,
        text = termsAndPolicyText,
        style = TextStyle(textAlign = textAlign),
        onClick = { index ->
            termsAndPolicyText
                .getStringAnnotations(start = index, end = index)
                .firstOrNull()
                ?.let { range ->
                    when (range.item) {
                        TERMS_OF_SERVICES -> onTermsClick()
                        PRIVACY_POLICY -> onPolicyClick()
                    }
                }
        }
    )
}

@Composable
private fun provideTermsAndPolicyText(): AnnotatedString {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    val bodyStyle = typography.body.toSpanStyle()
    val regularTextStyle = bodyStyle.copy(color = colors.grayLight)
    val clickableTextStyle = bodyStyle.copy(color = colors.white)

    val byConnectingWallet = stringResource(id = R.string.by_connecting_you_wallet)
    val termsOfServices = stringResource(id = R.string.terms_of_service)
    val and = stringResource(id = R.string.and)
    val privacyPolicy = stringResource(id = R.string.privacy_policy)

    return buildAnnotatedString {
        withStyle(regularTextStyle) {
            append(byConnectingWallet)
        }

        append(" ")

        withStyle(clickableTextStyle) {
            pushStringAnnotation(TERMS_OF_SERVICES, termsOfServices)
            append(termsOfServices)
            pop()
        }

        append(" ")

        withStyle(regularTextStyle) {
            append(and)
        }

        append(" ")

        withStyle(clickableTextStyle) {
            pushStringAnnotation(PRIVACY_POLICY, privacyPolicy)
            append(privacyPolicy)
            pop()
        }
    }
}

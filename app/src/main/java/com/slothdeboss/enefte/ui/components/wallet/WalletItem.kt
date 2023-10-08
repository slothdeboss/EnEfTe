package com.slothdeboss.enefte.ui.components.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun WalletItem(
    option: WalletOption,
    onOptionClick: (WalletOption) -> Unit,
    modifier: Modifier = Modifier
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Row(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(56.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = colors.secondary)
            .clickable { onOptionClick(option) }
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
       
        Image(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = option.icon),
            contentDescription = null
        )

        Text(
           text = stringResource(id = option.name),
            style = typography.h2.copy(color = colors.white)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WalletItemPreview() {
    EnEfTeTheme {
        WalletItem(
            option = WalletOption(
                type = WalletOption.WalletType.METAMASK,
                name = R.string.metamask,
                icon = R.drawable.ic_metamask
            ),
            onOptionClick = { }
        )
    }
}
package br.com.walletapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.walletapp.ui.theme.white

@Composable
fun WalletOverview(
    valueBeforeComma: () -> Int,
    valueAfterComma: () -> Int,
    onDepositClick: () -> Unit,
    onWithdrawClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(onClick = {
            onWithdrawClick()
        }) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "withdraw",
                tint = white,
                modifier = Modifier.size(28.dp)
            )
        }
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.BottomCenter
        ){
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                Text(
                    "${valueBeforeComma()}",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    ",",
                    fontSize = 20.sp,
                    modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                )
                Text(
                    "%02d".format(valueAfterComma()),
                    fontSize = 20.sp,
                    modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                )
                Text(
                    "€",
                    fontSize = 18.sp,
                    modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                )
            }
        }

        IconButton(onClick = {
            onDepositClick()
        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "deposit",
                tint = white,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Preview
@Composable
fun WalletOverviewPreview() {
    WalletOverview(
        valueAfterComma = { 10 },
        valueBeforeComma = { 30 },
        onDepositClick = {},
        onWithdrawClick = {}
    )
}
package br.com.walletapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import br.com.walletapp.presentation.components.TransactionDialog
import br.com.walletapp.presentation.components.TransactionItem
import br.com.walletapp.presentation.components.WalletOverview
import br.com.walletapp.ui.theme.gray
import br.com.walletapp.ui.theme.orange
import br.com.walletapp.ui.theme.white

@Composable
fun WalletScreen(
    viewModel: WalletViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WalletOverview(
            valueBeforeComma = {
                viewModel.totalAmountBeforeComma
            },
            valueAfterComma = {
                viewModel.totalAmountAfterComma
            },
            onDepositClick = {
                viewModel.onDepositClick()
            },
            onWithdrawClick = {
                viewModel.onWithdrawClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, RoundedCornerShape(15.dp))
                .background(orange, shape = RoundedCornerShape(15.dp))
                .aspectRatio(2f)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(viewModel.transactionList) {
                TransactionItem(
                    color = it.color,
                    description = it.description,
                    value = it.value,
                    date = it.date,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(white.copy(0.8f), RoundedCornerShape(25.dp))
                        .padding(12.dp)
                )
            }
        }
    }

    if (viewModel.transactionDialogState.isOpen) {
        TransactionDialog(
            onDismiss = {
                viewModel.onDismissDialog()
            },
            value = {
                viewModel.transactionDialogState.currentValueInput
            },
            onValueChange = {
                viewModel.onTransactionValueChange(it)
            },
            description = viewModel.transactionDialogState.type.toString(),
            onConfirm = {
                viewModel.onTransactionConfirm()
            },
            isButtonEnabled = {
                viewModel.transactionDialogState.isConfirmButtonEnabled
            }
        )
    }
}
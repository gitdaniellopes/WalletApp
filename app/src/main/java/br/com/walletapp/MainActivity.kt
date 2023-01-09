package br.com.walletapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import br.com.walletapp.presentation.WalletScreen
import br.com.walletapp.presentation.WalletViewModel
import br.com.walletapp.ui.theme.WalletAppTheme
import br.com.walletapp.ui.theme.orange

class MainActivity : ComponentActivity() {

    private val walletViewModel = WalletViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = orange.toArgb()
            window.navigationBarColor = orange.toArgb()
            WalletAppTheme {
                WalletScreen(viewModel = walletViewModel)
            }
        }
    }
}
package br.com.walletapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import br.com.walletapp.ui.theme.orange
import br.com.walletapp.ui.theme.white

@Composable
fun TransactionDialog(
    onDismiss: () -> Unit,
    value: () -> String,
    onValueChange: (String) -> Unit,
    description: String,
    onConfirm: () -> Unit,
    isButtonEnabled: () -> Boolean
) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ){
        Card(
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth()
        ){
            CompositionLocalProvider(
                LocalTextSelectionColors provides TextSelectionColors(
                    handleColor = orange,
                    backgroundColor = Color.Transparent
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){

                    OutlinedTextField(
                        value = value(),
                        onValueChange = {
                            onValueChange(it)
                        },
                        textStyle = MaterialTheme.typography.body1,
                        label = {
                            Text(description)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = orange,
                            focusedIndicatorColor = orange,
                            focusedLabelColor = orange
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    Button(
                        onClick = {
                            onConfirm()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = orange,
                            contentColor = white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        shape = CircleShape,
                        enabled = isButtonEnabled()
                    ) {
                        Text(
                            text = "Confirm",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}
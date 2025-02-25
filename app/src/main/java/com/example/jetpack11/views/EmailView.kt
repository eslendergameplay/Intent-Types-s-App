package com.example.jetpack11.views

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun EmailView(){

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){
        var email by remember { mutableStateOf("")}
        var subject by remember { mutableStateOf("")}
        var message by remember { mutableStateOf("")}
        val context = LocalContext.current
        Text(text = "Email View", fontSize = 50.sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(value = email, onValueChange = {email = it},label = { Text(text = "Introduzca el email Aqui.")}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp))
        OutlinedTextField(value = subject, onValueChange = {subject = it}, label = { Text(text = "introduzca el asunto Aqui.")},modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp))
        OutlinedTextField(value = message, onValueChange = {message = it},label = {Text(text ="Introduzca el mensaje Aqui.")}, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp))
        if(email.isNotEmpty() && subject.isNotEmpty() && message.isNotEmpty()){
            Button(onClick = {
                val intent = Intent(Intent.ACTION_SEND)
                val emailAdress = arrayOf(email)
                intent.putExtra(Intent.EXTRA_EMAIL,emailAdress)
                intent.putExtra(Intent.EXTRA_SUBJECT,subject)
                intent.putExtra(Intent.EXTRA_TEXT,message)
                intent.type = "message/rfc822"
                context.startActivity(Intent.createChooser(intent,"Email Client."))
            }) {
                Text(text = "Enviar Email.")
            }
        }else{

        }
    }
}
package com.juandiegogarcia.loginusertimetonic

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.runBlocking

@Composable
fun BookScreen(o_u:String, sessionKey:String){
    val context = LocalContext.current
    Column {

        val books = runBlocking {
            val booksResponse = BooksFetch(o_u = o_u, sessionKey)
            return@runBlocking booksResponse
        }

        if (books == null){
            showMessage(context, message = "Your user or password is wrong")
        }else{
            books.allBooks.books[0].description?.let { Text(text = it) }
        }
    }
}
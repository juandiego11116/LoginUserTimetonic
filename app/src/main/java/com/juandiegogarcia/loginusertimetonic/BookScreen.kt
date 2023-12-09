package com.juandiegogarcia.loginusertimetonic

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.runBlocking

/**
 * Composable function representing the user login screen.
 *
 * @param o_u used for call BookFetch
 * @param sessionKey used for call BookFetch
 */
@Composable
fun BookScreen(o_u:String, sessionKey:String){

    val books = runBlocking {
        val booksResponse = BooksFetch(o_u = o_u, sessionKey)
        return@runBlocking booksResponse
    }
    LazyVerticalGrid(GridCells.Fixed(1), modifier = Modifier.fillMaxSize()) {
        if (books != null) {
            items(books.allBooks.books){
                    book ->
                BookItem(book = book)
            }
        }
    }

}

/**
 * Composable function representing a book item in the UI.
 *
 * @param book The Book object containing information about the book.
 */
@Composable
fun BookItem(book: Book){
    Column (modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable {  },
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = rememberAsyncImagePainter("https://timetonic.com${book.ownerPrefs.oCoverImg}"),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(text = book.ownerPrefs.title,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

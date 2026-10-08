package ca.gbc.comp3074.rodrigues_leticia.lab3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.rodrigues_leticia.lab3.ui.theme.Lab3Theme

// Each row has an author and a message body.
data class Message(val author: String, val body: String)

private val sampleMessages =
    listOf(
        Message("Leticia", "Hi everyone!!!"),
        Message("Beatriz", "How are you?"),
        Message("Ricardo", "I'm tired!!!"),
        Message("Jenifa", "What?? you just for 12 hours"),
        Message("Ricardo", "Yeaaa but i worked a 12 hours shift!"),
        Message("Leticia", "Guys FOCUS last week of school"),
        Message("Beatriz", "I knowww, I'm so overwhelmed :("),
        Message("Jenifa", "Lets stay on the library to study tmo?"),
        Message("Leticia", "Sounds good to meee"),
        Message("Ricardo", "Then we can go grab something to eat after :D"),
        Message("Beatriz", "Omg please I vote for tacos"),
        Message("Jenifa", "I want sushi tho"),
        Message("Leticia", "I also want sushi"),
    )


private val ChatBackground = Color(0xFFFFFBF1)

@Composable
fun MessageScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(ChatBackground)
            .systemBarsPadding(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(sampleMessages) { message ->
            MessageItem(message)
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.catavatar),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Magenta, CircleShape)
        )
        Spacer(Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = message.author,
                color = Color(0xFF625C70),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFFF5E1BE),
                shadowElevation = 1.dp
            ) {
                Text(
                    text = message.body,
                    color = Color(0xFF242124),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 891)
@Composable
fun MessageScreenPreview() {
    Lab3Theme {
        MessageScreen()
    }
}

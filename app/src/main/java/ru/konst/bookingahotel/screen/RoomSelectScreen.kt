package ru.konst.bookingahotel.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.konst.bookingahotel.R
import ru.konst.bookingahotel.ui.theme.Blue
import ru.konst.bookingahotel.ui.theme.BookingAHotelTheme
import ru.konst.bookingahotel.ui.theme.BookingAHotelTypography

@Composable
fun RoomSelectScreen() {
    val modifier = Modifier
    val tags = listOf("Все включено", "Кондиционер")
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ImagePreview(modifier = modifier, image = painterResource(id = R.drawable.ic_launcher_foreground))
        NameHotel(modifier = modifier, name = "Стандартный с видом на бассейн или сад")
        TagsRoom(modifier = modifier, tags = tags)
        AboutRoomButton(modifier = modifier)
        PriceHotel(modifier = modifier, price = "186 600 ₽", service = "за 7 ночей с перелётом")
        ButtonSelectionRum(modifier = modifier, text = "Выбрать номер")
    }
}

@Composable
fun TagsRoom(modifier: Modifier, tags: List<String>) {
    LazyRow(modifier = modifier.padding(8.dp).height(33.dp)) {
        items(tags.size) {
            Tag(modifier = modifier, tag = tags[it])
        }
    }
}

@Composable
fun AboutRoomButton(modifier: Modifier) {
    Surface(
        modifier = modifier
            .padding(top = 8.dp)
    ) {
        Row {
            Text(
                text = "Подробнее о номере",
                style = BookingAHotelTypography.bodyLarge,
                color = Blue
            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_right_24),
                contentDescription = "arrow",
                tint = Blue
            )
        }
    }
}

@Preview
@Composable
fun RoomSelectPreview() {
    BookingAHotelTheme {
        Column(Modifier.fillMaxSize()) {
            RoomSelectScreen()
        }
    }
}
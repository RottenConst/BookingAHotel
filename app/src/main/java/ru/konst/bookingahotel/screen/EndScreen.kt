package ru.konst.bookingahotel.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.konst.bookingahotel.R
import ru.konst.bookingahotel.ui.theme.BookingAHotelTheme
import ru.konst.bookingahotel.ui.theme.BookingAHotelTypography

@Composable
fun EndScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier.padding(50.dp).height(44.dp).width(44.dp),
            painter = painterResource(id = R.drawable.party_popper),
            contentDescription = "party pooper image"
        )
        Text(
            modifier = modifier.fillMaxWidth().padding(bottom = 10.dp),
            text = "Ваш заказ принят в работу",
            textAlign = TextAlign.Center,
            style = BookingAHotelTypography.labelLarge
        )
        Text(
            modifier = modifier.padding(top = 10.dp),
            text = "Подтверждение заказа №104893 может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
            textAlign = TextAlign.Center,
            style = BookingAHotelTypography.bodyLarge
        )
    }
}


@Preview
@Composable
fun EndScreenPreview() {
    val modifier = Modifier
    BookingAHotelTheme {
        EndScreen(modifier)
    }
}
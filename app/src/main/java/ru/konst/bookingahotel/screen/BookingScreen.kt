package ru.konst.bookingahotel.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.konst.bookingahotel.R
import ru.konst.bookingahotel.ui.theme.BookingAHotelTheme
import ru.konst.bookingahotel.ui.theme.BookingAHotelTypography
import ru.konst.bookingahotel.ui.theme.GreyText

@Composable
fun BookingScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        RatingHotel(modifier = modifier, rating = 5, ratingName = "Превосходно")
        NameHotel(modifier = modifier, name = "Steigenberger Makadi")
        TagsHotel(modifier = modifier, tags = "Madinat Makadi, Safaga Road, Makadi Bay, Египет")
    }
}

@Composable
fun InfoOfBooking(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
            Info(modifier = modifier, title = "Вылет из", info = "Санкт-Петербург")
            Info(modifier = modifier, title = "Страна, город", info = "Египет, Хургада")
            Info(modifier = modifier, title = "Даты", info = "19.09.2023 – 27.09.2023")
            Info(modifier = modifier, title = "Кол-во ночей", info = "7 ночей")
            Info(modifier = modifier, title = "Отель", info = "Steigenberger Makadi")
            Info(modifier = modifier, title = "Номер", info = "Стандартный с видом на бассейн или сад")
            Info(modifier = modifier, title = "Питание", info = "Все включено")
        }
    }
}
@Composable
fun Info(modifier: Modifier, title: String, info: String) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = modifier.width(140.dp),
            text = title,
            style = BookingAHotelTypography.bodyLarge,
            color = GreyText
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            text = info,
            style = BookingAHotelTypography.bodyLarge,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun BuyerInformation(modifier: Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
            Text(
                modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "Информация о покупателе",
                style = BookingAHotelTypography.labelLarge
            )
            InfoBuyer(modifier = modifier, title = "Номер телефона", info = "+7 (951) 555-99-00")
            InfoBuyer(modifier = modifier, title = "Почта", info = "examplemail.000@mail.ru")
            Text(
                modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                text = "Эти данные никому не передаются. После оплаты мы вышли чек на указанный вами номер и почту",
                style = BookingAHotelTypography.labelSmall,
                color = GreyText
            )
        }
    }
}

@Composable
fun InfoBuyer(modifier: Modifier, title: String, info: String) {
    Box(modifier = modifier.padding(8.dp)) {
        Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
            Text(
                text = title,
                style = BookingAHotelTypography.displaySmall,
                color = GreyText
            )
            Text(
                text = info,
                style = BookingAHotelTypography.bodyLarge
            )
        }

    }
}

@Composable
fun TouristInfo(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = modifier.padding(8.dp)
    ) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        expanded = !expanded
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = modifier,
                    text = "Второй турист"
                )
                if (expanded) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_top),
                        contentDescription = "arrow"
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_bottom),
                        contentDescription = "arrow"
                    )
                }
            }
            if (expanded) {
                Box(modifier = modifier.padding(8.dp)) {
                    TextFieldInfoTourist(modifier = modifier, label = "Имя")
                    TextFieldInfoTourist(modifier = modifier, label = "Фамилия")
                    TextFieldInfoTourist(modifier = modifier, label = "Дата рождения")
                    TextFieldInfoTourist(modifier = modifier, label = "Гражданство")
                    TextFieldInfoTourist(modifier = modifier, label = "Номер загранпаспорта")
                    TextFieldInfoTourist(modifier = modifier, label = "Срок действия загранпаспорта")
                }
            }
        }
    }
}

@Composable
fun AddTourist(modifier: Modifier) {
    Box(
        modifier = modifier.padding(8.dp)
    ) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = modifier,
                    text = "Добавить туриста"
                )
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "arrow"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldInfoTourist(modifier: Modifier, label: String) {
    var name by remember { mutableStateOf("") }
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = name,
        onValueChange = { name = it },
        label = { Text(text = label) }
    )
}

@Composable
fun PayInfo(modifier: Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
            PaymentInfo(modifier = modifier, title = "Тур", pay = "186 600 ₽")
            PaymentInfo(modifier = modifier, title = "Топливный сбор", pay = "9 300 ₽")
            PaymentInfo(modifier = modifier, title = "Сервисный сбор", pay = "2 136 ₽")
            PaymentInfoAll(modifier = modifier, title = "К оплате", pay = "198 036 ₽")
        }
    }
}

@Composable
fun PaymentInfo(modifier: Modifier, title: String, pay: String) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = modifier.width(140.dp),
            text = title,
            style = BookingAHotelTypography.bodyLarge,
            color = GreyText
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            text = pay,
            style = BookingAHotelTypography.bodyLarge,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun PaymentInfoAll(modifier: Modifier, title: String, pay: String) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = modifier.width(140.dp),
            text = title,
            style = BookingAHotelTypography.bodyLarge,
            color = GreyText
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            text = pay,
            color = Color.Blue,
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
fun BookingScreenPreview() {
    val modifier = Modifier
    val state = rememberScrollState()
    BookingAHotelTheme {
        Column(modifier = modifier.verticalScroll(state)) {
            BookingScreen(modifier = modifier)
            InfoOfBooking(modifier = modifier)
            BuyerInformation(modifier = modifier)
            TouristInfo(modifier = modifier)
            AddTourist(modifier = modifier)
            PayInfo(modifier = modifier)
            ButtonSelectionRum(modifier = modifier, text = "Оплатить 198 036 ₽")
        }

    }
}
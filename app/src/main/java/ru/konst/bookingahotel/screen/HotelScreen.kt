package ru.konst.bookingahotel.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.konst.bookingahotel.R
import ru.konst.bookingahotel.ui.theme.Blue
import ru.konst.bookingahotel.ui.theme.BookingAHotelTheme
import ru.konst.bookingahotel.ui.theme.BookingAHotelTypography
import ru.konst.bookingahotel.ui.theme.GreyText
import ru.konst.bookingahotel.ui.theme.Yellow
import ru.konst.bookingahotel.ui.theme.YellowText


@Composable
fun HotelPreview() {
    val modifier = Modifier

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ImagePreview(
            modifier = modifier,
            image = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        RatingHotel(modifier = modifier, rating = 5, ratingName = "Превосходно")
        NameHotel(modifier = modifier, name = "Steigenberger Makadi")
        TagsHotel(modifier = modifier, tags = "Madinat Makadi, Safaga Road, Makadi Bay, Египет")
        PriceHotel(modifier = modifier, price = "от 134 673 ₽", service = "за тур с перелётом")
    }
}

@Composable
fun ImagePreview(modifier: Modifier, image: Painter) {
    Surface(
        modifier = modifier
            .height(257.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth(),
            painter = image,
            contentDescription = "TestImage",
            alignment = Alignment.TopCenter
        )
    }
}

@Composable
fun RatingHotel(modifier: Modifier, rating: Int, ratingName: String) {
    Surface(
        modifier = modifier
            .padding(top = 8.dp),
    ) {
        Row(
            modifier = modifier
                .height(29.dp),
//                .width(149.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = modifier
                    .width(15.dp)
                    .height(15.dp),
                painter = painterResource(id = R.drawable.icon_star),
                contentDescription = "Star",
                tint = Yellow
            )
            Text(
                text = "$rating $ratingName",
                style = BookingAHotelTypography.bodyLarge,
                textAlign = TextAlign.Center,
                maxLines = 1,
                color = YellowText
            )
        }

    }
}

@Composable
fun NameHotel(modifier: Modifier, name: String) {
    Text(
        modifier = modifier.padding(top = 8.dp),
        text = name,
        style = BookingAHotelTypography.labelLarge,
    )
}

@Composable
fun TagsHotel(modifier: Modifier, tags: String) {
    Text(
        modifier = modifier.padding(vertical = 8.dp),
        text = tags,
        style = BookingAHotelTypography.labelSmall,
        color = Blue
    )
}

@Composable
fun PriceHotel(modifier: Modifier, price: String, service: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    )
    {
        Text(
            text = price,
            style = BookingAHotelTypography.titleLarge
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .height(36.dp)
                .padding(start = 8.dp, end = 8.dp, top = 8.dp),
            text = service,
            style = BookingAHotelTypography.displayMedium,
            color = GreyText,
        )
    }
}

@Composable
fun HotelInfo() {
    val tags = listOf("3-я линия", "30 км до аэропорта", "Платный Wi-Fi в фойе", "1 км до пляжа")
    val modifier = Modifier
    Column(modifier = modifier.padding(8.dp)) {
        AboutHotelTitle(modifier = modifier)
        InfoTags(modifier = modifier, tags = tags)
        AboutHotelText(
            modifier = modifier,
            text = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!"
        )
        AdditionalFunction(modifier = modifier)
        ButtonSelectionRum(modifier = modifier, text = "К выбору номера")
    }
}

@Composable
fun AboutHotelTitle(modifier: Modifier) {
    Text(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        text = "Об отеле",
        style = BookingAHotelTypography.labelLarge
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InfoTags(modifier: Modifier, tags: List<String>) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(66.dp)
    ) {
        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Adaptive(32.dp),
            horizontalItemSpacing = 8.dp,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            items(tags.size) {
                Tag(modifier, tags[it])
            }
        }
    }
}

@Composable
fun Tag(modifier: Modifier, tag: String) {
    Box(modifier = modifier.padding(4.dp)) {
        Text(
            text = tag,
            style = BookingAHotelTypography.bodyLarge,
            textAlign = TextAlign.Center,
            color = GreyText
        )
    }
}


@Composable
fun AboutHotelText(modifier: Modifier, text: String) {
    Text(
        modifier = modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 8.dp),
        text = text,
        style = BookingAHotelTypography.displayMedium
    )
}

@Composable
fun AdditionalFunction(modifier: Modifier) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(184.dp)
    ) {
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonSetting(modifier = modifier, icon = painterResource(id = R.drawable.emoji_happy), name = "Удобства", subName = "Самое необходимое")
            Divider(
                modifier
                    .width(275.dp)
                    .padding(start = 32.dp, top = 4.dp, bottom = 4.dp),thickness = 1.dp, color = Color.LightGray)
            ButtonSetting(modifier = modifier, icon = painterResource(id = R.drawable.tick_square), name = "Что включено", subName = "Самое необходимое")
            Divider(
                modifier
                    .width(275.dp)
                    .padding(start = 32.dp, top = 4.dp, bottom = 4.dp),thickness = 1.dp, color = Color.LightGray)
            ButtonSetting(modifier = modifier, icon = painterResource(id = R.drawable.close_square), name = "Что не включено", subName = "Самое необходимое")
        }
    }
}

@Composable
fun ButtonSetting(modifier: Modifier, icon: Painter, name: String, subName: String) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(38.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = icon,
                    contentDescription = "icon",
                )
                NameButton(modifier = modifier, name = name, subName = subName)
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.arrow_right_24),
            contentDescription = "arrow"
        )
    }
}

@Composable
fun NameButton(modifier: Modifier, name: String, subName: String) {
    Column(modifier = modifier.padding(horizontal = 8.dp)) {
        Text(
            text = name,
            style = BookingAHotelTypography.bodyLarge
        )
        Text(
            text = subName,
            style = BookingAHotelTypography.labelSmall,
            color = GreyText
        )
    }
}

@Composable
fun ButtonSelectionRum(modifier: Modifier, text: String) {
    Button(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = text,
            style = BookingAHotelTypography.bodyLarge
        )
    }
}


@Preview
@Composable
fun HotelScreenPreview() {
    BookingAHotelTheme {
        val state = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(state)) {
            HotelPreview()
            HotelInfo()
        }

    }
}
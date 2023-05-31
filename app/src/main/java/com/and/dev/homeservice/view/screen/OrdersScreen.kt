package com.and.dev.homeservice.view.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.and.dev.homeservice.view.items.OrderDetailsItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


data class TabRowItem(
    val title: String,
    val screen: @Composable () -> Unit,
)

val tabRowItems = listOf(
    TabRowItem(
        title = "Pending",
        screen = { PendingOrder() },
    ), TabRowItem(
        title = "Underway",
        screen = { UnderwayOrder() },
    ), TabRowItem(
        title = "Completed ",
        screen = { CompletedOrder() },
    )
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OrdersScreen() {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()


    Column(Modifier.fillMaxSize()) {


        Box(
            Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xff346EDF), Color(0xff6FC8FB)),
                        startX = 0f,
                        endX = Float.POSITIVE_INFINITY
                    ),
                ),
        ) {
            Text(
                text = "Order Details", style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Cursive,
                    textAlign = TextAlign.Center,
                    color = Color.White
                ), modifier = Modifier.align(alignment = Alignment.Center)
            )


        }

        TabRow(
            backgroundColor = Color.White, contentColor = Color(0xFF636363),

            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = Color(0xFF266CE2)
                )
            },
        ) {
            tabRowItems.forEachIndexed { index, item ->
                Tab(selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = {
                        Text(
                            text = item.title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Start
                            )
                        )
                    })
            }
        }
        HorizontalPager(
            count = tabRowItems.size,
            state = pagerState,
        ) {
            tabRowItems[pagerState.currentPage].screen()
        }
    }
}

@Composable
fun PendingOrder() {

    OrderDetailsItem()
}

@Composable
fun CompletedOrder() {
    Text(text = "13333222211")

}

@Composable
fun UnderwayOrder() {
    Text(text = "113331")

}


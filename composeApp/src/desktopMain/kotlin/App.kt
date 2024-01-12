import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.NavigationRail
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.saveable.rememberSaveable
@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        WellnessScreen()
        //WellnessTaskItem("Test", {})
    }
}

data class WellnessTask(val id: Int, val label: String)

fun getWellnessTasks() = List(30) {i -> WellnessTask(i, "Task #$i")}

@Composable

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f).padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}
@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    WaterCounter(modifier, count, { count++ }, {count = 0})
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier, count: Int, onIncrement: () -> Unit, onClear: () -> Unit) {
    Column(modifier = modifier.padding(16.dp)) {
        //var count by rememberSaveable {mutableStateOf(0)}
        if (count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }
            if (showTask) {
//                WellnessTaskItem(
//                    onClose = {showTask = false},
//                    taskName = "Have you taken your 15 minute walk today?"
//                )
            }
            Text(text = "You have $count glasses")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = onIncrement,
                enabled = count < 10,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Add")
            }
            Button(
                onClick = onClear,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Clear")
            }
        }
    }
}
//
//data class BodyData(val text: String, val drawable: String)
//
//
//@Composable
//fun MySootheAppLandscape() {
//    Surface(color = MaterialTheme.colors.background) {
//        Row {
//            SootheNavigationRail()
//            HomeScreen()
//        }
//    }
//}
//
//@Composable
//fun SootheNavigationRail(modifier: Modifier = Modifier) {
//    NavigationRail(
//        modifier = modifier.padding(start = 8.dp, end = 8.dp),
//        contentColor = MaterialTheme.colors.background
//    ) {
//        Column(
//            modifier = modifier.fillMaxHeight(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            NavigationRailItem(
//                icon = {
//                    Icon(
//                        imageVector = Icons.Default.Spa,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    Text("Sample Text")
//                },
//                selected = true,
//                onClick = {}
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            NavigationRailItem(
//                icon = {
//                    Icon(
//                        imageVector = Icons.Default.AccountCircle,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    Text("Sample Text")
//                },
//                selected = false,
//                onClick = {}
//            )
//        }
//    }
//}
//
//@Composable
//fun MySootheAppPortrait() {
//    Scaffold(
//        bottomBar = {SootheBottomNavigation()}
//    ) {
//        padding -> HomeScreen(Modifier.padding(padding))
//    }
//}
//
//@Composable
//fun SootheBottomNavigation(modifier: Modifier = Modifier) {
//    NavigationBar(modifier = modifier) {
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Spa,
//                    contentDescription = null
//                )
//            },
//            label = {
//                Text("Sample Text")
//            },
//            selected = true,
//            onClick = {}
//        )
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.AccountCircle,
//                    contentDescription = null
//                )
//            },
//            label = {
//                Text("Sample Text")
//            },
//            selected = false,
//            onClick = {}
//        )
//    }
//}
//
//@Composable
//fun HomeScreen(modifier: Modifier = Modifier) {
//    Column(modifier) {
//        Spacer(Modifier.height(16.dp))
//        SearchBar(Modifier.padding(horizontal = 16.dp))
//        HomeSection(title = "Sample Title") {
//            AlignYourBodyRow()
//        }
//        HomeSection(title = "Sample Title") {
//            FavoriteCollectionGrid()
//        }
//        Spacer(Modifier.height(16.dp))
//    }
//}
//
//@Composable
//fun HomeSection(
//    title: String,
//    modifier: Modifier = Modifier,
//    content: @Composable () -> Unit
//) {
//    Column(modifier.verticalScroll(rememberScrollState())) {
//        Text(
//            text = title,
//            style = MaterialTheme.typography.h6,
//            modifier = Modifier
//                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
//                .padding(horizontal = 16.dp)
//        )
//        content()
//    }
//}
//
//@Composable
//fun FavoriteCollectionGrid(modifier: Modifier = Modifier) {
//    val testCollection = listOf(
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//    )
//
//    LazyHorizontalGrid(
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        rows = GridCells.Fixed(2),
//        userScrollEnabled = true,
//        modifier = modifier.height(168.dp)
//    ) {
//        items(testCollection) {
//            item -> FavoriteCollectionCard(text = item.text, image = item.drawable)
//        }
//    }
//}
//
//@Composable
//fun AlignYourBodyRow(modifier: Modifier = Modifier) {
//    val testList = listOf(
//        BodyData("Sample Text", "compose-multiplatform.xml"),
//        BodyData("Sample Text", "compose-multiplatform.xml")
//    )
//
//    LazyRow(
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        userScrollEnabled = true,
//        modifier = modifier
//    ) {
//        items(testList) {
//            item -> AlignYourBodyElement(drawable = item.drawable, text = item.text)
//        }
//    }
//}
//
//@Composable
//fun FavoriteCollectionCard(
//    modifier: Modifier = Modifier,
//    text: String,
//    image: String
//) {
//    Surface(
//        shape = MaterialTheme.shapes.medium,
//        modifier = modifier
//    ) {
//        Row(
//            modifier = Modifier.width(255.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(image),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.size(80.dp)
//            )
//            Text(
//                text = text,
//                style = MaterialTheme.typography.subtitle1,
//                modifier = Modifier.padding(horizontal = 16.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun AlignYourBodyElement(
//    modifier: Modifier = Modifier,
//    drawable: String,
//    text: String,
//) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//    ) {
//        Image(
//            painter = painterResource(drawable),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.size(88.dp).clip(CircleShape)
//        )
//        Text(text = text)
//    }
//}
//
//@Composable
//fun SearchBar(modifier: Modifier = Modifier) {
//    TextField(
//        value = "",
//        onValueChange = {},
//        leadingIcon = {
//            Icon(imageVector = Icons.Default.Search, contentDescription = null)
//        },
//        colors = TextFieldDefaults.textFieldColors(
//            unfocusedIndicatorColor = MaterialTheme.colors.surface,
//            focusedIndicatorColor = MaterialTheme.colors.surface
//        ),
//        placeholder = {Text("Search")},
//        modifier = modifier
//            .fillMaxWidth()
//            .heightIn(min = 56.dp)
//    )
//}
//    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
//
//    Surface(modifier) {
//        if (shouldShowOnboarding) {
//            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
//        } else {
//            Greetings()
//        }
//    }

//

//    Surface(modifier = Modifier.fillMaxSize()) {
//        MessageCard(Message(author = "Sample Author", body = "Sample Body"))
//    }

//    Conversation(
//        listOf(
//            Message("Author2", "Body2"),
//            Message("Author3", "Body3")
//        )
//    )

//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        val greeting = remember { Greeting().greet() }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource("compose-multiplatform.xml"), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun Greetings(
//    modifier: Modifier = Modifier,
//    names: List<String> = List(1000) {"$it"}
//) {
//    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
//        items(items = names) {
//            name -> Greeting(name = name)
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    var expanded by rememberSaveable {mutableStateOf(false)}
//
//    val extraPadding by animateDpAsState(
//        if (expanded) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )
//
//    Surface(
//        color = MaterialTheme.colors.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row {
//            Column(modifier = modifier.padding(bottom = extraPadding.coerceAtLeast(0.dp)).weight(1f)) {
//                Text("Hello")
//                Text(name)
//
//                if (expanded) {
//                    Text("Hello")
//                }
//            }
//            IconButton(onClick = {expanded = !expanded}) {
//                Icon(
//                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
//                    contentDescription = null
//                )
//            }
//            //ElevatedButton(onClick = {expanded = !expanded}) {Text(if (expanded) "Show less" else "Show more")}
//        }
//    }
//}
//
//@Composable
//fun OnboardingScreen(
//    modifier: Modifier = Modifier,
//    onContinueClicked: () -> Unit
//) {
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Welcome")
//        Button(
//            onClick = onContinueClicked,
//            modifier = Modifier.padding(vertical = 24.dp)
//        ) {Text("Continue")}
//    }
//}

//data class Message(val author: String, val body: String)
//
//@Composable
//fun Conversation(messages: List<Message>) {
//    LazyColumn {
//        items(messages) {
//            message -> MessageCard(message)
//        }
//    }
//}
//
//@Composable
//fun MessageCard(msg: Message) {
//    Row(modifier = Modifier.padding(all = 8.dp)) {
//        Image(
//            painter = painterResource("profile_picture.png"),
//            null,
//            modifier = Modifier.size(40.dp).clip(CircleShape).border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//
//        var isExpanded by remember { mutableStateOf(false) }
//
//        val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,)
//
//        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
//            Text(
//                text = msg.author,
//                color = MaterialTheme.colors.secondary
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Surface(
//                shape = MaterialTheme.shapes.medium,
//                color = surfaceColor,
//                elevation = 1.dp,
//                modifier = Modifier.animateContentSize().padding(1.dp)
//            ) {
//                Text(
//                    text = msg.body,
//                    modifier = Modifier.padding(all = 4.dp),
//                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                    style = MaterialTheme.typography.body2
//                )
//            }
//        }
//    }
//}

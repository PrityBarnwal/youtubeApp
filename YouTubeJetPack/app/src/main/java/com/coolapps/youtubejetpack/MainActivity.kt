package com.coolapps.youtubejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolapps.youtubejetpack.model.YouTubeDataProvider
import com.coolapps.youtubejetpack.ui.theme.YouTubeJetPackTheme
import com.coolapps.youtubejetpack.view.YouTubeChip
import com.coolapps.youtubejetpack.view.YouTubeListItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouTubeJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    YouTubeJetPackTheme()

                    }
            }
        }
    }
}
@Preview
@Composable
fun YouTubeJetPackTheme(){
    Scaffold (
        topBar ={
            TopAppBar(
                title={
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                       Icon(painter = painterResource(id = R.drawable.ic_youtube),
                           contentDescription = "YouTube Image",
                       tint = Color.Red,
                           modifier = Modifier
                               .padding(end = 5.dp)
                               .size(40.dp)
                       )
                        Text(text = "youTube",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif)
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = if (MaterialTheme.colors.isLight) 0.dp else 8.dp,
                actions = {
                    Icon(imageVector = Icons.Outlined.Tv, contentDescription ="Videos Icons",
                    modifier = Modifier.padding(horizontal = 8.dp))
                    Icon(imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notifications Icon",
                    modifier = Modifier.padding(horizontal = 8.dp))
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search Icons",
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Image(painter = painterResource(id = R.drawable.makeiteasy),
                        contentDescription = "Profile Image",
                    modifier = Modifier
                        .padding(
                            vertical = 4.dp,
                            horizontal = 4.dp
                        )
                        .size(30.dp)
                        .clip(CircleShape))
                }
            )
        },
        content = {
            Surface(elevation = if (MaterialTheme.colors.isLight) 0.dp else 8.dp) {
                YouTubeContent()
            }
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                BottomNavigationItem(selected = true
                    , onClick = { /*TODO*/ },
                alwaysShowLabel = true,
                icon = {
                    Icon(painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "Home")
                },
                label ={
                    Text(text = "Home",fontSize = 9.sp)
                })
                BottomNavigationItem(selected = false, onClick = { /*TODO*/ },
                alwaysShowLabel = true,
                icon = {
                    Icon(painter = painterResource(id = R.drawable.ic_short_text),
                        contentDescription = "Shorts")
                },
                    label = {
                        Text(text = "Shorts",fontSize = 9.sp)
                    }
                )
                BottomNavigationItem(selected = false,
                    onClick = { /*TODO*/ },
                alwaysShowLabel = false,
                icon =  {
                    Icon(
                        Icons.Outlined.AddCircleOutline,
                        contentDescription = "Shorts",
                        modifier = Modifier.size(45.dp)
                    )
                })
                BottomNavigationItem(selected = false,
                    onClick = { /*TODO*/ },
                alwaysShowLabel = true,
                icon = {
                    Icon(painter = painterResource(id = R.drawable.ic_subscriptions),
                     contentDescription = "Subscription")
                },
                label = {
                    Text(text = "Subscription",fontSize = 9.sp)
                })
                BottomNavigationItem(selected = false,
                    onClick = { /*TODO*/ },
                alwaysShowLabel = true,
                 icon = {
                     Icon(painter = painterResource(id = R.drawable.ic_baseline_video_library_24),
                         contentDescription = "Library")
                },
                label = {
                    Text(text = "Library",fontSize = 9.sp)
                })
            }

        }

            )
}

@Composable
fun YouTubeContent() {
    val youTubes = remember{
        YouTubeDataProvider.youTubeList.filter { it.youTubeImageId >0}}
        Column {
            Divider()
            LazyRow(contentPadding = PaddingValues(horizontal = 12.dp),
            modifier = Modifier.padding(vertical = 8.dp))
            {
                items(
                    items = youTubes,
                    itemContent = {
                        YouTubeChip(selected = it.id==2,
                            text = it.author,
                        modifier = Modifier.padding(horizontal = 4.dp))
                    }
                    
                )
                
            }
            LazyColumn{
                items(
                    items = youTubes,
                    itemContent = {
                        item -> YouTubeListItem(item = item)
                    }
                )
            }
            
        }
    }



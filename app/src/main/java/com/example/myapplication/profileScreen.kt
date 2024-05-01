package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column (modifier = Modifier
        .fillMaxSize()){
        // top bar with icons

        Topbar(name = "Motherson_Official",
            modifier = Modifier
                .padding(50.dp))
        Spacer(modifier = Modifier.height(10.dp))
        profileSection(modifier = Modifier
            .padding(10.dp))
        Spacer(modifier = Modifier.height(20.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        HighlightSection(highlights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.youtube_logo),
                text = "Youtube"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.reddit_logo),
                text = "Reddit"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.tiktok_logo),
                text = "Tiktok"
            ),
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(imageWithTexts = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.grid),
                text =  "Posts"
            ),

            ImageWithText(
                image = painterResource(id = R.drawable.reels),
                text =  "Reels"
            ),

            ImageWithText(
                image = painterResource(id = R.drawable.igtv),
                text =  "IGTV"
            ),

            ImageWithText(
                image = painterResource(id = R.drawable.profile),
                text =  "Mentions"
            )
        )) {
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(posts = listOf(
                painterResource(id = R.drawable.black),
                painterResource(id = R.drawable.black),
                painterResource(id = R.drawable.black),
                painterResource(id = R.drawable.black),
                painterResource(id = R.drawable.black)
            ),
            modifier = Modifier.fillMaxWidth())
        }
    }

}

@Composable
fun Topbar(
    name : String,
    modifier : Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                )

        Text(text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)

        Icon(
            painterResource(id = R.drawable.bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp))

        Icon(
            painterResource(id = R.drawable.dots),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Composable
fun profileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth())
    {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                // this will contain the round image and the profile stats
                .fillMaxWidth()
                .padding(horizontal = 20.dp) //padding before the image and after the stats
        ){
            RoundImage(
                image = painterResource(id = R.drawable.black),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatsSection(modifier = Modifier.weight(7f))

        }
        ProfileDescriptiion(
            displayName = "OverAcheiver",
            description = "The next time you're cruising down the highway, blasting your tunes, just remember: it's probably me, Motherson, keeping the whole operation running smoothly. You're welcome!",
            url = "www.mothersongroup.com",
            followedBy = listOf("Ford Motors", "Mahindra Group"),
            otherCount = 19
        )
    }
}

@Composable
fun RoundImage(
    image : Painter,
    modifier: Modifier = Modifier
){
    Image(painter = image, // the image that we pass as an arguement in the above composable
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape))
}

@Composable
fun StatsSection(
    // modifier is needed to that we can pass the weight to this composable
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        IndividualStat(stat = "99", title = "Posts")
        IndividualStat(stat = "190k", title = "Followers")
        IndividualStat(stat = "234", title = "Following")
    }

}

@Composable
fun IndividualStat(
    stat : String,
    title : String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = stat,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title,
            fontSize = 15.sp)

    }

}

//profiledescription
@Composable
fun ProfileDescriptiion (
    displayName : String,
    description : String,
    url : String,
    followedBy : List<String>,
    otherCount : Int
) {
    val letterSpacing = 0.5.sp //because we want to keep it
    val lineHeight = 20.sp  //constant across the description

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp))
    {
        Text(text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
            )

        Text(text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 13.sp
            )

        Text(text = url,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3F51B5),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
            )

        if(followedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(  //custom style for bold texts in the followed by section
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by ")

                followedBy.forEachIndexed { index, name ->  //append "," after every name
                    pushStyle(boldStyle)                    //up until the last text, after which
                    append(name)                               // append an "and" and enter the othersCount eg Followed by ABC, BCD and 4 others
                    pop()
                    if(index < followedBy.size - 1){
                        append(", ")
                    }
                }
                if(otherCount > 2){         // appending the othes count example " ------ and 13 others"
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight

            )
        }
    }

}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    // here we will have the action buttons
    val minWidth = 95.dp
    val height = 30.dp

    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "E-Mail",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = 50.dp)
                .height(height)
        )
    }

}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text : String? = null,
    icon : ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if( text != null){
            Text(text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        if( icon != null){
            Icon(imageVector = icon,
                contentDescription = null,
                tint = Color.Black)
        }
    }
}

@Composable
fun HighlightSection(
    /* we need an image and a text below it so we create a data class
       where we will define the image and the text
       and pass that as a list to the parameter in the above composable
       we could have also made a composable with an image and a row in it
       but since story highlight section is dynamic i.e not sure about the number of highlights
       so we make a data class and within the lazyRow component which
       only compose and render the items that are currently visible on the screen. */
    modifier: Modifier = Modifier,
    highlights : List<ImageWithText>
) {
    LazyRow(modifier = modifier) { // the modifier passed here is the modifier that is passed in the highlights section, the value for which is given in the profile screen
        items(highlights.size) /* consists of number of items to be shown*/
        {
            // defined here is how the individual item will look like
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
                    .clickable { }
            ){
                RoundImage(image = highlights[it].image,
                    modifier = Modifier.size(65.dp)
                )
                Text(text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                    )
            }
        }
    }

}

@Composable
fun PostTabView(
    modifier : Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected : (selectedIndex : Int) -> Unit // this is a function which will give us the selected index
    // so when ever we select a tab, this function will be triggered and we get the selcted index in our root composable
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    // now we want to create each and every tab and do the following when each tab is selected.
    //so instead of creating each and every tab we use a list of imagewithtexts and create a for loop which creates the individual tabs for us


    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = modifier.background(Color.Transparent)
    ) {
        imageWithTexts.forEachIndexed{index, item ->
        Tab(selected = selectedTabIndex == index, // this tab is selected if the selectedTabIndex is = index
            selectedContentColor = Color.Black,
            unselectedContentColor = inactiveColor,
            onClick = {
                selectedTabIndex = index
                onTabSelected(index)
            }) {

            Icon(painter = item.image ,  // the image and text that we will pass in the list as a parameter in the above composable
                contentDescription = item.text,
                tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)
            )
        }
    }
}
}

@Composable
fun PostSection(
    posts : List<Painter>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid( columns =GridCells.Fixed(3),
        modifier = modifier) {
        items(posts.size){
            Image(painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 2.dp,
                        color = Color.White
                    ))
        }
    }
}







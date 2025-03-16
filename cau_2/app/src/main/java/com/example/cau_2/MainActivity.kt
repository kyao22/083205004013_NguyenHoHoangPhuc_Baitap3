package com.example.cau_2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

val righteousFont = FontFamily(Font(R.font.righteous))
val poppinsMediumFont = FontFamily(Font(R.font.poppins_medium))
val poppinsRegularFont = FontFamily(Font(R.font.poppins_regular))

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("SFirst") { StartedFirst(navController) }
        composable("SSecond") { StartedSecond(navController) }
        composable("SThird") { StartedThird(navController) }
        composable("main") { MainScreen() }

    }
}


@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(2500)
        navController.navigate("SFirst") {
            popUpTo("splash") { inclusive = true }
        }

    }

    Column(
        modifier = Modifier.fillMaxSize().scale(1.5f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_pic),
            contentDescription = "Splash_pic",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(102.dp, 70.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "UTH SmartTasks",
            fontFamily = righteousFont,
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            color = Color(0xFF006EE9)
            )
    }
}

@Composable
fun StartedFirst(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.group_fs),
                contentDescription = "Group_FS",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(58.dp, 14.dp)
            )
            Text(
                text = "skip",
                fontFamily = poppinsMediumFont,
                fontSize = 16.5.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.5.sp,
                color = Color(0xFF006EE9),
                modifier = Modifier.clickable{navController.navigate("main"){
                    popUpTo(0) { inclusive = true } }
                }
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().scale(1.25f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.started_first),
            contentDescription = "Started_first",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(319.dp, 260.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Easy Time Management",
            fontFamily = poppinsMediumFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = Color(0xFF000000)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first",
            fontFamily = poppinsRegularFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 19.6.sp,
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { navController.navigate("SSecond") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).height(48.dp)
        ) {
            Text(
                text = "Next",
                fontFamily = poppinsMediumFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 25.sp
            )
        }
    }
}


@Composable
fun StartedSecond(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.group_ss),
                contentDescription = "Group_SS",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(58.dp, 14.dp)
            )
            Text(
                text = "skip",
                fontFamily = poppinsMediumFont,
                fontSize = 16.5.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.5.sp,
                color = Color(0xFF006EE9),
                modifier = Modifier.clickable{navController.navigate("main"){
                    popUpTo(0) { inclusive = true } }
                }
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().scale(1.25f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.started_second),
            contentDescription = "Started_second",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(344.dp, 260.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Increase Work Effectiveness",
            fontFamily = poppinsMediumFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = Color(0xFF000000)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Time management and the determination of more important tasks will give your job statistics better and always improve",
            fontFamily = poppinsRegularFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 19.6.sp,
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
    }
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(
                onClick = { navController.navigate("SFirst") },
                modifier = Modifier.size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2196F3)),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .graphicsLayer(scaleX = 1.55f, scaleY = 1.55f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { navController.navigate("SThird") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f).height(48.dp)
            ) {
                Text(
                    text = "Next",
                    fontFamily = poppinsMediumFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 25.sp
                )
            }
        }
    }
}

@Composable
fun StartedThird(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.group_ts),
                contentDescription = "Group_TS",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(58.dp, 14.dp)
            )
            Text(
                text = "skip",
                fontFamily = poppinsMediumFont,
                fontSize = 16.5.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.5.sp,
                color = Color(0xFF006EE9),
                modifier = Modifier.clickable{navController.navigate("main"){
                    popUpTo(0) { inclusive = true } }
                }
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().scale(1.25f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.started_third),
            contentDescription = "Started_Third",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(276.dp, 260.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Reminder Notification",
            fontFamily = poppinsMediumFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = Color(0xFF000000)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
            fontFamily = poppinsRegularFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 19.6.sp,
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
    }
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(
                onClick = { navController.navigate("SSecond") },
                modifier = Modifier.size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2196F3)),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .graphicsLayer(scaleX = 1.55f, scaleY = 1.55f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { navController.navigate("main") {
                    popUpTo(0) { inclusive = true } } },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(1f).height(48.dp)
            ) {
                Text(
                    text = "Get Started",
                    fontFamily = poppinsMediumFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 25.sp
                )
            }
        }
    }
}


@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Ứng dụng", fontSize = 20.sp, color = Color.Black)
    }
}
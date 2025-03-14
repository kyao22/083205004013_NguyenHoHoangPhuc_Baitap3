package com.example.cau_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

val poppinsMediumFont = FontFamily(Font(R.font.poppins_medium))
val poppinsRegularFont = FontFamily(Font(R.font.poppins_regular))
val robotoBold = FontFamily(Font(R.font.roboto_bold))
val robotoSemiBold = FontFamily(Font(R.font.roboto_semi_bold))
val robotoRegular = FontFamily(Font(R.font.roboto_regular))

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Started") {
        composable("Started") { Started(navController) }
        composable("Components") { Components(navController) }
        composable("TextD") { TextDetail(navController) }
        composable("ImageD") { ImageDetail(navController) }
        composable("TextFieldD") { TextFieldDetail(navController) }
        composable("PasswordD") { PasswordDetail(navController) }
        composable("ColumnD") { ColumnDetail(navController) }
        composable("RowD") { RowDetail(navController) }
    }
}

@Composable
fun Started(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().scale(1.25f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "Jetpack_compose",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(216.dp, 233.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jetpack Compose",
            fontFamily = poppinsMediumFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            color = Color(0xFF000000)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
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
            onClick = { navController.navigate("Components")
            {popUpTo(0) { inclusive = true } } },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).height(48.dp)
        ) {
            Text(
                text = "I’m ready",
                fontFamily = robotoBold,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 25.sp
            )
        }
    }
}


@Composable
fun Components(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
            ) {
            Text(
                text = "UI Components List",
                fontFamily = robotoSemiBold,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 37.5.sp,
                color = Color(0xFF2196F3)
            )
        }

        Spacer(modifier = Modifier.height(69.dp))

        Column(
            modifier = Modifier.scale(1.25f).padding(33.dp)
        ) {
            Text(
                text = "Display",
                fontFamily = robotoSemiBold,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 22.sp,
                color = Color(0xFF333333)
            )

            Button(
                onClick = { navController.navigate("TextD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.3f),
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Text",
                        fontFamily = robotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = "Displays text",
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )
                }
            }

            Button(
                onClick = { navController.navigate("ImageD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.3f),
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Image",
                        fontFamily = robotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = "Displays an image",
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Input",
                fontFamily = robotoSemiBold,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 22.sp,
                color = Color(0xFF333333)
            )

            Button(
                onClick = { navController.navigate("TextFieldD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.3f),
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "TextField",
                        fontFamily = robotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = "Input field for text",
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )
                }
            }

            Button(
                onClick = { navController.navigate("PasswordD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.3f),
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "PasswordField",
                        fontFamily = robotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = "Input field for passwords",
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Layout",
                fontFamily = robotoSemiBold,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 22.sp,
                color = Color(0xFF333333)
            )

            Button(
                onClick = { navController.navigate("ColumnD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.3f),
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Column",
                        fontFamily = robotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = "Arranges elements vertically",
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )
                }
            }

            Button(
                onClick = { navController.navigate("RowD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.3f),
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Row",
                        fontFamily = robotoBold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )

                    Text(
                        text = "Arranges elements horizontally",
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 22.sp,
                        color = Color(0xFF333333)
                    )
                }
            }
        }
    }
}

@Composable
fun TextDetail (navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { navController.navigate("Components") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    )

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chevron_left),
                        contentDescription = "Chevron_left",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(37.5.dp, 37.5.dp)
                    )
                }

                Text(
                    text = "Text Detail",
                    fontFamily = robotoSemiBold,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 37.5.sp,
                    color = Color(0xFF2196F3),
                    modifier = Modifier.align(Alignment.TopCenter).padding(9.dp)
                )

                Column(
                    modifier = Modifier.fillMaxSize().scale(1.25f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = buildAnnotatedString {
                            append("The ")

                            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                                append("quick ")
                            }

                            withStyle(style = SpanStyle(color = Color(0xFFB87333), fontWeight = FontWeight.Bold)) {
                                append("Brown\n")
                            }

                            append("fox j u m p s ")

                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                                append("over\n")
                            }

                            append("the ")
                            
                            withStyle(
                                style = SpanStyle(
                                    fontStyle = FontStyle.Italic,
                                    textDecoration = TextDecoration.Underline
                                )
                            ) {
                                append("lazy ")
                            }

                            append("dog.")
                        },
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
    }
}


@Composable
fun ImageDetail (navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("Components") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.chevron_left),
                    contentDescription = "Chevron_left",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(37.5.dp, 37.5.dp)
                )
            }

            Text(
                text = "Image Detail",
                fontFamily = robotoSemiBold,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 37.5.sp,
                color = Color(0xFF2196F3),
                modifier = Modifier.align(Alignment.TopCenter).padding(9.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize().scale(1.25f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.jetpack_compose),
                    contentDescription = "Jetpack_compose",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(216.dp, 233.dp)
                )
            }
        }
    }
}

@Composable
fun TextFieldDetail (navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("Components") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.chevron_left),
                    contentDescription = "Chevron_left",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(37.5.dp, 37.5.dp)
                )
            }

            Text(
                text = "Text Field Detail",
                fontFamily = robotoSemiBold,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 37.5.sp,
                color = Color(0xFF2196F3),
                modifier = Modifier.align(Alignment.TopCenter).padding(9.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize().scale(1.25f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                var text by remember { mutableStateOf("") }

                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Nhập văn bản") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Nhập nội dung") }
                )

            }
        }
    }
}

@Composable
fun PasswordDetail (navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("Components") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.chevron_left),
                    contentDescription = "Chevron_left",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(37.5.dp, 37.5.dp)
                )
            }

            Text(
                text = "Password Detail",
                fontFamily = robotoSemiBold,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 37.5.sp,
                color = Color(0xFF2196F3),
                modifier = Modifier.align(Alignment.TopCenter).padding(9.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize().scale(1.25f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Mật khẩu") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ColumnDetail (navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("Components") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.chevron_left),
                    contentDescription = "Chevron_left",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(37.5.dp, 37.5.dp)
                )
            }

            Text(
                text = "Image Detail",
                fontFamily = robotoSemiBold,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 37.5.sp,
                color = Color(0xFF2196F3),
                modifier = Modifier.align(Alignment.TopCenter).padding(9.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize().scale(1.25f).padding(24.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,

            ){
                Text(text = "Trên cùng",
                    fontFamily = robotoSemiBold,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 30.sp,
                    color = Color(0xFF2196F3)
                )

                Text(text = "Ở giữa",
                    fontFamily = robotoSemiBold,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 30.sp,
                    color = Color(0xFF2196F3)
                )

                Text(text = "Dưới cùng",
                    fontFamily = robotoSemiBold,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 30.sp,
                    color = Color(0xFF2196F3)
                )

            }
        }
    }
}

@Composable
fun RowDetail (navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("Components") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.chevron_left),
                    contentDescription = "Chevron_left",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(37.5.dp, 37.5.dp)
                )
            }

            Text(
                text = "Image Detail",
                fontFamily = robotoSemiBold,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 37.5.sp,
                color = Color(0xFF2196F3),
                modifier = Modifier.align(Alignment.TopCenter).padding(9.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize().scale(1.25f),
                verticalArrangement = Arrangement.Center
            ){
                Row(
                    modifier = Modifier.fillMaxWidth().padding(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Start",
                        fontFamily = robotoSemiBold,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 30.sp,
                        color = Color(0xFF2196F3)
                    )

                    Text(text = "Middle",
                        fontFamily = robotoSemiBold,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 30.sp,
                        color = Color(0xFF2196F3)
                    )

                    Text(text = "End",
                        fontFamily = robotoSemiBold,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 30.sp,
                        color = Color(0xFF2196F3)
                    )
                }
            }
        }
    }
}
package ca.gbc.comp3074.rodrigues_leticia.lab22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.rodrigues_leticia.lab22.ui.theme.Lab22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lab22Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFFF3EFFF)
                ) { innerPadding ->
                    ActionButtons(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ActionButtons(modifier: Modifier = Modifier) {
    var output by rememberSaveable { mutableStateOf(0) }
    var step by rememberSaveable { mutableStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ufo),
            contentDescription = "App logo",
            modifier = Modifier.size(96.dp)
        )

        Text(
            text = "Lab 2 - Counter",
            fontSize = 24.sp,
            color = Color(0xFF35265C)
        )

        Text(
            text = output.toString(),
            fontSize = 48.sp,
            color = Color(0xFF35265C)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { output = (output - step).coerceAtLeast(0) },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5E35B1),
                    contentColor = Color.White
                )
            ) {
                Text(text = "-", fontSize = 24.sp)
            }

            Button(
                onClick = { output += step },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5E35B1),
                    contentColor = Color.White
                )
            ) {
                Text(text = "+", fontSize = 24.sp)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    output = 0
                    step = 1
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAD1457),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Reset")
            }

            Button(
                onClick = { step = 2
                            output += step},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00695C),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Step")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    Lab22Theme {
        Scaffold(
            containerColor = Color(0xFFF3EFFF)
        ) { innerPadding ->
            ActionButtons(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
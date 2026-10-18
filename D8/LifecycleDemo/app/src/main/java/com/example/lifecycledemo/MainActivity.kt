package com.example.lifecycledemo

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private const val TAG = "MainActivity"
private const val KEY_MANUAL_COUNT = "manual_count"

object Routes {
    const val WELCOME = "welcome"
    const val COUNTER = "counter"
    const val VIDEO = "video"
    const val RESULT = "result"
}

/* ------------------------------------------------------------------
 * 1) Lifecycle-aware component (slide 31): DefaultLifecycleObserver
 * ------------------------------------------------------------------ */
class ScreenTimer : DefaultLifecycleObserver {
    private var startTime = 0L

    override fun onStart(owner: LifecycleOwner) {
        startTime = SystemClock.elapsedRealtime()
        Log.d("ScreenTimer", "Start counting")
    }

    override fun onStop(owner: LifecycleOwner) {
        val seconds = (SystemClock.elapsedRealtime() - startTime) / 1000
        Log.d("ScreenTimer", "Stop counting - screen was visible for ${seconds}s")
    }
}

/* ------------------------------------------------------------------
 * 2) Activity + log every lifecycle callback (slides 6-13, 18-20)
 * ------------------------------------------------------------------ */
class MainActivity : ComponentActivity() {

    // Counter saved manually with a Bundle (slide 25)
    private var manualCount by mutableIntStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called " + if (savedInstanceState == null) "(new)" else "(recreated)")
        Log.d(TAG, "State: ${lifecycle.currentState}")   // LifecycleOwner (slide 30)

        // Restore from Bundle
        manualCount = savedInstanceState?.getInt(KEY_MANUAL_COUNT) ?: 0

        // Register lifecycle observer
        lifecycle.addObserver(ScreenTimer())

        setContent {
            MaterialTheme {
                LifecycleDemoApp(
                    manualCount = manualCount,
                    onManualIncrement = { manualCount++ }
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }

    // Save small data in the Bundle (slide 25)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_MANUAL_COUNT, manualCount)
        Log.d(TAG, "onSaveInstanceState Called (manualCount=$manualCount)")
    }
}

/* ------------------------------------------------------------------
 * 3) Navigation + back stack (slides 35-36)
 * ------------------------------------------------------------------ */
@Composable
fun LifecycleDemoApp(manualCount: Int, onManualIncrement: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WELCOME) {
        composable(Routes.WELCOME) {
            WelcomeScreen(onStart = { navController.navigate(Routes.COUNTER) })
        }
        composable(Routes.COUNTER) {
            CounterScreen(
                manualCount = manualCount,
                onManualIncrement = onManualIncrement,
                onNext = { navController.navigate(Routes.VIDEO) }
            )
        }
        composable(Routes.VIDEO) {
            VideoScreen(
                onFinish = {
                    // Back on Result goes straight to Welcome
                    navController.navigate(Routes.RESULT) {
                        popUpTo(Routes.WELCOME)
                    }
                }
            )
        }
        composable(Routes.RESULT) {
            ResultScreen(
                onRestart = {
                    navController.navigate(Routes.WELCOME) {
                        popUpTo(Routes.WELCOME) { inclusive = true }
                    }
                }
            )
        }
    }
}

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Lifecycle Demo", style = MaterialTheme.typography.headlineMedium)
        Text("Mở Logcat với filter: tag:MainActivity | tag:ScreenTimer | tag:Video")
        Button(onClick = onStart) { Text("Bắt đầu") }
    }
}

/* ------------------------------------------------------------------
 * 4) remember vs Bundle vs rememberSaveable (slides 24-27)
 * ------------------------------------------------------------------ */
@Composable
fun CounterScreen(
    manualCount: Int,
    onManualIncrement: () -> Unit,
    onNext: () -> Unit
) {
    var rememberCount by remember { mutableIntStateOf(0) }              // lost on rotation
    var saveableCount by rememberSaveable { mutableIntStateOf(0) }      // survives rotation

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bấm vài lần rồi XOAY màn hình để so sánh")
        Button(onClick = { rememberCount++ }) {
            Text("remember: $rememberCount")
        }
        Button(onClick = onManualIncrement) {
            Text("Bundle (onSaveInstanceState): $manualCount")
        }
        Button(onClick = { saveableCount++ }) {
            Text("rememberSaveable: $saveableCount")
        }
        Button(onClick = onNext) { Text("Sang màn hình Video") }
    }
}

/* ------------------------------------------------------------------
 * 5) LifecycleEventEffect in a composable (slide 32)
 * ------------------------------------------------------------------ */
@Composable
fun VideoScreen(onFinish: () -> Unit) {
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        Log.d("Video", "Resume playback")
    }
    LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) {
        Log.d("Video", "Pause playback")
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Playing video...")
        Text("Nhấn Home rồi mở lại app, xem Logcat (tag:Video)")
        Button(onClick = onFinish) { Text("Xem kết quả") }
    }
}

@Composable
fun ResultScreen(onRestart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Result", style = MaterialTheme.typography.headlineMedium)
        Text("Nhấn Back: quay thẳng về Welcome nhờ popUpTo(WELCOME)")
        Button(onClick = onRestart) { Text("Làm lại") }
    }
}
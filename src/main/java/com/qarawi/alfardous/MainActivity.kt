package com.qarawi.alfardous

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.qarawi.alfardous.ui.theme.الفردوسTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            الفردوسTheme {
                WebPage("https://www.alfardous.shop/") // استبدل بعنوان موقعك
            }
        }
    }
}

@Composable
fun WebPage(url: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true // تمكين JavaScript إذا كان الموقع يحتاجه
                settings.cacheMode = WebSettings.LOAD_DEFAULT // لضبط الكاش
                webViewClient = WebViewClient() // فتح الروابط داخل التطبيق
                loadUrl(url) // تحميل الموقع
            }
        }
    )
}

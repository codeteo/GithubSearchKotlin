package search.example.com.utils

import android.support.annotation.NonNull
import android.support.annotation.Nullable
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * An interceptor that allows runtime changes to the URL hostname.
 * Usually used in combination with MockWebServer.
 */

class BaseUrlInterceptor(private val realBaseUrl: String) : Interceptor {

    @Nullable
    @Volatile private var host: String? = null

    fun setBaseUrl(host: String) {
        this.host = host
    }

    fun resetBaseUrl() {
        this.host = realBaseUrl
    }

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (host != null && realBaseUrl != host) {
            val newUrl = HttpUrl.parse(host!!)
            request = request.newBuilder()
                    .url(newUrl!!)
                    .build()
        }
        return chain.proceed(request)
    }

}
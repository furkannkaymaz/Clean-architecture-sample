package com.example.digisample.di

import android.os.Build
import android.util.Log
import android.webkit.CookieManager
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * Created by DTFKAYMAZ on 28.09.2022.
 */

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class WebviewCookieHandler : CookieJar {
    private val webviewCookieManager = CookieManager.getInstance()
    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val urlString = url.toString()
        for (cookie in cookies) {
            webviewCookieManager.setCookie(urlString, cookie.toString())
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                webviewCookieManager.flush()
            }
        }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val urlString = url.toString()
        val cookiesString =
            "dtCookie=v_4_srv_4_sn_F48EC06A59F3FC1AF7E0EE1CE4747B90_perc_100000_ol_0_mul_1_app-3A637860a0b976311e_0; __RequestVerificationToken=INMfSOYhXNMzRWc4S2wAEl6bADMjRcVzp4HQRpVwKzi0CGnzdS1EjRieLHFlJ9Dk5fVCMAnXgSxjnfKjuEnhFd99M4z61buxk6saV0jEKto1; rxVisitor=1663912979830486N7BDFIUF190IN7BFPC9CPVHDM2LAK; TS01097bf7026=01f7a0500c8f8c5377c2f6275b73597ade8a091766feb1b773c188e44a266b4b4bc6e8dccfbe51d17127eb967d8880e09878c1de24b9e8e3bd8478067a966cf70e53cf0c01; dtSa=-; rxvt=1663914801952|1663912979842; dtLatC=6; dtPC=4\$112992527_75h-vETUBHUWMCWARMTCMHCCWBDTPGGUPCVCU-0e0; m=i=GL39ncDrM5Z%2b9Yqd6CfuDRvpHJq3Ne3RMx%2fIGYu8GbELvD%2bZUPkL9QPY2FnOgr9Qpyx4XyQVU5AGr6zsC2pUzsKl7HcFG1ZcqE4HE5f%2bjzPJ7Z5DIOrRYz37tCi3F2qJpA0NCHJAFhYdBgbrQVA%2fQk5EfF71pPUzFRcD8XLvkM3ihso04ac9sDQYXZs6baPjYiKE4SOYtC8C%2bladBhxKAu1NMgtiGWiOmRyts8MQjcwie3eg7b6c3Kk7IOXZtv%2fNuGo4pF82jBZx47G69lHhG9ymjoN3pJeuERTXLfoBga9KPLPo2kLCZ5UlitLj%2f7eY0M%2fT%2b308n2aC1kZJIQe9yNN0qOVIAf5Ef6iZFY7%2boFBBp1ILMWyUrUNTUn7iGn5LvUUuu04IDT5S17NOKT4mBuVoIpQoSdwTemW05oZA4ak%3d; TS01097bf7=01a041d45fd109691fa2e4349f5f9fa9cc1ee14e0d4c093b71532e0c7d52429fd8bcf33269fa34b93b235f47a6160b0ed4e5136dce52891a7f2cbebc84fbe461f206e9a81f"

        if (cookiesString != null && !cookiesString.isEmpty()) {
            val cookieHeaders = cookiesString.split(";").toTypedArray()
            val cookies: MutableList<Cookie> = ArrayList(cookieHeaders.size)
            for (header in cookieHeaders) {
                val cookie = Cookie.parse(url, header)
                if (cookie != null) cookies.add(cookie)
            }
            return cookies
        }
        return emptyList()
    }

}
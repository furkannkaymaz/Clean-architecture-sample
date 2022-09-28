package com.example.digisample.data.network

import com.example.digisample.data.home.model.CompetitionData
import com.example.digisample.utils.Resource
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */
interface HomeApiServices {

    @POST("/api/content/competitions")
    suspend fun getContentCompetitions() : CompetitionData

    // i=GL39ncDrM5Z%2b9Yqd6CfuDRvpHJq3Ne3RMx%2fIGYu8GbELvD%2bZUPkL9QPY2FnOgr9Qpyx4XyQVU5AGr6zsC2pUzsKl7HcFG1ZcqE4HE5f%2bjzPJ7Z5DIOrRYz37tCi3F2qJpA0NCHJAFhYdBgbrQVA%2fQk5EfF71pPUzFRcD8XLvkM3ihso04ac9sDQYXZs6baPjYiKE4SOYtC8C%2bladBhxKAu1NMgtiGWiOmRyts8MQjcwie3eg7b6c3Kk7IOXZtv%2fNuGo4pF82jBZx47G69lHhG9ymjoN3pJeuERTXLfoBga9KPLPo2kLCZ5UlitLj%2f7eY0M%2fT%2b308n2aC1kZJIQe9yNN0qOVIAf5Ef6iZFY7%2boFBBp1ILMWyUrUNTUn7iGn5LvUUuu04IDT5S17NOKT4mBuVoIpQoSdwTemW05oZA4ak%3d
}
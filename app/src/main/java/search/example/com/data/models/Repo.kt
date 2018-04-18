package search.example.com.data.models

import com.google.gson.annotations.SerializedName

/**
 * Models the responses for [search.example.com.data.api.GithubApi.getUserRepos].
 */

data class Repo(

        @SerializedName("id")
        var id: Int,

        @SerializedName("name")
        var name: String?,

        @SerializedName("full_name")
        var fullname: String?,

        @SerializedName("description")
        val description: String?,

        @SerializedName("created_at")
        val createdAt: String?,

        @SerializedName("updated_at")
        val updatedAt: String?,

        @SerializedName("languages_url")
        val languagesUrl: String?,

        @SerializedName("stargazers_count")
        val stars: Int

)
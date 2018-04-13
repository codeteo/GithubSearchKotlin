package search.example.com.data.models

import com.google.gson.annotations.SerializedName

/**
 * Models the responses for [search.example.com.data.api.GithubApi.getUser].
 */

data class User (

        @SerializedName("login")
        val login: String,

        @SerializedName("avatar_url")
        val avatarUrl: String,

        @SerializedName("id")
        val id: String,

        @SerializedName("repos_url")
        val reposUrl: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("company")
        val company: String,

        @SerializedName("bio")
        val bio: String,

        @SerializedName("followers")
        val followers: String,

        @SerializedName("following")
        val following: String

)

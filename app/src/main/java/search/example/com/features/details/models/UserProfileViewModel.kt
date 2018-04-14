package search.example.com.features.details.models

data class UserProfileViewModel(
        val avatarUrl: String?,
        val name: String,
        val company: String,
        val bio: String,
        val following: Int,
        val followers: Int
)
package search.example.com.data.models

import com.google.gson.annotations.SerializedName

/**
 * Models the responses for search requests.
 */

data class SearchRepositoryResponse(

        @SerializedName("total_count")
        val  totalCount: Int?,

        @SerializedName("incomplete_results")
        val incompleteResults: Boolean?,

        @SerializedName("items")
        val items: List<RepoItem>
)

data class RepoItem(

        @SerializedName("score")
        val score: Double?
)

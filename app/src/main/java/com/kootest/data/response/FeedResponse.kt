package com.kootest.data.response

import com.google.gson.annotations.SerializedName

data class FeedResponse(

	@field:SerializedName("data")
	val data: List<Feed>,

	@field:SerializedName("meta")
	val meta: Meta
)

data class Links(

	@field:SerializedName("next")
	val next: String,

	@field:SerializedName("current")
	val current: String,

	@field:SerializedName("previous")
	val previous: Any
)

data class Meta(

	@field:SerializedName("pagination")
	val pagination: Pagination
)

data class Feed(

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("body")
	val body: String
)

data class Pagination(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("pages")
	val pages: Int,

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("links")
	val links: Links,

	@field:SerializedName("page")
	val page: Int
)

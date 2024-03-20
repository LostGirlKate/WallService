data class Comment(
    val fromID: Int,
    val text: String,
    val replyToUser: Int = 0,
    val attachments: Array<Attachment> = emptyArray<Attachment>(),
    val date: Long = System.currentTimeMillis(),
    val id: Int = 0
)

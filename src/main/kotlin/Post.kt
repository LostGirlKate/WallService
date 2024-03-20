data class Post(
    val toId: Int,
    val fromID: Int,
    val createdBy: Int,
    val text: String = "",
    val comments: PostComment = PostComment(),
    val likes: Likes = Likes(),
    val attachments: Array<Attachment> = emptyArray<Attachment>(),
    val canPin: Boolean = true,
    val isPinned: Boolean = false,
    val canEdit: Boolean = true,
    val canDelete: Boolean = true,
    val date: Long = System.currentTimeMillis(),
    var id: Int = 0
) {

}
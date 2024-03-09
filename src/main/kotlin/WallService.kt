class WallService {
    private var postList: Array<Post> = emptyArray()
    private var lastPostID: Int = 0

    fun add(post: Post): Post {
        post.id = ++lastPostID
        postList += post
        return postList.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postInList) in postList.withIndex()) {
            if (post.id == postInList.id) {
                postList[index] = postInList.copy(
                    toId = post.toId,
                    fromID = post.fromID,
                    createdBy = post.createdBy,
                    text = post.text,
                    comments = post.comments,
                    likes = post.likes,
                    attachments = post.attachments,
                    canPin = post.canPin,
                    isPinned = post.isPinned,
                    canEdit = post.canEdit,
                    canDelete = post.canDelete,
                    date = post.date
                )
                return true
            }
        }
        return false
    }
}
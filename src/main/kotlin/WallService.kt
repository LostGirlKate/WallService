class WallService {
    private var postList: Array<Post> = emptyArray()
    private var lastPostID: Int = 0
    private var comments = emptyArray<Comment>()
    private var lastCommentID: Int = 0
    private var reportComments = emptyArray<ReportComment>()

    fun add(post: Post): Post {
        postList += post.copy(id = ++lastPostID)
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

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, postInList) in postList.withIndex()) {
            if (postId == postInList.id) {
                ++postList[index].comments.count
                comments += comment.copy(id = ++lastCommentID)
                return comments.last()
            }
        }
        throw PostNotFoundException("Пост с id $postId не нейден")
    }

    fun addReportComment(commentID: Int, reportComment: ReportComment): Int {
        if (reportComment.reason !in 0..8)
            throw ReportCommentReasonNotFoundException("Некорректный код параметра reason: ${reportComment.reason}")

        for ((index, commentInList) in comments.withIndex()) {
            if (commentID == commentInList.id) {
                reportComments += reportComment.copy(commentID = comments[index].id)
                return 1
            }
        }
        throw CommentNotFoundException("Комментарий с id $commentID не нейден")
    }
}
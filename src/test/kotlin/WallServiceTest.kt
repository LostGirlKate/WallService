import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addExistingTest() {
        val service = WallService()
        val post = Post(133, 133, 133, "Запись 1")
        val result = service.add(post)
        post.id = 1
        assertEquals(post, result)
    }

    @Test
    fun updateExistingTest() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        service.add(Post(133, 133, 133, "Запись 1"))
        val update = Post(133, 133, 133, "Запись 2")
        update.id = 2
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExistingTest() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        service.add(Post(133, 133, 133, "Запись 1"))
        val update = Post(133, 133, 133, "Запись 2")
        val result = service.update(update)
        assertFalse(result)
    }


    @Test(expected = PostNotFoundException::class)
    fun createCommentShouldThrow() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        val newComment = Comment(1, "Тестовый комментарий")
        service.createComment(2, newComment)
    }

    @Test
    fun createCommentExistingPostTest() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        var newComment = Comment(1, "Тестовый комментарий")
        val result = service.createComment(1, newComment)
        newComment = newComment.copy(id = 1)
        assertEquals(newComment, result)
    }


    @Test
    fun addReportCommentExistingCommentTest() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        service.createComment(1, Comment(1, "Тестовый комментарий"))
        val result = service.addReportComment(1,ReportComment(2,0))
        assertEquals(1, result)
    }

    @Test(expected = ReportCommentReasonNotFoundException::class)
    fun addReportCommentReasonNotFoundShouldThrow() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        service.createComment(1, Comment(1, "Тестовый комментарий"))
        service.addReportComment(1,ReportComment(2,20))
    }

    @Test(expected = CommentNotFoundException::class)
    fun addReportCommentCommentNotFoundShouldThrow() {
        val service = WallService()
        service.add(Post(133, 133, 133, "Запись 1"))
        service.createComment(1, Comment(1, "Тестовый комментарий"))
        service.addReportComment(2,ReportComment(2,0))
    }
}
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
}
fun main() {
    val wallService = WallService()
    println(wallService.add(Post(133, 133, 133, "Запись 1")))
    wallService.add(Post(133, 133, 133, "Запись 2"))
    wallService.add(Post(133, 133, 133, "Запись 3"))
    val update = Post(133, 133, 133, "Запись 1")
    update.id = 2
    println(wallService.update(update))
}
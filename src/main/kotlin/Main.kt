fun main() {
    val wallService = WallService()
    println(wallService.add(Post(133, 133, 133, "Запись 1")))
    wallService.add(Post(133, 133, 133, "Запись 2"))
    wallService.add(Post(133, 133, 133, "Запись 3"))
    val update = Post(133, 133, 133, "Запись 0")
    update.id = 2
    println(wallService.update(update))

    val newComment = Comment(1, "Тестовый комментарий")
    println(wallService.createComment(2, newComment))
    try {
        println(wallService.createComment(5, newComment))
    } catch (e: RuntimeException) {
        println("Ошибка добавления комментария: ${e.javaClass.name}: ${e.message}")
    }

    println(wallService.addReportComment(1, ReportComment(2, 6)))


    try {
        println(wallService.addReportComment(1, ReportComment(2, 20)))
    } catch (e: RuntimeException) {
        println("Ошибка добавления жалобы: ${e.javaClass.name}: ${e.message}")
    }

    try {
        println(wallService.addReportComment(10, ReportComment(2, 6)))
    } catch (e: RuntimeException) {
        println("Ошибка добавления жалобы: ${e.javaClass.name}: ${e.message}")
    }
}
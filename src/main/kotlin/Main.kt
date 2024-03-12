fun main() {
    val wallService = WallService()
    println(wallService.add(Post(133, 133, 133, "Запись 1")))
    wallService.add(Post(133, 133, 133, "Запись 2"))
    wallService.add(Post(133, 133, 133, "Запись 3"))
    val update = Post(
        133, 133, 133, "Запись 0",
        attachments = arrayOf(
            PhotoAttachment(Photo(1, 1, 1, "My Photo", "https://photo", 100, 100)),
            AudioAttachment(Audio(1, 1, "artist", "my audio", "https://audio", 100, 1)),
            VideoAttachment(Video(1, 1, "title", "My video", "https://video", 10000, 100))
        )
    )
    update.id = 2
    println(wallService.update(update))
    for (attachment in update.attachments) {
        val url = when (attachment) {
            is PhotoAttachment -> attachment.photo.url
            is AudioAttachment -> attachment.audio.url
            is VideoAttachment -> attachment.video.url
            is StickerAttachment -> attachment.sticker.animationUrl
            is DocAttachment -> attachment.doc.url
        }
        println(url)
    }
}
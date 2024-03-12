abstract class Attachment(val type: AttachmentType)
data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val text: String,
    val url: String,
    val width: Int,
    val height: Int
)

data class PhotoAttachment(
    val photo: Photo
) : Attachment(AttachmentType.PHOTO)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val url: String,
    val duration: Int,
    val views: Int
)

data class VideoAttachment(
    val video: Video
) : Attachment(AttachmentType.VIDEO)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val url: String,
    val duration: Int,
    val albumId: Int
)

data class AudioAttachment(
    val audio: Audio
) : Attachment(AttachmentType.AUDIO)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val url: String,
    val size: Int,
    val ext: String
)

data class DocAttachment(
    val doc: Doc
) : Attachment(AttachmentType.DOC)

data class Sticker(
    val productId: Int,
    val stickerId: Int,
    val imageUrl: String,
    val width: Int,
    val height: Int,
    val animationUrl: String
)

data class StickerAttachment(
    val sticker: Sticker
) : Attachment(AttachmentType.STICKER)




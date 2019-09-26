package com.github.k1rakishou.fsaf.file

import com.github.k1rakishou.fsaf.extensions.appendMany
import java.io.File

class RawFile(
  root: Root<File>,
  segments: MutableList<Segment> = mutableListOf()
) : AbstractFile(root, segments) {

  override fun appendSubDirSegment(name: String): RawFile {
    check(root !is Root.FileRoot) { "root is already FileRoot, cannot append anything anymore" }
    return super.appendSubDirSegmentInner(name) as RawFile
  }

  override fun appendFileNameSegment(name: String): RawFile {
    check(root !is Root.FileRoot) { "root is already FileRoot, cannot append anything anymore" }
    return super.appendFileNameSegmentInner(name) as RawFile
  }

  override fun clone(): RawFile = RawFile(
    root.clone() as Root<File>,
    segments.toMutableList()
  )

  override fun getFullPath(): String {
    root.holder as File

    return File(root.holder.absolutePath)
      .appendMany(segments.map { segment -> segment.name })
      .absolutePath
  }

  override fun getFileManagerId(): FileManagerId = FILE_MANAGER_ID

  companion object {
    private const val TAG = "RawFile"
    val FILE_MANAGER_ID = FileManagerId(TAG)
  }
}
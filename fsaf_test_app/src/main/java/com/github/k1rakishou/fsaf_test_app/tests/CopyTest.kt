package com.github.k1rakishou.fsaf_test_app.tests

import android.net.Uri
import com.github.k1rakishou.fsaf.FileManager
import com.github.k1rakishou.fsaf.file.AbstractFile
import java.io.File

class CopyTest(
  tag: String,
  isFastMode: Boolean
) : BaseTest(tag, isFastMode) {

  fun runCopyTests(fileManager: FileManager, baseDir: Uri, baseDirFile: File) {
    fileManager.deleteContent(fileManager.fromUri(baseDir))

    val srcDir = fileManager.create(
      fileManager.fromUri(baseDir)
        .appendSubDirSegment("src")
    )
    if (srcDir == null || !fileManager.exists(srcDir) || !fileManager.isDirectory(srcDir)) {
      throw TestException("Couldn't create src directory")
    }

    val dstDir = fileManager.create(
      fileManager.fromUri(baseDir)
        .appendSubDirSegment("dst")
    )

    if (dstDir == null || !fileManager.exists(dstDir) || !fileManager.isDirectory(dstDir)) {
      throw TestException("Couldn't create dst directory")
    }

    // TODO
  }

  private fun test1(fileManager: FileManager, srcDir: AbstractFile, dstDir: AbstractFile) {
    // TODO
  }
}
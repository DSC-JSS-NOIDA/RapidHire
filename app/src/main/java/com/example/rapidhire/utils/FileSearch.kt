package com.example.rapidhire.utils

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import java.io.File

object FileSearch {

    fun getDirectoryPaths(directory: String): ArrayList<String> {
        val pathArray: ArrayList<String> = ArrayList()
        val file = File(directory)
        val listfiles: Array<File> = file.listFiles()
        for (i in listfiles.indices) {

            if (listfiles[i].isDirectory && !listfiles[i].isHidden && listfiles[i].listFiles()
                    .isNotEmpty()
            ) {
                pathArray.add(listfiles[i].absolutePath)
            }
        }
        return pathArray
    }

    fun getFilePaths(directory: String): ArrayList<String> {
        val pathArray: ArrayList<String> = ArrayList()
        val file = File(directory)
        val listfiles = file.listFiles()

//        listfiles?.let { list ->
//            Arrays.sort(list) { f1, f2 ->
//                f2.lastModified().compareTo(f1.lastModified())
//            }
//        }
        if (listfiles.isEmpty()) {
            return pathArray
        }
        for (i in listfiles.indices.reversed()) {
            if (listfiles[i].isFile) {
                pathArray.add(listfiles[i].absolutePath)
            }
        }

        return pathArray
    }

    fun getAllImages(context: Context): ArrayList<String> {

        val images = ArrayList<String>()
        val allImagesUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val orderBy: String = MediaStore.Images.Media.DATE_TAKEN
        val projection = arrayOf(MediaStore.Images.ImageColumns.DATA)
        var cursor = context.contentResolver.query(
            allImagesUri, projection, null, null,
            "$orderBy DESC"
        )

        try {
            cursor!!.moveToFirst()
            do {
                val url =
                    cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                images.add(url)
            } while (cursor.moveToNext())
            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return images
    }

    fun getRealPathFromURI(context: Context, contentURI: Uri): String {
        val result: String
        val cursor: Cursor? = context.contentResolver.query(contentURI, null, null, null, null)
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.path!!
        } else {
            cursor.moveToFirst()
            val idx: Int = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            result = cursor.getString(idx)
            cursor.close()
        }
        return result
    }


}
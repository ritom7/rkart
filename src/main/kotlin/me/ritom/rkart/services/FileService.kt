package me.ritom.rkart.services

import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileNotFoundException

@Component
class FileService {
    private val filePath = "~/Documents/rkart"
    fun saveFile(file:MultipartFile,filename:String) {
        val newFile = File("$filePath/$filename")
        newFile.createNewFile()
        newFile.writeBytes(file.bytes)
    }
    @Throws(FileNotFoundException::class)
    fun getFile(filename:String):File {
        val file = File("$filePath/$filename")
        if (!file.exists()) {
            throw FileNotFoundException("File $filename not found")
        }
        else return file
    }
}
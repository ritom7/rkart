package me.ritom.rkart.controllers

import me.ritom.rkart.models.ProductModel
import me.ritom.rkart.mongo.ProductRepo
import me.ritom.rkart.services.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.getOrNull

@RestController
class AdminController {
    @Autowired
    private lateinit var fileService: FileService
    @Autowired
    private lateinit var repo:ProductRepo

    @GetMapping("/admin")
    fun admin():String {
        return "{Usage:\"Use post on \\/admin/products/{id} to save new products\"}"
    }
    @GetMapping("/admin/products")
    fun products():List<ProductModel> {
        return repo.findAll()
    }
    @GetMapping("/admin/products/{id}")
    fun getProduct(@PathVariable("id") id:String):ProductModel? {
        return repo.findById(id).getOrNull()
    }
    @PostMapping("/admin/products/{id}")
    fun saveProduct(@PathVariable("id") id:String, @RequestBody product:ProductModel) {
        repo.save(product)
    }
    @DeleteMapping("/admin/products/{id}")
    fun deleteProduct(@PathVariable("id") id:String) {
        repo.deleteById(id)
    }
}
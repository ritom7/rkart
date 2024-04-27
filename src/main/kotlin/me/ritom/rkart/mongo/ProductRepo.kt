package me.ritom.rkart.mongo

import me.ritom.rkart.models.ProductModel
import org.springframework.data.mongodb.repository.MongoRepository


interface ProductRepo : MongoRepository<ProductModel,String>
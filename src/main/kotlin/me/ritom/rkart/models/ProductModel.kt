package me.ritom.rkart.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class ProductModel
    (@Id val id:String,
     var name:String, var description:String,
                        var price: Double, var image:String?)
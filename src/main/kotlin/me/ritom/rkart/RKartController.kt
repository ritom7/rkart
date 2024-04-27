package me.ritom.rkart

import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RKartController {
    @GetMapping("/kart")
    fun rKart(res: HttpServletResponse):String {
        res.status = HttpServletResponse.SC_OK
        return "No Endpoints set for"
    }
}
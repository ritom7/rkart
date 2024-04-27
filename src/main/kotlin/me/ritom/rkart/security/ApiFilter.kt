package me.ritom.rkart.security

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException


@Component
class ApiFilter : OncePerRequestFilter() {
    @Value("\${api.key}")
    private lateinit var apiKey: String

    @Value("\${api.secret}")
    private lateinit var apiSecret: String

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        //GUIDE:https://medium.com/@abhishekranjandev/a-comprehensive-guide-to-api-authentication-securing-spring-boot-apis-with-api-key-and-secret-e20b069b367e
        // Get the API key and secret from request headers

        val requestApiKey = request.getHeader("X-API-KEY")
        val requestApiSecret = request.getHeader("X-API-SECRET")
        // Validate the key and secret
        if (apiKey == requestApiKey && apiSecret == requestApiSecret) {
            // Continue processing the request
            filterChain.doFilter(request, response)
        } else {
            // Reject the request and send an unauthorized error
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.writer.write("Unauthorized")
        }
    }
}
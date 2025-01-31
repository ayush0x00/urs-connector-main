package com.urlshortner.urlshortner.repository

import org.springframework.data.cassandra.repository.CassandraRepository
import com.urlshortner.urlshortner.model.UrlModel
import org.springframework.data.cassandra.repository.AllowFiltering
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : CassandraRepository<UrlModel, Long> {

    @AllowFiltering
    fun findByLongUrl(longurl: String): List<UrlModel?>

    @AllowFiltering
    fun findByShortUrl(shorturl: String?): List<UrlModel?>?

    @AllowFiltering
    fun findUrlModelByShortUrl(shorturl: String?): UrlModel?

    @AllowFiltering
    fun countUrlModelByShortUrl(urlId: String?): Int
}

package ru.eda.bot.feedchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShopTest {

    @Test
    fun shop_name_null() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_name_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.id must not be blank")
    }

    @Test
    fun shop_name_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_name_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.id must not be blank")
    }

    @Test
    fun shop_company_null() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_company_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.categoryId must not be blank")
    }

    @Test
    fun shop_company_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_company_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.url must not be blank")
    }

    @Test
    fun shop_url_null() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_url_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.categoryId must not be blank")
    }

    @Test
    fun shop_url_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_url_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.url must not be blank")
    }

    @Test
    fun shop_currencies_null() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_currencies_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.categoryId must not be blank")
    }

    @Test
    fun shop_currencies_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_currencies_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.url must not be blank")
    }

    @Test
    fun shop_categories_null() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_categories_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.categoryId must not be blank")
    }

    @Test
    fun shop_categories_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_categories_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.url must not be blank")
    }

    @Test
    fun shop_offers_null() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_offers_null.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.categoryId must not be blank")
    }

    @Test
    fun shop_offers_textEmpty() {

        val readText = this.javaClass.classLoader.getResource("shopXMLs/shop_offers_textEmpty.xml")?.readText()
                ?: throw IllegalArgumentException("Path not found")
        val validate = FeedValidator().validate(readText)

        assertEquals(validate, "shop.url must not be blank")
    }



}
package com.example.useraccountsapi.service.controllers


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc


@ActiveProfiles("test")
@WebMvcTest
class UserControllerTest @Autowired constructor(val mockMvc: MockMvc) {

}
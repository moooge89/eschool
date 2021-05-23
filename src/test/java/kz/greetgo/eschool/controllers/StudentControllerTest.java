package kz.greetgo.eschool.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.eschool.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.annotations.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest extends org.springframework.test.context.testng.AbstractTestNGSpringContextTests{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentController studentController;

    @Test
    public void testMethod() throws Exception {
        mockMvc.perform(get("/student/test")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1000))
                .andExpect(jsonPath("$.name").value("Name"))
                .andExpect(jsonPath("$.surname").value("Surname"))
                .andExpect(jsonPath("$.grade").value(11))
                .andExpect(jsonPath("$.favoriteSubject").value("Math"));

    }

    @Test
    public void testGetAllStudents() throws Exception{
        mockMvc.perform(get("/student/all")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testAddNewStudent() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/student/add")
                .content(asJsonString(new Student(null, "Test", "Subject", 8, "Physics")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateStudent() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .put("/student/update")
                .content(asJsonString(new Student(2L, "Test", "Subject", 7,"Math")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Subject"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.favoriteSubject").value("Math"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
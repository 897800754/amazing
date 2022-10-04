package cn.cg.spring;

import cn.cg.spring.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: cg1
 * @date: 2022-09-25 02:06
 **/
public class ValidateTests extends ApplicationTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    static ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testValidate() throws Exception {


        Student student = new Student();

        String studentJson = objectMapper.writeValueAsString(student);

        MockHttpServletResponse response =
                mockMvc.perform(MockMvcRequestBuilders.post("/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
                )
                        .andDo(new ResultHandler() {
                            @Override
                            public void handle(MvcResult mvcResult) throws Exception {
                                MockHttpServletResponse response1 = mvcResult.getResponse();
                                System.out.println("==========================");
                                System.out.println(response1.getStatus());
                                System.out.println(response1.getContentType());
                                System.out.println(response1.getContentAsString());
                                System.out.println("==========================");

                            }
                        })
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse();
    }

    /**
     * validate 在service层
     *
     * @throws Exception
     */
    @Test
    public void testValidate1() throws Exception {


        Student student = new Student();

        String studentJson = objectMapper.writeValueAsString(student);

        MockHttpServletResponse response =
                mockMvc.perform(MockMvcRequestBuilders.post("/validate/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
                )
                        .andDo(new ResultHandler() {
                            @Override
                            public void handle(MvcResult mvcResult) throws Exception {
                                MockHttpServletResponse response1 = mvcResult.getResponse();
                                System.out.println("==========================");
                                System.out.println(response1.getStatus());
                                System.out.println(response1.getContentType());
                                System.out.println(response1.getContentAsString());
                                System.out.println("==========================");

                            }
                        })
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse();
    }


    /**
     * 测试validate util
     *
     * @throws Exception
     */
    @Test
    public void testValidateUtil() throws Exception {


        Student student = new Student();

        String studentJson = objectMapper.writeValueAsString(student);

        MockHttpServletResponse response =
                mockMvc.perform(MockMvcRequestBuilders.post("/validate/util")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
                )
                        .andDo(new ResultHandler() {
                            @Override
                            public void handle(MvcResult mvcResult) throws Exception {
                                MockHttpServletResponse response1 = mvcResult.getResponse();
                                System.out.println("==========================");
                                System.out.println(response1.getStatus());
                                System.out.println(response1.getContentType());
                                System.out.println(response1.getContentAsString());
                                System.out.println("==========================");

                            }
                        })
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse();
    }



    @Test
    public void testValidateValidation() throws Exception {


        Student student = new Student();

        String studentJson = objectMapper.writeValueAsString(student);

        MockHttpServletResponse response =
                mockMvc.perform(MockMvcRequestBuilders.post("/validate/Validation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
                )
                        .andDo(new ResultHandler() {
                            @Override
                            public void handle(MvcResult mvcResult) throws Exception {
                                MockHttpServletResponse response1 = mvcResult.getResponse();
                                System.out.println("==========================");
                                System.out.println(response1.getStatus());
                                System.out.println(response1.getContentType());
                                System.out.println(response1.getContentAsString());
                                System.out.println("==========================");

                            }
                        })
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse();
    }



    @Test
    public void testValidateGroup() throws Exception {


        Student student = new Student();

        String studentJson = objectMapper.writeValueAsString(student);
        //create组校验通过
        mockMvc.perform(MockMvcRequestBuilders.post("/validate/group/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson)
        )
                .andDo(new ResultHandler() {
                    @Override
                    public void handle(MvcResult mvcResult) throws Exception {
                        MockHttpServletResponse response1 = mvcResult.getResponse();
                        System.out.println("==========================");
                        System.out.println(response1.getStatus());
                        System.out.println(response1.getContentType());
                        System.out.println(response1.getContentAsString());
                        System.out.println("==========================");

                    }
                })
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        //update组校验通过
        mockMvc.perform(MockMvcRequestBuilders.post("/validate/group/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson)
        )
                .andDo(new ResultHandler() {
                    @Override
                    public void handle(MvcResult mvcResult) throws Exception {
                        MockHttpServletResponse response1 = mvcResult.getResponse();
                        System.out.println("==========================");
                        System.out.println(response1.getStatus());
                        System.out.println(response1.getContentType());
                        System.out.println(response1.getContentAsString());
                        System.out.println("==========================");

                    }
                })
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();


    }
}

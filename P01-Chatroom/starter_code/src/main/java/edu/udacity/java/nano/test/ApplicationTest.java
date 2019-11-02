package edu.udacity.java.nano.test;

import edu.udacity.java.nano.WebSocketChatApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers  = {WebSocketChatApplication.class})
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("/login"));
    }
    @Test
    public void chat() throws Exception{
        this.mockMvc.perform(get("/index").param("username","saran")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("chat"));
    }

    @Test
    public void userlogin() throws Exception{
        this.mockMvc.perform(get("/index").param("username","saran")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("saran")));
    }

    @Test
    public void leave() throws Exception{
        login();
        chat();
    }
}

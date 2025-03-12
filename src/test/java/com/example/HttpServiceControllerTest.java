package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMockMvc
public class HttpServiceControllerTest {


//    @Autowired
//    private MockMvc mockMvc;

//    @Test
//    public void testMyEndpoint() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/"))
//            .andExpectAll(
//                MockMvcResultMatchers.status().isOk()
//            );
//    }


/*
    @Test
    public void testAppLogger() {
        LogCaptor logCaptor = LogCaptor.forClass(Service.class);
        Service.main(null);
        List<String> infoLogs = logCaptor.getInfoLogs();
        Assertions.assertEquals(1, infoLogs.size());
        Assertions.assertEquals("Hello World", infoLogs.get(0));
    }
*/


    /**
     * Unit test the Get Method CheckIfPrime in HttperviceController.java.
     */
    @Test
    public void testCheckIfPrimeSmall() {
        HttpServiceController httpServiceController = new HttpServiceController();
        Assertions.assertEquals("false", httpServiceController.checkIfPrime5000("0"));  // 0
        Assertions.assertEquals("false", httpServiceController.checkIfPrime5000("1"));  // 1
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("2"));   // 2
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("3"));   // 3
        Assertions.assertEquals("false", httpServiceController.checkIfPrime5000("9"));  // 9
        Assertions.assertEquals("false", httpServiceController.checkIfPrime5000("10")); // 10
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("11"));  // 11
        Assertions.assertEquals("false", httpServiceController.checkIfPrime5000("12")); // 12
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("13"));  // 13
        Assertions.assertEquals("false", httpServiceController.checkIfPrime5000("14")); // 14
    }

    @Test
    public void testCheckIfPrimeBig() {
        HttpServiceController httpServiceController = new HttpServiceController();
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("10007"));                                       //  5 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("1000000007"));                                  // 10 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("144403552893599"));                             // 15 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("20212223242526272829"));                        // 20 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("3333322225555555777777777"));                   // 25 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("196169144121100816449362516941"));              // 30 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("68476562763327854359085599065855383"));         // 35 digits
        Assertions.assertEquals("true", httpServiceController.checkIfPrime5000("2030507011013017019023029031037041043047"));    // 40 digits
        
    }



}

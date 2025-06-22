package jsonutil;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonutil.model.User;
import jsonutil.util.UserJsonMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ParseJsonTest {

    static String FILENAME = "C:\\AutomationTestingAdvancedProgram\\JSONUtil\\JsonTest111.json";
    static String USERFILENAME = "C:\\AutomationTestingAdvancedProgram\\JSONUtil\\user-response.json";
    static String USERJSONFILENAME = "src/test/java/jsonutil/user-response.json";
    @Test
    public void userMappingTest(){
        User user = UserJsonMapper.mapJsonToUser(USERJSONFILENAME);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getFirstName());
        System.out.println(user.getRoles());
        Map<String, Object> val = user.getExtraFields();
        System.out.println(val);
    }
    @Test
    public void test117() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Sales[] sales = objectMapper.readValue(new File(FILENAME), Sales[].class);//Sales[].class given bcoz resp is in json array
        for(Sales sale:sales){
            System.out.println(sale.getName()+" has done sale of $"+sale.getTotalSales()+" for the period "+sale.getSalesPeriod()+" and have experience in sale of "+sale.getExperienceMultiplier() +"years");
        }
    }
}

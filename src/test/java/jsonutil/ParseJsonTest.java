package jsonutil;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ParseJsonTest {

    static String FILENAME = "C:\\AutomationTestingAdvancedProgram\\JSONUtil\\JsonTest111.json";
    @Test
    public void test117() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Sales[] sales = objectMapper.readValue(new File(FILENAME), Sales[].class);//Sales[].class given bcoz resp is in json array
        for(Sales sale:sales){
            System.out.println(sale.getName()+" has done sale of $"+sale.getTotalSales()+" for the period "+sale.getSalesPeriod()+" and have experience in sale of "+sale.getExperienceMultiplier() +"years");
        }
    }
}

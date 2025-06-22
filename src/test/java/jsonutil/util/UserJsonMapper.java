package jsonutil.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonutil.model.User;

import java.io.File;
import java.io.IOException;

public class UserJsonMapper {
    public static User mapJsonToUser(String filePath){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File(filePath), User.class);
        }catch (IOException e){
            throw new RuntimeException("Failed to Map JSON to User class" + e.getMessage());
        }
    }
}

package ru.sstu.rosatom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RegionsConfig {

    @Bean("regions")
    public Map<String,String> map() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("region.csv");
        Map<String,String> map = new HashMap<>();

        BufferedReader reader = null;

        String line = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(is));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                String key = arr[12].substring(3);
                map.put(key,arr[2]);
            }
            reader.close();
        }catch (Exception e){
            System.out.println("беда");
        }
        return map;
    }
}

package ru.sstu.rosatom.utils;


import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@UtilityClass
public class ParseRegion {

    @SneakyThrows
    public Map<String,String> getRegions() {
        Map<String,String> map = new HashMap<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(
                    "region.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
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

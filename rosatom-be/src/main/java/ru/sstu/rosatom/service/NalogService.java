package ru.sstu.rosatom.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.sstu.rosatom.entity.dto.nalog.NalogEntity;
import ru.sstu.rosatom.entity.dto.nalog.NalogResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NalogService {

    private final String TARGET_URL = "https://ofd.nalog.ru/search-proc.json";
    private final RestTemplate restTemplate;

    public List<NalogEntity> getNalogEntities(String okpd2, String region) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("mode", "extended");
        map.add("page", "1");
        //map.add("query", "");
        //map.add("dtCategory", "10.08.2021");
        //String buisnessFild = okpd2.split("\\.")[0];
        map.add("okved1", okpd2);
        //map.add("tru", okpd2);
        //todo:
        map.add("region", region);
        //map.add("slvd", "");
        map.add("pageSize", "100");
        map.add("sortField", "NAME_EX");
        map.add("sort", "ASC");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        return restTemplate.exchange(TARGET_URL, HttpMethod.POST, request, NalogResponse.class).getBody().getData();
    }


}

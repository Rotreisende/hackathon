package ru.sstu.rosatom.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sstu.rosatom.entity.dto.dadata.DaDataResponse;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NonStaticUtils {

    private final RestTemplate restTemplate;
    private final String DADATA_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party";


    public AddressAndPostcode findInDaData(String inn) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "application/json");
        httpHeaders.add("Authorization", "Token bf35a9ad3efc7b655caf8184bf320d8cb1d2eaa8");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("query", inn), httpHeaders);
        ResponseEntity<DaDataResponse> daDataResponse = restTemplate.exchange(DADATA_URL, HttpMethod.POST, request, DaDataResponse.class);
        AddressAndPostcode addressAndPostcode = new AddressAndPostcode();
        if (daDataResponse.getBody() != null && daDataResponse.getBody().getSuggestions().size() > 0) {
            addressAndPostcode.setAddress(daDataResponse.getBody().getSuggestions().get(0).getData().getAddress().getValue());
            addressAndPostcode.setPostcode(daDataResponse.getBody().getSuggestions().get(0).getData().getAddress().getData().getPostal_code());
        }
        return addressAndPostcode;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressAndPostcode {
        private String postcode;
        private String address;
    }
}

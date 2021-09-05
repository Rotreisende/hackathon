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
import ru.sstu.rosatom.entity.dto.dadata.DaDaDataEntityData;
import ru.sstu.rosatom.entity.dto.dadata.DaDataFio;
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
            DaDaDataEntityData data = daDataResponse.getBody().getSuggestions().get(0).getData();
            addressAndPostcode.setAddress(data.getAddress().getValue());
            addressAndPostcode.setPostcode(data.getAddress().getData().getPostal_code());
            addressAndPostcode.setName(daDataResponse.getBody().getSuggestions().get(0).getUnrestricted_value());
            if (data.getManagement() != null) {
                addressAndPostcode.setName(data.getManagement().getName());
            } else if (data.getFio() != null) {
                DaDataFio daDataFio = data.getFio();
                addressAndPostcode.setName(String.format("%s %s %s", daDataFio.getSurname(), daDataFio.getName(), daDataFio.getPatronymic()));
            }
        }
        return addressAndPostcode;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressAndPostcode {
        private String postcode;
        private String address;
        private String ceo;
        private String name;
    }
}

package ru.sstu.rosatom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sstu.rosatom.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.dto.rusprofile.RusProfileRequest;
import ru.sstu.rosatom.dto.rusprofile.RusProfileResponse;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RusProfileService {

    public final RestTemplate restTemplate;

    private final String SEARCH_URL = "https://www.rusprofile.ru/ajax_auth.php?action=search_advanced";

    public List<RusProfileEntity> getEntitiesByOkpd2(String okpd2) {
        RusProfileRequest request = new RusProfileRequest();
        request.setOkved(List.of(okpd2));
        HttpEntity<RusProfileRequest> requestEntity = new HttpEntity<>(request);
        RusProfileResponse response = restTemplate.exchange(SEARCH_URL, HttpMethod.POST, requestEntity, RusProfileResponse.class).getBody();
        if (Objects.nonNull(response)) {
            return response.getResult();
        }
        return null;
    }
}

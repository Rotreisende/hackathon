package ru.sstu.rosatom.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sstu.rosatom.dto.EntityRequestBody;
import ru.sstu.rosatom.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.service.RusProfileService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RusProfileController {

    private final RusProfileService rusProfileService;

    @PostMapping("/request")
    public List<RusProfileEntity> getEntities(@RequestBody EntityRequestBody requestBody) {
        return rusProfileService.getEntitiesByOkpd2(requestBody.getCode());
    }
}

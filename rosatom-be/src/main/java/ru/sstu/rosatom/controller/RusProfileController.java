package ru.sstu.rosatom.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sstu.rosatom.entity.Request;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;
import ru.sstu.rosatom.entity.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.repository.RequestRepo;
import ru.sstu.rosatom.service.RequestService;
import ru.sstu.rosatom.service.RusProfileService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RusProfileController {

    private final RusProfileService rusProfileService;
    private final RequestService requestService;


    @PostMapping("/request")
    public List<RusProfileEntity> getEntities(@RequestBody EntityRequestBody requestBody) {
        return rusProfileService.getEntitiesByOkpd2(requestBody.getCode());
    }

    @PostMapping("/requests")
    public Request save(@RequestBody EntityRequestBody requestBody) {
        return requestService.save(requestBody);
    }

    @GetMapping("/requests")
    public List<Request> getRequests() {
        return requestService.requestList();
    }

}

package ru.sstu.rosatom.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sstu.rosatom.entity.Region;
import ru.sstu.rosatom.entity.Request;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;
import ru.sstu.rosatom.service.RegionService;
import ru.sstu.rosatom.service.RequestService;
import ru.sstu.rosatom.service.RusProfileService;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RusProfileController {

    private final RusProfileService rusProfileService;
    private final RequestService requestService;
    private final RegionService regionService;

    @PostMapping("/requests")
    public Integer save(@RequestBody EntityRequestBody requestBody) {
        return requestService.save(requestBody);
    }

    @GetMapping("/requests")
    public List<Request> getRequests() {
        return requestService.requestList();
    }

    @GetMapping("/requests/{id}")
    public Request get(@PathVariable("id") Integer id) {
        return requestService.getById(id);
    }


    @GetMapping("/regions")
    public List<Region> get() {
        return regionService.getRegions();
    }

}

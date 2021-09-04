package ru.sstu.rosatom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Region;
import ru.sstu.rosatom.repository.RegionRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {


    public final RegionRepo regionRepo;

    public List<Region> getRegions(){
        return regionRepo.findAll();
    }

    public Region getTittleByRegion(String code){
        return regionRepo.findTitleByCode(code);
    }
}

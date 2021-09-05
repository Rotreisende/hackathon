package ru.sstu.rosatom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Producer;
import ru.sstu.rosatom.entity.dto.nalog.NalogEntity;
import ru.sstu.rosatom.entity.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.repository.ProducerRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepo producerRepo;

    public static Producer convert(RusProfileEntity rusProfileEntity) {
        return Producer.builder()
                .name(rusProfileEntity.getName())
                .ceo_name(rusProfileEntity.getCeo_name())
                .address(rusProfileEntity.getAddress())
                .inn(rusProfileEntity.getInn())
                .ogrn(rusProfileEntity.getOgrn())
                .okved_descr(rusProfileEntity.getOkved_descr())
                .region(rusProfileEntity.getRegion())
                .reg_date(rusProfileEntity.getReg_date())
                .main_okved_id(rusProfileEntity.getMain_okved_id())
                .email(null)
                .phone(null)
                .build();

    }

    private static Producer convert(NalogEntity nalogEntity) {
        return Producer.builder()
                .name(nalogEntity.getName_ex())
                .ceo_name(nalogEntity.getName_ex())
                .address(String.format("%s %s, %s %s", nalogEntity.getAreaname(), nalogEntity.getAreatype(), nalogEntity.getLocalitytype(), nalogEntity.getLocalityname()))
                .inn(nalogEntity.getInn())
                .ogrn(nalogEntity.getOgrn())
                .okved_descr(nalogEntity.getOkved1name())
                .region(nalogEntity.getRegioncode())
                .reg_date(nalogEntity.getDtregistry())
                .main_okved_id(nalogEntity.getOkved1())
                .email(nalogEntity.getEmail())
                .phone(nalogEntity.getPhone())
                .token(nalogEntity.getToken())
                .build();
    }

    public static List<Producer> convertRusProfile(List<RusProfileEntity> rusProfileEntities) {
        return rusProfileEntities.stream().map(ProducerService::convert).collect(Collectors.toList());

    }

    public static List<Producer> convertNalogEntity(List<NalogEntity> nalogEntities) {
        return nalogEntities.stream().map(ProducerService::convert).collect(Collectors.toList());
    }
}

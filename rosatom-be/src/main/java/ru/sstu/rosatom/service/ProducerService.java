package ru.sstu.rosatom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Producer;
import ru.sstu.rosatom.entity.dto.nalog.NalogEntity;
import ru.sstu.rosatom.entity.dto.rusprofile.RusProfileEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerService {

    @Autowired
    private NonStaticUtils nonStaticUtils;

    public static Producer convert(RusProfileEntity rusProfileEntity) {
        return Producer.builder()
                .name(rusProfileEntity.getName())
                .ceo_name(rusProfileEntity.getCeo_name())
                .inn(rusProfileEntity.getInn())
                .ogrn(rusProfileEntity.getOgrn())
                .okved_descr(rusProfileEntity.getOkved_descr())
                .region(rusProfileEntity.getRegion())
                .reg_date(rusProfileEntity.getReg_date())
                .main_okved_id(rusProfileEntity.getMain_okved_id())
                .build();

    }

    private static Producer convert(NalogEntity nalogEntity) {
        return Producer.builder()
                .name(nalogEntity.getName_ex())
                .inn(nalogEntity.getInn())
                .ogrn(nalogEntity.getOgrn())
                .okved_descr(nalogEntity.getOkved1name())
                .region(nalogEntity.getRegioncode())
                .reg_date(nalogEntity.getDtregistry())
                .main_okved_id(nalogEntity.getOkved1())
                .token(nalogEntity.getToken())
                .build();
    }

    public List<Producer> convertRusProfile(List<RusProfileEntity> rusProfileEntities) {
        return rusProfileEntities.stream().map(ProducerService::convert).collect(Collectors.toList());

    }

    public List<Producer> convertNalogEntity(List<NalogEntity> nalogEntities) {
        List<Producer> producers = nalogEntities.stream().map(ProducerService::convert).collect(Collectors.toList());
        for (Producer producer : producers) {
            NonStaticUtils.AddressAndPostcode addressAndPostcode = nonStaticUtils.findInDaData(producer.getInn());
            producer.setAddress(addressAndPostcode.getAddress());
            producer.setPostcode(addressAndPostcode.getPostcode());
            producer.setCeo_name(addressAndPostcode.getCeo());
            producer.setName(addressAndPostcode.getName());
        }
        return producers;
    }
}
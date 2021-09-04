package ru.sstu.rosatom.entity.dto.nalog;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NalogEntity {
    private Long id;
    private String ogrn;
    private String inn;
    private String phone;
    private String email;
    private Long isNew;
    private Long category;
    private String regioncode;
    private String dtregistry;
    private String nptype;
    //!!!!
    private String okved1;
    private String okved1name;
    private String areaname;
    private String areatype;
    private String localitytype;
    private String localityname;
    private String name_ex;
    private Long has_licenses;
    private Long has_contracts;
    private Long is_hitech;
    private Long is_partnership;
    private Long pr_soc;
    private Long is_pp;
    private Long cnt;
    private String token;
}

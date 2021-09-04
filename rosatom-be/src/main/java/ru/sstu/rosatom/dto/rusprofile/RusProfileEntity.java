package ru.sstu.rosatom.dto.rusprofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RusProfileEntity {
    private String name;
    private String raw_name;
    private Long many_ceo;
    private String link;
    private String ogrn;
    private String raw_ogrn;
    private String inn;
    private String region;
    private String address;
    private Long inactive;
    private Long status_extended;
    private String ceo_name;
    private String ceo_type;
    private String snippet_string;
    private String snippet_type;
    private String status_code;
    private String svprekrul_date;
    private String main_okved_id;
    private String okved_descr;
    private String authorized_capital;
    private String reg_date;
    private String okpo;
    private String url;
}

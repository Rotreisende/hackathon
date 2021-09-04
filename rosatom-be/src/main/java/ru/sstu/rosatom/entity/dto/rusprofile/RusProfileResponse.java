package ru.sstu.rosatom.entity.dto.rusprofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RusProfileResponse {

    private Long ul_count;
    private Long ip_count;
    private Long total_count;
    private List<RusProfileEntity> result;

}

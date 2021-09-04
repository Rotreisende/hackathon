package ru.sstu.rosatom.entity.dto.nalog;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NalogResponse {

    private Long pageCount;
    private String dtQueryEnd;
    private Long page;
    private Long pageSize;
    private List<NalogEntity> data;
    private String dtQueryBegin;
    private Boolean queryCount;
    private Long rowCount;
    private Long rowLimit;
    private Long queryTime;
}

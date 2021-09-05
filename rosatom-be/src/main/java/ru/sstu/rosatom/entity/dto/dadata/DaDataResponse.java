package ru.sstu.rosatom.entity.dto.dadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaDataResponse {
    List<DaDataEntity> suggestions;
}

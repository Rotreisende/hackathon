package ru.sstu.rosatom.entity.dto.dadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaDaDataEntityData {

    private DaDataAdressEntity address;
    private DaDataManagement management;
    private DaDataFio fio;
}

package com.shirayev.arithmetic_container.servisies;

import com.shirayev.arithmetic_container.dto.EMeasurementType;
import com.shirayev.arithmetic_container.dto.Request;
import org.springframework.stereotype.Service;

@Service
public class TanService {
    public Double tan(Request request) {
        EMeasurementType type = EMeasurementType.valueOf(request.getMeasurementType());

        return type.equals(EMeasurementType.RADIAN) ?
                Math.tan(request.getValue()) : Math.tan(request.getValue() * (Math.PI / 180));
    }
}

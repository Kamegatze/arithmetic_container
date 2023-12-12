package com.shirayev.arithmetic_container.servisies;

import com.shirayev.arithmetic_container.dto.EMeasurementType;
import com.shirayev.arithmetic_container.dto.Request;
import org.springframework.stereotype.Service;

@Service
public class CotService {
    public Double cot(Request request) {
        EMeasurementType type = EMeasurementType.valueOf(request.getMeasurementType());

        return type.equals(EMeasurementType.RADIAN) ?
                1 / Math.tan(request.getValue()) : 1 / Math.tan(request.getValue() * (Math.PI / 180));
    }
}

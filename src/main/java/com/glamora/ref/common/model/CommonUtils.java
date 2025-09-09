package com.glamora.ref.common.model;


import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CommonUtils {
    public ResponseModel createResponseModel(String code, String message) {
        return ResponseModel.create(code, message);
    }

    public ResponseModel createResponseModel(String code, String message, Object data) {
        return ResponseModel.create(code, message, data);
    }

    public void setResponseModel(ResponseModel responseModel, String code, String message) {
        this.setResponseModel(responseModel, code, message, (Object)null);
    }

    public void setResponseModel(ResponseModel responseModel, String code, String message, Object data) {
        responseModel.setCode(code);
        responseModel.setMessage(message);
        responseModel.setData(data);
    }

    public double[] convertListToArray(Collection<Double> values) {
        return values == null ? new double[0] : values.stream().mapToDouble(Double::doubleValue).toArray();
    }
}


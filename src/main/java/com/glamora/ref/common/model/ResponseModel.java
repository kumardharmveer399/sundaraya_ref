
package com.glamora.ref.common.model;


import lombok.Generated;


public class ResponseModel<T> {
    private T data;
    private String message;
    private String code;

    public ResponseModel(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseModel create(String code, String message, T data) {
        return new ResponseModel(code, message, data);
    }

    public static ResponseModel create(String code, String message) {
        return new ResponseModel(code, message, (Object)null);
    }

    @Generated
    public T getData() {
        return this.data;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public void setData(final T data) {
        this.data = data;
    }

    @Generated
    public void setMessage(final String message) {
        this.message = message;
    }

    @Generated
    public void setCode(final String code) {
        this.code = code;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseModel)) {
            return false;
        } else {
            ResponseModel<?> other = (ResponseModel)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ResponseModel;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = String.valueOf(this.getData());
        return "ResponseModel(data=" + var10000 + ", message=" + this.getMessage() + ", code=" + this.getCode() + ")";
    }
}

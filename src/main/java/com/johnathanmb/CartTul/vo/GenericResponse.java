package com.johnathanmb.CartTul.vo;

import com.johnathanmb.CartTul.util.CartConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private Object data;

    /**
     * Set Success Response
     */
    public void setSuccessResponse() {
        this.code = CartConstants.SUCCESS_CODE;
        this.message = CartConstants.SUCCESS_MESSAGE;
    }

    /**
     * Set Error Response
     */
    public void setErrorResponse() {
        this.code = CartConstants.ERROR_CODE;
        this.message = CartConstants.ERROR_MESSAGE;
    }

    public void setErrorResponse(Exception e) {
        this.setErrorResponse();
        this.setMessage(e.getMessage());
        this.setData(null);
    }

}

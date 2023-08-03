package com.master.modular.business.base.response;

import com.master.core.constants.base.BaseConstants;
import lombok.Data;

/**
 * @author wangyue
 * @date 2023/8/1
 */
@Data
public class ErrorResult extends ResponseResult {
    ErrorResult(){
        super(Boolean.FALSE, BaseConstants.ERROR_CODE, BaseConstants.ERROR_MESSAGE, null);
    }
    ErrorResult(String message){
        super(Boolean.FALSE, BaseConstants.ERROR_CODE, message, null);
    }
}

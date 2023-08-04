package com.master.modular.business.base.response;

import com.master.core.constants.base.BaseConstants;
import lombok.Data;

/**
 * @author wangyue
 * @date 2023/8/1
 */
@Data
public class SuccessResult extends ResponseResult {
    public SuccessResult() {
        super(Boolean.TRUE, BaseConstants.SUCCESS_CODE, BaseConstants.SUCCESS_MESSAGE, null);
    }

    public SuccessResult(String message, Object data) {
        super(Boolean.TRUE, BaseConstants.SUCCESS_CODE, message, data);
    }

    public SuccessResult(Object data) {
        super(Boolean.TRUE, BaseConstants.SUCCESS_CODE, BaseConstants.SUCCESS_MESSAGE, data);
    }
}

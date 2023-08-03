package com.master.modular.business.base.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wangyue
 * @date 2023/8/3
 */
@Data
public class BaseRequest {
    private Integer page;
    private Integer pageCount;
    private LocalDateTime createTime;
    private Long createUser;
    private LocalDateTime updateTime;
    private Long updateUser;
}

package com.chaosquark.backend.common.tkmapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName: MyTkMapper
 * @Description: 自定义接口集成tkmapper
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/18/018 14:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/18/018 14:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface MyTkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

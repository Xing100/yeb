package com.xxxx.server.service;
//27
//34
//51
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xingzhishan
 * @since 2022-03-17
 */

public interface IMenuService extends IService<Menu> {


    /**
     *根据用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenuWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}

package com.xmsmartcity.mapper;

import com.xmsmartcity.pojo.TsRole;

import java.util.List;

public interface TsRoleMapper {


    int deleteByPrimaryKey(int id);

    int insert(TsRole record);

    int insertSelective(TsRole record);

    TsRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsRole record);

    int updateByPrimaryKey(TsRole record);

    List<TsRole> findAllroles();

    List<TsRole> findRolesByRoleName(String rolename);

    TsRole selectByroleCode(String rolecode);

    /**
     * 全表查询
     * @return
     */
    public List<TsRole> selectAll();
    /**
     * 根据主键查数据,给多对一用
     * @param id
     * @return
     */

    public TsRole select(Integer id);




}
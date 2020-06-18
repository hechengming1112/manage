package admin.com.student.generator.mapper;


import admin.com.student.generator.domain.GenTable;

/**
 * 业务 数据层
 *
 * @author hecm
 */
public interface GenTableMapper {

    /**
     * 查询表名称业务信息
     *
     * @param tableName 表名称
     * @return 业务信息
     */
    public GenTable selectGenTableByName(String tableName);


}
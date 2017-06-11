package DAO;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface BaseDao {
    public Object persist(Object bean);

    public void delete(Object bean);

    public void update(Object bean);

    public Object findById(int i, Class clazz);

    public List findByHql(String hql);

    public List findAll(String tableName);

    public List findByProperties(String tableName, String[] name, Object[] values);

    public List findByPage(String tableName, int page, int pageSize);

    public List findByPropertiesAndPages(String tableName, String[] name, Object[] values, int page, int pageSize);

    public void clean(String tableName);
}

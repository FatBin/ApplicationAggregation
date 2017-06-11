package DaoImpl;

import Connection.DBconnection;
import DAO.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by mm on 2016/10/6.
 */
public class BaseDaoImpl implements BaseDao {

    public Object persist(Object bean) {
        try {
            Object result=null;
            Session session= DBconnection.getSession();
            try {
                session.save(bean);
                Transaction transaction=session.beginTransaction();
                transaction.commit();
                result=bean;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                DBconnection.closeSession(session);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void delete(Object bean) {
        try {
            Session session= DBconnection.getSession();
            try {
                session.delete(bean);
                Transaction transaction=session.beginTransaction();
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(Object bean) {
        try {
            Session session=DBconnection.getSession();
            try {
                session.update(bean);
                Transaction transaction=session.beginTransaction();
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object findById(int i,Class clazz) {
        try {
            Session session=DBconnection.getSession();
            Object result=null;
            try {
                result=session.get(clazz,i);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                session.close();
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List findByHql(String hql) {
        Session session=DBconnection.getSession();
        List result=null;
        try {
            result=session.createQuery(hql).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public List findAll(String tableName) {
        String hql="from "+tableName;
        Session session=DBconnection.getSession();
        List result=null;
        try {
            result=session.createQuery(hql).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public List findByProperties(String tableName, String[] name, Object[] values) {
        String hql="from "+tableName+" t where";
        for (int i=0;i<name.length;i++){
            hql=hql+" t."+name[i]+"=?";
            if (i!=(name.length-1)){
                hql+=" and";
            }
        }
        List result=null;

        Session session=DBconnection.getSession();
        try {
            Query query=session.createQuery(hql);
            for (int i=0;i<values.length;i++){
                query.setParameter(i,values[i]);
            }
            result=query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public List findByPage(String tableName, int page, int pageSize) {
        String hql="from "+tableName;
        List result=null;
        Session session=DBconnection.getSession();
        try {
            result=session.createQuery(hql).setFirstResult(page).setMaxResults(pageSize).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public List findByPropertiesAndPages(String tableName, String[] name, Object[] values, int page, int pageSize) {
        String hql="from "+tableName+" t where";
        for (int i=0;i<name.length;i++){
            hql=hql+" t."+name[i]+"=?";
            if (i!=(name.length-1)){
                hql+=" and";
            }
        }
        List result=null;

        System.out.println(hql);
        Session session=DBconnection.getSession();
        try {
            Query query=session.createQuery(hql);
            for (int i=0;i<values.length;i++){
                query.setParameter(i,values[i]);
            }
            result=query.setFirstResult(page).setMaxResults(pageSize).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public void clean(String tableName) {
        try {
            String hql="delete from "+tableName+" where 1=1";
            Session session=DBconnection.getSession();
            try {
                Transaction transaction=session.beginTransaction();
                Query query=session.createQuery(hql);
                query.executeUpdate();
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.demomodel.P7.beanInit.TBean.TService;

import org.springframework.beans.factory.annotation.Autowired;

import com.demomodel.P7.beanInit.TBean.Tdao.IDao;
//@1：这个地方要注意了，上面使用了@Autowired，来注入IDao对象
public class BaseService<T> {
    @Autowired
    private IDao<T> dao; //@1
 
    public IDao<T> getDao() {
        return dao;
    }
 
    public void setDao(IDao<T> dao) {
        this.dao = dao;
    }
}
/**
 * 2016/10/20 16:45:47 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.mybatis_dao_imp 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.salesman.dao;

import com.dyb.platforms.fixfunds.services.business.salesman.entity.Salesman;
import com.dyb.platforms.fixfunds.services.utils.core.dao.IbatisBaseStatement;
import com.dyb.platforms.fixfunds.services.utils.core.dao.IbatisDataDAOImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 业务员信息 Ibatis Dao 实现
 * Created by lenovo on 2016/10/20.
 */
@Repository
public class SalesmanDao extends IbatisDataDAOImpl<Salesman, String> implements ISalesmanDao {

    private IbatisBaseStatement ibatisBaseStatement;

    // dao的spring配置
    /*
    <bean id="salesmanDao" class="com.dyb.platforms.fixfunds.services.business.salesman.entity.daos.SalesmanDao">
        <constructor-arg name="sqlSession" ref="sqlSession"/>
    </bean>
    */

    /**
     * 用Ibatis会话创建Dao
     * @param sqlSession Ibatis会话
     */
    @Autowired
    public SalesmanDao(SqlSessionTemplate sqlSession){
        super(sqlSession);
    }

	@Override
	protected IbatisBaseStatement getIbatisBaseStatement() {
		if (ibatisBaseStatement == null) {
			ibatisBaseStatement = new IbatisBaseStatement();
			ibatisBaseStatement.setInsertStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.insertObject");
			ibatisBaseStatement.setUpdateStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.updateObject");
			ibatisBaseStatement.setDeleteStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.deleteObject");
			ibatisBaseStatement.setGetHasDetailStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.getDetailObject");
			ibatisBaseStatement.setGetNoDetailStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.getBaseObject");
			ibatisBaseStatement.setWhereDeleteStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.deleteObjectByWhere");
			ibatisBaseStatement.setQueryCountStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.queryCount");
			ibatisBaseStatement.setQueryHasDetailListStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.queryDetailList");
			ibatisBaseStatement.setQueryNoDetailListStatementId("com.dyb.platforms.fixfunds.services.business.salesman.dao.ISalesmanDao.queryBaseList");
		}
		return ibatisBaseStatement;
	}

}
/**
 * 2016/9/27 19:52:15 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.mybatis_dao_imp 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.turnover.dao;

import com.dyb.platforms.fixfunds.services.business.turnover.entity.Turnover;
import com.dyb.platforms.fixfunds.services.utils.core.dao.IbatisBaseStatement;
import com.dyb.platforms.fixfunds.services.utils.core.dao.IbatisDataDAOImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 营业额 Ibatis Dao 实现
 * Created by lenovo on 2016/09/27.
 */
@Repository
public class TurnoverDao extends IbatisDataDAOImpl<Turnover, String> implements ITurnoverDao {

    private IbatisBaseStatement ibatisBaseStatement;

    // dao的spring配置
    /*
    <bean id="turnoverDao" class="com.dyb.platforms.fixfunds.services.business.turnover.entity.daos.TurnoverDao">
        <constructor-arg name="sqlSession" ref="sqlSession"/>
    </bean>
    */

    /**
     * 用Ibatis会话创建Dao
     * @param sqlSession Ibatis会话
     */
    @Autowired
    public TurnoverDao(SqlSessionTemplate sqlSession){
        super(sqlSession);
    }

	@Override
	protected IbatisBaseStatement getIbatisBaseStatement() {
		if (ibatisBaseStatement == null) {
			ibatisBaseStatement = new IbatisBaseStatement();
			ibatisBaseStatement.setInsertStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.insertObject");
			ibatisBaseStatement.setUpdateStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.updateObject");
			ibatisBaseStatement.setDeleteStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.deleteObject");
			ibatisBaseStatement.setGetHasDetailStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.getDetailObject");
			ibatisBaseStatement.setGetNoDetailStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.getBaseObject");
			ibatisBaseStatement.setWhereDeleteStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.deleteObjectByWhere");
			ibatisBaseStatement.setQueryCountStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.queryCount");
			ibatisBaseStatement.setQueryHasDetailListStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.queryDetailList");
			ibatisBaseStatement.setQueryNoDetailListStatementId("com.dyb.platforms.fixfunds.services.business.turnover.dao.ITurnoverDao.queryBaseList");
		}
		return ibatisBaseStatement;
	}

}

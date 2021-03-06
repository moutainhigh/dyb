/**
 * 2016/10/10 10:33:57 lenovo created.
 * Generated by Caven.CodeBuilder (funiJava.mybatis_dao_imp 1.0).
 */

package com.dyb.platforms.fixfunds.services.business.invoiceapply.dao;

import com.dyb.platforms.fixfunds.services.business.invoiceapply.entity.InvoiceApply;
import com.dyb.platforms.fixfunds.services.utils.core.dao.IbatisBaseStatement;
import com.dyb.platforms.fixfunds.services.utils.core.dao.IbatisDataDAOImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 让利款发票申请 Ibatis Dao 实现
 * Created by lenovo on 2016/10/10.
 */
@Repository
public class InvoiceApplyDao extends IbatisDataDAOImpl<InvoiceApply, String> implements IInvoiceApplyDao {

    private IbatisBaseStatement ibatisBaseStatement;

    // dao的spring配置
    /*
    <bean id="invoiceApplyDao" class="com.dyb.platforms.fixfunds.services.business.invoiceapply.entity.daos.InvoiceApplyDao">
        <constructor-arg name="sqlSession" ref="sqlSession"/>
    </bean>
    */

    /**
     * 用Ibatis会话创建Dao
     * @param sqlSession Ibatis会话
     */
    @Autowired
    public InvoiceApplyDao(SqlSessionTemplate sqlSession){
        super(sqlSession);
    }

	@Override
	protected IbatisBaseStatement getIbatisBaseStatement() {
		if (ibatisBaseStatement == null) {
			ibatisBaseStatement = new IbatisBaseStatement();
			ibatisBaseStatement.setInsertStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.insertObject");
			ibatisBaseStatement.setUpdateStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.updateObject");
			ibatisBaseStatement.setDeleteStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.deleteObject");
			ibatisBaseStatement.setGetHasDetailStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.getDetailObject");
			ibatisBaseStatement.setGetNoDetailStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.getBaseObject");
			ibatisBaseStatement.setWhereDeleteStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.deleteObjectByWhere");
			ibatisBaseStatement.setQueryCountStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.queryCount");
			ibatisBaseStatement.setQueryHasDetailListStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.queryDetailList");
			ibatisBaseStatement.setQueryNoDetailListStatementId("com.dyb.platforms.fixfunds.services.business.invoiceapply.dao.IInvoiceApplyDao.queryBaseList");
		}
		return ibatisBaseStatement;
	}

}

package com.dyb.platforms.fixfunds.merchant.controller.web.commodity;

import com.dyb.platforms.fixfunds.services.business.commodity.entity.Commodity;
import com.dyb.platforms.fixfunds.services.business.commodity.service.ICommodityService;
import com.dyb.platforms.fixfunds.services.utils.DybUtils;
import com.dyb.platforms.fixfunds.services.utils.core.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/7/1.
 */
@RestController
@RequestMapping(value = "/web/merchant/commodity")
public class WebCommodityController extends BaseController {

    public Logger log = Logger.getLogger(WebCommodityController.class);//日志

    @Autowired
    private ICommodityService commodityService;

    /**
     * 商品添加
     * @param request
     * @param response
     * @param commodity 商品信息
     */
    @RequestMapping(value = "/addCommodity")
    public void addCommodity(HttpServletRequest request,HttpServletResponse response,Commodity commodity) {
        log.info("商品添加");
        if (commodity==null)
            validationResultJSONP(request,response,1001,"商品信息不能为空");
        commodity.setAccountCode(DybUtils.getCurrentAccount(request).getAccountCode());
        Commodity temp=commodityService.createCommodity(commodity);
        if (temp==null){
            validationResultJSONP(request,response,1001,"添加失败");
        }else {
            resultJSONP(request,response,"添加成功");
        }
    }

    /**
     * 修改商品信息
     * @param request
     * @param response
     * @param commodity 修改
     */
    @RequestMapping(value = "/updateCommodity")
    public void updateCommodity(HttpServletRequest request,HttpServletResponse response,Commodity commodity){
        log.info("商品修改");
        if (commodity==null)
            validationResultJSONP(request,response,1001,"商品信息不能为空");
        Commodity updateCommodity = commodityService.getCommodityByCode(commodity.getCommodityCode());
        updateCommodity.setName(commodity.getName());
        updateCommodity.setCommodityNum(commodity.getCommodityNum());
        updateCommodity.setSpecifications(commodity.getSpecifications());
        updateCommodity.setPrice(commodity.getPrice());
        Commodity temp=commodityService.modifyCommodity(updateCommodity);
        if (temp==null){
            validationResultJSONP(request,response,1001,"修改失败");
        }else {
            resultJSONP(request,response,"修改成功");
        }
    }

    /**
     * 根据code删除商品信息
     * @param request
     * @param response
     * @param commodityCode 商品code
     */
    @RequestMapping(value = "/deleteCommodity")
    public void deleteCommodity(HttpServletRequest request,HttpServletResponse response,String commodityCode){
        log.info("商品删除");
        if (DybUtils.isEmptyOrNull(commodityCode))
            validationResultJSONP(request,response,1001,"商品删除时，code不能为空");
        boolean flag=commodityService.deleteCommodity(commodityCode);
        if (flag)
            resultJSONP(request,response,"删除成功");
        validationResultJSONP(request,response,1001,"删除失败");
    }

    /**
     * 批量删除商品信息
     * @param request
     * @param response
     * @param commodityCodeList 商品code集合（格式：20108196524,2100254565,20132645....）
     */
    @RequestMapping(value = "/deleteCommodityList")
    public void deleteCommodityList(HttpServletRequest request,HttpServletResponse response,String commodityCodeList){
        log.info("批量删除商品信息");
        if (DybUtils.isEmptyOrNull(commodityCodeList))
            validationResultJSONP(request,response,1001,"批量删除商品信息时，commodityCodeList不能为空");

        boolean flag=commodityService.deleteCommodityList(commodityCodeList.split(","));
        if (flag)
            resultJSONP(request,response,"删除成功");
        validationResultJSONP(request,response,1001,"删除失败");
    }

    /**
     * 根据code查询商品信息
     * @param request
     * @param response
     * @param commodityCode 商品code
     */
    @RequestMapping(value = "/getCommodityByCode")
    public void getCommodityByCode(HttpServletRequest request,HttpServletResponse response,String commodityCode){
        log.info("根据code查询商品信息");
        if (DybUtils.isEmptyOrNull(commodityCode))
            validationResultJSONP(request,response,1001,"根据code查询商品信息时，code不能为空");
        Commodity commodity=commodityService.getCommodityByCode(commodityCode);
        if (commodity==null)
            validationResultJSONP(request,response,1001,"找不到此商品信息");
        resultJSONP(request,response,commodity);
    }

}
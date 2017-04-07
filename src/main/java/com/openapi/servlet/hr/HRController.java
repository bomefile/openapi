package com.openapi.servlet.hr;


import com.google.inject.Inject;
import com.openapi.annotation.mvc.Controller;
import com.openapi.entity.hr.*;
import com.openapi.service.hr.HrSetIdService;
import com.openapi.servlet.BaseServlet;
import com.openapi.util.BatchHeader;
import com.openapi.util.ResponseBatchDetailType;
import com.openapi.util.ResponseJsonRender;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.HotspotRuntimeMBean;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;


/**
 * @author:wzn Description: esb推送hr数据接收接口
 * Date: Created in 2016/12/28.
 * Modified By:
 */
@Controller
@Path("/hjh")
//@Consumes({"application/xml", "application/json"})
@Produces(MediaType.TEXT_PLAIN)
public class HRController extends BaseServlet {
    private static final Logger logger = LoggerFactory.getLogger(HRController.class);


    @Inject
    HrSetIdService hrSetIdService;
    /**
     * 1.ESB集合ID接口同步
     *
     * @return json
     *
     */
    @POST
    @Path("/Set/Ms/ProxyService/MsEsbSetIdSyncTopicProxy")
    public ResponseJsonRender msEsbSetIdSyncTopicProxy(DataBlockEntity<HrSetIdEntity> entity) {
        ResponseJsonRender render = new ResponseJsonRender("ESB集合ID接口同步成功");
        logger.info(JSONObject.fromObject(entity).toString());
        Integer i = hrSetIdService.insertBatch(entity);
        return render;
    }


    /**
     * 2.ESB公司接口同步
     *
     * @return json
     */
    @POST
    @Path("/Company/Ms/ProxyService/MsEsbCompanySyncTopicProxy")
    public String msEsbCompanySyncTopicProxy(DataBlockEntity<HrCmpanyEntity> entity) {

        return "S";
    }

    /**
     * 3.ESB部门接口同步
     *
     * @return json
     */
    @POST
    @Path("/Department/Ms/ProxyService/MsEsbDepartmentSyncTopicProxy")
    public String msEsbDepartmentSyncTopicProxy(DataBlockEntity<HrDpartmentEntity> entity) {


        return "S";
    }

    /**
     * 4.ESB部门树结构接口同步
     *
     * @return json
     */
    @POST
    @Path("/Department/Ms/ProxyService/MsEsbDepartmentTreeSyncTopicProxy")
    public String msEsbDepartmentTreeSyncTopicProxy(DataBlockEntity<HrDpartmentTreeEntity> entity) {


        return "S";
    }

    /**
     * 5.ESB岗位信息接口同步
     *
     * @return json
     */
    @POST
    @Path("/Position/Ms/ProxyService/MsEsbPositionSyncTopicProxy")
    public String msEsbPositionSyncTopicProxy(DataBlockEntity<HrPositionEntity> entity) {

        return "S";
    }

    /**
     * 6.ESB岗位与部门关系接口同步
     *
     * @return json
     */
    @POST
    @Path("/Position/Ms/ProxyService/MsEsbPositionAndDeptSyncTopicProxy")
    public String msEsbPositionAndDeptSyncTopicProxy(DataBlockEntity<HrPositionAndDeptEntity> entity) {

        return "S";
    }

    /**
     * 7.ESB岗位树结构接口同步
     *
     * @return json
     */
    @POST
    @Path("/Position/Ms/ProxyService/MsEsbPositionTreeSyncTopicProxy")
    public String msEsbPositionTreeSyncTopicProxy(DataBlockEntity<HrPositionTreeEntity> entity) {

        return "S";
    }

    /**
     * 8.ESB职务接口同步
     *
     * @return json
     */
    @POST
    @Path("/Job/Ms/ProxyService/MsEsbJobSyncTopicProxy")
    public String msEsbJobSyncTopicProxy(DataBlockEntity<HrJobEntity> entity) {

        return "S";
    }

    /**
     * 9.ESB职务级别接口同步
     *
     * @return json
     */
    @POST
    @Path("/Job/Ms/ProxyService/MsEsbJobLevelSyncTopicProxy")
    public String msEsbJobLevelSyncTopicProxy(DataBlockEntity<HrJobLevelEntity> entity) {

        return "S";
    }

    /**
     * 10.ESB个人信息接口同步
     *
     * @return json
     */
    @POST
    @Path("/Employee/Ms/ProxyService/MsEsbEmployeeSyncTopicProxy")
    public String msEsbEmployeeSyncTopicProxy(DataBlockEntity<HrEmployeeEntity> entity) {

        return "S";
    }

    /**
     * 11.ESB员工职务接口同步
     *
     * @return json
     */
    @POST
    @Path("/Employee/Ms/ProxyService/MsEsbEmployeeJobSyncTopicProxy")
    public String msEsbEmployeeJobSyncTopicProxy(DataBlockEntity<HrEmployeeJobEntity> entity) {

        return "S";
    }

    /**
     * 12.ESB级联关系基础数据接口同步
     *
     * @return json
     */
    @POST
    @Path("/BasicData/Ms/ProxyService/MsEsbBasicDataSyncTopicProxy")
    public String msEsbBasicDataSyncTopicProxy(DataBlockEntity<HrBasicDataEntity> entity) {

        return "S";
    }

    /**
     * 13.ESB实体店信息接口同步
     *
     * @return json
     */
    @POST
    @Path("/Store/Ms/ProxyService/MsEsbStoreSyncTopicProxy")
    public String msEsbStoreSyncTopicProxy(DataBlockEntity<HrStoreEntity> entity) {

        return "S";
    }

    /**
     * 14.ESB离职信息接口同步
     *
     * @return json
     */
    @POST
    @Path("/Employee/Ms/ProxyService/MsEsbEmployeeQuitSyncTopicProxy")
    public String msEsbEmployeeQuitSyncTopicProxy(DataBlockEntity<HrEmployeeQuitEntity> entity) {

        return "S";
    }
}

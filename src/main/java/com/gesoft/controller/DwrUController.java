/**
 * 文件名称：DwrController.java
 * 版权所有：Copyright gesoft
 * 创建时间：2015年1月26日
 * 创 建 人：WCL (ln_admin@yeah.net)
 * 功能描述：
 **/
package com.gesoft.controller;

import com.gesoft.model.BaseModel;
import com.gesoft.model.DwrModel;
import com.gesoft.service.DwrService;
import com.gesoft.util.FileUtil;
import com.gesoft.util.SystemUtils;
import org.apache.commons.io.IOUtils;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WCL
 * @version v1.001
 * @since   v1.001
 */
@Controller
@RemoteProxy(name = "loadDwr")
public class DwrUController
{

	private static final Logger logger = LoggerFactory.getLogger(DwrUController.class);
	
	@Resource
	private DwrService dwrService;
	
	
	@RemoteMethod
	public Map<?, ?> loadCity()
	{
		Map<String, String> mRetMap = new LinkedHashMap<String, String>();
		mRetMap.put("1", "南京市");
		mRetMap.put("2", "合肥市");
		mRetMap.put("3", "沈阳市");
		return mRetMap;
	}
	
	
	/**
	 * 描述信息：DWR文件上传
	 * 创建时间：2015年2月5日 上午11:02:56
	 * @author WCL (ln_admin@yeah.net)
	 * @param uploadFile
	 * @param filedataFileName
	 * @param
	 * @return
	 */
	@RemoteMethod
	public String uploadFileInfo(InputStream uploadFile, String filedataFileName)
	{
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
		String basePath = "/upload/" + FileUtil.createFoldersByType(2);
		try
		{
			filedataFileName = SystemUtils.getCurrentSystemTime("yyyyMMddHHmmssSSS") + "_" + filedataFileName;
			String realpath = request.getSession().getServletContext().getRealPath("/") + "//" + basePath;
			//realpath = "/Volumes/MacintoshHD2/Project/java/yge/src/main/webapp"+ "//" + basePath;
			File savefile = new File(new File(realpath), filedataFileName);
			if (!savefile.getParentFile().exists())
			{
				savefile.getParentFile().mkdirs();
			}
			IOUtils.copy(uploadFile, new FileOutputStream(savefile));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "-1";
		}
		//return  request.getContextPath() + "/"+basePath + "/" + filedataFileName;
		return  basePath + "/" + filedataFileName;
	}  
	
	/**
	 * 描述信息：加载定制类型
	 * 创建时间：2015年2月4日 上午7:07:04
	 * @author WCL (ln_admin@yeah.net)
	 * @return
	 */
	@RemoteMethod
	public Map<?, ?> loadCustom()
	{
		LinkedHashMap<?, ?> mRetMap = null;
		try
		{
			mRetMap = dwrService.queryCustomInfo();
		}
		catch (Exception e)
		{
			logger.error("DwrUController loadCustom error：", e);
		}
		return mRetMap;
	}
	

	/**
	 * 描述信息：加载新闻类型
	 * 创建时间：2015年2月3日 下午11:37:58
	 * @author WCL (ln_admin@yeah.net)
	 * @return
	 */
	@RemoteMethod
	public Map<?, ?> loadNewType(int customId)
	{
		LinkedHashMap<?, ?> mRetMap = null;
		try
		{
			mRetMap = dwrService.queryNewsTypeInfo(customId);
		}
		catch (Exception e)
		{
			logger.error("DwrUController loadNewType error：", e);
		}
		return mRetMap;
	}
	
	
	/**
	 * 描述信息：加载经典案例类型
	 * 创建时间：2015年2月5日 上午9:45:11
	 * @author WCL (ln_admin@yeah.net)
	 * @param customId
	 * @return
	 */
	@RemoteMethod
	public Map<?, ?> loadCaseType(int customId)
	{
		LinkedHashMap<?, ?> mRetMap = null;
		try
		{
			mRetMap = dwrService.queryCaseTypeInfo(customId);
		}
		catch (Exception e)
		{
			logger.error("DwrUController loadCaseType error：", e);
		}
		return mRetMap;
	}


	@RemoteMethod
	public List<DwrModel> queryDictInfo(String dmbm)
	{
		List<DwrModel>  argFlys = null;
		try
		{
			argFlys = dwrService.queryDictInfo(dmbm);
		}
		catch (Exception e)
		{
			logger.error("DwrUController queryDictInfo error：", e);
		}
		return argFlys;
	}

	
	/**
	 * 描述信息：加载产品中心类型
	 * 创建时间：2015年2月5日 上午10:14:41
	 * @author WCL (ln_admin@yeah.net)
	 * @param customId
	 * @return
	 */
	@RemoteMethod
	public Map<?, ?> loadProduceType(int customId)
	{
		LinkedHashMap<?, ?> mRetMap = null;
		try
		{
			mRetMap = dwrService.queryProduceTypeInfo(customId);
		}
		catch (Exception e)
		{
			logger.error("DwrUController loadProduceType error：", e);
		}
		return mRetMap;
	}


	/**
	 * 根据业务类型加载商品信息
	 * @param businessId
	 * @return
	 */
	@RemoteMethod
	public List<DwrModel> queryGoodsInfo(int businessId)
	{
		List<DwrModel>  argFlys = null;
		try
		{
			BaseModel model = new BaseModel();
			model.setPage(businessId);
			argFlys = dwrService.queryGoodsInfo(model);
		}
		catch (Exception e)
		{
			logger.error("DwrUController queryDictInfo error：", e);
		}
		return argFlys;
	}
}

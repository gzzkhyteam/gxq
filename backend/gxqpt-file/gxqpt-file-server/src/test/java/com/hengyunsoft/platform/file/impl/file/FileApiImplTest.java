package com.hengyunsoft.platform.file.impl.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.platform.file.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.FileInputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * FileApiImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre> 14, 2018</pre>
 */
public class FileApiImplTest extends BaseTest {


    //https://www.cnblogs.com/0201zcr/p/5756642.html
    //
    @Before
    public void before() throws Exception {
        /*
        * 测试方法 6部曲
        * 1，针对每一个具体Controller层类，创建一个测试类，继承BaseTest
        * 2，对Controller层中每个public方法，增加一个测试方法（testXxx）
        * 3，构造模拟uri，并且 配置好参数，请求头等信息
        * 4，模拟执行请求
        * 5，对执行结果进行断言
        * 6，打印一些返回值 [可选]
        * */
    }

    @After
    public void after() throws Exception {
    }

    private Long id = 7998537761L;
    private Long folderId = -1L;
    String submittedFileName = "0703.mp3";

    @Test
    public void testGet() throws Exception {
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/file/get");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("id", String.valueOf(id));

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.data.id").value(1)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 接口的参数使用 @RequestParam 或者 没有注解的 的，用这种方式
     *
     * @throws Exception
     */
    @Test
    public void testFind() throws Exception {
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/file/page");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        //mockHsrBuilder.contentType(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("pageNo", "1");
        mockHsrBuilder.param("pageSize", "20");
        mockHsrBuilder.param("folderId", "-1");
        mockHsrBuilder.param("submittedFileName", "");
        mockHsrBuilder.param("dataType", "");

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);
        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(jsonPath("$.errcode").value(0));
        resultActions.andExpect(jsonPath("$.data").isNotEmpty());
        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        //resultActions.andDo();

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * Method: test1(@RequestBody FolderSaveDTO folderSaveDto)
     */
    @Test
    public void testTest1() throws Exception {

    }

    /**
     * Method: test2(OpenApiReq openApiReq, FilePageReqDTO filePageReqDTO)
     */
    @Test
    public void testTest2() throws Exception {

    }

    /**
     * Method: saveFolder(@RequestBody FolderSaveDTO folderSaveDto)
     */
    @Test
    public void testSaveFolder() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder =
                MockMvcRequestBuilders.post("/file/folder");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        JSONObject req = new JSONObject();
        req.put("submittedFileName", "单元测试创建的文件夹");
        req.put("parentId", "-1");
        req.put("orderNum", "1");
        mockHsrBuilder.content(req.toString());

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);
        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(jsonPath("$.errcode").value(0));
        resultActions.andExpect(jsonPath("$.data").isNotEmpty());
        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        //resultActions.andDo();

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        JSONObject res = JSON.parseObject(result);
        System.out.println("result = " + result);

        folderId = res.getLong("id");
    }

    /**
     * Method: saveUpload(@RequestParam(value = "folderId") Long folderId, HttpServletRequest request)
     */
    @Test
    public void testSaveUpload() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.fileUpload("/file/upload")
                .file(new MockMultipartFile("file", "1.jpg", "image/jpeg", new FileInputStream("F:\\testImg\\1.jpg")))
                .file(new MockMultipartFile("file", "1.txt", "image/jpeg", new FileInputStream("F:\\testImg\\1.txt")));
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("folderId", String.valueOf(folderId));

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);
        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(jsonPath("$.errcode").value(0));
        resultActions.andExpect(jsonPath("$.data").isNotEmpty());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * Method: update(@RequestBody FileUpdateDTO fileUpdateDTO)
     */
    @Test
    public void testUpdate() throws Exception {

    }

    /**
     * Method: remove(@RequestParam(value = "id") Long id)
     */
    @Test
    public void testRemove() throws Exception {

    }

    /**
     * Method: myFileList()
     */
    @Test
    public void testMyFileList() throws Exception {

    }

    /**
     * Method: ergodic(List<FileTreeDTO> fileList, List<FileTreeDTO> noteList, Long ergodicId)
     */
    @Test
    public void testErgodic() throws Exception {

    }

    /**
     * Method: saveTo(@RequestBody ShareSaveDTO shareSaveDTO)
     */
    @Test
    public void testSaveTo() throws Exception {

    }

    /**
     * Method: download(@RequestParam(value = "url") String url, @RequestParam(value = "filename") String filename, HttpServletResponse response)
     */
    @Test
    public void testDownload() throws Exception {

    }

    /**
     * Method: downloadPackage(@RequestParam(value = "ids[]") Long[] ids, HttpServletResponse response)
     */
    @Test
    public void testDownloadPackage() throws Exception {

    }

    /**
     * Method: uploadSpeed(@RequestParam(value = "folderId") Long folderId, @RequestParam(value = "exsistFileMd5 []") String[] exsistFileMd5, HttpServletRequest request)
     */
    @Test
    public void testUploadSpeed() throws Exception {

    }

    /**
     * Method: uploadMd5Check(String md5)
     */
    @Test
    public void testUploadMd5Check() throws Exception {

    }

    /**
     * Method: uploadSpeedAll(@RequestParam(value = "folderId") Long folderId, @RequestParam(value = "exsistFileMd5 []") String[] exsistFileMd5)
     */
    @Test
    public void testUploadSpeedAll() throws Exception {

    }


    /**
     * Method: setTreePaths(List<File> treeList, Long id, File father)
     */
    @Test
    public void testSetTreePaths() throws Exception {
/* 
try { 
   Method method = FileApiImpl.getClass().getMethod("setTreePaths", List<File>.class, Long.class, File.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }


} 

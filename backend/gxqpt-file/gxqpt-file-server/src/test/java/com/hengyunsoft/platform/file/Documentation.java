//package com.hengyunsoft.platform.file;
//
//
//import com.hengyunsoft.commons.context.CommonConstants;
//import io.github.robwin.markup.builder.MarkupLanguage;
//import io.github.robwin.swagger2markup.GroupBy;
//import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import springfox.documentation.staticdocs.SwaggerResultHandler;
//
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@AutoConfigureMockMvc
//@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class Documentation {
//    private String snippetDir = "target/generated-snippets";
//    private String outputDir = "target/markdown";
//    //private String outputDir = "target/asciidoc";
//    //private String indexDoc = "docs/asciidoc/index.adoc";
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @After
//    public void Test() throws Exception {
//        // 得到swagger.json,写入outputDir目录中
//        mockMvc.perform(
//                get("/v2/api-docs?group=" + CommonConstants.SWAGGER_GROUP_PUB)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
//        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
//        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
//                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
//                //.withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)// 格式
//                .withExamples(snippetDir)
//                .build()
//                .intoFolder(outputDir);// 输出
//    }
//
//    //@Test
//    public void test2() {
//    }
//
//
//    @Test
//    public void TestApi() throws Exception {
//        //mockMvc.perform(get("/find/page").param("name", "szl")
//        //        .accept(MediaType.APPLICATION_JSON))
//        //        .andExpect(status().isOk())
//        //        .andDo(MockMvcRestDocumentation.document("getStudent", preprocessResponse(prettyPrint())));
//
//
//        mockMvc.perform(get("/file/page").contentType(MediaType.APPLICATION_JSON)
//                .header("token", "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImFkbWluSWQiOjEsImFwcElkIjoiMTAwMDAiLCJleHAiOjE1MjAyNTEyMDB9.k_HoX8aLWRWcFBp_1A7MbM6-bBsFbNtvbekuvCTuDZSWQIdhLUXD-NuTA5dR0VEuBxUyKLB5IZ3R19vLrg7R91zOo33De5llE8ef3sufMDQ8YnLb76rUlRV6tjeRzidWrFsnX-0omJ-jFy3AlChi3S32rqrXNvNy7KGMkQ31O8o")
//                .header("_isAdmin", "true")
//                .param("pageNo", "1")
//                .param("pageSize", "10")
//                //.content(JSON.toJSONString(student))
//                //.accept(MediaType.APPLICATION_JSON))
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful())
//                .andDo(MockMvcRestDocumentation.document("获取文件分页", preprocessResponse(prettyPrint())));
//    }
//}

/**  
* @Title:  MySqlPaginationPlugin.java
* @Package com.wugu.ycyp.plug
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-7 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.plug;

import java.util.List;  

import org.mybatis.generator.api.CommentGenerator;  
import org.mybatis.generator.api.IntrospectedTable;  
import org.mybatis.generator.api.PluginAdapter;  
import org.mybatis.generator.api.dom.java.Field;  
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;  
import org.mybatis.generator.api.dom.java.JavaVisibility;  
import org.mybatis.generator.api.dom.java.Method;  
import org.mybatis.generator.api.dom.java.Parameter;  
import org.mybatis.generator.api.dom.java.TopLevelClass;  
import org.mybatis.generator.api.dom.xml.Attribute;  
import org.mybatis.generator.api.dom.xml.Document;  
import org.mybatis.generator.api.dom.xml.TextElement;  
import org.mybatis.generator.api.dom.xml.XmlElement; 


/**
 * @ClassName: MySqlPaginationPlugin
 * @Description: mybatis自动代码生成工具分页插件
 * @author lijun
 * @date 2014-7-7 
 * @requiresDependencyResolution
 *
 */

public class MySqlPaginationPlugin extends PluginAdapter
{
    @Override  
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,  
            IntrospectedTable introspectedTable) {  
        // add field, getter, setter for limit clause  
        addPage(topLevelClass, introspectedTable, "pageInfo");  
        return super.modelExampleClassGenerated(topLevelClass,  
                introspectedTable);  
    }  
    
  
    @Override  
    public boolean sqlMapDocumentGenerated(Document document,  
            IntrospectedTable introspectedTable) {  
        XmlElement parentElement = document.getRootElement();  
  
        // 产生分页语句
        XmlElement paginationSuffixElement = new XmlElement("sql");  
        paginationSuffixElement.addAttribute(new Attribute("id",  
                "MySqlDialectSuffix"));  
        XmlElement pageEnd = new XmlElement("if");  
        pageEnd.addAttribute(new Attribute("test", "pageInfo != null"));  
        pageEnd.addElement(new TextElement(  
                "limit ${pageInfo.offset} , ${pageInfo.pageSize}"));  
        paginationSuffixElement.addElement(pageEnd);  
        parentElement.addElement(paginationSuffixElement);  
  
        return super.sqlMapDocumentGenerated(document, introspectedTable);
        
    }
    
    @Override  
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(  
            XmlElement element, IntrospectedTable introspectedTable) {  
        
        XmlElement pageElement = new XmlElement("include"); //$NON-NLS-1$     
        pageElement.addAttribute(new Attribute("refid",  
                "MySqlDialectSuffix"));  
        element.getElements().add(pageElement);  
  
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,  
                introspectedTable);  
    }  
  
    /** 
     * @param topLevelClass 
     * @param introspectedTable 
     * @param name 
     */  
    private void addPage(TopLevelClass topLevelClass,  
            IntrospectedTable introspectedTable, String name) {  
        topLevelClass.addImportedType(new FullyQualifiedJavaType(  
                "com.wugu.ycyp.entity.page.PageInfo"));  
        CommentGenerator commentGenerator = context.getCommentGenerator();  
        Field field = new Field();  
        field.setVisibility(JavaVisibility.PROTECTED);  
        field.setType(new FullyQualifiedJavaType("com.wugu.ycyp.entity.page.PageInfo"));  
        field.setName(name);
        //field.setInitializationString("new PageInfo()");
        commentGenerator.addFieldComment(field, introspectedTable);  
        topLevelClass.addField(field);  
        char c = name.charAt(0);  
        String camel = Character.toUpperCase(c) + name.substring(1);  
        Method method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setName("set" + camel);  
        method.addParameter(new Parameter(new FullyQualifiedJavaType(  
                "com.wugu.ycyp.entity.page.PageInfo"), name));  
        method.addBodyLine("this." + name + "=" + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
        method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setReturnType(new FullyQualifiedJavaType(  
                "com.wugu.ycyp.entity.page.PageInfo"));  
        method.setName("get" + camel);  
        method.addBodyLine("return " + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
    }  
  
    /** 
     * This plugin is always valid - no properties are required 
     */  
    public boolean validate(List<String> warnings) {  
        return true;  
    }  
}  

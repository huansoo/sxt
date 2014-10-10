/**  
* @Title:  ExcelUtil.java
* @Package com.wugu.zhaopin.util
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-1-26 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.util;

/**
 * @ClassName: ExcelUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-26 
 *
 */
import java.io.File;  
import java.io.IOException;  
import java.util.ArrayList;
import java.util.List;
  
import jxl.Cell;  
import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException;  
import jxl.write.Label;  
import jxl.write.WritableSheet;  
import jxl.write.WritableWorkbook;  
import jxl.write.WriteException;  
import jxl.write.biff.RowsExceededException;  
  
public class ExcelUtil {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        
        String fileName = "E:\\work\\文档\\招聘网站\\document\\zhaopin\\企业职位数据1.23.xls";  
        System.out.println(ExcelUtil.readExcel(fileName));  
        //String fileName1 = "d:" + File.separator + "abc.xls";  
        //ExcelUtil.writeExcel(fileName1);  
    }  
  
    /**
     *  
    * @Title: readExcel
    * @Description: 读取Excel文件内容
    * @author lijun
    * @param fileName
    * @return
    * @throws
     */
    public static List readExcel(String fileName) {  
        List sheetList = null;  
        Workbook wb = null;  
        try {  
            // 构造Workbook（工作薄）对象  
            wb = Workbook.getWorkbook(new File(fileName));  
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        if (wb == null)  
            return null;  
  
        // 获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了  
        Sheet[] sheet = wb.getSheets();  
  
        if (sheet != null && sheet.length > 0) {  
            sheetList = new ArrayList();
            // 对每个工作表进行循环  
            for (int i = 0; i < sheet.length; i++) {  
                List rowList = new ArrayList();
                sheetList.add(rowList);
                // 得到当前工作表的行数  
                int rowNum = sheet[i].getRows();  
                for (int j = 0; j < rowNum; j++) {
                    List colList = new ArrayList();
                    rowList.add(colList);
                    // 得到当前行的所有单元格  
                    Cell[] cells = sheet[i].getRow(j);  
                    if (cells != null && cells.length > 0) {  
                        // 对每个单元格进行循环  
                        for (int k = 0; k < cells.length; k++) {  
                            // 读取当前单元格的值  
                            String cellValue = cells[k].getContents();  
                            //sb.append(cellValue + "\t");
                            colList.add(cellValue);
                            if (i == 1 && j == 2 && k == 3)
                                System.out.println(cellValue);
                            }  
                    }  
                }  
            }  
        }  
        // 最后关闭资源，释放内存  
        wb.close();  
        return sheetList;  
    }  
  
    /**
     * 
    * @Title: writeExcel
    * @Description: 写excel文件
    * @author lijun
    * @param fileName
    * @throws
     */
    public static void writeExcel(String fileName) {  
        WritableWorkbook wwb = null;  
        try {  
            // 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象  
            wwb = Workbook.createWorkbook(new File(fileName));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        if (wwb != null) {  
            // 创建一个可写入的工作表  
            // Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置  
            WritableSheet ws = wwb.createSheet("sheet1", 0);  
  
            // 下面开始添加单元格  
            for (int i = 0; i < 10; i++) {  
                for (int j = 0; j < 5; j++) {  
                    // 这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行  
                    Label labelC = new Label(j, i, "这是第" + (i + 1) + "行，第"  
                            + (j + 1) + "列");  
                    try {  
                        // 将生成的单元格添加到工作表中  
                        ws.addCell(labelC);  
                    } catch (RowsExceededException e) {  
                        e.printStackTrace();  
                    } catch (WriteException e) {  
                        e.printStackTrace();  
                    }  
  
                }  
            }  
  
            try {  
                // 从内存中写入文件中  
                wwb.write();  
                // 关闭资源，释放内存  
                wwb.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } catch (WriteException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
}
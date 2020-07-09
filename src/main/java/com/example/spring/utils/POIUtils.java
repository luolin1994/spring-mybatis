package com.example.spring.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Excel文档导入导出
 */
public class POIUtils {


    //Excel文档的导入
    public static ResponseEntity<byte[]> createExcel(
            String excelName, String[] headList, String[] filedList, List<Map<String,Object>> dataList)  {

        //1.创建一个Excel文档
        HSSFWorkbook workbook= new HSSFWorkbook();
        //2.创建文档摘要
        workbook.createInformationProperties();
        //3.获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        docInfo.setCompany("example");//可配置各种信息
        //4.获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        summInfo.setTitle(excelName);//可配置各种信息
        //5.创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        //6.在Excel工作薄中创建一工作表,其名为缺省值
        HSSFSheet sheet = workbook.createSheet();
        //7.创建标题行
        HSSFRow r0 = sheet.createRow(0);
        for (int i = 0; i < headList.length; i++) {
            //创建单元格
            HSSFCell cell = r0.createCell(i);
            //设置单元格的内容
            cell.setCellValue(headList[i]);
            //定义单元格的格式
            cell.setCellStyle(headerStyle);
        }
        //8.添加数据
        for (int i = 0; i < dataList.size(); i++) {
            //创建一行数据
            HSSFRow row = sheet.createRow(i + 1);
            Map<String, Object> dataMap = dataList.get(i);
            for (int j = 0; j < filedList.length; j++) {
                //创建单元格
                HSSFCell cell = row.createCell(i);
                //设置单元格的内容
                cell.setCellValue(dataMap.get(filedList[i]).toString());
            }
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String(excelName.getBytes("UTF-8")));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(output.toByteArray(),headers, HttpStatus.CREATED);
    }

    public static List<List<Object>> readExcel(MultipartFile file){
        List<List<Object>> list = new LinkedList<List<Object>>();
        try {
            //1.创建一个workbook对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2.获取workbook中的表单数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3.获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                //4.获取表单中的数据
                for (int j = sheet.getFirstRowNum()+1; j <= sheet.getLastRowNum(); j++) {
                    //5.获取行
                    HSSFRow row = sheet.getRow(j);
                    if(row == null){
                        continue;//防止数据中间有空行

                    }
                    List<Object> linked = new LinkedList<Object>();
                    //6.获取列数据
                    for (int k = row.getFirstCellNum(); k <= row.getLastCellNum() ; k++) {
                        Object value = null;
                        HSSFCell cell = row.getCell(k);
                        if(cell == null){
                            linked.add(null);//该单元格没有数据若没有数据,则填null
                            continue;
                        }
                        switch (cell.getCellType()){
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                value = cell.getNumericCellValue();
                                break;
                            case BOOLEAN:
                                value = cell.getBooleanCellValue();
                                break;
                            case BLANK:
                                break;
                            default:
                                value = cell.toString();
                        }
                        linked.add(value);
                    }
                    if(linked.size() != 0){
                        list.add(linked);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}

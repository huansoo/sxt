package com.wugu.zhaopin.dao;

import com.wugu.zhaopin.webapp.model.ResumeReport;
import com.wugu.zhaopin.webapp.model.ResumeReportCriteria;
import java.util.List;

public interface ResumeReportDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    int countByExample(ResumeReportCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    int deleteByExample(ResumeReportCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    void insert(ResumeReport record);

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    void insertSelective(ResumeReport record);

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    List<ResumeReport> selectByExample(ResumeReportCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    int updateByExampleSelective(ResumeReport record,
            ResumeReportCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table resume_report
     * @ibatorgenerated  Mon Apr 14 17:23:21 CST 2014
     */
    int updateByExample(ResumeReport record, ResumeReportCriteria example);
}
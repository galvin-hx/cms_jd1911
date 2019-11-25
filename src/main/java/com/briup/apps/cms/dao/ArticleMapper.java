package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.ArticleWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    long countByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int deleteByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int insert(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int insertSelective(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    ArticleWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int updateByExampleSelective(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Tue Nov 12 15:03:39 CST 2019
     */
    int updateByPrimaryKey(Article record);
}
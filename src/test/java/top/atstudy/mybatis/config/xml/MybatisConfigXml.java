package top.atstudy.mybatis.config.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.atstudy.mybatis.config.xml.dao.dto.GoodsDTO;
import top.atstudy.mybatis.config.xml.dao.mapper.GoodsMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisConfigXml {

    /**
     * 获取 SqlSession 对象
     * @return
     */
    public SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();
            System.out.println(" ===>> sqlSession: " + sqlSession.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

    /**
     * 关闭 sqlSession
     * @param sqlSession
     */
    public void closeSqlSession(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    /**
     * 根据 ID 获取
     */
    @Test
    public void testGetById(){
        //1.获取 SqlSession 对象
        SqlSession sqlSession = getSqlSession();

        //2.
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        GoodsDTO goodsDTO = goodsMapper.getById(11L);
        System.out.println(" goodsId: " + goodsDTO.getGoodsId());

        //3.关闭 sqlSession
        closeSqlSession(sqlSession);
    }


}

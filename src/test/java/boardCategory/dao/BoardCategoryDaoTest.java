package boardCategory.dao;

import static org.junit.Assert.assertEquals;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springDb/application-context.xml",
								"/springDb/context-datasource.xml"})*/
public class BoardCategoryDaoTest {

	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/dbinit/jspBoardInit.sql" ));
		populator.setContinueOnError(false);
		
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUsername("jspboardTest");
		bds.setPassword("jspboardTest");
		DatabasePopulatorUtils.execute(populator , bds);
	}
	
	//게시판 카테고리 조회 테스트
	@Test
	public void getBoardCategoryTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(1, 1);
	}

}

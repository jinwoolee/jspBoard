package jspBoard.util.msg;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgUtilTest{
	private Logger logger = LoggerFactory.getLogger(MsgUtilTest.class);

	//msg 프로퍼티 생성 테스트
	@Test
	public void propertyGenerateTest() throws IOException {
		/***Given***/

		/***When***/
		PropertyUtil.msgPropertyGenerate();

		/***Then***/
//		InputStream is = getClass().getResourceAsStream("/jspBoard/msg/msg_KO_KR.properties");
//		Properties properties = new Properties();
//		properties.load(is);
		
		String path = getClass().getResource("/jspBoard/msg/").getPath();
		if(path.startsWith("file:/"))
			path = path.substring(path.indexOf("file:/") + "file:/".length());
		logger.debug("{}", path);
		
		File f = new File(path + "msg_KO_KR.properties");
		FileInputStream fis = new FileInputStream(f);
				 
		Properties properties = new Properties();
		properties.load(fis);
		
		String msg = properties.getProperty("MSG001");
		assertEquals("안녕하세요", msg);
	}

}

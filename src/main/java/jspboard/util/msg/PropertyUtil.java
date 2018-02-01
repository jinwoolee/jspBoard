package jspboard.util.msg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 프로퍼티 생성 유틸 PropertyUtil.java
 * 
 * @author jw
 * @since 2017. 12. 15.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 15.    jw				최초 생성
 *
 *      </pre>
 */
public class PropertyUtil {

	/**
	 * Method : msgPropertyGenerate 최초작성일 : 2017. 12. 15. 작성자 : jw 변경이력 : Method 설명
	 * : msg 번들 생성
	 * 
	 * @throws FileNotFoundException
	 */
	public static void msgPropertyGenerate() {
		// String propertyFile =
		// "C:\\development\\workspace\\lecture\\jspBoard\\src\\main\\resources\\jspBoard\\msg\\msg_KO_KR.properties";

		String path = PropertyUtil.class.getResource("/jspBoard/msg/").getPath();
		if (path.startsWith("file:/"))
			path = path.substring(path.indexOf("file:/") + "file:/".length());
		String propertyFile = path + File.separator + "msg_KO_KR.properties";

		try {
			File f = new File(propertyFile);
			if (!f.exists())
				f.createNewFile();

			FileOutputStream fos = new FileOutputStream(f);
			Properties properties = new Properties();
			properties.put("MSG001", "안녕하세요");
			properties.put("MSG002", "{0}님, 반갑습니다.");

			properties.store(fos, "");
			fos.close();

			// properties.

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

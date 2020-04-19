package kr.co.bit.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class BitFileNamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		String name = f.getName(); //get filename without its path location, such as index.txt
		String ext = ""; //get the extension if the file has one
		int dot = name.lastIndexOf("."); //뒤쪽에서부터 .을 찾는다. dot에는 인덱스(위치)번호가 들어감 !!
		if (dot != -1) { //dot이 있을때
			ext = name.substring(dot); //dot부터 자름.. (.xxx 확장자)
		} else {
			ext = "";
		}
		String str = "bit" + UUID.randomUUID();
		File renameFile = new File(f.getParent(), str + ext); //piece together the filename
		//getParent(): 파일 이름을 뺀 파일의 경로
		//새로운 이름으로 경로를 만들어서 저장 !!
		return renameFile;
	}
}

package com.kos.testlegacy.os.lecture.dao;

import java.util.List;

import com.kos.testlegacy.os.lecture.vo.OsLectureVO;

public interface OsLectureDAO {
	
	public List<OsLectureVO> osLectureSelectAll(OsLectureVO ovo);
	public List osLectureSelect(OsLectureVO ovo);
	public List osLectureSelectMain(OsLectureVO ovo);
	public List<OsLectureVO> osLectureSelectOne(OsLectureVO ovo);
	public int osBoardLhit(OsLectureVO ovo);
}

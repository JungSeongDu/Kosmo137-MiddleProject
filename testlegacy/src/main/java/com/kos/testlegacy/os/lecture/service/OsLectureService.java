package com.kos.testlegacy.os.lecture.service;

import java.util.List;

import com.kos.testlegacy.os.lecture.vo.OsLectureVO;

public interface OsLectureService {
	public List<OsLectureVO> osLectureSelectAll(OsLectureVO ovo);
	public List osLectureSelect(OsLectureVO ovo);
	public List osLectureSelectMain(OsLectureVO ovo);
	public List<OsLectureVO> osLectureSelectOne(OsLectureVO ovo);
	 public int osBoardLhit(OsLectureVO ovo);
}

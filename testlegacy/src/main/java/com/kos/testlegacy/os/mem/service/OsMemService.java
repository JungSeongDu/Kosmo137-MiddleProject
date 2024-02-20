package com.kos.testlegacy.os.mem.service;

import java.util.List;

import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.lecture.vo.OsLectureVO;
import com.kos.testlegacy.os.mem.vo.OsMemVO;

public interface OsMemService {
	public int osMemInsert(OsMemVO ovo);
	public String OsMemSelectAll();
	public String OsMemSelect(OsMemVO ovo);
	public String OsMemUpdate(OsMemVO ovo);
	public List<OsMemVO> idCheck(OsMemVO ovo);
	public List<OsMemVO> loginCheck(OsMemVO ovo);
	public List<OsMemVO> mypageCheck(OsMemVO ovo);
	public List<OsBuyVO> byCheck(OsBuyVO obo);
	public List<OsMemVO> idFindSelect(OsMemVO ovo);
	public int mypageUpdate(OsMemVO ovo);
	public int mypageDelete(OsMemVO ovo);
}

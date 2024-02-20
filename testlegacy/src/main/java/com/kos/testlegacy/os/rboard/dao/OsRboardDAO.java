package com.kos.testlegacy.os.rboard.dao;

import java.util.List;

import com.kos.testlegacy.os.rboard.vo.OsRboardVO;

public interface OsRboardDAO {
	
	public int osRboardInsert(OsRboardVO rbvo);
	public List<OsRboardVO> osRboardSelectAll(OsRboardVO rbvo);
	public int osRboardDelete(OsRboardVO rbvo);

}

package com.project.mapper;

import java.util.List;

import com.project.domain.CodeDetail;
import com.project.domain.CodeGroup;

public interface CodeDetailMapper {
	// 등록 처리
	public void create(CodeDetail codeDetail) throws Exception;
	// 그룹코드 정렬 순서의 최대값
	public Integer getMaxSortSeq(String groupCode) throws Exception;

	// 목록 페이지
	public List<CodeDetail> list() throws Exception;
	// 상세 페이지(수정페이지)
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
}
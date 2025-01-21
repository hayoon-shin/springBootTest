package com.project.common.domain;

import lombok.Data;
// 그룹코드에서 사용되고 있는 그룹코드(value)와 그룹네임(label)을 관리하는 도메인
@Data // get, set, toString, equal, hashcode, requireArgument constructor
public class CodeLabelValue {

	private final String value;
	private final String label;
}
